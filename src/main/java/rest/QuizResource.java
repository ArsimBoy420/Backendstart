package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.FlagDTO;
import dtos.QuestionDTO;
import dtos.QuizDTO;
import entities.Flag;
import entities.Question;
import entities.Quiz;
import entities.User;
import errorhandling.NotFoundException;
import facades.FlagFacade;
import facades.QuestionFacade;
import facades.QuizFacade;
import facades.UserFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lam@cphbusiness.dk
 */
@Path("quiz")
public class QuizResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final QuizFacade FACADE =  QuizFacade.getQuizFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"quiz endpoint\"}";
    }

    @Path("generate/{username}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response generate(@PathParam("username") String username) throws NotFoundException {
        Quiz quiz = FACADE.generateQuiz(username);
        return Response.ok().entity(GSON.toJson(new QuizDTO(quiz))).build();
    }
    @Path("create")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(String jsonContext) throws NotFoundException {
        QuizDTO dto = GSON.fromJson(jsonContext, QuizDTO.class);
        Long totalPoints = 0L;
        Long totalCorrect = 0L;
        Long totalIncorrect = 0L;
        List<Question> questions = new ArrayList<>();
        for (QuestionDTO q : dto.getQuestions()) {
            questions.add(new Question(
                    q.getCorrectCountryId(),
                    q.getFlagSVG(),
                    q.getAnswer1(),
                    q.getAnswer2(),
                    q.getAnswer3(),
                    q.getAnswer4(),
                    q.getPoints()
            ));
            totalPoints += q.getPoints();
            if (q.getPoints() != 0) {
                totalCorrect ++;
            } else {
                totalIncorrect ++;
            }
        }
        UserFacade userFacade = UserFacade.getUserFacade(EMF);
        User user = userFacade.getUserByName(dto.getUsername());
        // Update user entity
        user.setAnswered(user.getAnswered() + 5L);
        user.setPoints(user.getPoints() + totalPoints);// for making stats later on
        user.setCorrect(user.getCorrect() + totalCorrect);
        user.setIncorrect(user.getIncorrect() + totalIncorrect);
        userFacade.update(user);

        // Create quiz entity
        Quiz quiz = new Quiz(totalPoints, totalCorrect, totalIncorrect, questions, user);
        Quiz created = FACADE.create(quiz);

        QuestionFacade questionFacade = QuestionFacade.getQuestionFacade(EMF);
        FlagFacade flagFacade = FlagFacade.getFlagFacade(EMF);
        // for making stats later on
        for (Question q : created.getQuestions()) {
            q.setQuiz(created); // set quiz ref on  all the questions in the quiz
            questionFacade.update(q);// Update question entities
            Flag flag = flagFacade.getById(q.getCorrectCountryId());
            flag.setAnswered(flag.getAnswered() + 1L);
            if (q.getPoints() > 0) {
                flag.setCorrect(flag.getCorrect() + 1L);
            } else {
                flag.setIncorrect(flag.getIncorrect() + 1L);
            }
            flagFacade.update(flag);  // Update flag entities
        }

        QuizDTO createdDTO = new QuizDTO(created);
        return Response.ok().entity(GSON.toJson(createdDTO)).build();
    }

    @Path("result/{correctId}/{answer}/{time}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Long getResult(@PathParam("correctId") Long correctId, @PathParam("answer") String answer, @PathParam("time") float time) throws NotFoundException {
        return FACADE.getResult(correctId, answer, time);
    }

}
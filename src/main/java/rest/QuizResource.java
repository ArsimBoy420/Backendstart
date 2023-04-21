package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.FlagDTO;
import dtos.QuizDTO;
import entities.Flag;
import entities.Quiz;
import errorhandling.NotFoundException;
import facades.FlagFacade;
import facades.QuizFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
        return Response.ok("").entity(GSON.toJson(new QuizDTO(quiz))).build();
    }

}
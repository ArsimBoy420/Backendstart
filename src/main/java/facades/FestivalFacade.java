package facades;

import dtos.FestivalDTO;
import dtos.ShowDTO;
import entities.Festival;
import entities.Show;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;


public class FestivalFacade {

    private static EntityManagerFactory emf;
    private static FestivalFacade instance;
//    private EntityManager getEntityManager(){ return emf.createEntityManager();}

    private FestivalFacade(){}

    public static FestivalFacade getFestivalFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FestivalFacade();
        }
        return instance;
    }

//    public FestivalDTO createFestival(FestivalDTO festivalDTO) {
//        EntityManager em = emf.getEntityManager();
//        User user = em. emf.find(User.class, festivalDTO.getName());
//        Festival festival = new Festival(festivalDTO.getName(),festivalDTO.getCity(),festivalDTO.getStartDate(),festivalDTO.getDuration());
//
//        List<Show> list = new ArrayList<>();
//        for (ShowDTO sdto : festivalDTO.getShowDTOS()) {
//            Show show = new Show(sdto.getName(),sdto.getDuration(),sdto.getLocation(),sdto.getStartDate(),sdto.getStartTime());
//            Show s = em.find(Show.class, sdto.GetShowId());
//            show.add
//        }
//    }

    public FestivalDTO createFestival(FestivalDTO festivalDTO) {
        EntityManager em = emf.createEntityManager();
        Festival festival = new Festival(festivalDTO.getName(),festivalDTO.getCity(),festivalDTO.getStartDate(),festivalDTO.getDuration());
        try{
            em.getTransaction().begin();
            em.persist(festival);
            em.getTransaction().commit();
            return new FestivalDTO(festival);
        } finally {
            em.close();
        }
    }

    public FestivalDTO updateFestivals(FestivalDTO fe) {
        EntityManager em = emf.createEntityManager();
        Festival f = (em.find(Festival.class, fe.getId()));
        try{
            f.setName(fe.getName());
            em.getTransaction().begin();
            f = em.merge(f);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new FestivalDTO(f);
    }

}

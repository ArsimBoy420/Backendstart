package facades;

import dtos.FestivalDTO;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class FestivalFacade {

    private  static EntityManager emf;
    private static FestivalFacade instance;
//    private EntityManager getEntityManager(){ return emf.createEntityManager();}

    private FestivalFacade(){}

    public static FestivalFacade getFestivalFacade(EntityManagerFactory _emf) {
        if (instance == null){
            emf = _emf;
            instance = new FestivalFacade();
        }
        return instance;
    }

    public FestivalDTO createFestival(FestivalDTO festivalDTO) {
        EntityManager em = emf.getEntityManager();
        User user = em. emf.find
    }
}

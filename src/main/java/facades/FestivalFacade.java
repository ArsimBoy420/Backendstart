package facades;

import dtos.FestivalDTO;
import dtos.ShowDTO;
import entities.Festival;
import entities.Show;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.NotAllowedException;
import java.util.ArrayList;
import java.util.List;


public class FestivalFacade {

    private static EntityManagerFactory emf;
    private static FestivalFacade instance;
    private EntityManager getEntityManager(){ return emf.createEntityManager();}

    private FestivalFacade(){}

    public static FestivalFacade getFestivalFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FestivalFacade();
        }
        return instance;
    }

    public List<FestivalDTO> getAllFestivals() throws NotAllowedException {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<FestivalDTO> query = em.createQuery("SELECT new dtos.FestivalDTO(f) FROM Festival f", FestivalDTO.class);
            List<FestivalDTO> festivals = query.getResultList();
            if (festivals.isEmpty()) {
                throw new NotAllowedException("No festival found");
            }
            return festivals;
        } finally {
           em.close();
        }
    }

    public FestivalDTO getFestivalByName(String name) {
        EntityManager em = getEntityManager();
        TypedQuery<Festival> query = em.createQuery("SELECT f FROM Festival f WHERE f.name = :nt",Festival.class)
                .setParameter("nt",name);
        Festival festival = query.getSingleResult();
        FestivalDTO festivalDTO = new FestivalDTO(festival);
        em.close();
        return festivalDTO;
    }

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

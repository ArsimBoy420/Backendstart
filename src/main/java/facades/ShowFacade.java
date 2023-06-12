package facades;

import dtos.FestivalDTO;
import dtos.ShowDTO;
import entities.Festival;
import entities.Show;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class ShowFacade {

    private static EntityManagerFactory emf;
    private static ShowFacade instance;

    private ShowFacade(){}

    public static ShowFacade getShowFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new ShowFacade();
        }
        return instance;
    }

    public List<ShowDTO> getAllShows() {
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<ShowDTO> query = em.createQuery("SELECT new dtos.ShowDTO(s) FROM Show s", ShowDTO.class);
            List<ShowDTO> shows = query.getResultList();
            return shows;
        } finally {
            em.close();
        }
    }

    public ShowDTO createShow(ShowDTO showDTO) {
        EntityManager em = emf.createEntityManager();
        Show show = new Show(showDTO.getName(),showDTO.getDuration(),showDTO.getLocation(),showDTO.getStartDate(),showDTO.getStartTime());
        try {
            em.getTransaction().begin();
            em.persist(show);
            em.getTransaction().commit();
            return new ShowDTO(show);
        } finally {
            em.close();
        }
    }

    public ShowDTO updateShow(ShowDTO sh) {
        EntityManager em = emf.createEntityManager();
        Show s = (em.find(Show.class, sh.getId()));
        try {
            s.setName(sh.getName());
            em.getTransaction().begin();
            s = em.merge(s);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
        return new ShowDTO(s);
    }

    public void deleteShow(String name) {
        EntityManager em = emf.createEntityManager();
        Show show = em.find(Show.class, name);
        try {
            em.getTransaction().begin();
            em.remove(show);
            em.getTransaction().commit();
        } finally {
           em.close();
        }
    }

}

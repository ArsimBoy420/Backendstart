package facades;

import dtos.GuestDTO;
import entities.Guest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.NotAllowedException;
import java.util.List;

public class GuestFacade {
    private static EntityManagerFactory emf;
    private static GuestFacade instance;

    private GuestFacade (){}

    public static GuestFacade getGuestFacade (EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new GuestFacade();
        }
        return instance;
    }

    public List<GuestDTO> getAllGuest() throws NotAllowedException {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<GuestDTO> query = em.createQuery("SELECT new dtos.GuestDTO(g) FROM Guest g",GuestDTO.class);
            List<GuestDTO> guests = query.getResultList();
            if (guests.isEmpty()) {
                throw new NotAllowedException("No guest found");
            }
            return guests;
        } finally {
            em.close();
        }
    }

    public GuestDTO createGuest (GuestDTO guestDTO) {
        EntityManager em = emf.createEntityManager();
        Guest guest = new Guest(guestDTO.getName(),guestDTO.getPhone(),guestDTO.getEmail(),guestDTO.getStatus());
        try {
            em.getTransaction().begin();
            em.persist(guest);
            em.getTransaction().commit();
            return new GuestDTO(guest);
        } finally {
            em.close();
        }
    }

}

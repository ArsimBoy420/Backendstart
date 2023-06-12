package facades;

import dtos.GuestDTO;
import entities.Guest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GuestFacadeTest {

    private static EntityManagerFactory emf;
    private static GuestFacade guestFacade;

    public GuestFacadeTest(){}

    @BeforeAll
    static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        guestFacade = GuestFacade.getGuestFacade(emf);
    }

    @BeforeEach
    void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Guest.deleteAllRows").executeUpdate();
            Guest guest1 = new Guest("Suiii",23232323,"suuuiii@gmail.com","daddy");
            em.persist(guest1);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    @AfterEach
    void tearDown(){}

    @Test public void createGuest() {
        System.out.println("create a Guest test!");
        GuestDTO guestDTO = new GuestDTO("Suuui",55555555,"Suiiii@gmail.com","daddy");
        GuestDTO guestDTO1 = guestFacade.createGuest(guestDTO);
        assertNotNull(guestDTO1.getId());
    }
}

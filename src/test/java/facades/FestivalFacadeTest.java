package facades;

import dtos.FestivalDTO;
import entities.Festival;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FestivalFacadeTest {
    private static EntityManagerFactory emf;
    private static FestivalFacade festivalFacade;

    public FestivalFacadeTest() {
    }
    @BeforeAll
    static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        festivalFacade = FestivalFacade.getFestivalFacade(emf);
    }
    @BeforeEach
    void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
        em.getTransaction().begin();
        em.createNamedQuery("Festival.deleteAllRows").executeUpdate();
            Festival festival1 = new Festival("Arsim","Valby","27/4","2 timer");
            em.persist(festival1);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    @AfterEach
    void tearDown() {
    }

    @Test
    public void createFestival() {
        System.out.println("create Festival test!");
        FestivalDTO festivalDTO = new FestivalDTO("Andrim","Hvidovre","11/2","3 timer");
        FestivalDTO festivalDTO1 = festivalFacade.createFestival(festivalDTO);
        assertNotNull(festivalDTO1.getId());
    }

}

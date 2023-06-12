package facades;

import entities.Festival;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void cerateFastival() throws Exception {
        assertEquals(2, festivalFacade.getAllFestivals(), "Expects two rows in the database");
    }

}

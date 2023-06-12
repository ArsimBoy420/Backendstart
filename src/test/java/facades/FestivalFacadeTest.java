package facades;

import entities.Festival;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class FestivalFacadeTest {
    private static EntityManagerFactory emf;
    private static FestivalFacade facade;

    @BeforeAll
    static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = FestivalFacade.getFestivalFacade(emf);
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

}

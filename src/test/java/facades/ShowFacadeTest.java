package facades;

import dtos.ShowDTO;
import entities.Show;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ShowFacadeTest {

    private static EntityManagerFactory emf;
    private  static ShowFacade facade;

    @BeforeAll
    static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = ShowFacade.getShowFacade(emf);
    }

    @BeforeEach
    void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Show.deleteAllRows").executeUpdate();
            Show show1 = new Show("Luan","1 time","Rødovre","15/7","20:00");
            em.persist(show1);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    @AfterEach
    void tearDown() {
    }
    @Test
    void createShowTest(){
        System.out.println("create Show test!");
        ShowDTO showDTO = new ShowDTO( "","Luan", "1 time", "Rødovre", "15/7","20:00");
        ShowDTO showDTO1 = facade.createShow(showDTO);
        assertNotNull(showDTO1.getId());
    }


}

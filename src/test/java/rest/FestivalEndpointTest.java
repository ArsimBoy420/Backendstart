package rest;

import dtos.FestivalDTO;
import entities.Festival;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class FestivalEndpointTest {
    private  static final int SERVER_PORT = 7777;
    private static final String SERVER_URL = "http://localhost/api";
    private static Festival f1, f2;

    static final URI BASE_URI = UriBuilder.fromUri(SERVER_URL).port(SERVER_PORT).build();
    private static HttpServer httpServer;
    private static EntityManagerFactory emf;

    static HttpServer startServer() {
        ResourceConfig rc = ResourceConfig.forApplication(new ApplicationConfig());
        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
    }
    @BeforeAll
    public static void setUpClass() {
        EMF_Creator.startREST_TestWithDB();
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        httpServer = startServer();
        RestAssured.baseURI = SERVER_URL;
        RestAssured.port = SERVER_PORT;
        RestAssured.defaultParser = Parser.JSON;
    }

    @AfterAll
    public static void closeTestServer() {
        EMF_Creator.endREST_TestWithDB();

        httpServer.shutdownNow();
    }

    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        f1 = new Festival("Arsim", "Valby", "23/4", "2 timer");
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Festival.deleteAllRows").executeUpdate();
            em.persist(f1);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    private static String securityToken;

    @Test
    public void testServerIsUp(){given().when().get("/xxx").then().statusCode(200);}

    
    @Test
    void getAll()
    {
       List<FestivalDTO> festivalDTOS;
       festivalDTOS = given()
               .contentType("application/json")
               .when()
               .get("/festival/all")
               .then()
               .extract().body().jsonPath().getList("", FestivalDTO.class);
       FestivalDTO f1DTO = new FestivalDTO(f1);
       assertThat(festivalDTOS, containsInAnyOrder(f1DTO));
    }

}

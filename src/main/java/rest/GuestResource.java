package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.GuestDTO;
import facades.GuestFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("guest")
public class GuestResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final GuestFacade guestFacade = GuestFacade.getGuestFavade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInForAll() { return "{\"msg\":\"festival endpoint\"}";}

    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllGuest() throws NotAllowedException {
        List<GuestDTO> guests = guestFacade.getAllGuest();
        return Response.ok().entity(GSON.toJson(guests)).build();
    }
}


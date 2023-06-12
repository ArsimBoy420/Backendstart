package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.FestivalDTO;
import dtos.GuestDTO;
import facades.GuestFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("guest")
public class GuestResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final GuestFacade guestFacade = GuestFacade.getGuestFacade(EMF);
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
    @POST
    @Path("/create")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createGuest(String guest) {
        GuestDTO guestDTO = GSON.fromJson(guest, GuestDTO.class);
        GuestDTO created = guestFacade.createGuest(guestDTO);
        return Response.ok().entity(GSON.toJson(created)).build();
    }


}


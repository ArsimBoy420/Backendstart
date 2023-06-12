package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.FestivalDTO;
import facades.FestivalFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("festival")
public class FestivalResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final FestivalFacade festivalFacade = FestivalFacade.getFestivalFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInForAll() { return "{\"msg\":\"festival endpoint\"}";}

    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllFestivals() throws NotAllowedException {
        List<FestivalDTO> festivals = festivalFacade.getAllFestivals();
        return Response.ok().entity(GSON.toJson(festivals)).build();
    }

    @POST
    @Path("/create")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createFestival(String festival) {
        FestivalDTO festivalDTO = GSON.fromJson(festival, FestivalDTO.class);
        FestivalDTO created = festivalFacade.createFestival(festivalDTO);
        return Response.ok().entity(GSON.toJson(created)).build();
    }

    @PUT
    @Path("update/")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateFestivals(String content){
        FestivalDTO festivalDTO = GSON.fromJson(content, FestivalDTO.class);
        FestivalDTO newFestivalDTO = festivalFacade.updateFestivals(festivalDTO);
        return Response.ok().entity(GSON.toJson(newFestivalDTO)).build();
    }
}

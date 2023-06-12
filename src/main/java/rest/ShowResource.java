package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dtos.FestivalDTO;
import dtos.ShowDTO;
import errorhandling.API_Exception;
import facades.ShowFacade;
import utils.EMF_Creator;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("show")
public class ShowResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final ShowFacade showFacade = ShowFacade.getShowFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll(){ return "{\"msg\":\"show endpoint\"}";}

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllShows() throws EntityNotFoundException {
        return Response.ok().entity(GSON.toJson(showFacade.getAllShows())).build();
    }

    @PUT
    @Path("update/")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateShow(String content){
        ShowDTO showDTO = GSON.fromJson(content, ShowDTO.class);
        ShowDTO newShowDTO = showFacade.updateShow(showDTO);
        return Response.ok().entity(GSON.toJson(newShowDTO)).build();
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @RolesAllowed("delete")
    public Response delete(String jsonString) throws API_Exception {
        String name;
        try {
            JsonObject json = JsonParser.parseString(jsonString).getAsJsonObject();
            name = json.get("name").getAsString();
            System.out.println(name);
            showFacade.deleteShow(name);
        } catch (Exception e) {
            throw new API_Exception("Malformed JSON Suplied",400,e);
        }
        return Response.ok().entity(GSON.toJson(name)).build();
    }
}
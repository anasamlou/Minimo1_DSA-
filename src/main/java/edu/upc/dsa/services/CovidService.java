package edu.upc.dsa.services;

import edu.upc.dsa.models.Casos;
import edu.upc.dsa.models.Brote;
import edu.upc.dsa.utils.Covid19Manager;
import edu.upc.dsa.utils.Covid19ManagerImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Api(value = "/user", description = "Endpoint to COVID Service")
@Path("/")
public class CovidService {

    private Covid19Manager CS;

    public CovidService(){
        this.CS = Covid19ManagerImp.getInstance();
        if(this.CS.getBrotes().size() == 0){
            this.CS.crearBrote("Brote de Madrid");
            this.CS.crearBrote("Brote de Murcia");
            this.CS.crearBrote("Brote de Malaga");

            this.CS.addCasoToBrote("Brote de Madrid","1","27/01/1932","B","S");
            this.CS.addCasoToBrote("Brote de Madrid","2","27/01/1933","B", "S");
            this.CS.addCasoToBrote("Brote de Malaga","1","27/01/1936","B","C");
            this.CS.addCasoToBrote("Brote de Murcia","1","27/01/1932","B","NC");
        }
    }

    @GET //GET all Brotes sorted
    @ApiOperation(value = "get all users", notes = "Returns list of all users sorted by lastname")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Brote.class, responseContainer="List"),
    })
    @Path("/Brote")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBrotes(){

        List<Brote> allBrotes = this.CS.getBrotes();

        GenericEntity<List<Brote>> entity = new GenericEntity<List<Brote>>(allBrotes) {};
        return Response.status(201).entity(entity).build() ;
    }


    @POST
    @ApiOperation(value = "add new brote", notes = "Adding new user to database")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Brote.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/Brote/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newBrote(@PathParam("id") String id) {

        if(id == null){
            return Response.status(500).build();
        }
        this.CS.crearBrote(id);
        Brote u = this.CS.getBroteById(id);
        return Response.status(201).entity(u).build();
    }

    @GET
    @ApiOperation(value = "get Casos that a Brote has", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Casos.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/User/{id}/weapons")
    public Response getCasosByBrote(@PathParam("id") String id){
        Brote u = this.CS.getBroteById(id);
        if(u == null) return Response.status(404).build();
        else{
            List<Casos> casos = u.getCasos();
            GenericEntity<List<Casos>> entity = new GenericEntity<List<Casos>>(casos) {};
            return Response.status(201).entity(entity).build() ;
        }
    }


}

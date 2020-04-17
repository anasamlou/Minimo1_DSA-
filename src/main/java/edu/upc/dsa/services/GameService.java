package edu.upc.dsa.services;

import edu.upc.dsa.models.Armas;
import edu.upc.dsa.models.User;
import edu.upc.dsa.utils.GameManager;
import edu.upc.dsa.utils.GameManagerImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/user", description = "Endpoint to Students Service")
@Path("/")
public class GameService{

    private GameManager gm;

    public GameService(){
        this.gm = GameManagerImp.getInstance();
        if(this.gm.getNumUsers() == 0){
            this.gm.addUser("Anas","Amlou","anasamlou");
            this.gm.addUser("Carlos", "Mafiozo", "carlosmafiozo");
            this.gm.addUser("Juninho", "DaSouza", "elbicho");

            this.gm.addArmasUser("anasamlou","Espada", "afilada");
            this.gm.addArmasUser("carlosmafiozo","Puntero", "laser");
            this.gm.addArmasUser("elbicho", "maquina", "del tiempo");
        }
    }

    @GET //GET all users sorted by lastname (alphabetically)
    @ApiOperation(value = "get all users", notes = "Returns list of all users sorted by lastname")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer="List"),
    })
    @Path("/User")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers(){

        List<User> allUsers = this.gm.getUsers();

        GenericEntity<List<User>> entity = new GenericEntity<List<User>>(allUsers) {};
        return Response.status(201).entity(entity).build() ;
    }

    @GET // GET a specific user that has an id
    @ApiOperation(value = "get user by id", notes = "We get a user based of a id")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "Student not found")
    })
    @Path("/User/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") String id) {
        User u = this.gm.getUser(id);
        if (u == null) {
            return Response.status(404).build();
        }
        else return Response.status(201).entity(u).build();
    }

    @POST
    @ApiOperation(value = "add new user", notes = "Adding new user to database")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=User.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/User/{id}/{name}/{lastname}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newStudent(@PathParam("id") String id, @PathParam("name") String name, @PathParam("lastname") String lastname) {

        if(id == null || name == null || lastname == null){
            return Response.status(500).build();
        }
        this.gm.addUser(name,lastname,id);
        User u = this.gm.getUser(id);
        return Response.status(201).entity(u).build();
    }

    @GET
    @ApiOperation(value = "get weapons that a user has", notes = "Getting weapons from user")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Armas.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/User/{id}/weapons")
    public Response getArmasByUser(@PathParam("id") String id){
        User u = this.gm.getUser(id);
        if(u == null) return Response.status(404).build();
        else{
            List<Armas> armas = u.getArmas();
            GenericEntity<List<Armas>> entity = new GenericEntity<List<Armas>>(armas) {};
            return Response.status(201).entity(entity).build() ;
        }
    }

    @PUT
    @ApiOperation(value = "add weapon to a user", notes = "weapon added")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful",response = Armas.class),
            @ApiResponse(code = 404, message = "Subject/Student not found")
    })
    @Path("/User/{id}")
    public Response enrollUser(@PathParam("id") String id, Armas obj) {

        User u = this.gm.getUser(id);

        if (u == null) return Response.status(404).build();
        else {
            this.gm.addArmasUser(id,obj.getId(),obj.getDescrp());
            return Response.status(201).entity(u).build();
        }
    }

    @PUT
    @ApiOperation(value = "update a user based on a ID", notes = "user updated (id cannot change) IMPORTANT")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful",response = User.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/User")
    public Response updateUser(User u) {

        User us = this.gm.getUser(u.getId());
        if (us == null || u == null) return Response.status(404).build();
        else {
            this.gm.updateUser(u.getName(),u.getLastname(),u.getId());
            return Response.status(201).entity(us).build();
        }
    }
}

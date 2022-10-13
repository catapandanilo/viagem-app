package com.danilocatapan.cliente;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cliente")
public class ClienteResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAll(){
        return Response.ok(Cliente.listAll()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id){
        return Response.ok(Cliente.findById(id)).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteById(@PathParam("id") Long id){
        return Response.ok(Cliente.deleteById(id)).build();
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newCliente(Cliente cliente){
        cliente.id = null;
        cliente.persist();

        return Response.status(Response.Status.CREATED).entity(cliente).build();
    }
}

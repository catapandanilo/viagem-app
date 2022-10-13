package com.danilocatapan.cliente;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "http://localhost:8080/cliente")
public interface ClienteService {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente findById(@PathParam("id") long id);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String newCliente(Cliente cliente);
}

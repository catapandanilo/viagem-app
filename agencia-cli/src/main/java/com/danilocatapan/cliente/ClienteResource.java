package com.danilocatapan.cliente;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("cliente-cli")
public class ClienteResource {

    @Inject
    @RestClient
    ClienteService service;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @GET
    public String newCliente() {
        Cliente cliente = Cliente.of(99, "Remoto");
        return service.newCliente(cliente);
    }

}

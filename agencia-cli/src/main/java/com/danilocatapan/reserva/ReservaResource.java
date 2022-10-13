package com.danilocatapan.reserva;

import com.danilocatapan.cliente.Cliente;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/reserva-cli")
public class ReservaResource {

    @Inject
    @RestClient
    ReservaService service;

    @GET
    @Path("newReserva")
    @Produces(MediaType.APPLICATION_JSON)
    public Response newReserva() {
        Cliente cliente = Cliente.of(2, "danilo c");
        return service.newReserva(Reserva.of(cliente));
    }
}

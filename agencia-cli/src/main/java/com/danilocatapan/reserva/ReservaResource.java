package com.danilocatapan.reserva;

import com.danilocatapan.cliente.Cliente;
import com.danilocatapan.cliente.ClienteService;
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

    @Inject
    @RestClient
    ClienteService clienteService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response newReserva() {
        Reserva reserva = Reserva.of(0, 2);
        return service.newReserva(reserva);
    }
}

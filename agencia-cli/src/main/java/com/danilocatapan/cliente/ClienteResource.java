package com.danilocatapan.cliente;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.temporal.ChronoUnit;

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
    @Timeout(unit = ChronoUnit.SECONDS, value = 3) //se demorar +3 segundos exception timeout
    @Fallback(fallbackMethod = "fallback")
    @CircuitBreaker(
        requestVolumeThreshold=4, // a cada 4 req valida novamente
        failureRatio=0.5, //% falha, a cada 2 de 4 req vai abrir o circuito
        delay=6000,//a cada 6S fica com o circuito aberto, entra no Fallback
        successThreshold=1 //se 1 sucesso, fecha circuito
    )
    public Cliente findById(@PathParam("id") long id) {
        return service.findById(id);
    }

    @GET
    public String newCliente() {
        Cliente cliente = Cliente.of(99, "Remoto");
        return service.newCliente(cliente);
    }

    private Cliente fallback(long id){
        return Cliente.of(id, "fallback");
    }
}

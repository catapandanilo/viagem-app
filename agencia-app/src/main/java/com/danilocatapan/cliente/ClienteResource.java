package com.danilocatapan.cliente;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/cliente")
public class ClienteResource {

    @GET
    public List<Cliente> get(){
        return Cliente.listAll();
    }
}

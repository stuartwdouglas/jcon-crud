package com.test.resource;

import com.test.entity.Fruit74;
import com.test.service.FruitService74;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/fruit74")
@Transactional
public class FruitResource74 {

    @Inject
    FruitService74 fruitService;

    @GET
    public List<Fruit74> list() {
        return fruitService.list();
    }

    @GET
    @Path("{id}")
    public Fruit74 find(int id) {
        return fruitService.find(id);
    }

    @POST
    public Response save(Fruit74 fruit) {
        fruitService.save(fruit);
        return Response.status(201).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        fruitService.delete(fruitService.find(id));
        return Response.noContent().build();
    }

}

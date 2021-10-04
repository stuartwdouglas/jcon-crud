package com.test.resource;

import com.test.entity.Fruit34;
import com.test.service.FruitService34;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/fruit34")
@Transactional
public class FruitResource34 {

    @Inject
    FruitService34 fruitService;

    @GET
    public List<Fruit34> list() {
        return fruitService.list();
    }

    @GET
    @Path("{id}")
    public Fruit34 find(int id) {
        return fruitService.find(id);
    }

    @POST
    public Response save(Fruit34 fruit) {
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

package com.test.resource;

import com.test.entity.Fruit24;
import com.test.service.FruitService24;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/fruit24")
@Transactional
public class FruitResource24 {

    @Inject
    FruitService24 fruitService;

    @GET
    public List<Fruit24> list() {
        return fruitService.list();
    }

    @GET
    @Path("{id}")
    public Fruit24 find(int id) {
        return fruitService.find(id);
    }

    @POST
    public Response save(Fruit24 fruit) {
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

package com.test.resource;

import com.test.entity.Fruit10;
import com.test.service.FruitService10;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/fruit10")
@Transactional
public class FruitResource10 {

    @Inject
    FruitService10 fruitService;

    @GET
    public List<Fruit10> list() {
        return fruitService.list();
    }

    @GET
    @Path("{id}")
    public Fruit10 find(int id) {
        return fruitService.find(id);
    }

    @POST
    public Response save(Fruit10 fruit) {
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

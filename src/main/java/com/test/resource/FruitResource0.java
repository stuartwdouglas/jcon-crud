package com.test.resource;

import com.test.entity.Fruit0;
import com.test.service.FruitService0;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/fruit0")
@Transactional
public class FruitResource0 {

    @Inject
    FruitService0 fruitService;

    @GET
    public List<Fruit0> list() {
        return fruitService.list();
    }

    @GET
    @Path("{id}")
    public Fruit0 find(int id) {
        return fruitService.find(id);
    }

    @POST
    public Response save(Fruit0 fruit) {
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

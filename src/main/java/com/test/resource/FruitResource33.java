package com.test.resource;

import com.test.entity.Fruit33;
import com.test.service.FruitService33;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/fruit33")
@Transactional
public class FruitResource33 {

    @Inject
    FruitService33 fruitService;

    @GET
    public List<Fruit33> list() {
        return fruitService.list();
    }

    @GET
    @Path("{id}")
    public Fruit33 find(int id) {
        return fruitService.find(id);
    }

    @POST
    public Response save(Fruit33 fruit) {
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

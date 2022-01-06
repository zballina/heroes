package com.albo.challenge.resources;


import com.albo.challenge.commons.Routes;
import com.albo.challenge.dto.request.HeroRequest;
import com.albo.challenge.services.HeroesService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path(Routes.BASE_HEROES_ROUTE)
public class HeroesResource {

    @Inject
    HeroesService heroesService;

    @Transactional
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(HeroRequest request) {
        return Response.ok(heroesService.add(request)).build();
    }

    @Transactional
    @DELETE
    @Path(Routes.DELETE_HEROES_BY_SHORTNAME)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("shortName") String shortName) {
        return Response.ok(heroesService.delete(shortName)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response all() {
        return Response.ok(heroesService.all()).build();
    }
}
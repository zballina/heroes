package com.albo.challenge.resources;


import com.albo.challenge.commons.Routes;
import com.albo.challenge.services.CharactersService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path(Routes.BASE_MARVEL_ROUTE)
public class CharactersResource {

    @Inject
    CharactersService charactersService;

    @GET
    @Path(Routes.GET_CHARACTERS_BY_HERO)
    @Produces(MediaType.APPLICATION_JSON)
    public Response charactersByHero(@PathParam("hero") String hero) {
        return Response.ok(charactersService.interactions(hero)).build();
    }
}
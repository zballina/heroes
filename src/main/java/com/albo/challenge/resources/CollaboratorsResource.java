package com.albo.challenge.resources;


import com.albo.challenge.commons.Routes;
import com.albo.challenge.services.CollaboratorsService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path(Routes.BASE_MARVEL_ROUTE)
public class CollaboratorsResource {

    @Inject
    CollaboratorsService collaboratorsService;

    @GET
    @Path(Routes.GET_COLLABORATORS_BY_HERO)
    @Produces(MediaType.APPLICATION_JSON)
    public Response collaboratorsByHero(@PathParam("hero") String hero) {
        return Response.ok(collaboratorsService.involved(hero)).build();
    }
}
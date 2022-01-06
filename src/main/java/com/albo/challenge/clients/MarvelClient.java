package com.albo.challenge.clients;


import com.albo.challenge.commons.ExternalRoutes;
import com.albo.challenge.dto.response.external.CharactersResponse;
import com.albo.challenge.dto.response.external.ComicsResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path(ExternalRoutes.BASE_MARVEL_ROUTE)
@RegisterRestClient(configKey = "marvel-client-api")
public interface MarvelClient {

    @GET
    @Path(ExternalRoutes.MARVEL_CHARACTERS_BY_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    CharactersResponse getCharactersByName(
            @QueryParam("apikey") String apikey,
            @QueryParam("hash") String hash,
            @QueryParam("ts") String ts,
            @QueryParam("modifiedSince") String modifiedSince,
            @QueryParam("name") String name
    );

    @GET
    @Path(ExternalRoutes.MARVEL_COMICS_BY_CHARACTER)
    @Produces(MediaType.APPLICATION_JSON)
    ComicsResponse getComicsByCharacter(
            @QueryParam("apikey") String apikey,
            @QueryParam("hash") String hash,
            @QueryParam("ts") String ts,
            @QueryParam("modifiedSince") String modifiedSince,
            @PathParam("characterId") Long characterId
    );

    @GET
    @Path(ExternalRoutes.MARVEL_CHARACTER_BY_COMIC)
    @Produces(MediaType.APPLICATION_JSON)
    CharactersResponse getCharacterByComic(
            @QueryParam("apikey") String apikey,
            @QueryParam("hash") String hash,
            @QueryParam("ts") String ts,
            @QueryParam("modifiedSince") String modifiedSince,
            @PathParam("comicId") Long comicId
    );
}

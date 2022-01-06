package com.albo.challenge.resources;


import com.albo.challenge.commons.Routes;
import com.albo.challenge.services.SyncService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path(Routes.BASE_SYNC_ROUTE)
public class SyncResource {

    @Inject
    SyncService syncService;

    @Transactional
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response sync() {
        syncService.syncAll();
        return Response.ok().build();
    }
}
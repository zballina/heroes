package com.albo.challenge.resources;

import com.albo.challenge.commons.Routes;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Map;

@Path(Routes.BASE_ROUTE)
public class HealthCheckResource {

    @GET
    public Map getHealthCheck() {
        return Map.of("status", "UP");
    }
}

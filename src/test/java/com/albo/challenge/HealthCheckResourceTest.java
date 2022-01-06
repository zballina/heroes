package com.albo.challenge;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class HealthCheckResourceTest {

    @Test
    public void testHealthCheckEndpoint() {
        given()
                .when().get("/")
                .then()
                .statusCode(200);
    }

}
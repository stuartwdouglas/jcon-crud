package com.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import com.test.entity.Fruit49;
import com.test.resource.FruitResource49;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestHTTPEndpoint(FruitResource49.class)
public class FruitEndpointTest49 {

    @Test
    public void testFruitEndpoint49() {

        //Create the Pear:
        given()
                .when()
                .body("{\"name\" : \"Pear\"}")
                .contentType("application/json")
                .post()
                .then()
                .statusCode(201);
        int id = given()
                .when().get()
                .then()
                .statusCode(200)
                .body(
                        containsString("Pear"))
                .extract().body().as(Fruit49[].class)[0].getId();

        given()
                .when().delete("" + id)
                .then()
                .statusCode(204);

    }

}

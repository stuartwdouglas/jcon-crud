package com.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import com.test.entity.Fruit73;
import com.test.resource.FruitResource73;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestHTTPEndpoint(FruitResource73.class)
public class FruitEndpointTest73 {

    @Test
    public void testFruitEndpoint73() {

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
                .extract().body().as(Fruit73[].class)[0].getId();

        given()
                .when().delete("" + id)
                .then()
                .statusCode(204);

    }

}

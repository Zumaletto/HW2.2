package ru.netology.rest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEcho {
    @Test
    void shouldSendPostToPostmanEcho() {

        given()
                .baseUri("https://postman-echo.com")
                .body("first test")
                .when()
                .post("/post")
                .then()
                .statusCode(201)
                .body("data", equalTo("first test"));
    }

    @Test
    void shouldSendPostToPostmanEcho2() {

        given()
                .baseUri("https://postman-echo.com")
                .body("second test")
                .header("Content-Type", "application/json; charset=UTF-8")
                .when()
                .post("/post")
                .then()
                .statusCode(201)
                .body("data", equalTo("second test"))
                .contentType(ContentType.JSON);
    }
}

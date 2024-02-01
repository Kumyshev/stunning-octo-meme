package com.example.octomeme;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.example.octomeme.model.Comix;

import io.restassured.RestAssured;

public class MySpringBootTest {

    private static final String URL = "http://localhost:8081/api/books";

    private Comix createComix() {
        Comix comix = new Comix(RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphabetic(15));
        return comix;
    }

    private String createComixURI(Comix comix) {
        var response = RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(comix).post(URL);

        return URL + "/" + response.jsonPath().get("id");
    }

    @Test
    public void getAllComixTestOk() {
        var response = RestAssured.get(URL);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }
}

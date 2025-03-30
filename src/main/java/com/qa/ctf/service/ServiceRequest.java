package com.qa.ctf.service;

import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ServiceRequest extends SpecBuilder {

    public static Response post(String endPoint, Headers headers, HashMap<String, Object> formParams, Cookies cookies) {
        return given(getRequestSpecification())
                .headers(headers)
                .formParams(formParams)
                .cookies(cookies)
                .when()
                .post(endPoint)
                .then()
                .spec(getResponseSpecification())
                .extract()
                .response();
    }

    public static Response get(String endPoint, Cookies cookies) {
        return given(getRequestSpecification())
                .cookies(cookies)
                .when()
                .get(endPoint)
                .then()
                .spec(getResponseSpecification())
                .extract()
                .response();
    }

}

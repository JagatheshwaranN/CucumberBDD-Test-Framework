package com.qa.ctf.service;

import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

/**
 * The ServiceRequest class provides utility methods for making HTTP requests
 * using Rest Assured. It includes methods for sending HTTP GET and POST requests
 * while supporting headers, form parameters, and cookies.
 *
 * <p>Features:
 * <ul>
 *   <li><b>POST Request:</b> Sends an HTTP POST request with headers, form parameters,
 *   and cookies.</li>
 *   <li><b>GET Request:</b> Sends an HTTP GET request with cookies.</li>
 *   <li>Uses a predefined request and response specification for consistency.</li>
 * </ul>
 *
 * <p>Usage Example:
 * <pre>
 * {@code
 * Headers headers = new Headers(new Header("Content-Type", "application/json"));
 * HashMap<String, Object> formParams = new HashMap<>();
 * formParams.put("key", "value");
 * Cookies cookies = new Cookies();
 * Response response = ServiceRequest.post("/endpoint", headers, formParams, cookies);
 * System.out.println("Response: " + response.asString());
 * }
 * </pre>
 *
 * @author Jagatheshwaran N
 * @version 1.0
 */
public class ServiceRequest extends SpecBuilder {

    /**
     * Sends an HTTP POST request to the specified endpoint with headers, form parameters, and cookies.
     *
     * @param endPoint  The target URL endpoint for the POST request.
     * @param headers   The HTTP headers to include in the request.
     * @param formParams A {@code HashMap} containing form parameters to send in the request body.
     * @param cookies   The cookies to be sent with the request.
     * @return The {@code Response} object containing the server's response.
     */
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

    /**
     * Sends an HTTP GET request to the specified endpoint with cookies.
     *
     * @param endPoint The target URL endpoint for the GET request.
     * @param cookies  The cookies to be sent with the request.
     * @return The {@code Response} object containing the server's response.
     */
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

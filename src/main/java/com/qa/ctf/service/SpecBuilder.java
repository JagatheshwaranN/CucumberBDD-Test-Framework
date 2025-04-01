package com.qa.ctf.service;

import com.qa.ctf.constant.TestConstants;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.qa.ctf.constant.TestConstants.BASE_URI;

/**
 * The {@code SpecBuilder} class provides reusable Request and Response specifications
 * for Rest Assured API testing.
 *
 * <p>Features:
 * <ul>
 *   <li><b>Request Specification:</b> Sets a base URI and logs all request details.</li>
 *   <li><b>Response Specification:</b> Logs all response details for debugging.</li>
 * </ul>
 *
 * <p>Example Usage:
 * <pre>
 * {@code
 * RequestSpecification requestSpec = SpecBuilder.getRequestSpecification();
 * ResponseSpecification responseSpec = SpecBuilder.getResponseSpecification();
 * }
 * </pre>
 *
 * @author [Your Name]
 * @version 1.0
 */
public class SpecBuilder {

    /**
     * Returns a pre-configured Request Specification with base URI and logging enabled.
     *
     * @return RequestSpecification instance
     */
    public static RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .log(LogDetail.ALL)
                .build();
    }

    /**
     * Returns a pre-configured Response Specification with logging enabled.
     *
     * @return ResponseSpecification instance
     */
    public static ResponseSpecification getResponseSpecification() {
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }
}
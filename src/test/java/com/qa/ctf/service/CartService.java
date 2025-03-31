package com.qa.ctf.service;

import com.qa.ctf.constant.Endpoint;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.HashMap;

/**
 * The {@code CartService} class provides methods to interact with the cart
 * in the application.
 * <p>
 * This class contains methods for adding products to the cart using service
 * calls and managing the cookies required for authentication and session
 * management.
 * </p>
 *
 * @author Jagatheshwaran N
 * @version 1.1
 */
public class CartService {

    /** The cookies used for authentication and session management. */
    private Cookies cookies;

    /**
     * Constructs a {@code CartService} instance with the given cookies.
     *
     * @param cookies The cookies containing session and authentication
     *                details for the user.
     */
    public CartService(Cookies cookies) {
        this.cookies = cookies;
    }

    /**
     * Retrieves the cookies associated with the current session.
     * <p>
     * This method provides access to the cookies that are used to authenticate
     * and manage the user session during interactions with the cart service.
     * </p>
     *
     * @return The cookies associated with the current session.
     */
    public Cookies getCookies() {
        return cookies;
    }

    /**
     * Adds a product to the cart using a service call.
     * <p>
     * This method sends a POST request to the {@code ADD_TO_CART} endpoint with
     * the given product ID and quantity. The request includes the necessary headers
     * and form parameters, and the cookies are updated based on the response.
     * </p>
     *
     * @param productId The ID of the product to be added to the cart.
     * @param quantity  The quantity of the product to be added to the cart.
     * @throws RuntimeException If the HTTP status code is not 200 (OK), indicating failure.
     */
    public void addToCartUsingService(int productId, int quantity) {
        Header header = new Header("content-type", "application/x-www-form-urlencoded");
        Headers headers = new Headers(header);
        HashMap<String, Object> formParams = new HashMap<>();
        formParams.put("product_sku", "");
        formParams.put("product_id", productId);
        formParams.put("quantity", quantity);
        Response response = ServiceRequest.post(Endpoint.ADD_TO_CART.url, headers, formParams, cookies);
        if (response.getStatusCode() != 200) {
            throw new RuntimeException(String.format("Failed to add product %s to the cart and HTTP Status Code %d", productId, response.getStatusCode()));
        }
        this.cookies = response.getDetailedCookies(); // Update cookies based on response
    }

}

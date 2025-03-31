package com.qa.ctf.constant;

/**
 * Enum representing various application endpoints used in the test framework.
 *
 * @author Jagatheshwaran N
 * @version 1.0
 */
public enum Endpoint {

    /** Endpoint for the Store page. */
    STORE("/store"),

    /** Endpoint for the Account page. */
    ACCOUNT("/account"),

    /** Endpoint for adding a product to the cart via AJAX request. */
    ADD_TO_CART("/?wc-ajax=add_to_cart"),

    /** Endpoint for the Checkout page. */
    CHECKOUT("/checkout");

    /** The URL associated with the endpoint. */
    public final String url;

    /**
     * Constructor to initialize the endpoint with a specific URL.
     * @param url The URL corresponding to the endpoint.
     */
    Endpoint(String url) {
        this.url = url;
    }
}

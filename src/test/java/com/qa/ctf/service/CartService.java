package com.qa.ctf.service;

import com.qa.ctf.constant.Endpoint;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.HashMap;

public class CartService {

    private Cookies cookies;

    public CartService(Cookies cookies) {
        this.cookies = cookies;
    }

    public Cookies getCookies() {
        return cookies;
    }

    public Response addToCartUsingService(int productId, int quantity) {
        Header header = new Header("content-type", "application/x-www-form-urlencoded");
        Headers headers = new Headers(header);
        HashMap<String, Object> formParams = new HashMap<>();
        formParams.put("product_sku", "");
        formParams.put("product_id", productId);
        formParams.put("quantity", quantity);
        Response response = ServiceRequest.post(Endpoint.ADD_TO_CART.url, headers, formParams, cookies);
        if(response.getStatusCode() != 200) {
            throw new RuntimeException(String.format("Failed to add product %s to the cart and HTTP Status Code %d", productId, response.getStatusCode()));
        }
        this.cookies = response.getDetailedCookies();
        return response;
    }

}

package com.qa.ctf.context;

import com.qa.ctf.app.Cookies;
import com.qa.ctf.domain.BillingDetails;

/**
 * Represents the context of the application, holding important details needed for the
 * application under test.
 *
 * @author Jagatheshwaran N
 * @version 1.0
 */
public class AppContext {

    /** The billing details associated with the application context. */
    public BillingDetails billingDetails;

    /** The cookies associated with the current session in the application. */
    public Cookies cookies;

    /**
     * Constructor to initialize the {@code AppContext} with a new {@code Cookies} instance.
     * It also sets the cookies to an empty set of cookies.
     */
    public AppContext() {
        cookies = new Cookies();
        cookies.setCookies(new io.restassured.http.Cookies());
    }

}

package com.qa.ctf.steps;

import com.qa.ctf.constant.Endpoint;
import com.qa.ctf.context.AppContext;
import com.qa.ctf.context.TestContext;
import com.qa.ctf.data.BillingDetails;
import com.qa.ctf.pages.StorePage;
import io.cucumber.java.en.Given;

public class CustomerSteps extends BaseSteps {

    private final StorePage storePage;
    private final AppContext appContext;

    public CustomerSteps(AppContext appContext, TestContext testContext) {
        super(testContext);
        this.appContext = appContext;
        this.storePage = pageFactory.getStorePage(testContext);
    }

    @Given("I'm a guest user")
    public void i_m_a_guest_user() {
        storePage.load(Endpoint.STORE.url);
    }

    @Given("my billing details are")
    public void my_billing_details_are(BillingDetails billingDetails) {
        appContext.billingDetails = billingDetails;
    }

}

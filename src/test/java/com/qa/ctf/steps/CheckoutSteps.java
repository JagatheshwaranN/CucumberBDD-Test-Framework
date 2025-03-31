package com.qa.ctf.steps;

import com.qa.ctf.constant.Endpoint;
import com.qa.ctf.context.AppContext;
import com.qa.ctf.context.TestContext;
import com.qa.ctf.pages.CheckoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

/**
 * The {@code CheckoutSteps} class contains step definitions for actions
 * and verifications related to the checkout process.
 * <p>
 * This class extends {@code BaseSteps} to leverage the {@code PageFactory}
 * for accessing page objects. It defines steps for interacting with the
 * checkout page, such as providing billing details, placing an order, and
 * verifying the order status.
 * </p>
 *
 * @author Jagatheshwaran N
 * @version 1.1
 */
public class CheckoutSteps extends BaseSteps {

    /** The {@code CheckoutPage} instance used for interacting with the checkout page. */
    private final CheckoutPage checkoutPage;

    /** The {@code AppContext} instance used for accessing application-wide data. */
    private final AppContext appContext;

    /**
     * Constructs a {@code CheckoutSteps} instance with the given application
     * context and test context.
     * <p>
     * This constructor initializes the {@code CheckoutPage} and {@code AppContext}
     * using the {@code PageFactory}.
     * </p>
     *
     * @param appContext  The application context containing global data such as
     *                    billing details.
     * @param testContext The test context containing information for managing the
     *                    state of the test.
     */
    public CheckoutSteps(AppContext appContext, TestContext testContext) {
        super(testContext);
        this.appContext = appContext;
        this.checkoutPage = pageFactory.getCheckoutPage(testContext);
    }

    /**
     * Navigates to the checkout page.
     * <p>
     * This step ensures that the user is on the checkout page before proceeding
     * with further actions.
     * </p>
     */
    @Given("I'm on the checkout page")
    public void i_m_on_the_checkout_page() {
        checkoutPage.load(Endpoint.CHECKOUT.url);
    }

    /**
     * Provides the billing details on the checkout page.
     * <p>
     * This step uses the billing details from the {@code AppContext} to populate
     * the checkout form.
     * </p>
     */
    @When("I provide the billing details")
    public void i_provide_the_billing_details() {
        checkoutPage.setBillingDetails(appContext.billingDetails);
    }

    /**
     * Places the order by submitting the checkout form.
     * <p>
     * This step clicks the "Place Order" button to finalize the checkout process.
     * </p>
     */
    @When("I place an order")
    public void i_place_an_order() {
        checkoutPage.placeOrder();
    }

    /**
     * Verifies that the order was placed successfully.
     * <p>
     * This step ensures that the order was placed by checking the confirmation
     * message displayed on the checkout page.
     * </p>
     */
    @Then("the order should be placed successfully")
    public void the_order_should_be_placed_successfully() {
        Assert.assertEquals("Thank you. Your order has been received.",
                checkoutPage.getNotice(), "The order confirmation message did not match.");
    }

}

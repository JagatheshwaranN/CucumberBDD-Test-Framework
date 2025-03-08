package com.qa.ctf.steps;

import com.qa.ctf.constant.Endpoint;
import com.qa.ctf.context.TestContext;
import com.qa.ctf.data.Product;
import com.qa.ctf.pages.StorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StoreSteps extends BaseSteps {

    private final StorePage storePage;

    public StoreSteps(TestContext testContext) {
        super(testContext);
        this.storePage = pageFactory.getStorePage(testContext);
    }

    @Given("I'm on the Store page")
    public void i_m_on_the_store_page() {
        storePage.load(Endpoint.STORE.url);
    }

    @When("I add a {product} to the cart")
    public void i_add_a_to_the_cart(Product product) {
        storePage.addToCart(product.getProductName());
    }

    @Given("I have a {product} in the cart")
    public void i_have_a_product_in_the_cart(Product product) {
        storePage.addToCart(product.getProductName());
    }

}

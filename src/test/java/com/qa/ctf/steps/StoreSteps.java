package com.qa.ctf.steps;

import com.qa.ctf.constant.Endpoint;
import com.qa.ctf.context.AppContext;
import com.qa.ctf.context.TestContext;
import com.qa.ctf.domain.Product;
import com.qa.ctf.pages.StorePage;
import com.qa.ctf.service.CartService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StoreSteps extends BaseSteps {

    private final TestContext testContext;
    private final AppContext appContext;

    private final StorePage storePage;

    public StoreSteps(TestContext testContext, AppContext appContext) {
        super(testContext);
        this.testContext = testContext;
        this.appContext = appContext;
        this.storePage = pageFactory.getStorePage(testContext);
    }

    @Given("I'm on the Store page")
    public void i_m_on_the_store_page() {
        storePage.load(Endpoint.STORE.url);
    }

    @When("I add a {product} to the cart")
    public void i_add_a_to_the_cart(Product product) {
        storePage.addToCart(product.productName());
    }

    @Given("I have a {product} in the cart")
    public void i_have_a_product_in_the_cart(Product product) {
        storePage.addToCart(product.productName());
    }

    @Given("I have a {int} in the cart via service")
    public void i_have_a_product_in_the_cart_service(Integer product) {
        CartService cartService = new CartService(appContext.cookies.getCookies());
        cartService.addToCartUsingService(product, 1);
        appContext.cookies.setCookies(cartService.getCookies());
        appContext.cookies.injectCookiesToBrowser(testContext);
    }

}

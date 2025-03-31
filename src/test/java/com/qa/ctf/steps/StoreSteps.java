package com.qa.ctf.steps;

import com.qa.ctf.constant.Endpoint;
import com.qa.ctf.context.AppContext;
import com.qa.ctf.context.TestContext;
import com.qa.ctf.domain.Product;
import com.qa.ctf.pages.StorePage;
import com.qa.ctf.service.CartService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

/**
 * The {@code StoreSteps} class contains step definitions for actions related
 * to interacting with the store page,
 * such as adding products to the cart and verifying the cart contents.
 * <p>
 * This class includes steps for navigating to the store page, adding products
 * to the cart either through the UI or via a service, and other store-related
 * interactions.
 * </p>
 *
 * @author Jagatheshwaran N
 * @version 1.1
 */
public class StoreSteps extends BaseSteps {

    /** The {@code TestContext} instance containing test-related information. */
    private final TestContext testContext;

    /** The {@code AppContext} instance containing application context, such as cookies. */
    private final AppContext appContext;

    /** The {@code StorePage} instance used to interact with the store page of the application. */
    private final StorePage storePage;

    /**
     * Constructs a {@code StoreSteps} instance with the given test and
     * application contexts.
     * <p>
     * This constructor initializes the {@code StorePage} instance using the
     * {@code PageFactory}.
     * </p>
     *
     * @param testContext The test context containing information for managing the
     *                    state of the test.
     * @param appContext The application context containing application-specific data,
     *                  such as cookies.
     */
    public StoreSteps(TestContext testContext, AppContext appContext) {
        super(testContext);
        this.testContext = testContext;
        this.appContext = appContext;
        this.storePage = pageFactory.getStorePage(testContext);
    }

    /**
     * Navigates to the store page of the application.
     * <p>
     * This step loads the store page using the endpoint provided in the {@code
     * Endpoint} class.
     * </p>
     */
    @Given("I'm on the Store page")
    public void i_m_on_the_store_page() {
        storePage.load(Endpoint.STORE.url);
    }

    /**
     * Adds the specified product to the cart through the store page UI.
     * <p>
     * This step selects a product and adds it to the shopping cart by interacting
     * with the store page.
     * </p>
     *
     * @param product The product to be added to the cart.
     */
    @When("I add a {product} to the cart")
    public void i_add_a_to_the_cart(Product product) {
        storePage.addToCart(product.productName());
    }

    /**
     * Adds the specified product to the cart through the store page UI.
     * <p>
     * This step ensures that the given product is added to the cart before continuing
     * with the test.
     * </p>
     *
     * @param product The product to be added to the cart.
     */
    @Given("I have a {product} in the cart")
    public void i_have_a_product_in_the_cart(Product product) {
        storePage.addToCart(product.productName());
    }

    /**
     * Adds a product to the cart via the service, using the product ID.
     * <p>
     * This step adds a product to the cart programmatically using the {@code
     * CartService}.
     * </p>
     *
     * @param product The product ID to be added to the cart.
     */
    @Given("I have a {int} in the cart via service")
    public void i_have_a_product_in_the_cart_service(Integer product) {
        CartService cartService = new CartService(appContext.cookies.getCookies());
        cartService.addToCartUsingService(product, 1);
        appContext.cookies.setCookies(cartService.getCookies());
        appContext.cookies.injectCookiesToBrowser(testContext);
    }

}

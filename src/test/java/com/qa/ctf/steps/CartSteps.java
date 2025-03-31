package com.qa.ctf.steps;

import com.qa.ctf.context.TestContext;
import com.qa.ctf.domain.Product;
import com.qa.ctf.pages.CartPage;
import io.cucumber.java.en.Then;
import org.testng.Assert;

/**
 * The {@code CartSteps} class contains step definitions for actions and
 * verifications related to the cart page.
 * <p>
 * This class extends {@code BaseSteps} to leverage the {@code PageFactory}
 * for accessing page objects. It defines a step to verify the product and
 * its quantity in the cart.
 * </p>
 *
 * @author Jagatheshwaran N
 * @version 1.1
 */
public class CartSteps extends BaseSteps {

    /** The {@code CartPage} instance used for interacting with the cart page. */
    private final CartPage cartPage;

    /**
     * Constructs a {@code CartSteps} instance with the given test context.
     * <p>
     * This constructor initializes the {@code CartPage} using the {@code PageFactory}
     * provided by the {@code BaseSteps}.
     * </p>
     *
     * @param testContext The test context containing information for managing the
     *                    state of the test.
     */
    public CartSteps(TestContext testContext) {
        super(testContext);
        this.cartPage = pageFactory.getCartPage(testContext);
    }

    /**
     * Verifies that the specified product with the given quantity is present
     * in the cart.
     * <p>
     * This step checks that the product name and quantity in the cart match the
     * expected values.
     * </p>
     *
     * @param quantity The expected quantity of the product in the cart.
     * @param product  The {@code Product} object containing the expected product
     *                 details.
     */
    @Then("I should see {int} {product} in the cart")
    public void i_should_see_in_the_cart(Integer quantity, Product product) {
        Assert.assertEquals(product.productName(), cartPage.getProductName(), "Product name does not match.");
        Assert.assertEquals(quantity, cartPage.getProductQuantity(), "Product quantity does not match.");
    }

}

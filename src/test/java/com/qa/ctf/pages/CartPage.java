package com.qa.ctf.pages;

import com.qa.ctf.base.PageComponent;
import com.qa.ctf.context.TestContext;
import com.qa.ctf.handler.VerificationHandler;
import com.qa.ctf.objects.CartPageObject;

/**
 * Page class representing the Cart page of the application.
 * <p>
 * This class extends {@code CartPageObject} and provides additional actions
 * and verifications specific to the Cart page, such as retrieving product name,
 * quantity, and proceeding to checkout.
 * </p>
 *
 * @author Jagatheshwaran N
 * @version 1.1
 */
public class CartPage extends CartPageObject {

    /**
     * Instance of VerificationHandler for verifying elements on the page.
     */
    private final VerificationHandler verificationHandler;

    /**
     * Instance of PageComponent for interacting with page elements.
     */
    private final PageComponent pageComponent;

    /**
     * Constructs a {@code CartPage} instance with the given test context.
     *
     * @param testContext The test context containing information for managing
     *                    the state of the test.
     */
    public CartPage(TestContext testContext) {
        super(testContext);
        this.verificationHandler = pageFactory.getVerificationHelper();
        this.pageComponent = pageFactory.getPageComponent();
    }

    /**
     * Retrieves the name of the product from the cart.
     * <p>
     * This method uses the {@code VerificationHandler} to read the text value
     * of the product name displayed in the cart.
     * </p>
     *
     * @return The name of the product in the cart.
     */
    public String getProductName() {
        return verificationHandler.readTextValueFromElement(getProductNameFld(), getProductNameFldLabel());
    }

    /**
     * Retrieves the quantity of the product in the cart.
     * <p>
     * This method uses the {@code VerificationHandler} to read the value from
     * the product quantity input field and parses it to an integer.
     * </p>
     *
     * @return The quantity of the product in the cart.
     */
    public int getProductQuantity() {
        return Integer.parseInt(verificationHandler.readValueFromInput(getProductQuantityFld(), getProductQuantityFldLabel()));
    }

    /**
     * Proceeds to the checkout page by clicking the "Proceed to Checkout" button.
     * <p>
     * This method interacts with the {@code PageComponent} to click on the checkout
     * button and navigate to the checkout page.
     * </p>
     */
    public void proceedToCheckout() {
        pageComponent.clickElement(getProceedToCheckoutBtn(), getProceedToCheckoutBtnLabel());
    }

}

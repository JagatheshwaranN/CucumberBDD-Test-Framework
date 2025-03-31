package com.qa.ctf.pages;

import com.qa.ctf.base.PageComponent;
import com.qa.ctf.context.TestContext;
import com.qa.ctf.handler.VerificationHandler;
import com.qa.ctf.handler.WaitHandler;
import com.qa.ctf.objects.StorePageObject;

/**
 * Page class representing the Store page of the application.
 * <p>
 * This class extends {@code StorePageObject} and provides additional actions
 * for interacting with the store page, such as adding a product to the cart
 * and navigating to the cart page.
 * </p>
 *
 * @author Jagatheshwaran N
 * @version 1.1
 */
public class StorePage extends StorePageObject {

    /** Instance of VerificationHandler for verifying elements on the page. */
    private final VerificationHandler verificationHandler;

    /** Instance of PageComponent for interacting with page elements. */
    private final PageComponent pageComponent;

    /** Instance of WaitHandler for handling explicit waits. */
    private final WaitHandler waitHandler;

    /**
     * Constructs a {@code StorePage} instance with the given test context.
     *
     * @param testContext The test context containing information for managing the state of the test.
     */
    public StorePage(TestContext testContext) {
        super(testContext);
        this.verificationHandler = pageFactory.getVerificationHelper();
        this.pageComponent = pageFactory.getPageComponent();
        this.waitHandler = pageFactory.getWaitHandler();
    }

    /**
     * Adds the specified product to the cart and navigates to the cart page.
     * <p>
     * This method clicks the "Add to Cart" button for the given product and
     * waits for the cart link to become visible. Then, it navigates to the cart page.
     * </p>
     *
     * @param productName The name of the product to be added to the cart.
     */
    public void addToCart(String productName) {
        verificationHandler.isElementDisplayed(getTitleText(), getTitleTextLabel());
        pageComponent.clickElement(getAddToCartBtn(), productName, getAddToCartBtnLabel());
        waitHandler.waitForElementVisible(getViewCartLink(), getViewCartLinkLabel());
        pageComponent.clickElement(getViewCartLink(), getViewCartLinkLabel());
    }

}

package com.qa.ctf.pages;

import com.qa.ctf.base.PageComponent;
import com.qa.ctf.context.TestContext;
import com.qa.ctf.domain.BillingDetails;
import com.qa.ctf.handler.DropDownHandler;
import com.qa.ctf.handler.VerificationHandler;
import com.qa.ctf.objects.CheckoutPageObject;

/**
 * Page class representing the Checkout page of the application.
 * <p>
 * This class extends {@code CheckoutPageObject} and provides additional
 * actions for interacting with the checkout form, including entering billing
 * information, selecting billing state, and placing the order.
 * </p>
 *
 * @author Jagatheshwaran N
 * @version 1.1
 */
@SuppressWarnings("UnusedReturnValue")
public class CheckoutPage extends CheckoutPageObject {

    /** Instance of VerificationHandler for verifying elements on the page. */
    private final VerificationHandler verificationHandler;

    /** Instance of PageComponent for interacting with page elements. */
    private final PageComponent pageComponent;

    /** Instance of DropDownHandler for interacting with dropdown elements. */
    private final DropDownHandler dropDownHandler;

    /**
     * Constructs a {@code CheckoutPage} instance with the given test context.
     *
     * @param testContext The test context containing information for managing
     *                    the state of the test.
     */
    public CheckoutPage(TestContext testContext) {
        super(testContext);
        this.verificationHandler = pageFactory.getVerificationHelper();
        this.pageComponent = pageFactory.getPageComponent();
        this.dropDownHandler = pageFactory.getDropDownHandler();
    }

    /**
     * Enters the billing first name in the checkout form.
     *
     * @param billingFirstName The billing first name to be entered.
     * @return The current {@code CheckoutPage} instance for method chaining.
     */
    public CheckoutPage enterBillingFirstName(String billingFirstName) {
        pageComponent.typeText(getBillFirstNameFld(), billingFirstName, getBillFirstNameFldLabel());
        return this;
    }

    /**
     * Enters the billing last name in the checkout form.
     *
     * @param billingLastName The billing last name to be entered.
     * @return The current {@code CheckoutPage} instance for method chaining.
     */
    public CheckoutPage enterBillingLastName(String billingLastName) {
        pageComponent.typeText(getBillLastNameFld(), billingLastName, getBillLastNameFldLabel());
        return this;
    }

    /**
     * Enters the billing address in the checkout form.
     *
     * @param billingAddress The billing address to be entered.
     * @return The current {@code CheckoutPage} instance for method chaining.
     */
    public CheckoutPage enterBillingAddress(String billingAddress) {
        pageComponent.typeText(getBillAddressFld(), billingAddress, getBillAddressFldLabel());
        return this;
    }

    /**
     * Enters the billing city in the checkout form.
     *
     * @param billingCity The billing city to be entered.
     * @return The current {@code CheckoutPage} instance for method chaining.
     */
    public CheckoutPage enterBillingCity(String billingCity) {
        pageComponent.typeText(getBillCityFld(), billingCity, getBillCityFldLabel());
        return this;
    }

    /**
     * Selects the billing state from the dropdown in the checkout form.
     *
     * @param billingState The billing state to be selected.
     * @return The current {@code CheckoutPage} instance for method chaining.
     */
    public CheckoutPage selectBillingState(String billingState) {
        dropDownHandler.selectOptionByVisibleText(getBillStateDropdown(), billingState, getBillStateDropdownLabel());
        return this;
    }

    /**
     * Enters the billing postcode (zipcode) in the checkout form.
     *
     * @param billingZipcode The billing zipcode to be entered.
     * @return The current {@code CheckoutPage} instance for method chaining.
     */
    public CheckoutPage enterBillingZipcode(String billingZipcode) {
        pageComponent.typeText(getBillZipFld(), billingZipcode, getBillZipFldLabel());
        return this;
    }

    /**
     * Enters the billing email in the checkout form.
     *
     * @param billingEmail The billing email to be entered.
     * @return The current {@code CheckoutPage} instance for method chaining.
     */
    public CheckoutPage enterBillingEmail(String billingEmail) {
        pageComponent.typeText(getBillEmailFld(), billingEmail, getBillEmailFldLabel());
        return this;
    }

    /**
     * Sets all billing details in the checkout form.
     * <p>
     * This method allows the user to set all billing information using a
     * {@link BillingDetails} object.
     * </p>
     *
     * @param billingDetails The billing details object containing all the billing
     *                      information.
     * @return The current {@code CheckoutPage} instance for method chaining.
     */
    public CheckoutPage setBillingDetails(BillingDetails billingDetails) {
        return enterBillingFirstName(billingDetails.billingFirstName())
                .enterBillingLastName(billingDetails.billingLastName())
                .enterBillingAddress(billingDetails.billingAddressLine())
                .enterBillingCity(billingDetails.billingCity())
                .selectBillingState(billingDetails.billingState())
                .enterBillingZipcode(billingDetails.billingZipcode())
                .enterBillingEmail(billingDetails.billingEmail());
    }

    /**
     * Clicks the "Place Order" button to place the order.
     *
     * @return The current {@code CheckoutPage} instance for method chaining.
     */
    public CheckoutPage placeOrder() {
        pageComponent.clickElement(getPlaceOrderBtn(), getPlaceOrderBtnLabel());
        return this;
    }

    /**
     * Retrieves the notice text displayed after placing the order.
     *
     * @return The notice text displayed on the checkout page.
     */
    public String getNotice() {
        return verificationHandler.readTextValueFromElement(getNoticeTxt(), getNoticeTxtLabel());
    }

}

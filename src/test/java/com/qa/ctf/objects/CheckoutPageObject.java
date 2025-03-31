package com.qa.ctf.objects;

import com.qa.ctf.base.PageBase;
import com.qa.ctf.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object representing the Checkout page of the application.
 * <p>
 * This class provides the elements and actions related to the Checkout page.
 * It includes WebElement references to fields such as billing information
 * (first name, last name, address, etc.), the place order button, and the
 * notice message displayed after placing the order, along with their respective
 * labels for easier interaction in the automation framework.
 * </p>
 *
 * @author Jagatheshwaran N
 * @version 1.1
 */
public class CheckoutPageObject extends PageBase {

    /** Web element representing the billing first name field. */
    @FindBy(id = "billing_first_name")
    protected WebElement billFirstNameFld;

    /** Label for the billing first name field. */
    protected String billFirstNameFldLabel = "Billing First Name";

    /** Web element representing the billing last name field. */
    @FindBy(id = "billing_last_name")
    protected WebElement billLastNameFld;

    /** Label for the billing last name field. */
    protected String billLastNameFldLabel = "Billing Last Name";

    /** Web element representing the billing address field. */
    @FindBy(id = "billing_address_1")
    protected WebElement billAddressFld;

    /** Label for the billing address field. */
    protected String billAddressFldLabel = "Billing Address";

    /** Web element representing the billing city field. */
    @FindBy(id = "billing_city")
    protected WebElement billCityFld;

    /** Label for the billing city field. */
    protected String billCityFldLabel = "Billing City";

    /** Web element representing the billing state dropdown. */
    @FindBy(id = "billing_state")
    protected WebElement billStateDropdown;

    /** Label for the billing state dropdown. */
    protected String billStateDropdownLabel = "Billing State";

    /** Web element representing the billing postcode field. */
    @FindBy(id = "billing_postcode")
    protected WebElement billZipFld;

    /** Label for the billing postcode field. */
    protected String billZipFldLabel = "Billing Postcode";

    /** Web element representing the billing email field. */
    @FindBy(id = "billing_email")
    protected WebElement billEmailFld;

    /** Label for the billing email field. */
    protected String billEmailFldLabel = "Billing Email";

    /** Web element representing the place order button. */
    @FindBy(id = "place_order")
    protected WebElement placeOrderBtn;

    /** Label for the place order button. */
    protected String placeOrderBtnLabel = "Place Order";

    /** Web element representing the notice message displayed after placing an order. */
    @FindBy(css = ".woocommerce-notice")
    protected WebElement noticeTxt;

    /** Label for the notice message displayed after placing an order. */
    protected String noticeTxtLabel = "Place Order Message";


    /**
     * Constructs a {@code CheckoutPageObject} instance with the given test context.
     *
     * @param testContext The test context containing information for managing the
     *                    state of the test.
     */
    public CheckoutPageObject(TestContext testContext) {
        super(testContext);
    }

    /**
     * Gets the billing first name field WebElement.
     *
     * @return The WebElement representing the billing first name field.
     */
    public WebElement getBillFirstNameFld() {
        return billFirstNameFld;
    }

    /**
     * Gets the label for the billing first name field.
     *
     * @return The label for the billing first name field.
     */
    public String getBillFirstNameFldLabel() {
        return billFirstNameFldLabel;
    }

    /**
     * Gets the billing last name field WebElement.
     *
     * @return The WebElement representing the billing last name field.
     */
    public WebElement getBillLastNameFld() {
        return billLastNameFld;
    }

    /**
     * Gets the label for the billing last name field.
     *
     * @return The label for the billing last name field.
     */
    public String getBillLastNameFldLabel() {
        return billLastNameFldLabel;
    }

    /**
     * Gets the billing address field WebElement.
     *
     * @return The WebElement representing the billing address field.
     */
    public WebElement getBillAddressFld() {
        return billAddressFld;
    }

    /**
     * Gets the label for the billing address field.
     *
     * @return The label for the billing address field.
     */
    public String getBillAddressFldLabel() {
        return billAddressFldLabel;
    }

    /**
     * Gets the billing city field WebElement.
     *
     * @return The WebElement representing the billing city field.
     */
    public WebElement getBillCityFld() {
        return billCityFld;
    }

    /**
     * Gets the label for the billing city field.
     *
     * @return The label for the billing city field.
     */
    public String getBillCityFldLabel() {
        return billCityFldLabel;
    }

    /**
     * Gets the billing state dropdown WebElement.
     *
     * @return The WebElement representing the billing state dropdown.
     */
    public WebElement getBillStateDropdown() {
        return billStateDropdown;
    }

    /**
     * Gets the label for the billing state dropdown.
     *
     * @return The label for the billing state dropdown.
     */
    public String getBillStateDropdownLabel() {
        return billStateDropdownLabel;
    }

    /**
     * Gets the billing postcode field WebElement.
     *
     * @return The WebElement representing the billing postcode field.
     */
    public WebElement getBillZipFld() {
        return billZipFld;
    }

    /**
     * Gets the label for the billing postcode field.
     *
     * @return The label for the billing postcode field.
     */
    public String getBillZipFldLabel() {
        return billZipFldLabel;
    }

    /**
     * Gets the billing email field WebElement.
     *
     * @return The WebElement representing the billing email field.
     */
    public WebElement getBillEmailFld() {
        return billEmailFld;
    }

    /**
     * Gets the label for the billing email field.
     *
     * @return The label for the billing email field.
     */
    public String getBillEmailFldLabel() {
        return billEmailFldLabel;
    }

    /**
     * Gets the place order button WebElement.
     *
     * @return The WebElement representing the place order button.
     */
    public WebElement getPlaceOrderBtn() {
        return placeOrderBtn;
    }

    /**
     * Gets the label for the place order button.
     *
     * @return The label for the place order button.
     */
    public String getPlaceOrderBtnLabel() {
        return placeOrderBtnLabel;
    }

    /**
     * Gets the notice text WebElement.
     *
     * @return The WebElement representing the place order notice message.
     */
    public WebElement getNoticeTxt() {
        return noticeTxt;
    }

    /**
     * Gets the label for the notice message displayed after placing an order.
     *
     * @return The label for the place order notice message.
     */
    public String getNoticeTxtLabel() {
        return noticeTxtLabel;
    }

}

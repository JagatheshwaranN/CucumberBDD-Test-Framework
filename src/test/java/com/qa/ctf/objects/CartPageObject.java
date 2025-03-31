package com.qa.ctf.objects;

import com.qa.ctf.base.PageBase;
import com.qa.ctf.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object representing the Cart page of the application.
 * <p>
 * This class provides the elements and actions related to the Cart page.
 * It includes WebElement references to the product name field, product quantity
 * field, and the proceed-to-checkout button, along with their respective labels
 * for easier interaction in the automation framework.
 * </p>
 *
 * @author Jagatheshwaran N
 * @version 1.1
 */
public class CartPageObject extends PageBase {

    /** Web element representing the product name field. */
    @FindBy(css = "td[class='product-name'] a")
    protected WebElement productNameFld;

    /** Label for the product name field. */
    protected String productNameFldLabel = "Product Name";

    /** Web element representing the product quantity field. */
    @FindBy(css = "input[type='number']")
    protected WebElement productQuantityFld;

    /** Label for the product quantity field. */
    protected String productQuantityFldLabel = "Product Qty";

    /** Web element representing the proceed to checkout button. */
    @FindBy(css = ".checkout-button")
    protected WebElement proceedToCheckoutBtn;

    /** Label for the proceed to checkout button. */
    protected String proceedToCheckoutBtnLabel = "Proceed To Checkout Button";

    /**
     * Constructs a {@code CartPageObject} instance with the given test context.
     *
     * @param testContext The test context containing information for managing the state of the test.
     */
    public CartPageObject(TestContext testContext) {
        super(testContext);
    }

    /**
     * Gets the product name field WebElement.
     *
     * @return The WebElement representing the product name field.
     */
    public WebElement getProductNameFld() {
        return productNameFld;
    }

    /**
     * Gets the label for the product name field.
     *
     * @return The label for the product name field.
     */
    public String getProductNameFldLabel() {
        return productNameFldLabel;
    }

    /**
     * Gets the product quantity field WebElement.
     *
     * @return The WebElement representing the product quantity field.
     */
    public WebElement getProductQuantityFld() {
        return productQuantityFld;
    }

    /**
     * Gets the label for the product quantity field.
     *
     * @return The label for the product quantity field.
     */
    public String getProductQuantityFldLabel() {
        return productQuantityFldLabel;
    }

    /**
     * Gets the proceed to checkout button WebElement.
     *
     * @return The WebElement representing the proceed to checkout button.
     */
    public WebElement getProceedToCheckoutBtn() {
        return proceedToCheckoutBtn;
    }

    /**
     * Gets the label for the proceed to checkout button.
     *
     * @return The label for the proceed to checkout button.
     */
    public String getProceedToCheckoutBtnLabel() {
        return proceedToCheckoutBtnLabel;
    }

}

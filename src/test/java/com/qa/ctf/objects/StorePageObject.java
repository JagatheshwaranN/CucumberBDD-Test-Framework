package com.qa.ctf.objects;

import com.qa.ctf.base.PageBase;
import com.qa.ctf.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object representing the Store page of the application.
 * <p>
 * This class provides the elements and actions related to the Store page.
 * It includes WebElement references for the store page title, view cart
 * link, and add-to-cart buttons, along with their respective labels for
 * easier interaction in the automation framework.
 * </p>
 *
 * @author Jagatheshwaran N
 * @version 1.1
 */
public class StorePageObject extends PageBase {

    /** Web element representing the store page title. */
    @FindBy(xpath = "//h1[text()='Store']")
    protected WebElement titleText;

    /** Label for the store page title. */
    protected String titleTextLabel = "Store Page Title";

    /** Web element representing the view cart link. */
    @FindBy(css = "a[title='View cart']")
    protected WebElement viewCartLink;

    /** Label for the view cart link. */
    protected String viewCartLinkLabel = "View Cart Link";

    /** XPath template for the add to cart button. */
    protected String addToCartBtn = "//a[contains(@aria-label,'%s')]";

    /** Label for the add to cart button. */
    protected String addToCartBtnLabel = "Add To Cart Button";

    /**
     * Constructs a {@code StorePageObject} instance with the given test context.
     *
     * @param testContext The test context containing information for managing the
     *                    state of the test.
     */
    public StorePageObject(TestContext testContext) {
        super(testContext);
    }

    /**
     * Gets the store page title WebElement.
     *
     * @return The WebElement representing the store page title.
     */
    public WebElement getTitleText() {
        return titleText;
    }

    /**
     * Gets the label for the store page title.
     *
     * @return The label for the store page title.
     */
    public String getTitleTextLabel() {
        return titleTextLabel;
    }

    /**
     * Gets the view cart link WebElement.
     *
     * @return The WebElement representing the view cart link.
     */
    public WebElement getViewCartLink() {
        return viewCartLink;
    }

    /**
     * Gets the label for the view cart link.
     *
     * @return The label for the view cart link.
     */
    public String getViewCartLinkLabel() {
        return viewCartLinkLabel;
    }

    /**
     * Gets the XPath template for the add to cart button.
     *
     * @return The XPath template for the add to cart button.
     */
    public String getAddToCartBtn() {
        return addToCartBtn;
    }

    /**
     * Gets the label for the add to cart button.
     *
     * @return The label for the add to cart button.
     */
    public String getAddToCartBtnLabel() {
        return addToCartBtnLabel;
    }

}

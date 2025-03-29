package com.qa.ctf.objects;

import com.qa.ctf.base.PageBase;
import com.qa.ctf.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StorePageObject extends PageBase {

    @FindBy(xpath = "//h1[text()='Store']")
    protected WebElement titleText;
    protected String titleTextLabel = "Store Page Title";

    @FindBy(css = "a[title='View cart']")
    protected WebElement viewCartLink;
    protected String viewCartLinkLabel = "View Cart Link";

    protected String addToCartBtn = "//a[contains(@aria-label,'%s')]";
    protected String addToCartBtnLabel = "Add To Cart Button";

    public StorePageObject(TestContext testContext) {
        super(testContext);
    }

    public WebElement getTitleText() {
        return titleText;
    }

    public String getTitleTextLabel() {
        return titleTextLabel;
    }

    public WebElement getViewCartLink() {
        return viewCartLink;
    }

    public String getViewCartLinkLabel() {
        return viewCartLinkLabel;
    }

    public String getAddToCartBtn() {
        return addToCartBtn;
    }

    public String getAddToCartBtnLabel() {
        return addToCartBtnLabel;
    }

}

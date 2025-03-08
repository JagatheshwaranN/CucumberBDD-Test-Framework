package com.qa.ctf.pages;

import com.qa.ctf.base.PageComponent;
import com.qa.ctf.base.PageFactory;
import com.qa.ctf.context.TestContext;
import com.qa.ctf.handler.VerificationHandler;
import com.qa.ctf.handler.WaitHandler;
import com.qa.ctf.objects.StorePageObject;

public class StorePage extends StorePageObject {

    private final VerificationHandler verificationHandler;
    private final PageComponent pageComponent;
    private final WaitHandler waitHandler;

    public StorePage(TestContext testContext) {
        super(testContext.getDriver());
        PageFactory pageFactory = new PageFactory(testContext);
        this.verificationHandler = pageFactory.getVerificationHelper();
        this.pageComponent = pageFactory.getPageComponent();
        this.waitHandler = pageFactory.getWaitHandler();
    }

    public void addToCart(String productName) {
        verificationHandler.isElementDisplayed(getTitleText(), getTitleTextLabel());
        pageComponent.clickElement(getAddToCartBtn(), productName, getAddToCartBtnLabel());
        waitHandler.waitForElementVisible(getViewCartLink(), getViewCartLinkLabel());
        pageComponent.clickElement(getViewCartLink(), getViewCartLinkLabel());
    }

}

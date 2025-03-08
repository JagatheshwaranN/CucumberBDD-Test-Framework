package com.qa.ctf.pages;

import com.qa.ctf.base.PageComponent;
import com.qa.ctf.base.PageFactory;
import com.qa.ctf.context.TestContext;
import com.qa.ctf.handler.VerificationHandler;
import com.qa.ctf.objects.CartPageObject;

public class CartPage extends CartPageObject {

    private final VerificationHandler verificationHandler;
    private final PageComponent pageComponent;

    public CartPage(TestContext testContext) {
        super(testContext.getDriver());
        PageFactory pageFactory = new PageFactory(testContext);
        this.verificationHandler = pageFactory.getVerificationHelper();
        this.pageComponent = pageFactory.getPageComponent();
    }

    public String getProductName() {
        return verificationHandler.readTextValueFromElement(getProductNameFld(), getProductNameFldLabel());
    }

    public int getProductQuantity() {
        return Integer.parseInt(verificationHandler.readValueFromInput(getProductQuantityFld(), getProductQuantityFldLabel()));
    }

    public void checkout() {
        pageComponent.clickElement(getProceedToCheckoutBtn(), getProceedToCheckoutBtnLabel());
    }

}

package com.qa.ctf.base;

import com.qa.ctf.context.TestContext;
import com.qa.ctf.handler.*;
import com.qa.ctf.pages.*;
import com.qa.ctf.util.EncryptionManager;

public class PageFactory {

    public TestContext testContext;

    public PageFactory() {
    }

    public PageFactory(TestContext testContext) {
        this.testContext = testContext;
    }

    public LoginPage loginPage;

    public AccountPage accountPage;

    public StorePage storePage;

    public CartPage cartPage;

    public CheckoutPage checkoutPage;

    private PageComponent pageComponent;

    private BrowserHandler browserHandler;

    private DateTimeHandler datePickerHandler;

    private DropDownHandler dropDownHandler;

    private InteractionHandler interactionHandler;

    private VerificationHandler verificationHelper;

    private WaitHandler waitHandler;

    private EncryptionManager encryptionManager;

    public PageComponent getPageComponent() {
        return (pageComponent == null) ? pageComponent = new PageComponent(testContext, getVerificationHelper()) : pageComponent;
    }

    public BrowserHandler getBrowserHandler() {
        return (browserHandler == null) ? browserHandler = new BrowserHandler(testContext) : browserHandler;
    }

    public DateTimeHandler getDatePickerHandler() {
        return (datePickerHandler == null) ? datePickerHandler = new DateTimeHandler(testContext, getVerificationHelper()) : datePickerHandler;
    }

    public DropDownHandler getDropDownHandler() {
        return (dropDownHandler == null) ? dropDownHandler = new DropDownHandler(testContext, getVerificationHelper()) : dropDownHandler;
    }

    public InteractionHandler getInteractionHandler() {
        return (interactionHandler == null) ? interactionHandler = new InteractionHandler(testContext, getVerificationHelper()) : interactionHandler;
    }

    public VerificationHandler getVerificationHelper() {
        return (verificationHelper == null) ? verificationHelper = new VerificationHandler(testContext) : verificationHelper;
    }

    public WaitHandler getWaitHandler() {
        return (waitHandler == null) ? waitHandler = new WaitHandler(testContext) : waitHandler;
    }

    public EncryptionManager getEncryptionManager() {
        return (encryptionManager == null) ? encryptionManager = new EncryptionManager() : encryptionManager;
    }

    public LoginPage getLoginPage(TestContext testContext){
        return (loginPage == null) ? loginPage = new LoginPage(testContext) : loginPage;
    }

    public AccountPage getAccountPage(TestContext testContext){
        return (accountPage == null) ? accountPage = new AccountPage(testContext) : accountPage;
    }

    public StorePage getStorePage(TestContext testContext){
        return (storePage == null) ? storePage = new StorePage(testContext) : storePage;
    }

    public CartPage getCartPage(TestContext testContext){
        return (cartPage == null) ? cartPage = new CartPage(testContext) : cartPage;
    }

    public CheckoutPage getCheckoutPage(TestContext testContext){
        return (checkoutPage == null) ? checkoutPage = new CheckoutPage(testContext) : checkoutPage;
    }

}

package com.qa.ctf.base;

import com.qa.ctf.context.TestContext;
import com.qa.ctf.handler.*;
import com.qa.ctf.pages.*;
import com.qa.ctf.util.EncryptionManager;

/**
 * PageFactory class responsible for initializing and managing
 * page objects and utility handlers within the test framework.
 *
 * @author Jagatheshwaran N
 * @version 1.1
 */
public class PageFactory {

    /** Test context instance for managing shared test data and utilities. */
    public TestContext testContext;

    /**
     * Constructor for PageFactory.
     * @param testContext The test execution context.
     */
    public PageFactory(TestContext testContext) {
        this.testContext = testContext;
    }

    /** Instance of LoginPage. */
    public LoginPage loginPage;

    /** Instance of AccountPage. */
    public AccountPage accountPage;

    /** Instance of StorePage. */
    public StorePage storePage;

    /** Instance of CartPage. */
    public CartPage cartPage;

    /** Instance of CheckoutPage. */
    public CheckoutPage checkoutPage;

    /** Instance of PageComponent for handling UI components. */
    private PageComponent pageComponent;

    /** Instance of BrowserHandler for handling browser operations. */
    private BrowserHandler browserHandler;

    /** Instance of DateTimeHandler for handling date and time pickers. */
    private DateTimeHandler datePickerHandler;

    /** Instance of DropDownHandler for handling dropdown interactions. */
    private DropDownHandler dropDownHandler;

    /** Instance of InteractionHandler for handling user interactions. */
    private InteractionHandler interactionHandler;

    /** Instance of VerificationHandler for validation and assertions. */
    private VerificationHandler verificationHelper;

    /** Instance of WaitHandler for handling wait conditions. */
    private WaitHandler waitHandler;

    /** Instance of EncryptionManager for handling encryption operations. */
    private EncryptionManager encryptionManager;

    /**
     * Gets the PageComponent instance.
     * @return PageComponent instance.
     */
    public PageComponent getPageComponent() {
        return (pageComponent == null) ? pageComponent = new PageComponent(testContext, getVerificationHelper()) : pageComponent;
    }

    /**
     * Gets the BrowserHandler instance.
     * @return BrowserHandler instance.
     */
    public BrowserHandler getBrowserHandler() {
        return (browserHandler == null) ? browserHandler = new BrowserHandler(testContext) : browserHandler;
    }

    /**
     * Gets the DateTimeHandler instance.
     * @return DateTimeHandler instance.
     */
    public DateTimeHandler getDatePickerHandler() {
        return (datePickerHandler == null) ? datePickerHandler = new DateTimeHandler(testContext, getVerificationHelper()) : datePickerHandler;
    }

    /**
     * Gets the DropDownHandler instance.
     * @return DropDownHandler instance.
     */
    public DropDownHandler getDropDownHandler() {
        return (dropDownHandler == null) ? dropDownHandler = new DropDownHandler(testContext, getVerificationHelper()) : dropDownHandler;
    }

    /**
     * Gets the InteractionHandler instance.
     * @return InteractionHandler instance.
     */
    public InteractionHandler getInteractionHandler() {
        return (interactionHandler == null) ? interactionHandler = new InteractionHandler(testContext, getVerificationHelper()) : interactionHandler;
    }

    /**
     * Gets the VerificationHandler instance.
     * @return VerificationHandler instance.
     */
    public VerificationHandler getVerificationHelper() {
        return (verificationHelper == null) ? verificationHelper = new VerificationHandler(testContext) : verificationHelper;
    }

    /**
     * Gets the WaitHandler instance.
     * @return WaitHandler instance.
     */
    public WaitHandler getWaitHandler() {
        return (waitHandler == null) ? waitHandler = new WaitHandler(testContext) : waitHandler;
    }

    /**
     * Gets the EncryptionManager instance.
     * @return EncryptionManager instance.
     */
    public EncryptionManager getEncryptionManager() {
        return (encryptionManager == null) ? encryptionManager = new EncryptionManager() : encryptionManager;
    }

    /**
     * Gets the LoginPage instance.
     * @param testContext The test execution context.
     * @return LoginPage instance.
     */
    public LoginPage getLoginPage(TestContext testContext){
        return (loginPage == null) ? loginPage = new LoginPage(testContext) : loginPage;
    }

    /**
     * Gets the AccountPage instance.
     * @param testContext The test execution context.
     * @return AccountPage instance.
     */
    public AccountPage getAccountPage(TestContext testContext){
        return (accountPage == null) ? accountPage = new AccountPage(testContext) : accountPage;
    }

    /**
     * Gets the StorePage instance.
     * @param testContext The test execution context.
     * @return StorePage instance.
     */
    public StorePage getStorePage(TestContext testContext){
        return (storePage == null) ? storePage = new StorePage(testContext) : storePage;
    }

    /**
     * Gets the CartPage instance.
     * @param testContext The test execution context.
     * @return CartPage instance.
     */
    public CartPage getCartPage(TestContext testContext){
        return (cartPage == null) ? cartPage = new CartPage(testContext) : cartPage;
    }

    /**
     * Gets the CheckoutPage instance.
     * @param testContext The test execution context.
     * @return CheckoutPage instance.
     */
    public CheckoutPage getCheckoutPage(TestContext testContext){
        return (checkoutPage == null) ? checkoutPage = new CheckoutPage(testContext) : checkoutPage;
    }

}

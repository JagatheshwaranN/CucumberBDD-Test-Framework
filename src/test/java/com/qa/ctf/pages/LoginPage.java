package com.qa.ctf.pages;

import com.qa.ctf.base.PageComponent;
import com.qa.ctf.context.TestContext;
import com.qa.ctf.handler.VerificationHandler;
import com.qa.ctf.objects.LoginPageObject;
import com.qa.ctf.util.EncryptionManager;

import static com.qa.ctf.constant.Message.LOGIN_PASSWORD_ERROR;
import static com.qa.ctf.constant.Message.LOGIN_USERNAME_ERROR;

/**
 * Page class representing the Login page of the application.
 * <p>
 * This class extends {@code LoginPageObject} and provides additional actions
 * for interacting with the login page, including logging in, handling error
 * messages, and verifying login form elements.
 * </p>
 *
 * @author Jagatheshwaran N
 * @version 1.1
 */
public class LoginPage extends LoginPageObject {

    /** Instance of VerificationHandler for verifying elements on the page. */
    private final VerificationHandler verificationHandler;

    /** Instance of PageComponent for interacting with page elements. */
    private final PageComponent pageComponent;

    /** Instance of EncryptionManager for handling password decryption. */
    private final EncryptionManager encryptionManager;

    /**
     * Constructs a {@code LoginPage} instance with the given test context.
     *
     * @param testContext The test context containing information for managing
     *                    the state of the test.
     */
    public LoginPage(TestContext testContext) {
        super(testContext);
        this.verificationHandler = pageFactory.getVerificationHelper();
        this.pageComponent = pageFactory.getPageComponent();
        this.encryptionManager = pageFactory.getEncryptionManager();
    }

    /**
     * Logs in to the store by entering the provided username and password.
     * <p>
     * This method navigates to the account section, enters the provided
     * username and decrypted password into the login form fields.
     * </p>
     *
     * @param username The username for login.
     * @param password The encrypted password for login.
     */
    public void loginToStore(String username, String password) {
        pageComponent.clickElement(getAccountNavBar(), getAccountNavBarLabel());
        verificationHandler.isElementDisplayed(getLoginSection(), getLoginSectionLabel());
        pageComponent.typeText(getUsernameFld(), username, getUsernameFldLabel());
        String decryptedPassword = encryptionManager.decryptData(password);
        System.out.println("Decrypted PASSWORD : " + decryptedPassword);
        pageComponent.typeText(getPasswordFld(), decryptedPassword, getPasswordLabel());
    }

    /**
     * Clicks the login button to submit the login form.
     * <p>
     * This method triggers the login action by clicking the "Login" button on
     * the page.
     * </p>
     */
    public void clickLoginButton() {
        pageComponent.clickElement(getLoginBtn(), getLoginBtnLabel());
    }

    /**
     * Retrieves the error message displayed upon a failed login attempt.
     * <p>
     * This method reads the error message displayed on the login page when the
     * login fails.
     * </p>
     *
     * @return The error message displayed on the login page.
     */
    public String loginError() {
        verificationHandler.isElementDisplayed(getLoginErrMsg(), getLoginErrMsgLabel());
        return verificationHandler.readTextValueFromElement(getLoginErrMsg(), getLoginErrMsgLabel());
    }

    /**
     * Asserts the error message displayed after a failed login attempt.
     * <p>
     * This method compares the displayed error message with the expected error
     * message for the given error type (username or password).
     * </p>
     *
     * @param errorType The type of error to assert ("username" or "password").
     * @throws AssertionError If the error message does not match the expected message.
     */
    public void assertErrorMessage(String errorType) {
        String actualError = loginError();
        if (errorType.equalsIgnoreCase("username")) {
            pageComponent.assertTextMatches(actualError, LOGIN_USERNAME_ERROR);
        } else {
            pageComponent.assertTextMatches(actualError, LOGIN_PASSWORD_ERROR);
        }
    }

}

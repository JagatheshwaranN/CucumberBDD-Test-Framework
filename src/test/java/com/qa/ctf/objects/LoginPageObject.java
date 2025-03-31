package com.qa.ctf.objects;

import com.qa.ctf.base.PageBase;
import com.qa.ctf.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object representing the Login page of the application.
 * <p>
 * This class provides the elements and actions related to the Login page.
 * It includes WebElement references for the account navigation bar, login
 * section, input fields for username and password, login button, and the
 * login error message, along with their respective labels for easier
 * interaction in the automation framework.
 * </p>
 *
 * @author Jagatheshwaran N
 * @version 1.1
 */
public class LoginPageObject extends PageBase {

    /** Web element representing the account navigation bar. */
    @FindBy(xpath = "//nav[@id='primary-site-navigation']//li[contains(@id, 'menu-item')]//a[text()='Account']")
    protected WebElement accountNavBar;

    /** Label for the account navigation bar. */
    protected String accountNavBarLabel = "Account Top Nav Bar";

    /** Web element representing the login section. */
    @FindBy(css = "#customer_login form[class*='login']")
    protected WebElement loginSection;

    /** Label for the login section. */
    protected String loginSectionLabel = "Login Section";

    /** Web element representing the username input field. */
    @FindBy(id = "username")
    protected WebElement usernameFld;

    /** Label for the username input field. */
    protected String usernameFldLabel = "Username";

    /** Web element representing the password input field. */
    @FindBy(id = "password")
    protected WebElement passwordFld;

    /** Label for the password input field. */
    protected String passwordLabel = "Password";

    /** Web element representing the login button. */
    @FindBy(xpath = "//button[@name='login']")
    protected WebElement loginBtn;

    /** Label for the login button. */
    protected String loginBtnLabel = "Login Button";

    /** Web element representing the login error message. */
    @FindBy(css = "ul[class*='error'] li")
    protected WebElement loginErrMsg;

    /** Label for the login error message. */
    protected String loginErrMsgLabel = "Login Error Message";

    /**
     * Constructs a {@code LoginPageObject} instance with the given test context.
     *
     * @param testContext The test context containing information for managing the
     *                    state of the test.
     */
    public LoginPageObject(TestContext testContext) {
        super(testContext);
    }

    /**
     * Gets the account navigation bar WebElement.
     *
     * @return The WebElement representing the account navigation bar.
     */
    public WebElement getAccountNavBar() {
        return accountNavBar;
    }

    /**
     * Gets the label for the account navigation bar.
     *
     * @return The label for the account navigation bar.
     */
    public String getAccountNavBarLabel() {
        return accountNavBarLabel;
    }

    /**
     * Gets the login section WebElement.
     *
     * @return The WebElement representing the login section.
     */
    public WebElement getLoginSection() {
        return loginSection;
    }

    /**
     * Gets the label for the login section.
     *
     * @return The label for the login section.
     */
    public String getLoginSectionLabel() {
        return loginSectionLabel;
    }

    /**
     * Gets the username input field WebElement.
     *
     * @return The WebElement representing the username input field.
     */
    public WebElement getUsernameFld() {
        return usernameFld;
    }

    /**
     * Gets the label for the username input field.
     *
     * @return The label for the username input field.
     */
    public String getUsernameFldLabel() {
        return usernameFldLabel;
    }

    /**
     * Gets the password input field WebElement.
     *
     * @return The WebElement representing the password input field.
     */
    public WebElement getPasswordFld() {
        return passwordFld;
    }

    /**
     * Gets the label for the password input field.
     *
     * @return The label for the password input field.
     */
    public String getPasswordLabel() {
        return passwordLabel;
    }

    /**
     * Gets the login button WebElement.
     *
     * @return The WebElement representing the login button.
     */
    public WebElement getLoginBtn() {
        return loginBtn;
    }

    /**
     * Gets the label for the login button.
     *
     * @return The label for the login button.
     */
    public String getLoginBtnLabel() {
        return loginBtnLabel;
    }

    /**
     * Gets the login error message WebElement.
     *
     * @return The WebElement representing the login error message.
     */
    public WebElement getLoginErrMsg() {
        return loginErrMsg;
    }

    /**
     * Gets the label for the login error message.
     *
     * @return The label for the login error message.
     */
    public String getLoginErrMsgLabel() {
        return loginErrMsgLabel;
    }

}

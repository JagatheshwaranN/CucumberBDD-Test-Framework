package com.qa.ctf.objects;

import com.qa.ctf.base.PageBase;
import com.qa.ctf.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObject extends PageBase {

    public LoginPageObject(TestContext testContext) {
        super(testContext);
    }

    @FindBy(xpath = "//nav[@id='primary-site-navigation']//li[contains(@id, 'menu-item')]//a[text()='Account']")
    protected WebElement accountNavBar;
    protected String accountNavBarLabel = "Account Top Nav Bar";

    @FindBy(css = "#customer_login form[class*='login']")
    protected WebElement loginSection;
    protected String loginSectionLabel = "Login Section";

    @FindBy(id = "username")
    protected WebElement usernameFld;
    protected String usernameFldLabel = "Username";

    @FindBy(id = "password")
    protected WebElement passwordFld;
    protected String passwordLabel = "Password";

    @FindBy(xpath = "//button[@name='login']")
    protected WebElement loginBtn;
    protected String loginBtnLabel = "Login Button";

    public WebElement getAccountNavBar() {
        return accountNavBar;
    }

    public String getAccountNavBarLabel() {
        return accountNavBarLabel;
    }

    public WebElement getLoginSection() {
        return loginSection;
    }

    public String getLoginSectionLabel() {
        return loginSectionLabel;
    }

    public WebElement getUsernameFld() {
        return usernameFld;
    }

    public String getUsernameFldLabel() {
        return usernameFldLabel;
    }

    public WebElement getPasswordFld() {
        return passwordFld;
    }

    public String getPasswordLabel() {
        return passwordLabel;
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }

    public String getLoginBtnLabel() {
        return loginBtnLabel;
    }

}

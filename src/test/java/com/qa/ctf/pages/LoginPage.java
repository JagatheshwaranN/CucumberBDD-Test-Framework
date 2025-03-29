package com.qa.ctf.pages;

import com.qa.ctf.base.PageComponent;
import com.qa.ctf.context.TestContext;
import com.qa.ctf.handler.VerificationHandler;
import com.qa.ctf.objects.LoginPageObject;

public class LoginPage extends LoginPageObject {

    private final VerificationHandler verificationHandler;
    private final PageComponent pageComponent;

    public LoginPage(TestContext testContext) {
        super(testContext);
        this.verificationHandler = pageFactory.getVerificationHelper();
        this.pageComponent = pageFactory.getPageComponent();
    }

    public void loginToStore(String username, String password) {
        pageComponent.clickElement(getAccountNavBar(), getAccountNavBarLabel());
        verificationHandler.isElementDisplayed(getLoginSection(), getLoginSectionLabel());
        pageComponent.typeText(getUsernameFld(), username, getUsernameFldLabel());
        pageComponent.typeText(getPasswordFld(), password, getPasswordLabel());
    }

    public void clickLoginButton() {
        pageComponent.clickElement(getLoginBtn(), getLoginBtnLabel());
    }

}

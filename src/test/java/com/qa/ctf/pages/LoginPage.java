package com.qa.ctf.pages;

import com.qa.ctf.base.PageComponent;
import com.qa.ctf.context.TestContext;
import com.qa.ctf.handler.VerificationHandler;
import com.qa.ctf.objects.LoginPageObject;
import com.qa.ctf.util.EncryptionManager;
import org.testng.Assert;

import static com.qa.ctf.constant.Message.LOGIN_PASSWORD_ERROR;
import static com.qa.ctf.constant.Message.LOGIN_USERNAME_ERROR;

public class LoginPage extends LoginPageObject {

    private final VerificationHandler verificationHandler;
    private final PageComponent pageComponent;
    private final EncryptionManager encryptionManager;

    public LoginPage(TestContext testContext) {
        super(testContext);
        this.verificationHandler = pageFactory.getVerificationHelper();
        this.pageComponent = pageFactory.getPageComponent();
        this.encryptionManager = pageFactory.getEncryptionManager();
    }

    public void loginToStore(String username, String password) {
        pageComponent.clickElement(getAccountNavBar(), getAccountNavBarLabel());
        verificationHandler.isElementDisplayed(getLoginSection(), getLoginSectionLabel());
        pageComponent.typeText(getUsernameFld(), username, getUsernameFldLabel());
        String decryptedPassword = encryptionManager.decryptData(password);
        System.out.println("Decrypted PASSWORD : "+ decryptedPassword);
        pageComponent.typeText(getPasswordFld(), decryptedPassword, getPasswordLabel());
    }

    public void clickLoginButton() {
        pageComponent.clickElement(getLoginBtn(), getLoginBtnLabel());
    }

    public String loginError() {
        verificationHandler.isElementDisplayed(getLoginErrMsg(), getLoginErrMsgLabel());
        return verificationHandler.readTextValueFromElement(getLoginErrMsg(), getLoginErrMsgLabel());
    }

    public void assertErrorMessage(String errorType) {
        String actualError = loginError();
        if(errorType.equalsIgnoreCase("username")) {
            pageComponent.assertTextMatches(actualError, LOGIN_USERNAME_ERROR);
        } else {
        pageComponent.assertTextMatches(actualError, LOGIN_PASSWORD_ERROR);
        }
    }

}

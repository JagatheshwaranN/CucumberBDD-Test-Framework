package com.qa.ctf.pages;

import com.qa.ctf.base.PageComponent;
import com.qa.ctf.context.TestContext;
import com.qa.ctf.handler.VerificationHandler;
import com.qa.ctf.objects.AccountPageObject;

public class AccountPage extends AccountPageObject {

    private final VerificationHandler verificationHandler;
    private final PageComponent pageComponent;

    public AccountPage(TestContext testContext) {
        super(testContext);
        this.verificationHandler = pageFactory.getVerificationHelper();
        this.pageComponent = pageFactory.getPageComponent();
    }

    public void verifyAccountHeader() {
        verificationHandler.isElementDisplayed(getAccountDashboard(), getAccountDashboardLabel());
    }

    public void logoutFromStore() {
        verificationHandler.isElementDisplayed(getAccountDashboard(), getAccountDashboardLabel());
        pageComponent.clickElement(getLogout(), getLogoutLabel());
    }

}

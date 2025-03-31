package com.qa.ctf.pages;

import com.qa.ctf.base.PageComponent;
import com.qa.ctf.context.TestContext;
import com.qa.ctf.handler.VerificationHandler;
import com.qa.ctf.objects.AccountPageObject;

/**
 * Page class representing the Account page of the application.
 * <p>
 * This class extends {@code AccountPageObject} and provides additional actions
 * and verifications specific to the Account page, such as verifying the account
 * header and logging out from the account.
 * </p>
 *
 * @author Jagatheshwaran N
 * @version 1.1
 */
public class AccountPage extends AccountPageObject {

    /** Instance of VerificationHandler for verifying elements on the page. */
    private final VerificationHandler verificationHandler;

    /** Instance of PageComponent for interacting with page elements. */
    private final PageComponent pageComponent;

    /**
     * Constructs an {@code AccountPage} instance with the given test context.
     *
     * @param testContext The test context containing information for managing the
     *                    state of the test.
     */
    public AccountPage(TestContext testContext) {
        super(testContext);
        this.verificationHandler = pageFactory.getVerificationHelper();
        this.pageComponent = pageFactory.getPageComponent();
    }

    /**
     * Verifies if the account dashboard header is displayed on the page.
     * <p>
     * This method uses the {@code VerificationHandler} to check whether the account
     * dashboard element is displayed and matches the expected label.
     * </p>
     */
    public void verifyAccountDashboardHeader() {
        verificationHandler.isElementDisplayed(getAccountDashboard(), getAccountDashboardLabel());
    }

    /**
     * Logs out of the account by clicking the logout button.
     * <p>
     * This method first verifies if the account dashboard is displayed and then clicks
     * the logout button to log out of the account.
     * </p>
     */
    public void logoutFromAccount() {
        verificationHandler.isElementDisplayed(getAccountDashboard(), getAccountDashboardLabel());
        pageComponent.clickElement(getLogout(), getLogoutLabel());
    }
}

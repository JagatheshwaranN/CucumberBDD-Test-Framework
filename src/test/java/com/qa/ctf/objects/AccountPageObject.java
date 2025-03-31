package com.qa.ctf.objects;

import com.qa.ctf.base.PageBase;
import com.qa.ctf.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object representing the Account page of the application.
 * <p>
 * This class provides the elements and actions related to the Account page.
 * It includes WebElement references to the account dashboard and logout button,
 * along with their respective labels for easier interaction in the automation
 * framework.
 * </p>
 *
 * @author Jagatheshwaran N
 * @version 1.1
 */
public class AccountPageObject extends PageBase {

    /**
     * Constructs an {@code AccountPageObject} instance with the given test context.
     *
     * @param testContext The test context containing information for managing the
     *                    state of the test.
     */
    public AccountPageObject(TestContext testContext) {
        super(testContext);
    }

    /**
     * Web element representing the account dashboard title.
     */
    @FindBy(xpath = "//main//h1[text()='Account']")
    protected WebElement accountDashboard;

    /**
     * Label for the account dashboard element.
     */
    protected String accountDashboardLabel = "Account Dashboard";

    /**
     * Web element representing the logout button.
     */
    @FindBy(css = "li[class*=logout]>a")
    protected WebElement logout;

    /**
     * Label for the logout button.
     */
    protected String logoutLabel = "Logout";

    /**
     * Gets the account dashboard WebElement.
     *
     * @return The WebElement representing the account dashboard.
     */
    public WebElement getAccountDashboard() {
        return accountDashboard;
    }

    /**
     * Gets the label for the account dashboard.
     *
     * @return The label for the account dashboard.
     */
    public String getAccountDashboardLabel() {
        return accountDashboardLabel;
    }

    /**
     * Gets the logout WebElement.
     *
     * @return The WebElement representing the logout button.
     */
    public WebElement getLogout() {
        return logout;
    }

    /**
     * Gets the label for the logout button.
     *
     * @return The label for the logout button.
     */
    public String getLogoutLabel() {
        return logoutLabel;
    }

}

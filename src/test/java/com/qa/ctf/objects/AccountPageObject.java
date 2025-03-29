package com.qa.ctf.objects;

import com.qa.ctf.base.PageBase;
import com.qa.ctf.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPageObject extends PageBase {


    public AccountPageObject(TestContext testContext) {
        super(testContext);
    }

    @FindBy(xpath = "//main//h1[text()='Account']")
    protected WebElement accountDashboard;
    protected String accountDashboardLabel = "Account Dashboard";

    @FindBy(css = "li[class*=logout]>a")
    protected WebElement logout;
    protected String logoutLabel = "Logout";

    public WebElement getAccountDashboard() {
        return accountDashboard;
    }

    public String getAccountDashboardLabel() {
        return accountDashboardLabel;
    }

    public WebElement getLogout() {
        return logout;
    }

    public String getLogoutLabel() {
        return logoutLabel;
    }

}

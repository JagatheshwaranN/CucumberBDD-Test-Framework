package com.qa.ctf.steps;

import com.qa.ctf.context.TestContext;
import com.qa.ctf.pages.AccountPage;
import com.qa.ctf.pages.LoginPage;
import com.qa.ctf.pages.StorePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseSteps {

    private final LoginPage loginPage;
    private final AccountPage accountPage;

    public LoginSteps(TestContext testContext) {
        super(testContext);
        this.loginPage = pageFactory.getLoginPage(testContext);
        this.accountPage = pageFactory.getAccountPage(testContext);
    }

    @When("I enter {string} and {string}")
    public void i_enter_and(String username, String password) {
        loginPage.loginToStore(username, password);
    }

    @When("click on login button")
    public void click_on_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("Account dashboard page should open")
    public void account_dashboard_page_should_open() {
        accountPage.verifyAccountHeader();
        accountPage.logoutFromStore();
    }

}

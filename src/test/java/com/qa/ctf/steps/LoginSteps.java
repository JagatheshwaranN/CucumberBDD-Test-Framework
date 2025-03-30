package com.qa.ctf.steps;

import com.qa.ctf.context.TestContext;
import com.qa.ctf.factory.DriverFactory;
import com.qa.ctf.pages.AccountPage;
import com.qa.ctf.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

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

    @When("I enter login details from given sheet {string} and row {int}")
    public void i_enter_login_details_from_given_sheet_and_row_number(String sheetName, Integer rowNumber) {
        List<Map<String, String>> loginData = DriverFactory.excelReader.getData(sheetName);
        String username = loginData.get(rowNumber).get("Username");
        String password = loginData.get(rowNumber).get("Password");
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

    @Then("Login {string} error message should display")
    public void login_error_message_should_display(String errorType) {
        loginPage.assertErrorMessage(errorType);
    }

}
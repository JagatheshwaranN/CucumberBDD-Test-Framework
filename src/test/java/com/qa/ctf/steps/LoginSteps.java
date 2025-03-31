package com.qa.ctf.steps;

import com.qa.ctf.context.TestContext;
import com.qa.ctf.factory.DriverFactory;
import com.qa.ctf.pages.AccountPage;
import com.qa.ctf.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

/**
 * The {@code LoginSteps} class contains step definitions for actions related to
 * logging in to the application.
 * <p>
 * This class includes steps for entering login credentials, handling login actions,
 * and verifying account-related actions.
 * </p>
 *
 * @author Jagatheshwaran N
 * @version 1.1
 */
public class LoginSteps extends BaseSteps {

    /** The {@code LoginPage} instance used to interact with the login page of
     * the application. */
    private final LoginPage loginPage;

    /** The {@code AccountPage} instance used to interact with the account dashboard
     *  page after successful login. */
    private final AccountPage accountPage;

    /**
     * Constructs a {@code LoginSteps} instance with the given test context.
     * <p>
     * This constructor initializes the {@code LoginPage} and {@code AccountPage}
     * instances using the {@code PageFactory}.
     * </p>
     *
     * @param testContext The test context containing information for managing the
     *                    state of the test.
     */
    public LoginSteps(TestContext testContext) {
        super(testContext);
        this.loginPage = pageFactory.getLoginPage(testContext);
        this.accountPage = pageFactory.getAccountPage(testContext);
    }

    /**
     * Enters the provided username and password into the login form.
     * <p>
     * This step allows the user to enter their login credentials for authentication.
     * </p>
     *
     * @param username The username to be entered in the login form.
     * @param password The password to be entered in the login form.
     */
    @When("I enter {string} and {string}")
    public void i_enter_and(String username, String password) {
        loginPage.loginToStore(username, password);
    }

    /**
     * Enters login details from an Excel sheet at the specified row.
     * <p>
     * This step reads the login credentials (username and password) from a given
     * Excel sheet and row, and enters them into the login form for authentication.
     * </p>
     *
     * @param sheetName The name of the Excel sheet containing login data.
     * @param rowNumber The row number in the Excel sheet containing the credentials.
     */
    @When("I enter login details from given sheet {string} and row {int}")
    public void i_enter_login_details_from_given_sheet_and_row_number(String sheetName, Integer rowNumber) {
        List<Map<String, String>> loginData = DriverFactory.excelReader.getData(sheetName);
        String username = loginData.get(rowNumber).get("Username");
        String password = loginData.get(rowNumber).get("Password");
        loginPage.loginToStore(username, password);
    }

    /**
     * Clicks the login button to submit the login form.
     * <p>
     * This step triggers the login action by clicking the "Login" button on the
     * login page.
     * </p>
     */
    @When("click on login button")
    public void click_on_login_button() {
        loginPage.clickLoginButton();
    }

    /**
     * Verifies that the account dashboard page is displayed after a successful
     * login.
     * <p>
     * This step checks whether the account dashboard is successfully loaded and
     * verifies that the header is correct.
     * </p>
     */
    @Then("Account dashboard page should open")
    public void account_dashboard_page_should_open() {
        accountPage.verifyAccountDashboardHeader();
        accountPage.logoutFromAccount();
    }

    /**
     * Asserts that the specified login error message is displayed after a failed
     * login attempt.
     * <p>
     * This step checks that the appropriate error message (either for username or
     * password) is displayed on the login page.
     * </p>
     *
     * @param errorType The type of error to assert (either "username" or "password").
     */
    @Then("Login {string} error message should display")
    public void login_error_message_should_display(String errorType) {
        loginPage.assertErrorMessage(errorType);
    }

}

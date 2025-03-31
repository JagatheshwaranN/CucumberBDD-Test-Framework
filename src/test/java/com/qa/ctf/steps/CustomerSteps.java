package com.qa.ctf.steps;

import com.qa.ctf.constant.Endpoint;
import com.qa.ctf.context.AppContext;
import com.qa.ctf.context.TestContext;
import com.qa.ctf.domain.BillingDetails;
import com.qa.ctf.domain.ExcelDataToDataTable;
import com.qa.ctf.pages.StorePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The {@code CustomerSteps} class contains step definitions related to
 * customer actions, including guest user interactions and managing billing
 * details.
 * <p>
 * This class extends {@code BaseSteps} and defines steps for handling
 * customer-specific actions, such as providing billing details manually
 * or retrieving them from an Excel sheet.
 * </p>
 *
 * @author Jagatheshwaran N
 * @version 1.1
 */
public class CustomerSteps extends BaseSteps {

    /** The {@code StorePage} instance used for interacting with the store page. */
    private final StorePage storePage;

    /** The {@code AppContext} instance used for accessing application-wide data such
     *  as billing details. */
    private final AppContext appContext;

    /**
     * Constructs a {@code CustomerSteps} instance with the given test context and
     * application context.
     * <p>
     * This constructor initializes the {@code StorePage} and {@code AppContext} using
     * the {@code PageFactory}.
     * </p>
     *
     * @param testContext The test context containing information for managing the
     *                    state of the test.
     * @param appContext  The application context containing global data such as
     *                    billing details.
     */
    public CustomerSteps(TestContext testContext, AppContext appContext) {
        super(testContext);
        this.appContext = appContext;
        this.storePage = pageFactory.getStorePage(testContext);
    }

    /**
     * Navigates to the store page as a guest user.
     * <p>
     * This step ensures that the user is on the store page before performing
     * any actions.
     * </p>
     */
    @Given("I'm a guest user")
    public void i_m_a_guest_user() {
        storePage.load(Endpoint.STORE.url);
    }

    /**
     * Sets the billing details for the user.
     * <p>
     * This step stores the provided {@link BillingDetails} object in the
     * {@code AppContext}.
     * </p>
     *
     * @param billingDetails The billing details to be set for the user.
     */
    @Given("my billing details are")
    public void my_billing_details_are(BillingDetails billingDetails) {
        appContext.billingDetails = billingDetails;
    }

    /**
     * Sets the billing details for the user taken from an Excel sheet.
     * <p>
     * This step reads the billing details from the specified Excel sheet, converts
     * them to a {@code DataTable},
     * and stores them in the {@code AppContext}.
     * </p>
     *
     * @param sheetName The name of the Excel sheet containing the billing details.
     */
    @Given("my billing details are taken from excel sheet {string}")
    public void my_billing_details_are_taken_from_excel_sheet(String sheetName) {
        DataTable dataTable = ExcelDataToDataTable.convertToDataTable(sheetName);
        List<BillingDetails> billingDetailsList = getBillingDetailsList(dataTable);
        for (BillingDetails billingDetails : billingDetailsList) {
            appContext.billingDetails = billingDetails;
        }
    }

    /**
     * Converts the given {@code DataTable} into a list of {@code BillingDetails}
     * objects.
     * <p>
     * This method processes each row in the {@code DataTable} and creates a
     * {@code BillingDetails} object for each row.
     * </p>
     *
     * @param dataTable The {@code DataTable} containing billing details as rows
     *                  of key-value pairs.
     * @return A list of {@code BillingDetails} objects.
     */
    private static List<BillingDetails> getBillingDetailsList(DataTable dataTable) {
        List<Map<String, String>> dataList = dataTable.asMaps(String.class, String.class);
        List<BillingDetails> billingDetailsList = new ArrayList<>();
        for (Map<String, String> row : dataList) {
            BillingDetails billingDetails = new BillingDetails(
                    row.get("firstname"),
                    row.get("lastname"),
                    row.get("address_line"),
                    row.get("city"),
                    row.get("state"),
                    row.get("zipcode"),
                    row.get("email")
            );
            billingDetailsList.add(billingDetails);
        }
        return billingDetailsList;
    }

}

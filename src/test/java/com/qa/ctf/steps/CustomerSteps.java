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

public class CustomerSteps extends BaseSteps {

    private final StorePage storePage;
    private final AppContext appContext;

    public CustomerSteps(TestContext testContext, AppContext appContext) {
        super(testContext);
        this.appContext = appContext;
        this.storePage = pageFactory.getStorePage(testContext);
    }

    @Given("I'm a guest user")
    public void i_m_a_guest_user() {
        storePage.load(Endpoint.STORE.url);
    }

    @Given("my billing details are")
    public void my_billing_details_are(BillingDetails billingDetails) {
        appContext.billingDetails = billingDetails;
    }

    @Given("my billing details are taken from excel sheet {string}")
    public void my_billing_details_are_taken_from_excel_sheet(String sheetName) {
        DataTable dataTable = ExcelDataToDataTable.convertToDataTable(sheetName);
        List<BillingDetails> billingDetailsList = getBillingDetailsList(dataTable);
        for (BillingDetails billingDetails : billingDetailsList) {
            appContext.billingDetails = billingDetails;
        }
    }

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

package com.qa.ctf.steps;

import com.qa.ctf.app.CustomDataTableType;
import com.qa.ctf.constant.Endpoint;
import com.qa.ctf.context.AppContext;
import com.qa.ctf.context.TestContext;
import com.qa.ctf.data.BillingDetails;
import com.qa.ctf.data.ExcelDataToDataTable;
import com.qa.ctf.pages.StorePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

public class CustomerSteps extends BaseSteps {

    private final StorePage storePage;
    private final AppContext appContext;

    public CustomerSteps(AppContext appContext, TestContext testContext) {
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
        appContext.billingDetails = new CustomDataTableType().billingInfoDetails(dataTable.asMap());
    }

    // {zipcode=75024, firstname=Auto, address_line=2200 Spring Way, city=Plano, state=Texas, email=autotest@gmail.com, lastname=User}

}

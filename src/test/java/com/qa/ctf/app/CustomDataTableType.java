package com.qa.ctf.app;

import com.qa.ctf.domain.BillingDetails;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class CustomDataTableType {

    @DataTableType
    public BillingDetails billingDetails(Map<String, String> entry) {
        if (entry == null || entry.isEmpty()) {
            System.out.println("DataTable entry is null or empty!");
        }
        assert entry != null;
        return new BillingDetails(
                entry.get("firstname"),
                entry.get("lastname"),
                entry.get("address_line"),
                entry.get("city"),
                entry.get("state"),
                entry.get("zipcode"),
                entry.get("email")
        );
    }

}

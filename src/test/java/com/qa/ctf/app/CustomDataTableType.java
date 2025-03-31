package com.qa.ctf.app;

import com.qa.ctf.domain.BillingDetails;
import com.qa.ctf.util.ExceptionHub;
import io.cucumber.java.DataTableType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

/**
 * Custom DataTableType definition for Cucumber to map DataTable entries
 * to the {@link BillingDetails} domain object.
 *
 * @author Jagatheshwaran N
 * @version 1.1
 */
public class CustomDataTableType {

    // Logger instance for the CustomDataTableType class to enable logging during execution
    private static final Logger log = LogManager.getLogger(CustomDataTableType.class);

    /**
     * Converts a Cucumber DataTable entry (represented as a {@code Map<String, String>})
     * into a {@link BillingDetails} object.
     *
     * <p>This method allows automatic mapping of Cucumber DataTable rows
     * to Java objects when used in step definitions.</p>
     *
     * @param entry A map containing billing details with keys like "firstname", "lastname",
     *              "address_line", "city", "state", "zipcode", and "email".
     * @return A populated {@link BillingDetails} object.
     * @throws ExceptionHub.InvalidDataException If the provided entry map is {@code null}.
     */
    @DataTableType
    public BillingDetails billingDetails(Map<String, String> entry) {
        if (entry == null || entry.isEmpty()) {
            log.error("DataTable entry is null or empty!");
            throw new ExceptionHub.InvalidDataException("DataTable entry cannot be null or empty.");
        }
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


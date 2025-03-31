package com.qa.ctf.app;

import com.qa.ctf.domain.Product;
import com.qa.ctf.util.ExceptionHub;
import io.cucumber.java.ParameterType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Custom parameter type for Cucumber step definitions.
 * This class defines a parameter type to convert a string into a {@link Product} object.
 *
 * @author Jagatheshwaran N
 * @version 1.1
 */
public class CustomParameterType {

    // Logger instance for the CustomParameterType class to enable logging during execution
    private static final Logger log = LoggerFactory.getLogger(CustomParameterType.class);

    /**
     * Converts a given product name string into a {@link Product} object.
     * Removes any double quotes from the input string before creating the object.
     *
     * @param productName The product name as a string from the Cucumber step.
     * @return A {@link Product} object initialized with the given product name.
     * @throws ExceptionHub.InvalidDataException if the product name is null or empty.
     */
    @ParameterType(".*")
    public Product product(String productName) {
        if (productName == null || productName.trim().isEmpty()) {
            log.error("Received null or empty product name.");
            throw new ExceptionHub.InvalidDataException("Product name cannot be null or empty.");
        }
        return new Product(productName.replace("\"", ""));
    }

}

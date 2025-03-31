package com.qa.ctf.domain;

/**
 * Represents the billing details of a customer.
 * <p>
 * This record holds the information related to a customer's billing such as their
 * name, address, city, state, zipcode, and email. This data can be used for billing
 * purposes in various parts of the application.
 * </p>
 *
 * @author Jagatheshwaran N
 * @version 1.1
 */
public record BillingDetails(
        String billingFirstName,
        String billingLastName,
        String billingAddressLine,
        String billingCity,
        String billingState,
        String billingZipcode,
        String billingEmail) {
}

package com.qa.ctf.context;

import org.openqa.selenium.WebDriver;

/**
 * TestContext class manages shared test dependencies across different test components.
 * <p>
 * This class holds a WebDriver instance, ensuring that all page objects and test classes
 * can access and utilize the same WebDriver instance during test execution.
 * </p>
 *
 * @author Jagatheshwaran N
 * @version 1.0
 */
public class TestContext {

    // WebDriver instance used for interacting with web elements in test execution.
    public WebDriver driver;

    /**
     * Retrieves the WebDriver instance.
     * <p>
     * This method returns the current WebDriver instance. If the driver is not
     * initialized, it throws a NullPointerException.
     * </p>
     *
     * @return The WebDriver instance.
     * @throws NullPointerException if the driver is not initialized.
     */
    public WebDriver getDriver() {
        if (this.driver == null) {
            throw new NullPointerException("Driver is not initialized.");
        }
        return this.driver;
    }

    /**
     * Sets the WebDriver instance.
     * <p>
     * This method assigns the provided WebDriver instance to the class-level
     * driver variable.
     * </p>
     *
     * @param driver The WebDriver instance to be set.
     */
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

}


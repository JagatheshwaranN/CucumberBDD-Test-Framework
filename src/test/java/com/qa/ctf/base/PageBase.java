package com.qa.ctf.base;

import com.qa.ctf.context.TestContext;
import com.qa.ctf.util.ExceptionHub;
import com.qa.ctf.util.FileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

import static com.qa.ctf.constant.TestConstants.EXPLICIT_WAIT_TIME;

/**
 * Base class for all page objects.
 * Provides common utility methods for interacting with web pages.
 *
 * @author Jagatheshwaran N
 * @version 1.1
 */
public class PageBase {

    // Logger instance for the PageBase class to enable logging during execution
    private static final Logger log = LoggerFactory.getLogger(PageBase.class);

    // WebDriver instance used for interacting with the browser.
    protected WebDriver driver;

    // WebDriverWait instance for implementing explicit waits.
    protected WebDriverWait wait;

    // Custom PageFactory instance for managing page object initialization.
    protected com.qa.ctf.base.PageFactory pageFactory;

    /**
     * Constructor initializes WebDriver, WebDriverWait, and PageFactory.
     *
     * @param testContext The TestContext instance that provides access to WebDriver.
     */
    public PageBase(TestContext testContext) {
        pageFactory = new com.qa.ctf.base.PageFactory(testContext);
        this.driver = testContext.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIME));
        PageFactory.initElements(driver, this);
    }

    /**
     * Loads a given endpoint by appending it to the base URL.
     *
     * @param endpoint The endpoint to navigate to.
     * @throws ExceptionHub.InvalidDataException If the BaseURL is null or empty.
     */
    public void load(String endpoint) {
        try {
            String baseUrl = FileReader.fetchDataFromPropFile("AppURL");
            if (baseUrl == null || baseUrl.isEmpty()) {
                log.error("App URL is missing in the properties file.");
                throw new ExceptionHub.InvalidDataException("App URL cannot be null or empty.");
            }
            driver.get(baseUrl + endpoint);
            log.info("Navigated to URL: {}", baseUrl + endpoint);
        } catch (Exception ex) {
            log.error("Failed to load the page: {}", endpoint, ex);
            throw ex;
        }
    }

    /**
     * Waits for an overlay element to disappear.
     *
     * @param overlay The locator of the overlay element.
     */
    public void waitForOverlayToDisappear(By overlay) {
        List<WebElement> overlays = driver.findElements(overlay);
        log.info("Overlay count: {}", overlays.size());

        if (!overlays.isEmpty()) {
            wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
            log.info("Overlays have disappeared.");
        } else {
            log.info("No overlays found.");
        }
    }

}

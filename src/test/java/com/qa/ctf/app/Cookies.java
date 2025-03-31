package com.qa.ctf.app;

import com.qa.ctf.base.PageFactory;
import com.qa.ctf.context.TestContext;
import com.qa.ctf.service.CookieMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Cookie;

import java.util.List;

/**
 * The {@code Cookies} class provides utility methods for handling cookies
 * in the automation framework.
 *
 * <p>Features:
 * <ul>
 *   <li><b>Cookie Management:</b> Stores and retrieves cookies in the automation
 *   framework.</li>
 *   <li><b>Cookie Injection:</b> Converts and injects RestAssured cookies into the
 *   Selenium browser session.</li>
 *   <li><b>Logging:</b> Logs detailed cookie information for debugging purposes.</li>
 * </ul>
 *
 * <p>Exception Handling:
 * <ul>
 *   <li>Logs any potential issues encountered while handling cookies.</li>
 * </ul>
 *
 * <p>Example Usage:
 * <pre>
 * {@code
 * Cookies cookiesUtil = new Cookies();
 * cookiesUtil.setCookies(response.getCookies());
 * cookiesUtil.injectCookiesToBrowser(testContext);
 * }
 * </pre>
 *
 * @author Jagatheshwaran N
 * @version 1.1
 */
public class Cookies {

    // Logger instance for the Cookies class to enable logging during execution
    private static final Logger log = LogManager.getLogger(Cookies.class);

    // Stores the RestAssured cookies used for authentication and session management
    private io.restassured.http.Cookies cookies;

    /**
     * Retrieves the stored RestAssured cookies.
     *
     * @return The cookies stored in the instance.
     */
    public io.restassured.http.Cookies getCookies() {
        return cookies;
    }

    /**
     * Sets the RestAssured cookies to be used in the automation framework.
     *
     * @param cookies The RestAssured cookies to store.
     */
    public void setCookies(io.restassured.http.Cookies cookies) {
        this.cookies = cookies;
    }

    /**
     * Injects stored cookies into the Selenium browser session.
     * <p>
     * This method converts RestAssured cookies into Selenium-compatible cookies
     * and adds them to the browser session, ensuring session continuity.
     * The browser is then refreshed to apply the cookies.
     * </p>
     *
     * @param testContext The test execution context used to manage browser sessions.
     */
    public void injectCookiesToBrowser(TestContext testContext) {
        if (cookies == null || cookies.asList().isEmpty()) {
            log.error("No cookies available to inject into the browser.");
            return;
        }
        PageFactory pageFactory = new PageFactory(testContext);
        List<Cookie> seleniumCookies = new CookieMapper().convertRestAssuredCookieToSelenium(cookies);
        for (int i = 0; i < seleniumCookies.size(); i++) {
            Cookie cookie = seleniumCookies.get(i);
            log.info("Injecting Cookie {}: {}", i, cookie);
            pageFactory.getBrowserHandler().addCookie(cookie);
        }
        pageFactory.getBrowserHandler().refresh();
        log.info("All cookies injected successfully.");
    }

}
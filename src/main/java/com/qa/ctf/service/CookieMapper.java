package com.qa.ctf.service;

import io.restassured.http.Cookies;
import org.openqa.selenium.Cookie;

import java.util.ArrayList;
import java.util.List;

/**
 * The CookieMapper class provides a utility method to convert cookies
 * from RestAssured's {@code Cookies} format to Selenium's {@code Cookie} format.
 *
 * <p>Features:
 * <ul>
 *   <li><b>Cookie Conversion:</b> Converts a list of HTTP cookies from RestAssured
 *   into a format compatible with Selenium WebDriver.</li>
 *   <li><b>Domain, Path, and Expiry Handling:</b> Preserves all attributes such as
 *   domain, path, expiry date, security, HTTP-only flags, and SameSite attributes.</li>
 * </ul>
 *
 * <p>Usage Example:
 * <pre>
 * {@code
 * CookieMapper cookieMapper = new CookieMapper();
 * List<Cookie> seleniumCookies = cookieMapper.convertRestAssuredCookieToSelenium
 * (restAssuredCookies);
 * }
 * </pre>
 *
 * <p>Note:
 * Ensure that the cookies provided are valid and not null before conversion.
 *
 * @author Jagatheshwaran N
 * @version 1.0
 */
public class CookieMapper {

    /**
     * Converts a list of cookies from RestAssured's {@code Cookies} format to
     * Selenium WebDriver's {@code Cookie} format.
     *
     * <p>This method iterates over the RestAssured cookies and maps each one
     * to a Selenium-compatible format while retaining all relevant attributes.</p>
     *
     * @param cookies The {@code Cookies} object containing RestAssured cookies.
     * @return A list of Selenium {@code Cookie} objects.
     */
    public List<Cookie> convertRestAssuredCookieToSelenium(Cookies cookies) {
        List<io.restassured.http.Cookie> restAssuredCookies;
        restAssuredCookies = cookies.asList();
        List<Cookie> seleniumCookieList = new ArrayList<>();
        for (io.restassured.http.Cookie cookie : restAssuredCookies) {
            seleniumCookieList.add(new Cookie(
                    cookie.getName(),
                    cookie.getValue(),
                    cookie.getDomain(),
                    cookie.getPath(),
                    cookie.getExpiryDate(),
                    cookie.isSecured(),
                    cookie.isHttpOnly(),
                    cookie.getSameSite()
            ));
        }
        return seleniumCookieList;
    }

}

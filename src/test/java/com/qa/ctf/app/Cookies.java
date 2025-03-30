package com.qa.ctf.app;

import com.qa.ctf.base.PageFactory;
import com.qa.ctf.context.TestContext;
import com.qa.ctf.service.CookieMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class Cookies {

    private static final Logger log = LogManager.getLogger(Cookies.class);

    private io.restassured.http.Cookies cookies;

    public io.restassured.http.Cookies getCookies() {
        return cookies;
    }

    public void setCookies(io.restassured.http.Cookies cookies) {
        this.cookies = cookies;
    }

    public void injectCookiesToBrowser(TestContext testContext) {
        PageFactory pageFactory = new PageFactory(testContext);
        List<Cookie> seleniumCookies = new CookieMapper().convertRestAssuredCookieToSelenium(cookies);
        int count = 0;
        for (Cookie cookie : seleniumCookies) {
            log.info("Cookie {}: {}", count, cookie.toString());
            pageFactory.getBrowserHandler().addCookie(cookie);
            count++;
        }
        pageFactory.getBrowserHandler().refresh();
    }

}

package com.qa.ctf.base;

import com.qa.ctf.context.TestContext;
import com.qa.ctf.util.FileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PageBase {

    protected WebDriver driver;

    protected WebDriverWait wait;

    protected  com.qa.ctf.base.PageFactory pageFactory;

    public PageBase(TestContext testContext) {
        //System.out.println("Initializing BasePage with driver: " + driver);
//        if (driver == null) {
//            throw new IllegalStateException("Driver is not initialized in TestContext.");
//        }
        pageFactory = new com.qa.ctf.base.PageFactory(testContext);
        this.driver = testContext.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    public void load(String endpoint) {
        System.out.println("BASE DRIVER : "+driver);
        driver.get(FileReader.fetchDataFromPropFile("BaseURL") +endpoint);
    }

    public void waitForOverlayToDisappear(By overlay) {
        List<WebElement> overlays = driver.findElements(overlay);
        System.out.println("OVERLAY SIZE: "+ overlays.size());
        if(!overlays.isEmpty()) {
            wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
            System.out.println("OVERLAYS INVISIBLE");
        }else{
            System.out.println("OVERLAYS NOT FOUND");
        }
    }

}

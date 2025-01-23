package com.qa.ctf.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 *
 * @author Jaga
 *
 */

//@CucumberOptions(features = "src/test/resources/features/", tags = "@launch", glue = { "com/jtaf/qa/steps",
//		"com/jtaf/qa/test", "com/jtaf/qa/pages", "com/jtaf/qa/base" }, plugin = { "pretty",
//				"json:target/cucumber/report/report.json", "junit:target/cucumber/report/report.xml",
//				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, publish = true, monochrome = true)
//public class Old_TestRunner extends AbstractTestNGCucumberTests {
//
//}

@CucumberOptions(features = "src/test/resources/features/", glue = { "com/qa/ctf"}, plugin = { "pretty",
        "json:target/cucumber/report/report.json", "junit:target/cucumber/report/report.xml",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, publish = true, monochrome = true)
public class Old_TestRunner extends AbstractTestNGCucumberTests {

}

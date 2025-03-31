package com.qa.ctf.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * The {@code TestNGRunnerTest} class serves as the entry point for running
 * Cucumber tests with TestNG. It is configured to run Cucumber feature files
 * with specific options, such as the feature file location, tag filters, report
 * generation, and parallel execution of scenarios.
 *
 * <p>
 * This class extends {@link AbstractTestNGCucumberTests} and utilizes the
 * {@link DataProvider} annotation to enable parallel execution of Cucumber
 * scenarios.
 * </p>
 *
 * <p>
 * The {@code @CucumberOptions} annotation configures the Cucumber test execution
 * environment, including feature file paths, tags, glue code locations, reporting
 * plugins, and other test settings like publishing results and generating various
 * report formats (HTML, JSON, JUnit, etc.).
 * </p>
 *
 * @author Jagatheshwaran N
 * @version 1.0
 */
@CucumberOptions(
        features = "src/test/resources/features/", // Path to the feature files
        tags = "@service", // Tags to filter which tests to run
        glue = {"com/qa/ctf"}, // Package where step definitions are located
        plugin = { // Cucumber plugins for various reports
                "pretty",
                "html:target/cucumber/report/cucumber.html", // HTML report location
                "json:target/cucumber/report/report.json", // JSON report location
                "junit:target/cucumber/report/report.xml", // JUnit report location
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", // Extent Reports integration
                "rerun:target/failedRerun.txt", // List of failed scenarios for rerun
                "timeline:test-output-thread/" // Timeline report
        },
        publish = true, // Publish the results to the Cucumber cloud
        monochrome = true // Ensures the output is readable in the console
)
public class TestNGRunnerTest extends AbstractTestNGCucumberTests {

    /**
     * Provides the scenarios for execution with parallelism enabled.
     * <p>
     * This method overrides the {@link AbstractTestNGCucumberTests#scenarios()} method
     * and is annotated with {@link DataProvider} to allow for parallel execution of test
     * scenarios.
     * </p>
     *
     * @return An array of scenarios to be run in parallel.
     */
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios(); // Returns scenarios from the parent class
    }

}

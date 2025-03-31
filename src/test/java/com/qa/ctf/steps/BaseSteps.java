package com.qa.ctf.steps;

import com.qa.ctf.base.PageFactory;
import com.qa.ctf.context.TestContext;

/**
 * The {@code BaseSteps} class is a base class for step definitions in the
 * Cucumber framework.
 * <p>
 * This class provides a mechanism to initialize the {@code PageFactory} that
 * is responsible for creating page objects based on the provided {@code TestContext}.
 * </p>
 *
 * @author Jagatheshwaran N
 * @version 1.0
 */
public class BaseSteps {

    /** The {@code PageFactory} used to create page objects. */
    protected PageFactory pageFactory;

    /**
     * Constructs a {@code BaseSteps} instance with the given test context.
     * <p>
     * This constructor initializes the {@code PageFactory} with the provided
     * {@code TestContext}. The {@code PageFactory} is used to create and manage
     * page objects for the test steps.
     * </p>
     *
     * @param testContext The test context that contains information for managing
     *                    the state of the test.
     */
    public BaseSteps(TestContext testContext) {
        pageFactory = new PageFactory(testContext);
    }

}

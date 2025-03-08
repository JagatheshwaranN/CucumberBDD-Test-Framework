package com.qa.ctf.pages;

import com.qa.ctf.base.PageFactory;
import com.qa.ctf.context.TestContext;

public class BasePage {

    protected PageFactory pageFactory;

    public BasePage(TestContext testContext) {
        pageFactory = new PageFactory(testContext);
    }
}

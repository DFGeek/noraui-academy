package com.yourcompany.norarobot;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.github.noraui.exception.TechnicalException;
import com.yourcompany.norarobot.utils.NoraRobotContext;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import com.github.noraui.utils.Context;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, glue = { "com.github.noraui.application.steps", "com.github.noraui.browser.steps", "com.yourcompany.norarobot.application.steps" }, plugin = { "html:target/reports/html" },
features = { "src/test/resources" })
public class NoraRobotRunner {

    /**
     * BeforeClass Read constants file
     */
    @BeforeClass
    public static void setUpClass() throws TechnicalException {
        NoraRobotContext.getInstance().initializeEnv("NoraRobot.properties");
        NoraRobotContext.getInstance().initializeRobot(NoraRobotRunner.class);
    }

    /**
     * AfterClass clear Context
     */
    @AfterClass
    public static void tearDownClass() {
        Context.clear();
    }

}

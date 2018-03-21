/**
 * NoraRobot generated free by NoraUi Organization https://github.com/NoraUi
 * NoraRobot is licensed under the license BSD.
 * CAUTION: NoraRobot use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 */
package com.yourcompany.norarobot;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.yourcompany.norarobot.utils.NoraRobotContext;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import com.github.noraui.exception.TechnicalException;
import com.github.noraui.utils.Context;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, glue = { "com.github.noraui.application.steps", "com.github.noraui.browser.steps", "com.yourcompany.norarobot.application.steps" }, plugin = { "html:target/reports/html", "json:target/reports/json/report.json", "junit:target/reports/junit/report.xml" },
        features = { "src/test/resources" })
public class NoraRobotRunnerApi {

    /**
     * BeforeClass Read constants file
     */
    @BeforeClass
    public static void setUpClass() throws TechnicalException {
        NoraRobotContext.getInstance().initializeEnv("NoraRobot.properties");
        NoraRobotContext.getInstance().initializeRobot(NoraRobotRunnerApi.class);
	}

    /**
     * AfterClass clear Context
     */
    @AfterClass
    public static void tearDownClass() {
        Context.clear();
    }

}

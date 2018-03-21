/**
 * NoraRobot generated free by NoraUi Oraganization https://github.com/NoraUi
 * NoraRobot is licensed under the license BSD.
 * CAUTION: NoraRobot use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 */
package com.yourcompany.norarobot.application.steps.jhipstersampleapp;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.github.noraui.application.steps.Step;
import com.github.noraui.browser.Auth;
import com.github.noraui.exception.FailureException;
import com.github.noraui.exception.Result;
import com.github.noraui.exception.TechnicalException;
import com.github.noraui.utils.Context;
import com.github.noraui.utils.Messages;
import com.github.noraui.utils.Utilities;
import com.google.inject.Inject;
import com.yourcompany.norarobot.application.pages.jhipstersampleapp.JHipsterSampleAppPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JHipsterSampleAppSteps extends Step {

    @Inject
    private JHipsterSampleAppPage jHipsterSampleAppPage;

    /**
     * Check Login page.
     *
     * @throws FailureException
     *             if the scenario encounters a functional error.
     */
    @Then("The JHIPSTERSAMPLEAPP home page is displayed")
    public void checkJHipsterSampleAppLoginPage() throws FailureException {
        if (!jHipsterSampleAppPage.checkPage()) {
            new Result.Failure<>(jHipsterSampleAppPage.getApplication(), Messages.FAIL_MESSAGE_UNKNOWN_CREDENTIALS, true, jHipsterSampleAppPage.getCallBack());
        }
    }

    /**
     * Log in to JHIPSTERSAMPLEAPP without NoraRobot (login and password in Gherkin scenario).
     *
     * @param login
     *            Login to use.
     * @param password
     *            Password to use.
     * @throws FailureException
     *             if the scenario encounters a functional error.
     */
    @When("I log in to JHIPSTERSAMPLEAPP as '(.*)' '(.*)'")
    public void logInToJHipsterSampleApp(String login, String password) throws FailureException {
        try {
            Utilities.findElement(jHipsterSampleAppPage.accountMenu).click();
            Context.waitUntil(ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(jHipsterSampleAppPage.signinMenu))).click();

            Context.waitUntil(ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(jHipsterSampleAppPage.signInButton)));
            Utilities.findElement(jHipsterSampleAppPage.login).sendKeys(login);
            Utilities.findElement(jHipsterSampleAppPage.password).sendKeys(password);
            Utilities.findElement(jHipsterSampleAppPage.signInButton).click();
        } catch (Exception e) {
            new Result.Failure<>(e, Messages.FAIL_MESSAGE_UNKNOWN_CREDENTIALS, true, jHipsterSampleAppPage.getCallBack());
        }
    }

    /**
     * Check JHipsterSampleApp portal page.
     *
     * @throws FailureException
     *             if the scenario encounters a functional error.
     */
    @Then("The JHIPSTERSAMPLEAPP portal is displayed")
    public void checkJHipsterSampleAppPage() throws FailureException {
        try {
            Context.waitUntil(ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(jHipsterSampleAppPage.signInMessage)));
            if (!jHipsterSampleAppPage.isDisplayed()) {
                logInToJHipsterSampleAppWithNoraRobot();
            }
            if (!jHipsterSampleAppPage.checkPage()) {
                new Result.Failure<>(jHipsterSampleAppPage.getApplication(), Messages.FAIL_MESSAGE_UNKNOWN_CREDENTIALS, true, jHipsterSampleAppPage.getCallBack());
            }
        } catch (Exception e) {
            new Result.Failure<>(jHipsterSampleAppPage.getApplication(), Messages.FAIL_MESSAGE_UNKNOWN_CREDENTIALS, true, jHipsterSampleAppPage.getCallBack());
        }
        Auth.setConnected(true);
    }

    /**
     * Logout of JHipsterSampleApp.
     *
     * @throws FailureException
     *             if the scenario encounters a functional error.
     * @throws TechnicalException
     *             is thrown if you have a technical error (format, configuration, datas, ...) in NoraUi.
     */
    @When("I log out of JHIPSTERSAMPLEAPP")
    public void logOutOfJHipsterSampleApp() throws FailureException, TechnicalException {
        if (Auth.isConnected()) {
            getDriver().switchTo().defaultContent();
            clickOn(jHipsterSampleAppPage.accountMenu);
            Context.waitUntil(ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(jHipsterSampleAppPage.signoutMenu))).click();
        }
    }

    /**
     * Check Logout page.
     */
    @Then("The JHIPSTERSAMPLEAPP logout page is displayed")
    public void checkJHipsterSampleAppLogoutPage() {
        jHipsterSampleAppPage.checkPage();
    }

    /**
     * Log in to JHIPSTERSAMPLEAPP with NoraRobot (login and password in job parameters).
     *
     * @throws FailureException
     *             if the scenario encounters a functional error.
     */
    private void logInToJHipsterSampleAppWithNoraRobot() throws FailureException {
        String login = Auth.getLogin();
        String password = Auth.getPassword();
        if (!"".equals(login) && !"".equals(password)) {
            logInToJHipsterSampleApp(login, password);
        }
    }

}

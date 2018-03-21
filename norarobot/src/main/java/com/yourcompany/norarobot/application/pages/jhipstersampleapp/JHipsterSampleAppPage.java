/**
 * NoraRobot generated free by NoraUi Organization https://github.com/NoraUi
 * NoraRobot is licensed under the license BSD.
 * CAUTION: NoraRobot use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 */
package com.yourcompany.norarobot.application.pages.jhipstersampleapp;

import static com.yourcompany.norarobot.utils.NoraRobotContext.JHIPSTERSAMPLEAPP_KEY;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yourcompany.norarobot.utils.NoraRobotContext;

import com.github.noraui.application.page.Page;
import com.github.noraui.utils.Context;

public class JHipsterSampleAppPage extends Page {

    private static final Logger logger = LoggerFactory.getLogger(JHipsterSampleAppPage.class.getName());

    public final PageElement accountMenu = new PageElement("-accountMenu", "Account menu");
    public final PageElement signinMenu = new PageElement("-signinMenu", "Sign-in menu");
    public final PageElement signoutMenu = new PageElement("-signoutMenu", "Sign-out menu");
    public final PageElement login = new PageElement("-login_field", "Login");
    public final PageElement password = new PageElement("-password_field", "Password");
    public final PageElement signInButton = new PageElement("-sign_in_button", "Sign-in button");
    public final PageElement signInMessage = new PageElement("-sign_in_message");

    private static final String TITLE_PAGE = "JHipsterSampleApp";

    public JHipsterSampleAppPage() {
        super();
        this.application = JHIPSTERSAMPLEAPP_KEY;
        this.pageKey = "APP_HOM";
        this.callBack = Context.getCallBack(NoraRobotContext.CLOSE_WINDOW_AND_SWITCH_TO_JHIPSTERSAMPLEAPP_HOME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkPage(Object... elements) {
        try {
            Context.waitUntil(ExpectedConditions.not(ExpectedConditions.titleIs("")));
            if (!TITLE_PAGE.equals(getDriver().getTitle())) {
                logger.error("HTML title is not good");
                return false;
            }
            return true;
        } catch (Exception e) {
            logger.error("HTML title Exception", e);
            return false;
        }
    }

    /**
     * isDisplayed returns true if JHIPSTERSAMPLEAPP portal page is displayed.
     *
     * @return boolean
     */
    public boolean isDisplayed() {
        return isDisplayed(TITLE_PAGE);
    }

    /**
     * isDisplayed returns true if the required JHIPSTERSAMPLEAPP portal page is displayed.
     *
     * @param titlePage
     *            The page title to check
     * @return boolean
     */
    public boolean isDisplayed(String titlePage) {
        try {
            Context.waitUntil(ExpectedConditions.not(ExpectedConditions.titleIs("")));
            if (!titlePage.equals(getDriver().getTitle())) {
                return false;
            }
        } catch (Exception e) {
            logger.error("Exception in isDisplayed: " + e);
            return false;
        }
        return true;
    }

}

/**
 * NoraRobot generated free by NoraUi Organization https://github.com/NoraUi
 * NoraRobot is licensed under the license BSD.
 * CAUTION: NoraRobot use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 */
package com.yourcompany.norarobot.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.noraui.application.Application;
import com.github.noraui.application.page.Page;
import com.github.noraui.exception.TechnicalException;
import com.github.noraui.utils.Context;

public class NoraRobotContext extends Context {

    /**
     * Specific logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(NoraRobotContext.class);

    public static final String JHIPSTERSAMPLEAPP_KEY = "jhipstersampleapp";
    public static final String JHIPSTERSAMPLEAPP_HOME = "JHIPSTERSAMPLEAPP_HOME";
    public static final String JHIPSTERSAMPLEAPP_CUSTOMER = "JHIPSTERSAMPLEAPP_CUSTOMER";
    public static final String JHIPSTERSAMPLEAPP_APP = "jhipstersampleapp.app";

    public static final String GO_TO_JHIPSTERSAMPLEAPP_HOME = "GO_TO_JHIPSTERSAMPLEAPP_HOME";
    public static final String CLOSE_WINDOW_AND_SWITCH_TO_JHIPSTERSAMPLEAPP_HOME = "CLOSE_WINDOW_AND_SWITCH_TO_JHIPSTERSAMPLEAPP_HOME";
    public static final String CLOSE_ALL_WINDOWS_AND_SWITCH_TO_JHIPSTERSAMPLEAPP_HOME = "CLOSE_ALL_WINDOWS_AND_SWITCH_TO_JHIPSTERSAMPLEAPP_HOME";

    private String jHipsterSampleAppHome; // JHIPSTERSAMPLEAPP home url

    /**
     * Constructor is useless because all attributes are static
     */
    private NoraRobotContext() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void initializeRobot(Class clazz) throws TechnicalException {
        super.initializeRobot(clazz);
        logger.info("NoraRobotContext > initializeRobot()");

        // Urls configuration
        jHipsterSampleAppHome = getProperty(JHIPSTERSAMPLEAPP_KEY, applicationProperties);

        // Selectors configuration
        initApplicationDom(clazz.getClassLoader(), selectorsVersion, JHIPSTERSAMPLEAPP_KEY);

        exceptionCallbacks.put(GO_TO_JHIPSTERSAMPLEAPP_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, GO_TO_URL_METHOD_NAME, JHIPSTERSAMPLEAPP_HOME);
        exceptionCallbacks.put(CLOSE_WINDOW_AND_SWITCH_TO_JHIPSTERSAMPLEAPP_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, "closeWindowAndSwitchTo", JHIPSTERSAMPLEAPP_KEY, JHIPSTERSAMPLEAPP_HOME);
        exceptionCallbacks.put(CLOSE_ALL_WINDOWS_AND_SWITCH_TO_JHIPSTERSAMPLEAPP_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, "closeAllWindowsAndSwitchTo", JHIPSTERSAMPLEAPP_KEY);

        Application jHipsterSampleApp = new Application(JHIPSTERSAMPLEAPP_HOME, jHipsterSampleAppHome);
        jHipsterSampleApp.addUrlPage(JHIPSTERSAMPLEAPP_CUSTOMER, jHipsterSampleAppHome + "/#/customer");
        applications.put(JHIPSTERSAMPLEAPP_KEY, jHipsterSampleApp);

        Page.setPageMainPackage("com.yourcompany.norarobot.application.pages.");
    }

    /**
     * Get context singleton.
     *
     * @return context instance
     */
    public static Context getInstance() {
        if (instance == null || !(instance instanceof NoraRobotContext)) {
            instance = new NoraRobotContext();
        }
        return instance;
    }

    public String getJHipsterSampleAppHome() {
        return jHipsterSampleAppHome;
    }

}

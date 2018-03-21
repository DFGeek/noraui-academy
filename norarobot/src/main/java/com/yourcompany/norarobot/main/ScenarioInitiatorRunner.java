/**
 * NoraRobot generated free by NoraUi Organization https://github.com/NoraUi
 * NoraRobot is licensed under the license BSD.
 * CAUTION: NoraRobot use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 */
package com.yourcompany.norarobot.main;

import com.yourcompany.norarobot.utils.NoraRobotContext;

import com.github.noraui.main.ScenarioInitiator;

public class ScenarioInitiatorRunner {

    public static void main(String[] args) {
        NoraRobotContext.getInstance().initializeEnv("NoraRobot.properties");
        new ScenarioInitiator().start(args);
    }

}

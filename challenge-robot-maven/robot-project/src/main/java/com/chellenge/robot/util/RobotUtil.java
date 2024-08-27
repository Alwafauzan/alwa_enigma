package com.chellenge.robot.util;

public class RobotUtil {

    public static boolean isValidCommand(String command) {
        return command.matches("[FLR]");
    }

}

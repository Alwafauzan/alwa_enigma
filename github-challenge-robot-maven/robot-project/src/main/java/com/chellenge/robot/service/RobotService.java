package com.chellenge.robot.service;
import com.chellenge.robot.entity.RobotEntity;

public class RobotService {

    public void moveForward(RobotEntity robot) {
        switch (robot.getDirection()) {
            case 'N': robot.setY(robot.getY() + 1); break;
            case 'E': robot.setX(robot.getX() + 1); break;
            case 'S': robot.setY(robot.getY() - 1); break;
            case 'W': robot.setX(robot.getX() - 1); break;
        }
    }

    public void turnLeft(RobotEntity robot) {
        switch (robot.getDirection()) {
            case 'N': robot.setDirection('W'); break;
            case 'W': robot.setDirection('S'); break;
            case 'S': robot.setDirection('E'); break;
            case 'E': robot.setDirection('N'); break;
        }
    }

    public void turnRight(RobotEntity robot) {
        switch (robot.getDirection()) {
            case 'N': robot.setDirection('E'); break;
            case 'E': robot.setDirection('S'); break;
            case 'S': robot.setDirection('W'); break;
            case 'W': robot.setDirection('N'); break;
        }
    }
}


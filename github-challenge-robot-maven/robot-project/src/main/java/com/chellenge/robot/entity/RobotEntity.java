package com.chellenge.robot.entity;

public class RobotEntity {
    int x;
    int y;
    char direction;
    public RobotEntity() {
    }
    public RobotEntity(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public char getDirection() {
        return direction;
    }
    public void setDirection(char direction) {
        this.direction = direction;
    }
    // @Override
    // public String toString() {
    //     return "RobotEntity [x=" + x + ", y=" + y + ", direction=" + direction + "]";
    // }

        @Override
    public String toString() {
        return String.format("%c->(%d,%d)", direction, x, y);
    }

    

}

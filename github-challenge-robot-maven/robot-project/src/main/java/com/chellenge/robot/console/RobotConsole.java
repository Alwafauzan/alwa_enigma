package com.chellenge.robot.console;

import java.util.Scanner;

import com.chellenge.robot.entity.RobotEntity;
import com.chellenge.robot.service.RobotService;

public class RobotConsole {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RobotService robotService = new RobotService();
        RobotEntity robot = new RobotEntity(0, 0, 'N');

        System.out.println("posisi awal: " + robot);

        // Contoh Interaksi Console
        System.out.println("masukkan command (F = forward, L = left, R = right): ");
        System.out.println("bikin satu huruf aja, gabisa to char, error mlu");
        String command = scanner.nextLine();

        switch (command) {
            case "F": robotService.moveForward(robot); break;
            case "L": robotService.turnLeft(robot); break;
            case "R": robotService.turnRight(robot); break;
        }

        System.out.println("Final Robot Position: " + robot);
    }
}

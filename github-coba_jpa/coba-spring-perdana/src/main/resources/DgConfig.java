package com.example.coba_spring_perdana;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class Engine {
    private String type;
    private int speed;

    public Engine(String type) {
        this.type = type;
        if (type.equals("electric")) {
            this.speed = 200;
        } else if (type.equals("diesel")) {
            this.speed = 250;
        }
    }

    public String getType() {
        return type;
    }

    public int getSpeed() {
        return speed;
    }
}

class Car {
    private String name;
    private String color;
    private Engine engine;

    public Car(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void showDetails() {
        System.out.println("Car Name: " + name);
        System.out.println("Car Color: " + color);
        System.out.println("Engine Type: " + engine.getType());
        System.out.println("Speed: " + engine.getSpeed() + " km/h");
    }
}

public class DgConfig {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Car car = (Car) context.getBean("car");
        car.showDetails();
    }
}

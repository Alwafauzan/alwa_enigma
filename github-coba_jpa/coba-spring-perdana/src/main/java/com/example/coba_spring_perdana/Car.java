package com.example.coba_spring_perdana;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    private String name;
    private String color;

    @Autowired
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

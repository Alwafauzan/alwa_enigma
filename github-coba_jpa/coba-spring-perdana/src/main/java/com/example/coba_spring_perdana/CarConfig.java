package com.example.coba_spring_perdana;

public class CarConfig {
    private String name;
    private String color;
    private EngineConfig engine;

    public CarConfig(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public void setEngineConfig(EngineConfig engine) {
        this.engine = engine;
    }

    public void showDetails() {
        System.out.println("CarConfig Name: " + name);
        System.out.println("CarConfig Color: " + color);
        System.out.println("EngineConfig Type: " + engine.getType());
        System.out.println("Speed: " + engine.getSpeed() + " km/h");
    }
}

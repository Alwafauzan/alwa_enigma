package com.example.coba_spring_perdana;

public class Engine {
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

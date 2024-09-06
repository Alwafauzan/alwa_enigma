package com.example.coba_spring_perdana;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Car car = (Car) context.getBean("car");
        car.showDetails();
    }
}

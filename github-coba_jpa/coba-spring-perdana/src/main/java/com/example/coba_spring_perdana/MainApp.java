package com.example.coba_spring_perdana;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainApp {

    @Bean
    public Engine electricEngine() {
        return new Engine("electric");
    }

    @Bean
    public Engine dieselEngine() {
        return new Engine("diesel");
    }

    @Bean
    public Car car(Engine engine) {
        Car car = new Car("yaris", "yellow blue");
        car.setEngine(engine); // Pilih engine yang ingin digunakan
        return car;
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainApp.class);
        Car car = context.getBean(Car.class);
        car.showDetails();
    }
}

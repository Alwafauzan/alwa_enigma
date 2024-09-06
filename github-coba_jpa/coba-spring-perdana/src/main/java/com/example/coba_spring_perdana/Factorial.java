package com.example.coba_spring_perdana;

import java.util.logging.Logger;

public class Factorial {
    private static final Logger LOGGER = Logger.getLogger(Factorial.class.getName());

    public static long factorial(int n) {
        LOGGER.info("Memanggil metode factorial dengan n = " + n);
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        long result = factorial(10);
        System.out.println("Faktorial dari 10: " + result);
    }
}
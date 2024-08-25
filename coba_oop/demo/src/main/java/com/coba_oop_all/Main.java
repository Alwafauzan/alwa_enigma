package com.coba_oop_all;

public class Main {

    public static void main(String[] args) {

        // instansiasi

        Gorilla gorilla = new Gorilla("halo saya gorila, saya berbunyi : ");

        Cat cat = new Cat("halo saya kucing, saya berbunyi : ");



        
        // encapsulation
        System.out.print(gorilla.getNarate());
        gorilla.sound();

        System.out.print(cat.getNarate());
        cat.sound();







    }

}



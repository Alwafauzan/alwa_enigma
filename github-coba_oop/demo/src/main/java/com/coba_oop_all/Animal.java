package com.coba_oop_all;


public abstract class Animal {

    // variaabel
    private String narate;  


    // constructor
    public Animal(String narate) {

        this.narate = narate;

    }

    // constructor kosog
    public Animal() {
    }



    public abstract void sound();

    // getter
    public String getNarate() {

        return narate;

    }

}

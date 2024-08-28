package com.enigmacamp.polymorphism;

public class MageHeroes extends Heroes{
    public MageHeroes(String name, Integer hp, Integer mana, Integer baseDamage, Integer attackSpeed) {
        super(name, hp, mana, baseDamage, attackSpeed);
        this.setMana(getMana() + 400);
    }

    public MageHeroes() {
    }

    
}

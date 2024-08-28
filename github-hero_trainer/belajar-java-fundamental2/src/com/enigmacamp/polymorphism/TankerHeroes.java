package com.enigmacamp.polymorphism;

public class TankerHeroes extends Heroes {

    public TankerHeroes(String name, Integer hp, Integer mana, Integer baseDamage, Integer attackSpeed) {
        super(name, hp, mana, baseDamage, attackSpeed);
        this.setHp(getHp() + 300);
    }

    public TankerHeroes() {
    }
}

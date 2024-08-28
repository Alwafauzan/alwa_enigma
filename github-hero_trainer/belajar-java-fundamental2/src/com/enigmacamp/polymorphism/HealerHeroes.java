package com.enigmacamp.polymorphism;

public class HealerHeroes extends Heroes {
    public HealerHeroes(String name, Integer hp, Integer mana, Integer baseDamage, Integer attackSpeed) {
        super(name, hp, mana, baseDamage, attackSpeed);
        this.setBaseDamage(getBaseDamage() + 100);
    }

    public HealerHeroes() {
    }
    
}

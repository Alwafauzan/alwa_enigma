package com.enigmacamp.polymorphism;

public class AssassinHeroes extends Heroes {
    public AssassinHeroes(String name, Integer hp, Integer mana, Integer baseDamage, Integer attackSpeed) {
        super(name, hp, mana, baseDamage, attackSpeed);
        this.setAttackSpeed(getAttackSpeed() + 100);
    }

    public AssassinHeroes() {
    }
}

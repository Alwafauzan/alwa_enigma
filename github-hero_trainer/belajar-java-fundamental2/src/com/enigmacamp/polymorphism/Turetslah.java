package com.enigmacamp.polymorphism;

public interface Turetslah {
    void attackAble();
    void noAttackAble();
}

class Asassin implements Turet {
    private Integer hp;
    private Integer range;
    private Integer baseDamage;

    public Asassin(Integer hp, Integer range, Integer baseDamage) {
        this.hp = hp;
        this.range = range;
        this.baseDamage = baseDamage;
    }

    @Override
    public void attackAble() {
        System.out.println("serang sebanyak " + baseDamage + " damage!");
    }

    @Override
    public void noAttackAble() {
        System.out.println("kejauhan bro");
    }
}

class mage implements Turet {
    private Integer hp;
    private Integer range;
    private Integer baseDamage;

    public mage(Integer hp, Integer range, Integer baseDamage) {
        this.hp = hp;
        this.range = range;
        this.baseDamage = baseDamage;
    }

    @Override
    public void attackAble() {
        System.out.println("serang sebanyak " + baseDamage + " damage!");
    }

    @Override
    public void noAttackAble() {
        System.out.println("kejauhan bro");
    }
}






package com.enigmacamp.polymorphism;

public abstract class Heroes {
    private String name;
    private Integer hp;
    private Integer mana;
    private Integer baseDamage;
    private Integer attackSpeed;
    private boolean shield;



    public Heroes(String name, Integer hp, Integer mana, Integer baseDamage, Integer attackSpeed, boolean shield) {
        this.name = name;
        this.hp = hp;
        this.mana = mana;
        this.baseDamage = baseDamage;
        this.attackSpeed = attackSpeed;
        this. shield = shield;
    }
    public Heroes() {
    }

    public boolean isShield() {
        return shield;
    }

    public void setShield(boolean shield) {
        this.shield = true;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getMana() {
        return mana;
    }

    public void setMana(Integer mana) {
        this.mana = mana;
    }

    public Integer getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(Integer baseDamage) {
        this.baseDamage = baseDamage;
    }

    public Integer getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(Integer attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    // ===================================

    public void attack(  turets){
        turets.getHit(this.baseDamage);
    }

    public void heal(Heroes turets){
        turets.getHeal(this.baseDamage);
    }

    public void getHit(Integer damage){
        this.hp = this.hp-damage;
    }

    public void getHeal(Integer damage){
        this.hp = this.hp+damage;
    }
    public void shield(Integer damage){
        // this.hp = this.hp;
        System.out.println("nyerang apa bro?");
    }



    // @Override
    // public String toString() {
    //     return "Heroes{" +
    //             "name='" + name + '\'' +
    //             ", hp=" + hp +
    //             ", mana=" + mana +
    //             ", baseDamage=" + baseDamage +
    //             ", attackSpeed=" + attackSpeed +
    //             '}';
    // }

    @Override
    public String toString() {
        return "Heroes [name=" + name + ", hp=" + hp + ", mana=" + mana + ", baseDamage=" + baseDamage
                + ", attackSpeed=" + attackSpeed + ", shield=" + shield + "]";
    }
    
}

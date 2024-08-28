class Mage implements Turetslah {
    private Integer hp;
    private Integer mana;
    private Integer baseDamage;
    private Integer range;

    public Mage(Integer hp, Integer mana, Integer baseDamage, Integer range) {
        this.hp = hp;
        this.mana = mana;
        this.baseDamage = baseDamage;
        this.range = range;
    }

    @Override
    public void attackAble() {
        if (isInRange()) {
            System.out.println(baseDamage + " damage!");
        } else {
            System.out.println("kejauhan bro");
        }
    }

    @Override
    public void noAttackAble() {
        System.out.println("gaada mana");
    }

    private boolean isInRange() {
        // asumsi range adalah jarak maksimum yang dapat dijangkau oleh mage
        return range >= 15; // jika range >= 15 maka mage dapat menyerang
    }
}
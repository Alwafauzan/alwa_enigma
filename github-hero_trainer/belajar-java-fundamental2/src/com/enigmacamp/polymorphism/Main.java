package com.enigmacamp.polymorphism;

public class Main {
    public static void main(String[] args) {
        AssassinHeroes assassin = new AssassinHeroes("Haya", 500, 20, 200, 300) ;
        MageHeroes mage = new MageHeroes("Nana", 300, 400, 100, 150) ;
        TankerHeroes tanker = new TankerHeroes("Franco", 1000, 20, 50, 100) ;
        HealerHeroes healer = new HealerHeroes("angela", 1000, 20, 50, 100) ;
        Turet turet = new Turet("turet", 1000) ;

 
        // Heroes heroasassin = assassin;
        // Heroes herotanker = tanker;
        // Heroes heromage = mage;

        //Status heroes before attack
        System.out.println(assassin);
        System.out.println(mage);
        System.out.println(tanker);
        System.out.println(healer);
        System.out.println(turet);
        System.out.println("===================");


        assassin.attack(mage);
        mage.attack(tanker);
        tanker.attack(assassin);
        healer.heal(tanker);
        // assassin.shield((turet));

        //status heroes after attack
        System.out.println(assassin);
        System.out.println(mage);
        System.out.println(tanker);

    }
}

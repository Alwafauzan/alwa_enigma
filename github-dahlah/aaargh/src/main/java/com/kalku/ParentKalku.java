package com.kalku;

public abstract class ParentKalku {
    private Integer angka1;
    private Integer angka2;

    public ParentKalku(Integer angka1, Integer angka2) {
        this.angka1 = angka1;
        this.angka2 = angka2;
    }

    public ParentKalku() {
    }


    public Integer getAngka1() {
        return angka1;
    }
    public void setAngka1(Integer angka1) {
        this.angka1 = angka1;
    }
    public Integer getAngka2() {
        return angka2;
    }
    public void setAngka2(Integer angka2) {
        this.angka2 = angka2;
    }

    public abstract Integer penjumlahan();
    // public abstract Integer pengurangan();
    // public abstract Integer perkalian();
    // public abstract Integer pembagian();


    @Override
    public String toString() {
        return "ParentKalku [angka1=" + angka1 + ", angka2=" + angka2 + "]";
    }


    
    
}

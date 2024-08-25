package com.kalku;

public class Penjumlahan extends ParentKalku {

    public Penjumlahan(Integer angka1, Integer angka2) {
        super(angka1, angka2);
    }

    @Override
    public Integer penjumlahan() {
        
        return super.getAngka1() + super.getAngka2();
    }

    

}


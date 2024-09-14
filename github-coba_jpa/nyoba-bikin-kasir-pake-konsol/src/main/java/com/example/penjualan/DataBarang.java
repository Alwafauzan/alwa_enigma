package com.example.penjualan;

public class DataBarang {
    String kodeBarang, namaBarang;
    float hargaBarang;
    int jumlahBeli;
    double bayar;

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public float getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(float hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public int getJumlahBeli() {
        return jumlahBeli;
    }

    public void setJumlahBeli(int jumlahBeli) {
        this.jumlahBeli = jumlahBeli;
    }

    // public double getBayar() {
    // return bayar;
    // }

    public void setBayar(double bayar) {
        this.bayar = bayar;
    }

    public double getBayar() {
        bayar = hargaBarang * jumlahBeli;
        return bayar;
    }

}

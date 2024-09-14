package com.example.penjualan;

import java.util.Scanner;

public class Penjualan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String namaKasir = System.console().readLine("nama kasir : ");

        DataBarang[] dataBarang = new DataBarang[0];

        int pilihan, jumlahBarang, i;
        do {
            System.out.println("pilih menu : ");
            System.out.println("1. input data penjualan");
            System.out.println("2. pembayaran");
            System.out.println("3. keluar");

            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("masukkan jumlah barang : ");
                    jumlahBarang = scanner.nextInt();
                    dataBarang = new DataBarang[jumlahBarang];
                    for (i = 0; i < dataBarang.length; i++) {
                        dataBarang[i] = new DataBarang();
                        System.out.println("barang ke : " + (i + 1));
                        System.out.println("masukkan kode barang : ");
                        dataBarang[i].setKodeBarang(scanner.next());
                        System.out.println("masukkan nama barang : ");
                        dataBarang[i].setNamaBarang(scanner.next());
                        System.out.println("masukkan harga barang : ");
                        dataBarang[i].setHargaBarang(scanner.nextFloat());
                        System.out.println("masukkan jumlah beli : ");
                        dataBarang[i].setJumlahBeli(scanner.nextInt());
                    }
                    break;

                case 2:
                    System.out.println("data penjualan barang");
                    System.out.println("pt mencari cinta sejati");
                    System.out.println("nama kasir : " + namaKasir);
                    System.out.println("=================================================");
                    System.out.println("no. \t kode \t nama \t harga \t jumlah \t bayar");
                    System.out.println("=================================================");
                    for (i = 0; i < dataBarang.length; i++) {
                        System.out.println((i + 1) + "\t" + dataBarang[i].getKodeBarang() + "\t"
                                + dataBarang[i].getNamaBarang() + "\t" + dataBarang[i].getHargaBarang() + "\t"
                                + dataBarang[i].getJumlahBeli() + "\t" + dataBarang[i].getBayar());

                    }
                default:
                    break;
            }
        } while (pilihan != 3);

    }
}

import java.util.Scanner;

public class Pahawan {

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String nama = scanner.nextLine();
        String peran = scanner.nextLine();

        if (nama.isEmpty() && peran.isEmpty()) {
            System.out.println("Nama dan Peran Harus Di Isi");
        } 
        else if (nama.isEmpty()) {
            System.out.println("Nama Harus Di Isi");
        } 
        else if (peran.isEmpty()) {
            System.out.println("Peran Harus Di Isi");
        } 
        else if (!peran.equals("Superhero") && !peran.equals("Monster")) {
            System.out.println("Peran hanya boleh 'Superhero' atau 'Monster'.");
        } 
        else {
            System.out.println("Selamat Datang "+peran+" "+nama+", Kalahkan Semua Monster Di Muka Bumi");
        }
    }
}

/*Problem

Pada tugas ini kamu diminta untuk membuat game sederhana. Untuk memulai game ini diperlukan 2 variabel yaitu nama dan peran. Kedua Variabel ini tidak boleh kosong harus ada nilainya, untuk peran sendiri terdapat 2 jenis peran yaitu Superhero & Monster. Untuk selain 2 peran tersebut kalian harus memberikan peringatan. Tugas kalian adalah untuk mengecek masing masing variabel nama dan peran tersebut.


Kriteria

    Variabel Nama dan Peran dapat diisi apa saja
    Buatlah if - else percabangan untuk mengecek Nama dan Peran


Output

// Jika Nama & peran kosong maka tampilkan:

"Nama dan Peran Harus Di Isi"

// Jika Nama Diisi & Peran Kosong maka tampilkan:

"Peran Harus Di Isi"

// Jika Nama Diisi & Peran Diisi Superhero

"Selamat Datang Superhero Saitama, Kalahkan Semua Monster Di Muka Bumi"


// Jika Nama Diisi & Peran Diisi Monster

"Selamat Datang Monster Saitama, Hancurkan Semua Superhero Yang Ada"

// Jika Nama Diisi & Peran Diisi Bukan Superhero atau Monster

"Selamat Datang Saitama, Pilih Peranmu Untuk Melanjutkan Game Ini"

For example:
Input 	Result

Solehudin
Superhero

	

Selamat Datang Superhero Solehudin, Kalahkan Semua Monster Di Muka Bumi */    
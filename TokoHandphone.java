/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handphone;

/**
 *
 * @author User
 */
import java.util.Scanner;
// Class Handphone sebagai parent class
class Handphone {
    private String merk;
    private int harga;

    public Handphone(String merk, int harga) {
        this.merk = merk;
        this.harga = harga;
    }

    // Accessor
    public String getMerk() {
        return merk;
    }

    public int getHarga() {
        return harga;
    }

    // Mutator
    public void setHarga(int harga) {
        this.harga = harga;
    }

    // Polymorphism
    public void displayInfo() {
        System.out.println("Merk: " + merk);
        System.out.println("Harga: Rp " + harga);
    }
}

// Subclass HandphoneSmartphone yang merupakan turunan dari Handphone
class HandphoneSmartphone extends Handphone {
    private String sistemOperasi;

    public HandphoneSmartphone(String merk, int harga, String sistemOperasi) {
        super(merk, harga);
        this.sistemOperasi = sistemOperasi;
    }

    // Polymorphism
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Sistem Operasi: " + sistemOperasi);
    }
}

public class TokoHandphone {
    public static void main(String[] args) {
        // Array untuk menyimpan objek Handphone
        Handphone[] handphones = new Handphone[2];

        // Membuat objek HandphoneSmartphone
        HandphoneSmartphone hp1 = new HandphoneSmartphone("Samsung", 3000000, "Android");
        HandphoneSmartphone hp2 = new HandphoneSmartphone("iPhone", 8000000, "iOS");

        handphones[0] = hp1;
        handphones[1] = hp2;

        // Menampilkan informasi handphone
        for (Handphone handphone : handphones) {
            handphone.displayInfo();
        }

        // Input dari user menggunakan IO sederhana
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan harga baru untuk " + hp1.getMerk() + ": ");
        int newPrice = scanner.nextInt();
        hp1.setHarga(newPrice);

        // Menampilkan informasi handphone setelah perubahan harga
        hp1.displayInfo();

        // Error handling
        try {
            // Menampilkan informasi handphone yang tidak ada
            handphones[2].displayInfo();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Indeks di luar batas array");
        }
    }
}

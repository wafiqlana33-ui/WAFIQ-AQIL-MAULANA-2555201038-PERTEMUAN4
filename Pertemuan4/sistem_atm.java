/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan4;

/**
 *
 * @author aqilm
 */

import java.util.ArrayList;
import java.util.Scanner;

public class sistem_atm {
     static class nasabahatm {
        nasabah nasabah;
        rekening rekening;  
    
        nasabahatm(nasabah nasabah, rekening rekening){
            this.nasabah = nasabah;
            this.rekening = rekening;
       }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        ArrayList<nasabahatm> daftarNasabah = new ArrayList<>();
        
        //nasabah 1
        nasabah nasabah1 = new nasabah();
       nasabah1.nama = "Baba";
       nasabah1.alamat = "Blitar";
       nasabah1.noidentitas  = "12345";
       nasabah1.pin  ="112233";
       
       rekening rekening1 = new rekening();
       rekening1.setNoRekening ("255538");
       rekening1.setNamaPemilik  (nasabah1.nama);
       rekening1.setSaldo (7000000);
       
       daftarNasabah.add(new nasabahatm(nasabah1, rekening1));
       
       //nasaba 2
       nasabah nasabah2 = new nasabah();
       nasabah2.nama = "Bobo";
       nasabah2.alamat = "Blitar";
       nasabah2.noidentitas  = "12345";
       nasabah2.pin  ="2006";
       
       rekening rekening2 = new rekening();
       rekening2.setNoRekening ("255539");
       rekening2.setNamaPemilik (nasabah2.nama);
       rekening2.setSaldo (5000000);
       
       daftarNasabah.add(new nasabahatm(nasabah2, rekening2));
       
       
       atm atm = new atm();
      atm.id = "BRI";
      atm.lokasi = "Blitar";
      atm.status = "Online";
      
      nasabahatm penggunaaktif = null;
      int percobaan = 0;
         System.out.println("=== LOGIN ATM ===");
         
         while (percobaan < 4) {
             System.out.println("Masukan Pin:  ");
             String pin = input.nextLine();
             
             for (nasabahatm pengguna : daftarNasabah) {
                if (pin.equals(pengguna.nasabah.pin)) {
                    penggunaaktif = pengguna;
                    break;
             }
         }
             if (penggunaaktif != null) {
                break;
            }
             
         percobaan++;
            System.out.println("PIN salah!");
            System.out.println("Sisa percobaan: " + (4 - percobaan));
        }
    
         if (penggunaaktif == null) {
            System.out.println("Login gagal ! Atm Terblokir!");
            input.close();
            return;
        }
         
         System.out.println(
            "Selamat datang, " + penggunaaktif.nasabah.nama
        );
         
          int menu = 0;

        while (menu != 5) {
            System.out.println("\n=== MENU ATM ===");
            System.out.println("1. Data Nasabah");
            System.out.println("2. Cek Saldo");
            System.out.println("3. Setor Tunai");
            System.out.println("4. Tarik Tunai");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            try {
                menu = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Masukkan Tidak valid!");
                continue;
            }

            switch (menu) {
                case 1:
                    penggunaaktif.nasabah.tampilkandata();
                    break;

                case 2:
                    atm.ceksaldo(penggunaaktif.rekening);
                    break;

                case 3:
                    System.out.print("Nominal setor: Rp");
                    try {
                        long setor = Long.parseLong(input.nextLine());
                        atm.setor(penggunaaktif.rekening, setor);
                    } catch (NumberFormatException e) {
                        System.out.println("Nominal tidak valid.");
                    }
                    break;

                case 4:
                    System.out.print("Nominal tarik: Rp");
                    try {
                        long tarik = Long.parseLong(input.nextLine());
                        atm.tarik(penggunaaktif.rekening, tarik);
                    } catch (NumberFormatException e) {
                        System.out.println("Nominal tidak valid.");
                    }
                    break;

                case 5:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
            }
        }

        input.close();      
    }
}

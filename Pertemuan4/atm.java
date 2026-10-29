/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan4;

/**
 *
 * @author aqilm
 */
public class atm {
    String id;
    String lokasi;
    String status;
    
        void ceksaldo(rekening rekening){
            rekening.ceksaldo();
        }
        void tarik(rekening rekening, long jumlahtarik){
            rekening.tarik(jumlahtarik);
        }
        void setor(rekening rekening, long jumlahsetor){
            rekening.setor(jumlahsetor);
        }
}

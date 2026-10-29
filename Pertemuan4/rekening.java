/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan4;

/**
 *
 * @author aqilm
 */
public class rekening {
    private String NoRekening ;
    private String NamaPemilik ;
    private long Saldo ;
    
    //getter
    public String getNorek(){
    return NoRekening;
    }
    public String getNamaPemilik(){
    return NamaPemilik;
    }
    public long getSaldo(){
    return Saldo;
    }
    
  //setter  
   public void setNoRekening(String NoRekening){
   this.NoRekening=NoRekening;
   } 
   public void setNamaPemilik(String NamaPemilik){
   this.NamaPemilik=NamaPemilik;
   }
   public void setSaldo(long Saldo){
   if (Saldo>=0){
   this.Saldo=Saldo;
   }else{
       System.out.println("Saldo tidak boleeh negatif!");
        }
   }
    
   
    void ceksaldo() {
        System.out.printf("Saldo Anda: Rp%,d%n", getSaldo());
    }
    
      public void setor(long jumlahsetor) {
        if (jumlahsetor <= 0) {
            System.out.println("Nominal Harus Lebih Dari Nol !");
        } else {
            Saldo += jumlahsetor;
            System.out.println("Setor Tunai Berhasil");
            ceksaldo();
        }
    }

    public void tarik(long jumlahtarik) {
        if (jumlahtarik <= 0) {
            System.out.println("Nominal Harus Lebih Dari Nol !");
        } else if (jumlahtarik > Saldo) {
            System.out.println("Saldo Anda Tidak Mencukupi");
        } else {
            Saldo -= jumlahtarik;
            System.out.println("Tarik Tunai Berhasil.");
            ceksaldo();
        }
    }  
}

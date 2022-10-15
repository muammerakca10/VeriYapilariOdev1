/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veri_yapilari_deneme;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Air
 */
public class Liste {
    Yemek ilkYemek = null;
    Yemek sonYemek = null;
    Scanner sc = new Scanner(System.in);
    
    List<String> okunanYemekAdlari = new ArrayList<String>();
    List<Integer> okunanYemekGramajlari = new ArrayList<Integer>();
    List<Double> okunanYemekFiyatlari = new ArrayList<Double>();

    
    void dosyadakileriTopluEkle(){
        for (int i = 0;i<okunanYemekAdlari.size();i++){
            yemekEkle(okunanYemekAdlari.get(i), okunanYemekGramajlari.get(i), okunanYemekFiyatlari.get(i));
            System.out.println((i+1) + ". dugum olusturuldu");
        }
        
    }
    
    
    void yemekEkle(String yemekAdi, int yemekGramaji, double yemekFiyati){
                
        Yemek eklenecekYemek = new Yemek(yemekAdi, yemekGramaji, yemekFiyati);
        Yemek gecici = ilkYemek;

        
        if (ilkYemek == null){  //Liste bos ise
            ilkYemek = eklenecekYemek;
            sonYemek = ilkYemek;
            ilkYemek.sonrakiYemek = null;
            sonYemek.sonrakiYemek = null;
            //System.out.println("bos listeye eklendi");
            
        } else {  // Liste bos degilse
            if(ilkYemek.getYemekFiyati() > eklenecekYemek.getYemekFiyati()){ //Girilen sayi ilk sayidan kucukse
                eklenecekYemek.sonrakiYemek = ilkYemek;
                ilkYemek = eklenecekYemek;
            } else {
                while(gecici != null){  //gecici elemaninin sonraki null ise ve son elemandan buyukse (sona ekleme)
                    if(gecici.sonrakiYemek == null && gecici.getYemekFiyati() <= eklenecekYemek.getYemekFiyati()){
                        eklenecekYemek.sonrakiYemek = null;
                        gecici.sonrakiYemek = eklenecekYemek;
                        sonYemek = eklenecekYemek;
                        break;
                    }
                    //Araya ekleme
                    if(gecici.sonrakiYemek.getYemekFiyati() > eklenecekYemek.getYemekFiyati()){
                        eklenecekYemek.sonrakiYemek = gecici.sonrakiYemek;
                        gecici.sonrakiYemek = eklenecekYemek;
                        break;
                    }
                    gecici = gecici.sonrakiYemek;
                }
            }
            
        }
        dosyayaYaz();
    }
    
    
    
    void yazdir(){
        Yemek gecici = ilkYemek;
        
        if(gecici == null){
            System.out.println("Liste Bos");
        } else {
            while(gecici != null){
                
                System.out.println("Yemek adi : " + gecici.getYemekAdi() 
                        + " // Yemek gramaji : " + gecici.getYemekGramaji()
                        + " // Yemek fiyati : " + gecici.getYemekFiyati());
                gecici = gecici.sonrakiYemek;
            }
        }
    }
    
    public void menu(){
        int secim, eklenecekYemekGramaji, sira;
        char yemekIstiyorMu;
        String eklenecekYemekAdi;
        double eklenecekYemekFiyati;
              
        System.out.println(" --Yemekhane Otomasyonu--");
        System.out.println("1-Yemek ekle");
        System.out.println("2-Yemek sil");
        System.out.println("3-Yemekleri listele");
        System.out.println("4-Yemek Sec (Yemek tam adini giriniz)");
        System.out.println("5-Cikis");
        
        secim = sc.nextInt();
        
        switch (secim) {
            case 1:
                System.out.println("Yemek adini giriniz: ");
                eklenecekYemekAdi = sc.next();
                System.out.println("Yemek gramajini giriniz: ");
                eklenecekYemekGramaji = sc.nextInt();
                System.out.println("Yemek fiyatini giriniz: ");
                eklenecekYemekFiyati = sc.nextDouble();
                
                yemekEkle(eklenecekYemekAdi, eklenecekYemekGramaji, eklenecekYemekFiyati);
                System.out.println("Basariyla eklendi.");
                menu();
                break;
                
            case 2:
                break;
                
            case 3:
                yazdir();
                menu();
                break;
            case 4:
                System.out.println("Secmek istediginiz yemek listelendiginde, yemegi secmek icin e, atlamak icin herhangi bir tusa basiniz.");
                Yemek gecici = ilkYemek;
                while(gecici != null){
                    System.out.println(gecici.getYemekAdi() + "  " + gecici.getYemekGramaji() + "gr  " + gecici.getYemekFiyati() + "TL");
                    yemekIstiyorMu = sc.next().charAt(0);
                    if(yemekIstiyorMu == 'e'){
                        System.out.println("Yemek secildi, siparis hazirlaniyor.");
                        break;
                    } else {
                        gecici = gecici.sonrakiYemek;
                        continue;
                    }
                }
                
                menu();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Hatali giris yaptiniz.");
                //menu();
        }
    }
    
    
    public void dosyadanOku() {
        List<String> list = new ArrayList<String>();
        String satir;
        
        try  {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/com/mycompany/veri_yapilari_deneme/yemekListesi.txt"));
            
            while(true){
                satir = bufferedReader.readLine();
                if (satir != null){
                    String[] okunanSatir = satir.split(" ");
                    okunanYemekAdlari.add(okunanSatir[0]);
                    okunanYemekGramajlari.add(Integer.parseInt(okunanSatir[1]));
                    okunanYemekFiyatlari.add(Double.parseDouble(okunanSatir[2]));
                    System.out.println(satir);
                }else{
                    break;
                }
            }
        } catch(Exception e){
            System.out.println("Hata");
        }
    }

    public void dosyayaYaz() {
        Yemek gecici = ilkYemek;
        String satir = "";
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/java/com/mycompany/veri_yapilari_deneme/yemekListesi.txt",false));
            while (gecici != null) {                
                satir = gecici.getYemekAdi() + " " + gecici.getYemekGramaji() + " " + gecici.getYemekFiyati() + "\n";
                bufferedWriter.write(satir);
                gecici = gecici.sonrakiYemek;
            } 
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("hata");
        }
            
    }

    
    
}

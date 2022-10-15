/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veri_yapilari_deneme;
import java.util.Scanner;
/**
 *
 * @author MuammerAkca
 */
public class Liste {
    Yemek ilkYemek = null;
    Yemek sonYemek = null;
    Scanner sc = new Scanner(System.in);
    
    
    void yemekEkle(String yemekAdi, int yemekGramaji, double yemekFiyati){
                
        Yemek eklenecekYemek = new Yemek(yemekAdi, yemekGramaji, yemekFiyati);
        Yemek gecici = ilkYemek;

        
        if (ilkYemek == null){  //Liste bos ise
            ilkYemek = eklenecekYemek;
            sonYemek = ilkYemek;
            ilkYemek.sonrakiYemek = null;
            sonYemek.sonrakiYemek = null;
            System.out.println("bos listeye eklendi");
            
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
                
                System.out.println("Valla elimizde olan bunlar, en iyisi biz sizi ana menuye yonlendirelim oradan istediginiz yemegi ekleyin .\n");
                menu();
                break;
            case 5:
                
                break;
            default:
                System.out.println("Hatali giris yaptiniz.");
                //menu();
        }
        
    }
    
    
}
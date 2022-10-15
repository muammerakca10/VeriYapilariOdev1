/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veri_yapilari_deneme;

/**
 *
 * @author air
 */
public class Yemek {
    private String yemekAdi;
    private int yemekGramaji;
    private double yemekFiyati;
    Yemek sonrakiYemek = null;

    public Yemek(String yemekAdi, int yemekGramaji, double yemekFiyati) {
        this.yemekAdi = yemekAdi;
        this.yemekGramaji = yemekGramaji;
        this.yemekFiyati = yemekFiyati;
    }
    
    
    
    public String getYemekAdi() {
        return yemekAdi;
    }

    public void setYemekAdi(String yemekAdi) {
        this.yemekAdi = yemekAdi;
    }

    public int getYemekGramaji() {
        return yemekGramaji;
    }

    public void setYemekGramaji(int yemekGramaji) {
        this.yemekGramaji = yemekGramaji;
    }

    public double getYemekFiyati() {
        return yemekFiyati;
    }

    public void setYemekFiyati(double yemekFiyati) {
        this.yemekFiyati = yemekFiyati;
    }
    
    
}

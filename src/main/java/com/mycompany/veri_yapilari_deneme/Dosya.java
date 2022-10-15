/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veri_yapilari_deneme;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author air
 */
public class Dosya {

    public void oku() {
        List<String> list = new ArrayList<String>();
        List<String> okunanYemekAdlari = new ArrayList<String>();
        List<Integer> okunanYemekGramajlari = new ArrayList<Integer>();
        List<Double> okunanYemekFiyatlari = new ArrayList<Double>();

        File file = new File("dosya.txt");
        if (file.exists()) {
            try {
                list = Files.readAllLines(file.toPath(), Charset.defaultCharset());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if (list.isEmpty()) {
                return;
            }
        }
        for (String line : list) {
            String[] res = line.split(" ");
            okunanYemekAdlari.add(res[0]);
            okunanYemekGramajlari.add(Integer.parseInt(res[1]));
            okunanYemekFiyatlari.add(Double.parseDouble(res[2]));
        }
        System.out.println(okunanYemekAdlari);
        
    }

    public void yaz() {

    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author barbo
 */
public class PotionSoin extends Objet {
        private int soin; // nombre de point de vie que la potion donne 
        public int utiliser(){
            return soin;
        }

    public int getSoin() {
        return soin;
    }

    public void setSoin(int soin) {
        this.soin = soin;
    }
        public void  crea_potion_soin(ArrayList<Objet> a){
    Random random= new Random();
    int alea = random.nextInt(100);

    for (int i=0; i<alea; i++ ){
        String n = "Potion soin" + i;
        PotionSoin po= new PotionSoin();
        po.setNom(n);
        a.add(po);
        }
    } 
   
}

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
public class Epee extends Objet  {

    private int puissance;
    
    public void  crea_epee(ArrayList<Objet> a){
    Random random= new Random();
    int alea = random.nextInt(100);

    for (int i=0; i<alea; i++ ){
        String n = "Epee" + i;
        Epee e= new Epee();
        e.setNom(n);
        a.add(e);
        }
    } 
}



 
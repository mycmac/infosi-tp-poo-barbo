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
public class Lapin extends Monstre {
    
    public Lapin(String n, int ptVie, int degAtt,int ptPar, int pageAtt,int pagePar, Point2D pos){
        super(n,ptVie,degAtt, ptPar, pageAtt,pagePar, pos);
    }

    public Lapin(Lapin i){
        super(i);
    }
    
    public Lapin(){
        super();
    } 
    
    public void  crea_lapin(ArrayList<Creature> a){
    Random random= new Random();
    int alea = random.nextInt(100);

    for (int i=0; i<alea; i++ ){
        String n = "Lapin" + i;
        Lapin la= new Lapin();
        la.setNom(n);
        a.add(la);
    }
    } 

}

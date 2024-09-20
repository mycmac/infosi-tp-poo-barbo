/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet;

/**
 *
 * @author barbo
 */
public class Lapin extends Monstre {
    public Lapin(int ptVie, int degAtt,int ptPar, int pageAtt,int pagePar, Point2D pos){
        super(ptVie,degAtt, ptPar, pageAtt,pagePar, pos);
    }
    public Lapin(Lapin i){
        super(i);
    }
    public Lapin(){
        super();
    }   
}


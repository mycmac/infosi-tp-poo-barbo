/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author PRO
 */
public class Loup extends Monstre implements Combattant {
    
    public Loup(String n, int ptVie, int degAtt,int ptPar, int pageAtt,int pagePar, Point2D pos){
        super(n,ptVie,degAtt, ptPar, pageAtt,pagePar, pos);
    }
    
    public Loup(Loup l){
        super(l);
    }
    
    public Loup(){
        super();
    } 
    public Loup(int a){
        super(a);
    }
    
 

    public int getPtVie() {
        return ptVie;
    }

    public int getDegAtt() {
        return degAtt;
    }

    public int getPtPar() {
        return ptPar;
    }

    public int getPageAtt() {
        return pageAtt;
    }

    public int getPagePar() {
        return pagePar;
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    
    @Override
    public void combattre(Creature c) {
    Random rand = new Random();
    double distance = this.pos.distanceTo(c.getPos());

    if (distance == 1) {  // Combat au corps à corps (proche)
        int jetAttaque = rand.nextInt(100) + 1;
        if (jetAttaque <= this.pageAtt) {  // Loup réussit son attaque
            System.out.println("Le loup attaque " + c.getNom() + " avec succès !");
            int jetParade = rand.nextInt(100) + 1;
            if (jetParade <= c.getPagePar()) {  // Parade réussie
                int degats = this.degAtt - c.getPtPar();
                degats = Math.max(degats, 0);  // Évite les dégâts négatifs
                c.setPtVie(c.getPtVie() - degats);
                System.out.println(c.getNom() + " a paré l'attaque ! Il lui reste " + c.getPtVie() + " points de vie.");
            } else {  // Parade échouée
                c.setPtVie(c.getPtVie() - this.degAtt);
                System.out.println(c.getNom() + " n'a pas paré ! Il lui reste " + c.getPtVie() + " points de vie.");
            }
        } else {
            System.out.println("Le loup rate son attaque contre " + c.getNom() + ".");
        }
    } else {
        System.out.println("Le loup est trop loin pour attaquer.");
    }
}
    public void  crea_loup(ArrayList<Creature> a){
    Random random= new Random();
    int alea = random.nextInt(100);

    for (int i=0; i<20; i++ ){
        String n = "Loup" + i;
        Loup lo= new Loup(4);
        lo.setNom(n);
        lo.dplt_case_libre(lo,a);
        a.add(lo);
    }
    } 

}

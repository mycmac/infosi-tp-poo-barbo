/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

public class Monstre {
    private int ptVie ; 
    private int degAtt ;
    private int ptPar; 
    private int pageAtt; 
    private int pagePar;
    private Point2D pos;
    
    public Monstre(int ptVie, int degAtt,int ptPar, int pageAtt,int pagePar, Point2D pos){
        this.ptVie=ptVie;
        this.degAtt=degAtt; 
        this.ptPar=ptPar;
        this.pageAtt=pageAtt;
        this.pagePar=pagePar;
        this.pos=pos;     
    }
    public Monstre(Monstre m){
        this.ptVie=m.ptVie;
        this.degAtt=m.degAtt; 
        this.ptPar=m.ptPar;
        this.pageAtt=m.pageAtt;
        this.pagePar=m.pagePar;
        this.pos=m.pos;       
    }
    
 public Monstre(){
        this.ptVie=0;
        this.degAtt=0;
        this.ptPar=0;
        this.pageAtt=0;
        this.pagePar=0;
        this.pos= new Point2D();      
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
    public void deplace() {
        Random rand = new Random();
        // Générer des déplacements aléatoires sur l'axe X et Y
        int dx = rand.nextInt(3) - 1;  // Valeurs possibles : -1, 0, 1
        int dy = rand.nextInt(3) - 1;  // Valeurs possibles : -1, 0, 1

        // Déplacer le personnage en ajoutant dx et dy à sa position actuelle
        pos.translate(dx, dy);

        System.out.println("Personnage déplacé à la position : " + pos);
    }

   
    public void affiche() {
        System.out.println( "Monstre{" + "ptVie=" + ptVie + ", degAtt=" + degAtt + ", ptPar=" + ptPar + ", pageAtt=" + pageAtt + ", pagePar=" + pagePar + ", pos=" + pos + '}');
    }
}

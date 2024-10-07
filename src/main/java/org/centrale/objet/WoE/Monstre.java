/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

public abstract class Monstre extends Creature {

    
    public Monstre(String n, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
        this.nom = n ;
    }

    public Monstre(Monstre m) {
        super(m.ptVie, m.degAtt, m.ptPar, m.pageAtt, m.pagePar, m.pos);
        this.nom = m.nom ;
    }

    public Monstre() {
        super(0, 0, 0, 0, 0, new Point2D());
    }
    
    public void setNom(String n){
        this.nom = n;
    }
    
    public String getNom(){
        return nom ;
    }
    

    @Override
    public void deplace() {
        Random rand = new Random();
        int dx = rand.nextInt(3) - 1;
        int dy = rand.nextInt(3) - 1;
        pos.translate(dx, dy);
        System.out.println("Monstre déplacé à la position : " + pos);
    }

    @Override
    public void affiche() {
        System.out.println("Monstre{" + nom + "ptVie=" + ptVie + ", degAtt=" + degAtt + ", ptPar=" + ptPar 
                + ", pageAtt=" + pageAtt + ", pagePar=" + pagePar + ", pos=" + pos + '}');
    }

    @Override
    public void combattre(Creature c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}

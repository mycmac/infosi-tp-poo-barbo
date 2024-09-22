/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 *
 * @author PRO
 */
public class Guerrier extends Personnage {
    private Epee e;

    public Guerrier(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p, Epee e) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
        this.e = e;
    }

    public Guerrier(Guerrier g) {
        super(g);
        this.e = g.e;
    }
    
    public Guerrier() {
        super();
    }
    
    @Override
    public void combattre(Creature c) {
    Random rand = new Random();
    float distance = this.pos.distanceTo(c.getPos());

    if (distance == 1) {  // Combat au corps à corps
        int jetAttaque = rand.nextInt(100) + 1;
        if (jetAttaque <= this.pageAtt) {  // Attaque réussie
            System.out.println("Le guerrier attaque " + c.getNom() + " avec succès !");
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
            System.out.println("Le guerrier rate son attaque contre " + c.getNom() + ".");
        }
    } else {
        System.out.println("La cible est trop loin pour un combat au corps à corps.");
    }
}

    @Override
    public void affiche() {
        super.affiche();
        //System.out.println("Nombre de flèches: " + e);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random ;
import java.util.ArrayList;
/**
 *
 * @author PRO
 */
public class Archer extends Personnage implements Combattant {
    private int nbFleches;



    public Archer(String n, int pV, int dA, int pPar, int paAtt, int paPar, int distAttMax, Point2D p, int nbFleches) {
        super(n, pV, dA, pPar, paAtt, paPar, distAttMax, p);
        this.nbFleches = nbFleches;
    }

    public Archer(Archer a) {
        super(a);
        this.nbFleches = a.nbFleches;
    }

    public Archer() {
        super();
    }

    public int getNbFleches() {
        return nbFleches;
    }

    @Override
    public void combattre(Creature c) {
    Random rand = new Random();
    double distance = this.pos.distanceTo(c.getPos());

    if (distance > 1 && distance <= this.getDistAttMax()) {  // Combat à distance
        int jetAttaque = rand.nextInt(100) + 1;
        if (jetAttaque <= this.pageAtt) {  // Attaque réussie
            c.setPtVie(c.getPtVie() - this.degAtt);
            System.out.println("L'archer tire et touche " + c.getNom() + ", infligeant " + this.degAtt + " dégâts.");
        } else {
            System.out.println("L'archer rate son tir sur " + c.getNom() + ".");
        }
        this.nbFleches = this.nbFleches - 1; // enleve 1 fleche car l'archer a tiré. 
    } else {
        System.out.println("La cible est hors de portée pour un tir à distance.");
    }
} 
    
    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }

    @Override
    public void affiche() {
        super.affiche();
        System.out.println("Nombre de flèches: " + nbFleches);
    }
    public void  crea_archer(ArrayList<Creature> a){
    Random random= new Random();
//    int alea = random.nextInt(100);

    for (int i=0; i<20; i++ ){
        String n = "Archer" + i;
        Archer arch= new Archer();
        arch.setNom(n);
        arch.setPtVie();
        arch.dplt_case_libre(arch,  a);
        a.add(arch);

        }

    }
    
}
    

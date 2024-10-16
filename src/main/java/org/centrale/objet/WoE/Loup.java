/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe Loup héritant de Monstre et implémentant l'interface Combattant.
 * Représente un loup dans le jeu, capable de se déplacer et d'attaquer des créatures.
 * 
 * @author PRO
 */
public class Loup extends Monstre implements Combattant {

    // Constructeur avec des paramètres spécifiques pour initialiser les attributs du Loup
    public Loup(String n, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(n, ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    }
    
    // Constructeur de copie (copy constructor)
    public Loup(Loup l) {
        super(l);
    }
    
    // Constructeur par défaut
    public Loup() {
        super();
    }
    
    // Constructeur avec un paramètre pour initialiser la vie du loup
    public Loup(int a) {
        super(a);
    }

    // Getters pour accéder aux attributs du loup
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

    // Setters pour modifier les attributs du loup
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
    
    /**
     * Méthode pour faire combattre le loup contre une autre créature.
     * Le combat est au corps à corps si la distance entre le loup et la créature est 1.
     * 
     * @param c La créature contre laquelle le loup va combattre.
     */
    @Override
    public void combattre(Creature c) {
        Random rand = new Random();
        double distance = this.pos.distanceTo(c.getPos());  // Calcul de la distance entre le loup et la créature

        if (distance == 1) {  // Si la distance est égale à 1, on peut attaquer
            int jetAttaque = rand.nextInt(100) + 1;  // Jet d'attaque du loup
            if (jetAttaque <= this.pageAtt) {  // Si l'attaque réussit
                System.out.println("Le loup attaque " + c.getNom() + " avec succès !");
                int jetParade = rand.nextInt(100) + 1;  // Jet de parade de la créature
                if (jetParade <= c.getPagePar()) {  // Si la créature parvient à parer l'attaque
                    int degats = this.degAtt - c.getPtPar();  // Calcul des dégâts après la parade
                    degats = Math.max(degats, 0);  // Les dégâts ne peuvent pas être négatifs
                    c.setPtVie(c.getPtVie() - degats);  // La créature perd des points de vie
                    System.out.println(c.getNom() + " a paré l'attaque ! Il lui reste " + c.getPtVie() + " points de vie.");
                } else {  // Si la parade échoue
                    c.setPtVie(c.getPtVie() - this.degAtt);  // La créature perd les points de vie directement
                    System.out.println(c.getNom() + " n'a pas paré ! Il lui reste " + c.getPtVie() + " points de vie.");
                }
            } else {
                System.out.println("Le loup rate son attaque contre " + c.getNom() + ".");
            }
        } else {
            System.out.println("Le loup est trop loin pour attaquer.");  // Si le loup est trop loin pour attaquer
        }
    }

    /**
     * Méthode pour créer des loups et les ajouter à une liste.
     * Crée 20 loups et les place dans des positions libres sur la carte.
     * 
     * @param a La liste des créatures à ajouter les loups.
     */
    public void crea_loup(ArrayList<Creature> a) {
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            String n = "Loup" + i;  // Nom du loup
            Loup lo = new Loup(4);  // Crée un nouveau loup avec 4 points de vie
            lo.setNom(n);  // Affecte un nom au loup
            lo.dplt_case_libre(lo, a);  // Place le loup à une case libre
            a.add(lo);  // Ajoute le loup à la liste des créatures
        }
    } 
}

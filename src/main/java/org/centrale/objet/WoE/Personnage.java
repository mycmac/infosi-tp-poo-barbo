package org.centrale.objet.WoE;

import java.util.Random;

public abstract class Personnage extends Creature {
    private int distAttMax;  // Distance d'attaque maximale pour le personnage

    // Constructeur par défaut
    public Personnage() {
        super();  // Appel au constructeur par défaut de Creature
        this.nom = null;  // Nom non défini par défaut
        this.distAttMax = 0;  // Distance d'attaque maximale par défaut
    }

    // Constructeur avec paramètres pour initialiser un personnage avec des caractéristiques
    public Personnage(String n, int pV, int dA, int pPar, int paAtt, int paPar, int distAttMax, Point2D p) {
        super(pV, dA, pPar, paAtt, paPar, p);  // Appel au constructeur de Creature
        this.nom = n;  // Initialisation du nom du personnage
        this.distAttMax = distAttMax;  // Initialisation de la distance d'attaque maximale
    }

    // Constructeur avec un paramètre entier (probablement pour définir certains attributs par défaut)
    public Personnage(int a) {
        super(a);  // Appel du constructeur de Creature avec un entier
        switch (a) {
            case 1: 
                this.distAttMax = 5;  // Si a est 1, la distance d'attaque maximale est 5
                break;
            case 2: 
                this.distAttMax = 1;  // Si a est 2, la distance d'attaque maximale est 1
                break;
            case 3:                 
                this.distAttMax = 0;  // Si a est 3, la distance d'attaque maximale est 0
                break;
        }
    }

    // Constructeur de copie pour créer une copie d'un personnage existant
    public Personnage(Personnage pers) {
        super(pers);  // Appel du constructeur de copie de Creature
        this.nom = pers.nom;  // Copie le nom du personnage
        this.distAttMax = pers.distAttMax;  // Copie la distance d'attaque maximale
    }

    // Accesseurs et mutateurs pour l'attribut distAttMax

    public int getDistAttMax() {
        return distAttMax;
    }

    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    // Méthode pour afficher les informations du personnage
    @Override
    public void affiche() {
        System.out.println("Nom :" + nom + ", " + "Point de vie "+ ptVie + ", "+degAtt+ ", "+ ptPar + ", "+ pageAtt +", " + distAttMax + ", " + "Position :"+ pos);
    }

    // Méthode de combat qui n'est pas encore implémentée pour les personnages
    @Override
    public void combattre(Creature c) {
        throw new UnsupportedOperationException("Not supported yet.");  // Lancer une exception car le combat n'est pas implémenté pour cette classe
    }

}


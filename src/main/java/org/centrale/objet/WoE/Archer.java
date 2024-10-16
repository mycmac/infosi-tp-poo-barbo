/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;
import java.util.ArrayList;

/**
 * Classe représentant un Archer, un personnage combattant avec des flèches.
 * L'archer est une extension de la classe Personnage et implémente l'interface Combattant.
 */
public class Archer extends Personnage implements Combattant {
    // Nombre de flèches que possède l'archer
    private int nbFleches;

    /**
     * Constructeur de la classe Archer avec tous les attributs définis.
     * @param n Nom de l'archer
     * @param pV Points de vie de l'archer
     * @param dA Dégâts d'attaque de l'archer
     * @param pPar Points de parade de l'archer
     * @param paAtt Page d'attaque de l'archer
     * @param paPar Page de parade de l'archer
     * @param distAttMax Distance maximale d'attaque
     * @param p Position de l'archer
     * @param nbFleches Nombre de flèches que possède l'archer
     */
    public Archer(String n, int pV, int dA, int pPar, int paAtt, int paPar, int distAttMax, Point2D p, int nbFleches) {
        // Appel du constructeur de la classe parent Personnage
        super(n, pV, dA, pPar, paAtt, paPar, distAttMax, p);
        this.nbFleches = nbFleches;  // Initialisation du nombre de flèches
    }

    /**
     * Constructeur par copie pour créer une nouvelle instance d'archer à partir d'un autre archer.
     * @param a L'archer à copier
     */
    public Archer(Archer a) {
        // Appel du constructeur de la classe parent Personnage pour copier les attributs
        super(a);
        this.nbFleches = a.nbFleches;  // Copie du nombre de flèches
    }

    /**
     * Constructeur par défaut, sans paramètres.
     */
    public Archer() {
        super();  // Appel du constructeur par défaut de Personnage
    }
    
    /**
     * Constructeur avec un paramètre pour spécifier une valeur d'initialisation spécifique pour un archer.
     * @param a Utilisé pour identifier le type d'archer, ici c'est toujours 1 pour l'archer.
     */
    public Archer(int a) {
        super(a);  // Appel du constructeur de la classe parent Personnage avec l'argument a
        this.nbFleches = 10;  // Initialise l'archer avec 10 flèches
    }

    /**
     * Méthode pour obtenir le nombre de flèches de l'archer.
     * @return Nombre de flèches de l'archer
     */
    public int getNbFleches() {
        return nbFleches;  // Retourne le nombre actuel de flèches
    }

    /**
     * Méthode permettant à l'archer de combattre une autre créature.
     * L'archer attaque à distance si la cible est dans la portée.
     * @param c Créature cible à attaquer
     */
    @Override
    public void combattre(Creature c) {
        Random rand = new Random();  // Générateur de nombres aléatoires
        double distance = this.pos.distanceTo(c.getPos());  // Calcul de la distance entre l'archer et la cible

        // Si la cible est à une distance valide pour une attaque à distance
        if (distance > 1 && distance <= this.getDistAttMax()) {  
            int jetAttaque = rand.nextInt(100) + 1;  // Jet de dé pour déterminer si l'attaque réussit
            if (jetAttaque <= this.pageAtt) {  // Si l'attaque est réussie
                c.setPtVie(c.getPtVie() - this.degAtt);  // Réduction des points de vie de la cible
                System.out.println("L'archer tire et touche " + c.getNom() + ", infligeant " + this.degAtt + " dégâts.");
            } else {
                System.out.println("L'archer rate son tir sur " + c.getNom() + ".");
            }
            this.nbFleches = this.nbFleches - 1;  // Réduit le nombre de flèches après chaque tir
        } else {
            System.out.println("La cible est hors de portée pour un tir à distance.");
        }
    }

    /**
     * Méthode pour définir le nombre de flèches de l'archer.
     * @param nbFleches Nouveau nombre de flèches
     */
    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;  // Modifie le nombre de flèches
    }

    /**
     * Méthode pour afficher les informations de l'archer, y compris son nombre de flèches.
     */
    @Override
    public void affiche() {
        super.affiche();  // Appel de la méthode affiche() de la classe parent Personnage
        System.out.println("Nombre de flèches: " + nbFleches);  // Affichage du nombre de flèches
    }

    /**
     * Méthode pour créer plusieurs archers et les ajouter à une liste de créatures.
     * @param a Liste dans laquelle les archers seront ajoutés
     */
    public void crea_archer(ArrayList<Creature> a) {
        Random random = new Random();  // Générateur de nombres aléatoires

        // Création de 20 archers avec des noms uniques et ajout dans la liste
        for (int i = 0; i < 20; i++) {
            String n = "Archer" + i;  // Nom de l'archer basé sur l'index i
            Archer arch = new Archer(1);  // Création d'un nouvel archer avec un constructeur spécifique
            arch.setNom(n);  // Définir le nom de l'archer
            arch.setPtVie();  // Définir les points de vie de l'archer
            arch.dplt_case_libre(arch, a);  // Déplacement de l'archer à une case libre dans la grille
            a.add(arch);  // Ajout de l'archer à la liste de créatures
        }
    }
}
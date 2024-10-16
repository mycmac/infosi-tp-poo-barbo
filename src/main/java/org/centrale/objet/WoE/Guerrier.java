/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;
import java.util.ArrayList;


/**
 * Classe représentant un Guerrier dans le jeu.
 * Le Guerrier est une classe dérivée de la classe Personnage et implémente l'interface Combattant.
 * Il possède une épée et peut attaquer une créature en combat rapproché (au corps à corps).
 * 
 * @author PRO
 */
public class Guerrier extends Personnage implements Combattant {
    // L'épée du Guerrier, utilisée pour infliger des dégâts lors des attaques
    private Epee e;

    /**
     * Constructeur complet pour créer un Guerrier avec tous ses attributs.
     * 
     * @param n Le nom du Guerrier
     * @param pV Points de vie du Guerrier
     * @param dA Dégâts d'attaque du Guerrier
     * @param pPar Points de parade du Guerrier
     * @param paAtt Page d'attaque du Guerrier
     * @param paPar Page de parade du Guerrier
     * @param dMax Distance maximale d'attaque
     * @param p Position du Guerrier dans le jeu
     * @param e L'épée du Guerrier
     */
    public Guerrier(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p, Epee e) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p); // Appel du constructeur de la classe mère Personnage
        this.e = e; // Initialisation de l'épée du Guerrier
    }

    /**
     * Constructeur de copie pour créer un Guerrier à partir d'un autre Guerrier.
     * 
     * @param g Guerrier à copier
     */
    public Guerrier(Guerrier g) {
        super(g); // Copie les attributs de la classe mère Personnage
        this.e = g.e; // Copie l'épée du Guerrier
    }
    
    /**
     * Constructeur par défaut pour créer un Guerrier sans attributs spécifiés.
     */
    public Guerrier() {
        super(); // Appel au constructeur par défaut de la classe mère Personnage
    }

    /**
     * Constructeur pour créer un Guerrier avec un attribut de type entier (utilisé dans certaines créations spécifiques).
     * 
     * @param a Un paramètre entier, ici utilisé pour spécifier des attributs du Guerrier
     */
    public Guerrier(int a) {
        super(a); // Appel au constructeur de la classe Personnage avec un paramètre entier
    }

    /**
     * Méthode pour que le Guerrier combatte une créature.
     * Le combat se fait au corps à corps, avec un calcul de chance de réussite de l'attaque et de parade.
     * 
     * @param c La créature cible du combat
     */
    @Override
    public void combattre(Creature c) {
        Random rand = new Random(); // Création d'un générateur de nombres aléatoires
        double distance = this.pos.distanceTo(c.getPos()); // Calcul de la distance entre le Guerrier et la créature

        // Si la cible est à portée de corps à corps (distance = 1)
        if (distance == 1) {
            int jetAttaque = rand.nextInt(100) + 1; // Jet d'attaque (valeur entre 1 et 100)
            if (jetAttaque <= this.pageAtt) { // Si l'attaque réussit
                System.out.println("Le guerrier attaque " + c.getNom() + " avec succès !");
                int jetParade = rand.nextInt(100) + 1; // Jet de parade de la créature
                if (jetParade <= c.getPagePar()) { // Si la créature parvient à parer l'attaque
                    int degats = this.degAtt - c.getPtPar(); // Calcul des dégâts après parade
                    degats = Math.max(degats, 0); // Assure que les dégâts ne sont pas négatifs
                    c.setPtVie(c.getPtVie() - degats); // Application des dégâts à la créature
                    System.out.println(c.getNom() + " a paré l'attaque ! Il lui reste " + c.getPtVie() + " points de vie.");
                } else { // Si la parade échoue
                    c.setPtVie(c.getPtVie() - this.degAtt); // Applique les dégâts à la créature
                    System.out.println(c.getNom() + " n'a pas paré ! Il lui reste " + c.getPtVie() + " points de vie.");
                }
            } else {
                System.out.println("Le guerrier rate son attaque contre " + c.getNom() + ".");
            }
        } else {
            System.out.println("La cible est trop loin pour un combat au corps à corps.");
        }
    }

    /**
     * Méthode pour afficher les informations du Guerrier.
     */
    @Override
    public void affiche() {
        super.affiche(); // Affichage des informations du Guerrier (héritées de Personnage)
        // Le nombre de flèches n'est pas affiché ici car le Guerrier n'a pas de flèches, mais une épée
        // System.out.println("Nombre de flèches: " + e);
    }

    /**
     * Méthode pour créer un groupe de Guerriers et les ajouter à la liste donnée.
     * Crée 20 Guerriers avec un nom unique et les place sur des cases libres.
     * 
     * @param a La liste des créatures où les Guerriers seront ajoutés
     */
    public void crea_guerrier(ArrayList<Creature> a) {
        Random random = new Random(); // Création d'un générateur de nombres aléatoires
        int alea = random.nextInt(100); // Nombre aléatoire de Guerriers à créer

        // Création de 20 Guerriers
        for (int i = 0; i < 20; i++) {
            String n = "Guerrier" + i; // Nom unique pour chaque Guerrier
            Guerrier gue = new Guerrier(2); // Création d'un nouveau Guerrier
            gue.setNom(n); // Définition du nom du Guerrier
            gue.setPtVie(); // Définition des points de vie du Guerrier
            gue.dplt_case_libre(gue, a); // Placement du Guerrier sur une case libre
            a.add(gue); // Ajout du Guerrier à la liste de créatures
        }
    } 
}

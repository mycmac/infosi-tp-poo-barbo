/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author PRO
 */
public class IllustrationCombat {
    
    // Création d'un Guerrier, avec des paramètres spécifiques pour son nom, points de vie, dégâts, etc.
    private Guerrier guy = new Guerrier("guy", 100, 18, 67, 35, 52, 2, new Point2D(5,5), new Epee()) ;

    // Création d'un Archer avec ses propres caractéristiques
    private Archer jacques = new Archer("jacques", 100, 13, 50, 40, 60, 60, new Point2D(6,5), 15);

    // Création d'un Loup avec ses propres caractéristiques
    private Loup wolfie = new Loup("wolfie",100, 25,50, 30 ,15, new Point2D(5,6)) ;

    /**
     * Méthode pour simuler un combat entre les créatures.
     * Le Guerrier attaque le Loup, l'Archer attaque le Loup, puis le Loup attaque le Guerrier.
     */
    public void creerMondeAlea(){
        
        // Première partie : Le Guerrier attaque le Loup
        System.out.println("Combat entre le Guerrier et le Loup :");
        guy.combattre(wolfie);  // Guerrier attaque le loup

        // Deuxième partie : L'Archer attaque le Loup
        System.out.println("\nCombat entre l'Archer et le Loup :");
        jacques.combattre(wolfie);  // Archer attaque le loup à distance

        // Troisième partie : Le Loup attaque le Guerrier
        System.out.println("\nLe Loup attaque le Guerrier en retour :");
        wolfie.combattre(guy);  // Le loup attaque le guerrier
        
        // Affichage des points de vie restants après les combats
        System.out.println("Point de vie du guerrier : " + guy.ptVie);  // Affichage des points de vie du Guerrier
        System.out.println("Point de vie de l'archer : " + jacques.ptVie);  // Affichage des points de vie de l'Archer
        System.out.println("Point de vie du loup : " + wolfie.ptVie);  // Affichage des points de vie du Loup
    }

    // Constructeur vide de la classe IllustrationCombat
    public void IllustrationCombat(){
        // Aucune opération ici, mais peut être utile pour initialiser des variables ou des états
    }
}

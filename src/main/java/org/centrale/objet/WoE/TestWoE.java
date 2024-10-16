/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import javax.swing.JFrame;  // Import uniquement JFrame
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe principale du jeu qui initialise et exécute le jeu.
 * Ce programme crée un monde avec des créatures, permet au joueur d'interagir avec ces créatures 
 * et d'afficher un environnement graphique pour le jeu.
 * 
 * @author barbo
 */
public class TestWoE {

    public static void main(String[] args){
        
        // Commenté : tests pour créer et manipuler des points dans l'environnement
        /*
        Point2D p1= new Point2D();
        System.out.println("Point p1 : " + p1);
        
        Point2D p2= new Point2D(5,5);
        System.out.println("Point p2 : " + p2);
        
        Point2D p3= new Point2D(p2);
        System.out.println("Point p3 : " + p3);
         
        p1.translate(1,1);
        System.out.println("Nouvelle coordonée point p1 de +1 : " + p1);
        
        p1.modifier(10,10);
        System.out.println("Nouvelle coordonée point p1 (10,10) : " + p1);
        
        IllustrationCombat world = new IllustrationCombat();
        
        world.creerMondeAlea();
        */
        
        // Création des objets nécessaires pour le jeu
        Joueur j = new Joueur();  // Création d'un joueur
        World w = new World();    // Création d'un monde de jeu
        w.creation();  // Place les personnages dans le monde 
        j.creePerso();  // Crée le personnage du joueur
        j.deplacement_joueur(w.liste_creatures);  // Permet au joueur de se déplacer

        // Affichage de la grille de jeu avec JFrame
        JFrame frame = new JFrame("Grille de Jeu"); // Création de la fenêtre de jeu
        JeuGrille jeuGrille = new JeuGrille(j.getPersonnage(), w.liste_creatures); 
        frame.add(jeuGrille);
        frame.pack();  // Ajuste la taille de la fenêtre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Ferme l'application à la fermeture de la fenêtre
        frame.setVisible(true);  // Rend la fenêtre visible
        
        // Boucle principale du jeu : le jeu continue tant qu'il reste des créatures ou que le joueur est en vie
        Creature lk;  // Variable pour stocker une créature choisie par le joueur
        while((!w.liste_creatures.isEmpty()) || j.getPersonnage().getPtVie()>0){  // Le jeu continue si des créatures existent ou que le joueur est en vie
            System.out.println("Les créatures ont bougé, voici les créatures proches de vous :");
            j.getPersonnage().affiche_monstre(w.liste_creatures,j.getPersonnage());  // Affiche les créatures proches du joueur
            System.out.println("Que voulez-vous faire ? ");
            System.out.println("1 : Attaque (archer) ; 2 : Attaque (guerrier) ; 3 : Déplacement ");

            // Lecture de l'entrée utilisateur
            Scanner scanner = new Scanner(System.in);
            int choix = scanner.nextInt();
            
            // Switch pour traiter les actions en fonction du choix de l'utilisateur
            switch(choix){
                
                case 1 :  // Attaque avec l'archer
                    System.out.println("Voici la liste des créatures que vous pouvez attaquer");
                    j.getPersonnage().affiche_monstre(w.liste_creatures,j.getPersonnage());  // Affiche les créatures à moins de 5 cases
                    System.out.println("Veuillez choisir votre cible");
                    scanner.nextLine();  // Consomme la ligne vide restante après l'entrée de l'int
                    String nom1 = scanner.nextLine();  // Nom de la créature à attaquer
                    try { 
                        lk = j.getPersonnage().retournecrea(nom1, w.liste_creatures);  // Récupère la créature choisie
                        j.getPersonnage().combattre(lk);  // Combat avec la créature
                    } catch (Exception e) {
                        System.out.println("La créature n'a pas été trouvée, vérifiez les majuscules dans le nom");
                    }
                    break; 
                    
                case 2 :  // Attaque avec le guerrier
                    System.out.println("Voici la liste des créatures que vous pouvez attaquer");
                    j.getPersonnage().affiche_monstre(w.liste_creatures,j.getPersonnage());  // Affiche les créatures à moins de 5 cases
                    System.out.println("Veuillez choisir votre cible");
                    scanner.nextLine();  // Consomme la ligne vide restante après l'entrée de l'int
                    String nom2 = scanner.nextLine();  // Nom de la créature à attaquer
                    try {
                        lk = j.getPersonnage().retournecrea(nom2, w.liste_creatures);  // Récupère la créature choisie
                        j.getPersonnage().combattre(lk);  // Combat avec la créature
                    } catch (Exception e) {
                        System.out.println("La créature n'a pas été trouvée, vérifiez les majuscules dans le nom");
                    }
                    break; 
                
                case 3 :  // Déplacement du joueur
                    System.out.println("Votre position actuelle est : "+j.getPersonnage().getPos());
                    j.deplacement_joueur(w.liste_creatures);  // Déplace le joueur
                    break; 
            }
            
            // Nettoyage et mise à jour de l'état du jeu
            j.vider_jeu(w.liste_creatures);  // Enlève les créatures mortes
            j.getPersonnage().deplacemonstre(w.liste_creatures);  // Déplace toutes les créatures à chaque tour
            jeuGrille.mettreAJourGrille(j.getPersonnage(),w.liste_creatures);  // Met à jour la grille d'affichage
        }
    }
}


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
 *
 * @author barbo
 */
public class TestWoE {
    
    public static void main(String[] args){
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
        /*PotionSoin p = new PotionSoin(); 
        Creature wolfie = new Loup("wolfie",70, 25,50, 30 ,15, new Point2D(0,0)) ;
        p.setSoin(20);
        System.out.println("Point de vie du loup : " + wolfie.ptVie);
        wolfie.recuperePointDeVie(p.utiliser());
        System.out.println("Point de vie du loup apres potion: " + wolfie.ptVie);
        
//        p= null;*/
//        World m = new World();
//        m.creation();

    Joueur j = new Joueur();
    World w = new World();
    w.creation(); // place les personnages sur la map 
    j.creePerso();
    j.deplacement_joueur(w.liste_creatures);
  
     // pour l'affichage
    JFrame frame = new JFrame("Grille de Jeu"); // Utilisation de JFrame ici
    JeuGrille jeuGrille = new JeuGrille(j.getPersonnage(), w.liste_creatures); 
    frame.add(jeuGrille);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Méthode spécifique à JFrame
    frame.setVisible(true);
    while((!w.liste_creatures.isEmpty()) || j.getPersonnage().getPtVie()>0){// le jeu continue tant qu'il reste des monstres et tant que le joueur n'est pas mort 
        System.out.println("1 : attaque(archer) ; 2 : attaque(guerrier) ; 3 : déplacement "    );
        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();
        switch(choix){
            case 1 : 
                combattre // il faut avoir le nom de la créature 
                  
            case 3 : 
                j.deplacement_joueur(w.liste_creatures);
    }
}
}

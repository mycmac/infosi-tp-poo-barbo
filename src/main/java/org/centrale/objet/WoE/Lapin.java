/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author barbo
 */
public class Lapin extends Monstre {
    
    /**
     * Constructeur de la classe Lapin avec des paramètres pour initialiser ses attributs
     */
    public Lapin(String n, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos){
        super(n, ptVie, degAtt, ptPar, pageAtt, pagePar, pos);  // Appel au constructeur de la classe parent (Monstre)
    }

    /**
     * Constructeur de copie pour créer une copie d'un Lapin existant
     */
    public Lapin(Lapin i){
        super(i);  // Appel au constructeur de copie de la classe parent (Monstre)
    }
    
    /**
     * Constructeur sans paramètre pour créer un Lapin avec des valeurs par défaut
     */
    public Lapin(){
        super();  // Appel au constructeur sans paramètre de la classe parent (Monstre)
    }

    /**
     * Constructeur qui prend un entier pour initialiser le Lapin avec un certain attribut
     */
    public Lapin(int a){
        super(a);  // Appel au constructeur de la classe parent (Monstre) avec un seul paramètre
    }    
    
    /**
     * Méthode pour créer plusieurs Lapins et les ajouter à la liste 'a'
     * Chaque Lapin est créé avec un nom unique et placé dans une position libre
     */
    public void crea_lapin(ArrayList<Creature> a){
        Random random = new Random();  // Instance de Random pour générer des nombres aléatoires
        int alea = random.nextInt(100);  // Génére un nombre aléatoire entre 0 et 99

        // Crée 20 Lapins et les ajoute à la liste de créatures 'a'
        for (int i = 0; i < 20; i++ ){
            String n = "Lapin" + i;  // Nom du Lapin
            Lapin la = new Lapin(5);  // Création d'un nouveau Lapin avec un paramètre (ici, probablement la force)
            la.setNom(n);  // Définir le nom du Lapin
            la.dplt_case_libre(la, a);  // Placer le Lapin dans une case libre
            a.add(la);  // Ajouter le Lapin à la liste de créatures
        }
    } 
}

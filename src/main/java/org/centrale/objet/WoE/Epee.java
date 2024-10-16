/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe représentant une épée dans le jeu.
 * L'épée est un objet qui peut avoir une puissance, permettant d'influencer les combats.
 * Elle hérite de la classe Objet.
 * 
 * @author barbo
 */
public class Epee extends Objet {

    // Puissance de l'épée, utilisée pour déterminer l'efficacité de l'arme en combat
    private int puissance;
    
    /**
     * Méthode pour créer une liste d'épées avec un nombre aléatoire d'objets.
     * Cette méthode génère un nombre aléatoire d'épées et les ajoute à la liste fournie.
     * 
     * @param a La liste d'objets à laquelle les épées seront ajoutées
     */
    public void crea_epee(ArrayList<Objet> a) {
        Random random = new Random(); // Création d'un générateur de nombres aléatoires
        int alea = random.nextInt(100); // Génération d'un nombre aléatoire entre 0 et 99

        // Boucle pour créer et ajouter des épées à la liste "a"
        for (int i = 0; i < alea; i++) {
            String n = "Epee" + i; // Nom de l'épée, unique pour chaque instance
            Epee e = new Epee(); // Création d'une nouvelle épée
            e.setNom(n); // Définition du nom de l'épée
            a.add(e); // Ajout de l'épée à la liste
        }
    } 
}



 
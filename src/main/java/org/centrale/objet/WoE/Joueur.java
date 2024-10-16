/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

/**
 * Classe Joueur permettant de gérer la création d'un personnage, son déplacement et la suppression des créatures mortes.
 * 
 * @author barbo
 */
public class Joueur {
    private Personnage personnage; // Variable pour stocker le personnage du joueur

    // Méthode pour récupérer le personnage
    public Personnage getPersonnage() {
        return personnage;
    }
    
    /**
     * Méthode pour créer un personnage (archer ou guerrier) en fonction de l'entrée de l'utilisateur.
     */
    public void creePerso(){
        Scanner scanner = new Scanner(System.in);
        
        // Demande à l'utilisateur de choisir le type de personnage (archer ou guerrier)
        System.out.println("Veuillez entrer 1 pour un archer, 2 pour un guerrier "); 
        int nombre = scanner.nextInt();
        
        // Création d'un Guerrier ou d'un Archer selon le choix de l'utilisateur
        if(nombre == 2){
            this.personnage = new Guerrier(2);  // Crée un Guerrier
        }
        else if(nombre == 1){
            this.personnage = new Archer(1);  // Crée un Archer
        }
        else {
            System.out.println("Veuillez entrer 1 ou 2 ");  // Si l'entrée est invalide, affiche un message
        }
        
        // Demande à l'utilisateur de saisir le nom du personnage
        scanner.nextLine(); // Consomme la nouvelle ligne restante après nextInt()
        System.out.println("Veuillez entrer le nom du personnage :");

        // Saisie du nom du personnage
        String inputText = scanner.nextLine();
        this.personnage.setNom(inputText);  // Définir le nom du personnage
        
        // Utilisation de "instanceof" pour accéder à des méthodes spécifiques aux types Archer ou Guerrier
        if (this.personnage instanceof Archer) {
            Archer archer = (Archer) this.personnage;  // Cast vers Archer
        } else if (this.personnage instanceof Guerrier) {
            Guerrier guerrier = (Guerrier) this.personnage;  // Cast vers Guerrier
        }    
    }
    
    /**
     * Méthode pour déplacer le personnage à une position choisie par l'utilisateur.
     * Vérifie que la position choisie est libre.
     */
    public void deplacement_joueur(ArrayList<Creature> a){
        ArrayList<ArrayList<Integer>> position_crea = new ArrayList<>();  // Liste pour stocker les positions des créatures
        ArrayList<Integer> position_act = new ArrayList<>();  // Position actuelle du personnage
        
        // Création d'un vecteur de positions pour toutes les créatures
        for (int y = 0; y < a.size(); y++) {  
            position_crea.add(this.personnage.retourpos(a.get(y)));  // Ajout de la position de chaque créature à la liste
        }

        // Demande à l'utilisateur de choisir une coordonnée x et y pour déplacer le personnage
        System.out.println("Choisir une coordonnée x,y compris entre [@,50] : choisir x puis entrer, choisir y puis entrer");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        position_act.add(x);  // Ajouter la coordonnée x
        position_act.add(y);  // Ajouter la coordonnée y
        
        // Vérifie si la position est déjà prise par une autre créature
        while (position_crea.contains(position_act)) {
            System.out.println("La position choisie est déjà prise, veuillez choisir une autre position");  
            position_act.clear();  // Réinitialise la liste des positions
            x = scanner.nextInt();  // Demande de nouvelles coordonnées
            y = scanner.nextInt();
            position_act.add(x);  // Ajoute les nouvelles coordonnées
            position_act.add(y);
        }
        
        // Déplace le personnage à la nouvelle position
        this.personnage.getPos().setX(position_act.get(0));
        this.personnage.getPos().setY(position_act.get(1));   
    }
    
    /**
     * Méthode pour vider la liste des créatures mortes (ayant des points de vie < 0).
     */
    public void vider_jeu(ArrayList<Creature> a){
        // Parcours de la liste de créatures en sens inverse pour éviter les problèmes lors de la suppression
        for (int i = a.size() - 1; i >= 0; i--) {
            if(a.get(i).getPtVie() < 0) {  // Si les points de vie de la créature sont inférieurs à 0
                a.remove(i);  // Supprime la créature de la liste
            }
        }        
    }
}

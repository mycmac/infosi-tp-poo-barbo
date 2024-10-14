/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Scanner;
/**
 *
 * @author barbo
 */
public class Joueur {
    private Personnage personnage; 
    
    public void creePerso(){
    Scanner scanner = new Scanner(System.in);
    // créer le type de personnage
    System.out.println("Veuillez entrer 1 pour un archer, 2 pour un guerrier "); 
    int nombre = scanner.nextInt();
    if(nombre==2){
        this.personnage = new Guerrier(2);
    }
    
     else if(nombre==1){
        this.personnage = new Archer(1);
    }
     else {
         System.out.println("Veuillez entrer 1 ou 2 ");
     }
    // créer le nom du personnage 
    scanner.nextLine(); // Consomme la nouvelle ligne restante après nextInt()    
    System.out.println("Veuillez entrer le nom du personnage :");

    String inputText = scanner.nextLine();
    this.personnage.setNom(inputText);
    // Accéder aux méthodes spécifiques avec un cast
   if (this.personnage instanceof Archer) {
            Archer archer = (Archer) this.personnage; // Cast vers Archer
        } else if (this.personnage instanceof Guerrier) {
            Guerrier guerrier = (Guerrier) this.personnage; // Cast vers Guerrier
        }
}
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Scanner;
import java.util.Random ;
import java.util.ArrayList;
/**
 *
 * @author barbo
 */
public class Joueur {
    private Personnage personnage; 

    public Personnage getPersonnage() {
        return personnage;
    }
    
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
    
    public void deplacement_joueur(ArrayList<Creature> a){
        ArrayList<ArrayList<Integer >> position_crea = new ArrayList<>();
        ArrayList<Integer> position_act= new ArrayList<>();
        for (int y=0; y < a.size();y++ ){    // créer un vecteur de poosition 
            position_crea.add(this.personnage.retourpos(a.get(y)));       
        }

        System.out.println("Choisir une coordonné x,y compris entre [@,50] : choisir x puis entrer, choisir y puis entrer");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        position_act.add(x);
        position_act.add(y);
        while(position_crea.contains(position_act)){
        System.out.println("La position choisit est deja prise veuillez choisir une autre position");  
        position_act.clear();
        x = scanner.nextInt();
        y = scanner.nextInt();
        position_act.add(x);
        position_act.add(y); 
        }
        this.personnage.getPos().setX(position_act.get(0));
        this.personnage.getPos().setY(position_act.get(1));   
    }
    public void vider_jeu(ArrayList<Creature> a){
       for(int i = a.size() - 1; i >= 0; i--){
            if(a.get(i).getPtVie()< 0){
                 a.remove(i);
            }
        }        
    }
}

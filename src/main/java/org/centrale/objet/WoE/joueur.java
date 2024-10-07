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
public class joueur {
    private Personnage personnage; 
    
    public void créePerso(){
    Scanner scanner = new Scanner(System.in); 
    System.out.println("Veuillez entrer 1 pour un archer, 2 pour un guerrier "); 
    int nombre = scanner.nextInt();
    if(nombre == 2){
        this.personnage = new Guerrier();
    }
    
     else if(nombre==1){
        this.personnage = new Archer();
    }
     else {
         System.out.println("Veuillez entrer 1 ou 2 ");
     }
}
}


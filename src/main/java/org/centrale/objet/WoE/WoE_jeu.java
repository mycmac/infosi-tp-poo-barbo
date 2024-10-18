package org.centrale.objet.WoE;

import java.util.Scanner;

/**
 *
 */
public class WoE_jeu {
    public static void main(String [] args){
        
        World2 world = new World2() ;
        
        Scanner scanner = new Scanner(System.in) ;
        
        System.out.println("Tapez 1 si vous voulez charger une partie, 2 si vous voulez en créer une") ;
        
        int x = scanner.nextInt() ;
        
        if (x==2){
        
            world.creation_monde() ;
            
        }
        
        if (x==1){
            System.out.println("Entrez le nom du fichier") ;
            String n = scanner.nextLine() ;
            world.chargerPartie(n);
        }
        
        while (world.getJoueur().getPtVie()>0){
            world.tour_de_jeu() ;
        }
    }
}
    

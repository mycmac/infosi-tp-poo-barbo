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
    
    private Guerrier guy = new Guerrier("guy", 100, 18, 67, 35, 52, 2, new Point2D(5,5), new Epee()) ;
    private Archer jacques = new Archer("jacques", 100, 13, 50, 40, 60, 60, new Point2D(6,5), 15);
    private Loup wolfie = new Loup("wolfie",100, 25,50, 30 ,15, new Point2D(5,6)) ;
    
    public void creerMondeAlea(){
        
        System.out.println("Combat entre le Guerrier et le Loup :");
        guy.combattre(wolfie);  // Guerrier attaque le loup

        System.out.println("\nCombat entre l'Archer et le Loup :");
        jacques.combattre(wolfie);  // Archer attaque le loup à distance

        System.out.println("\nLe Loup attaque le Guerrier en retour :");
        wolfie.combattre(guy);  // Le loup attaque le guerrier
        
        System.out.println("Point de vie du guerrier : " + guy.ptVie);
        System.out.println("Point de vie de l'archer : " + jacques.ptVie);
        System.out.println("Point de vie du loup : " + wolfie.ptVie);
        
    }

    public void IllustrationCombat(){
        
    }
   
}

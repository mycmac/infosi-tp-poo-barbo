/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Interface représentant un combattant dans le jeu.
 * Un combattant est une entité capable de se battre contre une autre créature.
 * Toutes les classes qui implémentent cette interface doivent fournir une implémentation de la méthode "combattre".
 * 
 * @author barbo
 */
public interface Combattant {

    /**
     * Méthode pour effectuer une action de combat contre une créature.
     * Cette méthode doit être implémentée par toutes les classes qui représentent des personnages ou créatures capables de se battre.
     * 
     * @param c La créature cible à attaquer
     */
    public void combattre(Creature c);
}
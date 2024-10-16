/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.ArrayList;

/**
 * Interface 'deplacable' qui définit les méthodes nécessaires pour le déplacement des créatures.
 * Les classes qui implémentent cette interface doivent fournir une implémentation de la méthode
 * permettant à une créature de se déplacer sur une case libre dans un environnement donné.
 * 
 * @author barbo
 */
public interface deplacable {
    
    /**
     * Méthode pour déplacer une créature vers une case libre.
     * 
     * @param crea La créature à déplacer
     * @param a La liste des créatures présentes dans le monde
     */
    public void dplt_case_libre(Creature crea, ArrayList<Creature> a);  // Méthode pour déplacer une créature à une case libre
}


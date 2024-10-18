/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe abstraite représentant un monstre dans le jeu.
 * Un monstre est une créature qui possède des attributs de base pour le combat,
 * et peut être spécialisé dans des sous-classes comme Loup ou Lapin.
 * 
 * Cette classe hérite de la classe Creature et fournit des fonctionnalités spécifiques aux monstres.
 */
public abstract class Monstre extends Creature {

    /**
     * Constructeur avec paramètres pour créer un monstre avec des valeurs spécifiques.
     * 
     * @param n Nom du monstre.
     * @param ptVie Points de vie du monstre.
     * @param degAtt Dégâts d'attaque du monstre.
     * @param ptPar Points de parade du monstre.
     * @param pageAtt Page d'attaque (probabilité de réussir une attaque).
     * @param pagePar Page de parade (probabilité de réussir une parade).
     * @param pos Position du monstre sur la carte.
     * @param inventaire Inventaire d'objets que possède le monstre.
     */
    public Monstre(String n, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos, ArrayList<ObjetNumero> inventaire) {
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos, inventaire);
        this.nom = n;
    }

    /**
     * Constructeur de copie pour créer un monstre à partir d'un autre monstre.
     * 
     * @param m Le monstre à copier.
     */
    public Monstre(Monstre m) {
        super(m.ptVie, m.degAtt, m.ptPar, m.pageAtt, m.pagePar, m.pos, m.inventaire);
        this.nom = m.nom;
    }

    /**
     * Constructeur par défaut pour créer un monstre avec des valeurs par défaut.
     */
    public Monstre() {
        super();
    }

    /**
     * Affiche les informations du monstre, y compris ses points de vie, ses dégâts d'attaque, 
     * ses points de parade, sa page d'attaque, sa page de parade, et sa position.
     */
    @Override
    public void affiche() {
        System.out.println("Monstre{" + nom + "ptVie=" + ptVie + ", degAtt=" + degAtt + ", ptPar=" + ptPar 
                + ", pageAtt=" + pageAtt + ", pagePar=" + pagePar + ", pos=" + pos + '}');
    }

    /**
     * Méthode permettant au monstre de combattre une créature.
     * Cette méthode n'est pas encore implémentée dans la classe Monstre, elle devra être
     * redéfinie dans les sous-classes spécifiques qui héritent de Monstre.
     * 
     * @param c La créature que le monstre combat.
     * @throws UnsupportedOperationException Si la méthode n'est pas redéfinie dans une sous-classe.
     */
    @Override
    public void combattre(Creature c) {
        throw new UnsupportedOperationException("Not supported yet."); // Méthode à redéfinir dans les sous-classes
    }
}
package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe représentant de la nourriture dans le jeu.
 * La nourriture est un objet qui peut avoir un bonus et un malus.
 * Elle peut être utilisée par les créatures pour influencer leurs attributs, tels que la vie ou les capacités de combat.
 */
public class Nourriture extends Objet {
    
    int bonus;  // Bonus accordé par la nourriture
    int malus;  // Malus infligé par la nourriture
    
    /**
     * Constructeur avec paramètres pour créer de la nourriture avec un bonus, un malus, un nom et une position spécifiés.
     * 
     * @param n Nom de la nourriture.
     * @param bonus Valeur du bonus apporté par la nourriture.
     * @param malus Valeur du malus infligé par la nourriture.
     * @param pos Position de la nourriture sur la carte.
     */
    public Nourriture(String n, int bonus, int malus, Point2D pos) {
        super(n, pos);
        this.bonus = bonus;
        this.malus = malus;
    }
    
    /**
     * Constructeur par défaut pour créer de la nourriture sans bonus ni malus.
     */
    public Nourriture() {
        super();
        this.bonus = 0;
        this.malus = 0;
    }
    
    /**
     * Constructeur de copie pour créer de la nourriture à partir d'une autre nourriture.
     * 
     * @param nour L'objet Nourriture à copier.
     */
    public Nourriture(Nourriture nour) {
        super(nour);
        this.bonus = nour.bonus;
        this.malus = nour.malus;
    }

    /**
     * Récupère le bonus accordé par la nourriture.
     * 
     * @return La valeur du bonus.
     */
    public int getBonus() {
        return bonus;
    }

    /**
     * Récupère le malus infligé par la nourriture.
     * 
     * @return La valeur du malus.
     */
    public int getMalus() {
        return malus;
    }

    /**
     * Modifie la valeur du bonus de la nourriture.
     * 
     * @param bonus La nouvelle valeur du bonus.
     */
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    /**
     * Modifie la valeur du malus de la nourriture.
     * 
     * @param malus La nouvelle valeur du malus.
     */
    public void setMalus(int malus) {
        this.malus = malus;
    }
}

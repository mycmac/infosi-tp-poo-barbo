package org.centrale.objet.WoE;

/**
 * Interface représentant un combattant dans le jeu. 
 * Toute classe qui implémente cette interface doit définir la méthode combattre.
 */
public interface Combattant {

    /**
     * Permet à un combattant d'attaquer une créature donnée.
     * 
     * @param c La créature à combattre.
     */
    public void combattre(Creature c);
}
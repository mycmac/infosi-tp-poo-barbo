package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe abstraite représentant un personnage dans le jeu.
 * Un personnage est une créature avec des attributs supplémentaires comme la distance d'attaque maximale.
 * Cette classe hérite de la classe Creature et est destinée à être étendue par des sous-classes spécifiques (Guerrier, Archer, etc.).
 */
public abstract class Personnage extends Creature {
    protected int distAttMax;  // Distance d'attaque maximale du personnage

    /**
     * Constructeur par défaut qui initialise un personnage avec des valeurs par défaut.
     * Le nom est null et la distance d'attaque maximale est 0.
     */
    public Personnage() {
        super();  // Appel au constructeur par défaut de Creature
        this.nom = null;
        this.distAttMax = 0;
    }

    /**
     * Constructeur avec paramètres pour créer un personnage avec des valeurs spécifiques.
     * 
     * @param n Nom du personnage.
     * @param pV Points de vie du personnage.
     * @param dA Dégâts d'attaque du personnage.
     * @param pPar Points de parade du personnage.
     * @param paAtt Page d'attaque (probabilité de réussir une attaque).
     * @param paPar Page de parade (probabilité de réussir une parade).
     * @param distAttMax Distance d'attaque maximale du personnage.
     * @param p Position du personnage sur la carte.
     * @param inventaire Inventaire d'objets que possède le personnage.
     */
    public Personnage(String n, int pV, int dA, int pPar, int paAtt, int paPar, int distAttMax, Point2D p, ArrayList<ObjetNumero> inventaire) {
        super(pV, dA, pPar, paAtt, paPar, p, inventaire);  // Appel au constructeur de Creature
        this.nom = n;
        this.distAttMax = distAttMax;
    }

    /**
     * Constructeur de copie pour créer un personnage à partir d'un autre personnage.
     * 
     * @param pers Le personnage à copier.
     */
    public Personnage(Personnage pers) {
        super(pers);  // Appel au constructeur de copie de Creature
        this.nom = pers.nom;
        this.distAttMax = pers.distAttMax;
    }

    /**
     * Récupère la distance d'attaque maximale du personnage.
     * 
     * @return La distance d'attaque maximale.
     */
    public int getDistAttMax() {
        return distAttMax;
    }

    /**
     * Modifie la distance d'attaque maximale du personnage.
     * 
     * @param distAttMax La nouvelle distance d'attaque maximale.
     */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    /**
     * Affiche les informations du personnage, y compris son nom, ses points de vie, ses dégâts d'attaque, 
     * ses points de parade, ses pages d'attaque et de parade, sa distance d'attaque maximale, et sa position.
     */
    @Override
    public void affiche() {
        System.out.println("Nom :" + nom + ", " + "Point de vie "+ ptVie + ", "+degAtt+ ", "+ ptPar + ", "+ pageAtt +", " + distAttMax + ", " + "Position :"+ pos);
    }

    /**
     * Méthode de combat abstraite, à être redéfinie dans les sous-classes de Personnage.
     * 
     * @param c La créature contre laquelle le personnage se bat.
     * @throws UnsupportedOperationException Si la méthode n'est pas redéfinie dans une sous-classe.
     */
    @Override
    public void combattre(Creature c) {
        throw new UnsupportedOperationException("Not supported yet."); // Méthode à redéfinir dans les sous-classes
    }
    
    /**
     * Retourne une chaîne de caractères représentant les attributs du personnage
     * pour la sauvegarde dans un fichier texte.
     *
     * @return String Les attributs de l'archer sous forme de texte.
     */
    
    public String getTexteSauvegarde() {
        return "Archer;" + getNom() + ";" + getPos().getX() + ";" + getPos().getY() + ";"
                + getPtVie() + ";" + getDegAtt() + ";" + getPageAtt() + ";" + getPagePar() + ";"
                + getDistAttMax();
    }
    
}
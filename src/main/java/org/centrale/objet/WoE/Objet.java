package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Classe représentant un objet dans le jeu. 
 * Un objet peut avoir un nom, une position, ainsi que des attributs de bonus et malus.
 * Les objets peuvent être des consommables comme des champignons, des burgers ou des potions de soin.
 * 
 * Cette classe hérite de la classe ElementDeJeu et représente des éléments interactifs dans le jeu.
 */
public class Objet extends ElementDeJeu {
    
    protected String nom;   // Nom de l'objet
    protected Point2D pos;  // Position de l'objet sur la carte
    protected int bonus;    // Bonus accordé par l'objet
    protected int malus;    // Malus infligé par l'objet
    
    /**
     * Définit le nom de l'objet.
     * 
     * @param n Le nom de l'objet.
     */
    public void setNom(String n) {
        this.nom = n;
    }

    /**
     * Constructeur avec paramètres pour créer un objet avec un nom et une position spécifiés.
     * 
     * @param nom Nom de l'objet.
     * @param pos Position de l'objet sur la carte.
     */
    public Objet(String nom, Point2D pos) {
        this.nom = nom;
        this.pos = pos;
    }

    /**
     * Constructeur de copie pour créer un objet à partir d'un autre objet.
     * 
     * @param o L'objet à copier.
     */
    public Objet(Objet o) {
        this.nom = o.nom;
        this.pos = o.pos;
    }

    /**
     * Constructeur par défaut pour créer un objet avec une position par défaut.
     */
    public Objet() {
        this.pos = new Point2D();
    }

    /**
     * Récupère le nom de l'objet.
     * 
     * @return Le nom de l'objet.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Récupère la position de l'objet sur la carte.
     * 
     * @return La position de l'objet.
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     * Récupère le bonus accordé par l'objet.
     * 
     * @return La valeur du bonus.
     */
    public int getBonus() {
        return bonus;
    }

    /**
     * Récupère le malus infligé par l'objet.
     * 
     * @return La valeur du malus.
     */
    public int getMalus() {
        return malus;
    }

    /**
     * Modifie la valeur du bonus de l'objet.
     * 
     * @param bonus La nouvelle valeur du bonus.
     */
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    /**
     * Modifie la valeur du malus de l'objet.
     * 
     * @param malus La nouvelle valeur du malus.
     */
    public void setMalus(int malus) {
        this.malus = malus;
    }

    /**
     * Modifie la position de l'objet sur la carte.
     * 
     * @param pos La nouvelle position de l'objet.
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    /**
     * Définit les bonus et malus de l'objet en fonction de son nom.
     * 
     * @param n Le nom de l'objet (Champignon, Burger, ou PotionSoin).
     */
    public void setBonus(String n) {
        if (n.equals("Champignon")) {
            this.bonus = 0;
            this.malus = -50;
        }
        if (n.equals("Burger")) {
            this.bonus = 25;
            this.malus = -25;
        }
        if (n.equals("PotionSoin")) {
            this.bonus = 50;
            this.malus = 0;
        }
    }

    /**
     * Positionne l'objet de manière aléatoire sur la carte (coordonnées entre 0 et 50).
     * 
     * @param obj L'objet à positionner.
     */
    public void setPos_alea(Objet obj) {
        Random random = new Random();
        int randx = random.nextInt(50);
        int randy = random.nextInt(50);
        Point2D pos = new Point2D(randx, randy);
        obj.setPos(pos) ;
    }

    /**
     * Crée un nouvel objet avec une position aléatoire, un nom, un bonus et un malus, 
     * et l'ajoute à la liste des objets.
     * 
     * @param liste_objet Liste des objets présents sur la carte.
     */
    public void crea_objet(ArrayList<Objet> liste_objet) {
        Random random = new Random();
        Objet obj = new Objet();
        setPos_alea(obj);
        int rand = random.nextInt(3) + 1;
        if (rand == 1) {
            obj.setNom("Champignon");
            obj.setBonus(0);
            obj.setMalus(50);
        }
        if (rand == 2) {
            obj.setNom("Burger");
            obj.setBonus(25);
            obj.setMalus(-25);
        }
        if (rand == 3) {
            obj.setNom("PotionSoin");
            obj.setBonus(50);
            obj.setMalus(0);
        }
        
        liste_objet.add(obj);
    }
    
    /**
     * Retourne une chaîne de caractères représentant les attributs de l'archer
     * pour la sauvegarde dans un fichier texte.
     *
     * @return String Les attributs de l'archer sous forme de texte.
     */
    public String getTexteSauvegarde() {
        return "Objet;" + getNom() + ";" + getPos().getX() + ";" + getPos().getY() + ";"
                + getBonus() + ";" + getMalus();
    }
    
}
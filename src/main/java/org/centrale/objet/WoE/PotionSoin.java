package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe représentant une potion de soin dans le jeu.
 * La potion de soin permet de restaurer un certain nombre de points de vie lorsqu'elle est utilisée.
 * Elle hérite des caractéristiques de la classe Objet.
 */
public class PotionSoin extends Objet {
    private int soin; // Nombre de points de vie que la potion restaure

    /**
     * Méthode permettant d'utiliser la potion et de récupérer la quantité de points de vie qu'elle restaure.
     * 
     * @return Le nombre de points de vie restaurés par la potion.
     */
    public int utiliser() {
        return soin;
    }

    /**
     * Constructeur avec paramètres pour créer une potion de soin avec un nom, une position, et une quantité de points de vie à restaurer.
     * 
     * @param nom Le nom de la potion de soin.
     * @param pos La position de la potion sur la carte.
     * @param soin La quantité de points de vie restaurés par la potion.
     */
    public PotionSoin(String nom, Point2D pos, int soin) {
        super(nom, pos);
        this.soin = soin;
    }

    /**
     * Récupère la quantité de points de vie que la potion de soin peut restaurer.
     * 
     * @return La quantité de points de vie restaurés par la potion.
     */
    public int getSoin() {
        return soin;
    }

    /**
     * Constructeur par défaut pour créer une potion de soin avec des valeurs par défaut (0 point de vie restauré).
     */
    public PotionSoin() {
        super();
        this.soin = 0;
    }

    /**
     * Constructeur de copie pour créer une potion de soin à partir d'une autre potion de soin.
     * 
     * @param s La potion de soin à copier.
     */
    public PotionSoin(PotionSoin s) {
        super(s);
        this.soin = s.soin;
    }

    /**
     * Modifie la quantité de points de vie que la potion de soin peut restaurer.
     * 
     * @param soin La nouvelle quantité de points de vie restaurés par la potion.
     */
    public void setSoin(int soin) {
        this.soin = soin;
    }

    /**
     * Crée plusieurs potions de soin aléatoires et les ajoute à la liste des objets sur la carte.
     * 
     * @param liste La liste des objets présents sur la carte.
     */
    public void crea_potion_soin(ArrayList<Objet> liste) {
        Random random = new Random();
        int rand = random.nextInt(100);
        for (int i = 0; i < rand; i++) {
            String n = "Archer" + i;
            PotionSoin arch = new PotionSoin();
            arch.setNom(n);
            liste.add(arch);
        }
    }
}
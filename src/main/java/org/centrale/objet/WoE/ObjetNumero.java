package org.centrale.objet.WoE;

import java.util.ArrayList;

/**
 * Classe représentant un objet associé à un numéro unique.
 * Cette classe est utilisée pour gérer l'inventaire d'une créature, chaque objet étant référencé par un numéro.
 * 
 */
public class ObjetNumero {

    public Objet obj;    // L'objet associé
    public int numero;   // Le numéro unique associé à l'objet

    /**
     * Constructeur par défaut qui crée un objet avec un numéro par défaut (0).
     */
    public ObjetNumero() {
        this.obj = new Objet();
        this.numero = 0;
    }

    /**
     * Constructeur avec paramètres pour créer un objet-numéro avec un objet spécifique et un numéro associé.
     * 
     * @param obj L'objet associé.
     * @param numero Le numéro unique de l'objet.
     */
    public ObjetNumero(Objet obj, int numero) {
        this.obj = obj;
        this.numero = numero;
    }

    /**
     * Récupère l'objet associé à ce numéro.
     * 
     * @return L'objet associé.
     */
    public Objet getObj() {
        return obj;
    }

    /**
     * Récupère le numéro associé à cet objet.
     * 
     * @return Le numéro unique de l'objet.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Modifie l'objet associé à ce numéro.
     * 
     * @param obj Le nouvel objet à associer.
     */
    public void setObj(Objet obj) {
        this.obj = obj;
    }

    /**
     * Modifie le numéro unique associé à cet objet.
     * 
     * @param numero Le nouveau numéro.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Récupère la position de l'objet associé.
     * 
     * @return La position de l'objet (Point2D).
     */
    public Point2D getPos() {
        return obj.getPos();
    }

    /**
     * Récupère le nom de l'objet associé.
     * 
     * @return Le nom de l'objet.
     */
    public String getNom() {
        return obj.getNom();
    }
}
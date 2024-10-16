/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author barbo
 */


public class Objet {
    // Attributs de la classe : nom de l'objet et sa position
    private String nom;  // Le nom de l'objet
    private Point2D pos;  // La position de l'objet, représentée par un Point2D

    // Méthode pour définir le nom de l'objet
    public void setNom(String nom) {
        this.nom = nom;  // Assigne le nom passé en paramètre à l'attribut nom
    }

    // Méthode pour définir la position de l'objet
    public void setPos(Point2D pos) {
        this.pos = pos;  // Assigne la position passée en paramètre à l'attribut pos
    }
}

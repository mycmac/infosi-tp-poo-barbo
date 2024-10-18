package org.centrale.objet.WoE;

import java.util.ArrayList;

/**
 * Classe représentant un point en deux dimensions (2D) avec des coordonnées x et y.
 * Cette classe offre des méthodes pour manipuler les points, calculer la distance entre deux points,
 * et translater les coordonnées.
 */
public class Point2D {
    // Attributs
    private int x;  // Coordonnée x du point
    private int y;  // Coordonnée y du point

    /**
     * Constructeur par défaut qui initialise les coordonnées à (0, 0).
     */
    public Point2D() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Constructeur avec paramètres pour initialiser les coordonnées avec des valeurs spécifiques.
     * 
     * @param x Coordonnée x du point.
     * @param y Coordonnée y du point.
     */
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructeur de copie pour créer un nouveau point à partir d'un autre point.
     * 
     * @param p Le point à copier.
     */
    public Point2D(Point2D p) {
        this.x = p.x;
        this.y = p.y;
    }

    // Accesseurs (getters)

    /**
     * Récupère la coordonnée x du point.
     * 
     * @return La coordonnée x.
     */
    public int getX() {
        return x;
    }

    /**
     * Récupère la coordonnée y du point.
     * 
     * @return La coordonnée y.
     */
    public int getY() {
        return y;
    }

    // Mutateurs (setters)

    /**
     * Modifie la coordonnée x du point.
     * 
     * @param x La nouvelle coordonnée x.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Modifie la coordonnée y du point.
     * 
     * @param y La nouvelle coordonnée y.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Définit simultanément les deux coordonnées x et y du point.
     * 
     * @param x La nouvelle coordonnée x.
     * @param y La nouvelle coordonnée y.
     */
    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Translate le point en ajoutant des valeurs delta à ses coordonnées actuelles.
     * 
     * @param dx La valeur delta à ajouter à la coordonnée x.
     * @param dy La valeur delta à ajouter à la coordonnée y.
     */
    public void translate(int dx, int dy) {
        this.x = x + dx;
        this.y = y + dy;
    }

    /**
     * Modifie les coordonnées du point avec de nouvelles valeurs.
     * 
     * @param xx La nouvelle coordonnée x.
     * @param yy La nouvelle coordonnée y.
     */
    public void modifier(int xx, int yy) {
        this.x = xx;
        this.y = yy;
    }

    /**
     * Calcule la distance entre ce point et un autre point.
     * 
     * @param p Le point auquel calculer la distance.
     * @return La distance entre ce point et le point p.
     */
    public float distanceTo(Point2D p) {
        int dx = p.x - this.x;  // Différence sur l'axe X
        int dy = p.y - this.y;  // Différence sur l'axe Y
        return (float) Math.sqrt(dx * dx + dy * dy);  // Conversion du résultat en float
    }

    /**
     * Calcule la distance entre deux points donnés.
     * 
     * @param p1 Le premier point.
     * @param p2 Le deuxième point.
     * @return La distance entre p1 et p2.
     */
    public float distance_point(Point2D p1, Point2D p2) {
        int x1 = p1.getX();
        int x2 = p2.getX();
        int y1 = p1.getY();
        int y2 = p2.getY();
        return (float) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    /**
     * Retourne une représentation textuelle du point au format (x, y).
     * 
     * @return Une chaîne de caractères représentant les coordonnées du point.
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * Compare ce point avec un autre objet pour vérifier s'ils sont égaux.
     * Deux points sont égaux si leurs coordonnées x et y sont identiques.
     * 
     * @param obj L'objet à comparer avec ce point.
     * @return true si les deux objets sont égaux, sinon false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Point2D point = (Point2D) obj;
        return x == point.x && y == point.y;
    }
}
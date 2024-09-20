package org.centrale.objet.WoE;

public class Point2D {
    // Attributs
    private int x;
    private int y;

    // Constructeur par défaut
    public Point2D() {
        this.x = 0;
        this.y = 0;
    }

    // Constructeur avec paramètres
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Constructeur de copie
    public Point2D(Point2D p) {
        this.x = p.x;
        this.y = p.y;
    }

    // Accesseurs (getters)
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Mutateurs (setters)
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Méthode pour définir les deux coordonnées
    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    //Méthode pour translater 
    
    public void translate(int dx, int dy){
        this.x = x+dx ;
        this.y = y+dy ;
    }
    
    public void modifier(int xx, int yy){
        this.x= xx;
        this.y=yy;
    }
    

    // Méthode pour calculer la distance à un autre point
    public double distanceTo(Point2D p) {
        int dx = p.x - this.x;
        int dy = p.y - this.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Méthode toString pour l'affichage
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // Méthode equals pour comparer deux points
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

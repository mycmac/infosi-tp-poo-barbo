package org.centrale.objet.WoE;

public class Point2D {
    // Attributs représentant les coordonnées d'un point dans un plan 2D
    private int x;  // Coordonnée x
    private int y;  // Coordonnée y

    // Constructeur par défaut
    public Point2D() {
        this.x = 0;  // Initialise x à 0
        this.y = 0;  // Initialise y à 0
    }

    // Constructeur avec paramètres pour initialiser les coordonnées du point
    public Point2D(int x, int y) {
        this.x = x;  // Initialise x avec la valeur donnée
        this.y = y;  // Initialise y avec la valeur donnée
    }

    // Constructeur de copie pour créer un nouveau Point2D à partir d'un autre
    public Point2D(Point2D p) {
        this.x = p.x;  // Copie la coordonnée x
        this.y = p.y;  // Copie la coordonnée y
    }

    // Accesseurs (getters) pour accéder aux coordonnées x et y
    public int getX() {
        return x;  // Retourne la coordonnée x
    }

    public int getY() {
        return y;  // Retourne la coordonnée y
    }

    // Mutateurs (setters) pour modifier les coordonnées x et y
    public void setX(int x) {
        this.x = x;  // Modifie la coordonnée x
    }

    public void setY(int y) {
        this.y = y;  // Modifie la coordonnée y
    }

    // Méthode pour définir les deux coordonnées en même temps
    public void setCoordinates(int x, int y) {
        this.x = x;  // Modifie la coordonnée x
        this.y = y;  // Modifie la coordonnée y
    }
    
    // Méthode pour translater (déplacer) le point d'un certain décalage (dx, dy)
    public void translate(int dx, int dy){
        this.x = this.x + dx;  // Déplace la coordonnée x de dx
        this.y = this.y + dy;  // Déplace la coordonnée y de dy
    }
    
    // Méthode pour modifier les coordonnées directement
    public void modifier(int xx, int yy){
        this.x = xx;  // Remplace la coordonnée x par xx
        this.y = yy;  // Remplace la coordonnée y par yy
    }

    // Méthode pour calculer la distance entre ce point et un autre Point2D
    public double distanceTo(Point2D p) {
        int dx = p.getX() - this.x;  // Différence en x
        int dy = p.getY() - this.y;  // Différence en y
        return Math.sqrt(dx * dx + dy * dy);  // Utilise le théorème de Pythagore pour calculer la distance
    }

    // Méthode toString pour afficher les coordonnées du point sous forme de chaîne de caractères
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";  // Retourne une chaîne formatée (x, y)
    }

    // Méthode equals pour comparer deux objets Point2D
    @Override
    public boolean equals(Object obj) {
        if (this == obj)  // Vérifie si les deux objets sont le même
            return true;
        if (obj == null || getClass() != obj.getClass())  // Vérifie si l'objet est null ou d'une classe différente
            return false;
        Point2D point = (Point2D) obj;  // Cast l'objet en Point2D
        return x == point.x && y == point.y;  // Compare les coordonnées x et y
    }
}

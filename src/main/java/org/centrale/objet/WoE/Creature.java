package org.centrale.objet.WoE;
import java.util.Random;

public abstract class Creature {
    protected int ptVie; // Points de vie
    protected String nom ; // Nom
    protected int degAtt;  // Dégâts d'attaque
    protected int ptPar;  // Points de parade
    protected int pageAtt;  // Page d'attaque
    protected int pagePar;  // Page de parade
    protected Point2D pos;  // Position de la créature

    /**
     * Constructeur avec paramètres pour créer une créature.
     *
     * @param ptVie Points de vie de la créature
     * @param degAtt Dégâts d'attaque
     * @param ptPar Points de parade
     * @param pageAtt Page d'attaque (vitesse d'attaque)
     * @param pagePar Page de parade (vitesse de parade)
     * @param pos Position de la créature
     */
    public Creature(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        this.ptVie = ptVie;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        this.pageAtt = pageAtt;
        this.pagePar = pagePar;
        this.pos = pos;
    }

    /**
     * Constructeur de copie pour créer une nouvelle créature à partir d'une autre.
     *
     * @param c Créature à copier
     */
    public Creature(Creature c) {
        this.ptVie = c.ptVie;
        this.degAtt = c.degAtt;
        this.ptPar = c.ptPar;
        this.pageAtt = c.pageAtt;
        this.pagePar = c.pagePar;
        this.pos = new Point2D(c.pos);  // Copie de la position
    }

    /**
     * Constructeur par défaut pour créer une créature avec des valeurs par défaut.
     */
    public Creature() {
        this.ptVie = 0;
        this.degAtt = 0;
        this.ptPar = 0;
        this.pageAtt = 0;
        this.pagePar = 0;
        this.pos = new Point2D();
    }

    // Getters et Setters
    public int getPtVie() {
        return ptVie;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    public int getDegAtt() {
        return degAtt;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    public int getPtPar() {
        return ptPar;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    public int getPageAtt() {
        return pageAtt;
    }

    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    public int getPagePar() {
        return pagePar;
    }

    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    /**
     * Calcule la distance entre cette créature et un autre point.
     *
     * @param p Le point auquel calculer la distance.
     * @return La distance en float.
     */
    public float distance(Point2D p) {
        int dx = p.getX() - this.pos.getX();
        int dy = p.getY() - this.pos.getY();
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Méthode abstraite pour le comportement de combat d'une créature.
     *
     * @param c La créature contre laquelle combattre.
     */
    public abstract void combattre(Creature c);

    /**
     * Déplace la créature sur une case adjacente aléatoire.
     */
    public void deplace() {
        Random rand = new Random();
        int dx = rand.nextInt(3) - 1;  // Valeurs possibles : -1, 0, 1
        int dy = rand.nextInt(3) - 1;  // Valeurs possibles : -1, 0, 1
        pos.translate(dx, dy);
        System.out.println("Creature déplacée à la position : " + pos);
    }

    /**
     * Affiche les informations de la créature.
     */
    public void affiche() {
        System.out.println("Creature{" + "ptVie=" + ptVie + ", degAtt=" + degAtt + ", ptPar=" + ptPar
                + ", pageAtt=" + pageAtt + ", pagePar=" + pagePar + ", pos=" + pos + '}');
    }
}
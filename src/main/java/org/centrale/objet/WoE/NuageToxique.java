package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Random;

/**
 * La classe NuageToxique représente un nuage toxique qui est un type d'objet dans le jeu. 
 * Le nuage toxique a des propriétés spécifiques telles que des dégâts et une portée. 
 * Il peut être placé aléatoirement sur la carte et se déplacer.
 */
public class NuageToxique extends Objet {
    
    /** Dégâts infligés par le nuage toxique. */
    private int deg;
    
    /** Portée du nuage toxique. */
    private int portee;
    
    /**
     * Constructeur par défaut de la classe NuageToxique.
     * Initialise les dégâts et la portée à zéro.
     */
    public NuageToxique(){
        super();
        this.deg = 0;
        this.portee = 0;
    }
    
    /**
     * Constructeur avec paramètres pour créer un nuage toxique avec un nom, une position, des dégâts et une portée.
     * 
     * @param n Nom de l'objet.
     * @param pos Position du nuage toxique sur la carte.
     * @param deg Dégâts infligés par le nuage toxique.
     * @param portee Portée du nuage toxique.
     */
    public NuageToxique(String n, Point2D pos, int deg, int portee){
        super(n, pos);
        this.deg = deg;
        this.portee = portee;
    }
    
    /**
     * Constructeur de copie pour créer un nouveau nuage toxique en copiant un autre.
     * 
     * @param n Nuage toxique à copier.
     */
    public NuageToxique(NuageToxique n){
        super(n);
        this.deg = n.deg;
        this.portee = n.portee;
    }

    /**
     * Obtient la position du nuage toxique.
     * 
     * @return Position du nuage toxique.
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     * Obtient les dégâts infligés par le nuage toxique.
     * 
     * @return Dégâts du nuage toxique.
     */
    public int getDeg() {
        return deg;
    }

    /**
     * Obtient la portée du nuage toxique.
     * 
     * @return Portée du nuage toxique.
     */
    public int getPortee() {
        return portee;
    }

    /**
     * Définit la position du nuage toxique.
     * 
     * @param pos Nouvelle position du nuage toxique.
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    /**
     * Définit les dégâts infligés par le nuage toxique.
     * 
     * @param deg Dégâts du nuage toxique.
     */
    public void setDeg(int deg) {
        this.deg = deg;
    }

    /**
     * Définit la portée du nuage toxique.
     * 
     * @param portee Portée du nuage toxique.
     */
    public void setPortee(int portee) {
        this.portee = portee;
    }

    /**
     * Obtient le nom du nuage toxique.
     * 
     * @return Nom de l'objet.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Obtient le bonus associé à cet objet.
     * 
     * @return Bonus de l'objet.
     */
    public int getBonus() {
        return bonus;
    }

    /**
     * Obtient le malus associé à cet objet.
     * 
     * @return Malus de l'objet.
     */
    public int getMalus() {
        return malus;
    }

    /**
     * Définit le nom du nuage toxique.
     * 
     * @param nom Nom de l'objet.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Définit le bonus associé à cet objet.
     * 
     * @param bonus Bonus de l'objet.
     */
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    /**
     * Définit le malus associé à cet objet.
     * 
     * @param malus Malus de l'objet.
     */
    public void setMalus(int malus) {
        this.malus = malus;
    }
    
    /**
     * Crée et place un nuage toxique de manière aléatoire sur la carte.
     * 
     * @param liste_objet Liste des objets où ajouter le nuage toxique.
     */
    public void crea_nuage(ArrayList<Objet> liste_objet) {
        String n = "Nuage Toxique";
        NuageToxique nuage = new NuageToxique();
        nuage.setNom(n);
        setPos_alea(nuage);
        Random random = new Random();
        int rand = random.nextInt(10) + 5;
        nuage.setDeg(rand);
        liste_objet.add(nuage);
    }
    
    /**
     * Déplace le nuage toxique de manière aléatoire sur la carte.
     */
    public void deplace() {
        Random rand = new Random();
        int deltaX = rand.nextBoolean() ? 1 : -1;
        int deltaY = rand.nextBoolean() ? 1 : -1;

        // Récupérer les positions actuelles
        int currentX = this.getPos().getX();
        int currentY = this.getPos().getY();

        // Calculer la nouvelle position pour X
        int newX = currentX + deltaX;
        if (newX > 50) {
            newX = 0;
        } else if (newX < 0) {
            newX = 50;
        }

        // Calculer la nouvelle position pour Y
        int newY = currentY + deltaY;
        if (newY > 50) {
            newY = 0;
        } else if (newY < 0) {
            newY = 50;
        }

        // Mettre à jour la position de la créature
        this.getPos().setX(newX);
        this.getPos().setY(newY);
    }   
    
    /**
     * Calcule la distance entre une créature et un nuage toxique.
     *
     * @param c Créature pour laquelle calculer la distance.
     * @param n Nuage toxique dont la distance est calculée.
     * @return Distance en float entre la créature et le nuage toxique.
     */
    public float distance_crea_nuage(Creature c, NuageToxique n) {
        Point2D p1 = c.getPos();
        Point2D p2 = n.getPos();
        int x1 = p1.getX();
        int x2 = p2.getX();
        int y1 = p1.getY();
        int y2 = p2.getY();
        return (float) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
    
    /**
     * Vérifie si un nuage toxique est présent sur le terrain.
     * Méthode utilisée dans la classe World2.
     * 
     * @param liste_objets Liste des objets à vérifier.
     * @return true si un nuage toxique est trouvé, false sinon.
     */
    public boolean contientNuageToxique(ArrayList<Objet> liste_objets) {
        for (Objet obj : liste_objets) {
            if (obj instanceof NuageToxique) {
                return true;  // Retourne true si un NuageToxique est trouvé
            }
        }
        return false;  // Retourne false si aucun NuageToxique n'est trouvé
    }
    
    /**
     * Sélectionne et retourne un nuage toxique présent dans la liste des objets.
     * Par convention, il n'y aura qu'un seul nuage toxique, de taille 3x3.
     * 
     * @param liste_objets Liste des objets où chercher le nuage toxique.
     * @return Le nuage toxique trouvé, ou null s'il n'y en a pas.
     */
    public NuageToxique selectionnerNuageToxique(ArrayList<Objet> liste_objets) {
        for (Objet obj : liste_objets) {
            if (obj instanceof NuageToxique) {
                return (NuageToxique) obj;  // Retourne l'objet trouvé en tant que NuageToxique
            }
        }
        return null;  // Retourne null si aucun NuageToxique n'est trouvé
    }
    
    
    /**
     * Retourne une chaîne de caractères représentant les attributs de l'archer
     * pour la sauvegarde dans un fichier texte.
     *
     * @return String Les attributs de l'archer sous forme de texte.
     */
    @Override
    public String getTexteSauvegarde() {
        return "Archer;" + getNom() + ";" + getPos().getX() + ";" + getPos().getY();
    }
    
}
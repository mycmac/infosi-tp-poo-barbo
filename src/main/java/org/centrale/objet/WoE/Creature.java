package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Classe abstraite représentant une créature dans le jeu. 
 * Implémente l'interface Deplacable pour permettre aux créatures de se déplacer.
 */
public abstract class Creature extends ElementDeJeu {
    protected int ptVie; // Points de vie
    protected String nom; // Nom
    protected int degAtt;  // Dégâts d'attaque
    protected int ptPar;  // Points de parade
    protected int pageAtt;  // Page d'attaque
    protected int pagePar;  // Page de parade
    protected Point2D pos;  // Position de la créature
    protected ArrayList<ObjetNumero> inventaire;

    /**
     * Constructeur avec paramètres pour créer une créature.
     *
     * @param ptVie Points de vie de la créature
     * @param degAtt Dégâts d'attaque
     * @param ptPar Points de parade
     * @param pageAtt Page d'attaque (vitesse d'attaque)
     * @param pagePar Page de parade (vitesse de parade)
     * @param pos Position de la créature
     * @param inventaire Inventaire d'objets que possède la créature
     */
    public Creature(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos, ArrayList<ObjetNumero> inventaire) {
        this.ptVie = ptVie;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        this.pageAtt = pageAtt;
        this.pagePar = pagePar;
        this.pos = pos;
        this.inventaire = inventaire;
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
        this.inventaire = c.inventaire;
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
        this.inventaire = new ArrayList<>();
    }

    // Getters et Setters

    /**
     * Récupère les points de vie de la créature.
     * @return Points de vie
     */
    public int getPtVie() {
        return ptVie;
    }

    /**
     * Modifie les points de vie de la créature.
     * @param ptVie Points de vie à attribuer
     */
    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    /**
     * Modifie les points de vie de la créature avec une valeur aléatoire.
     */
    public void setPtVie() {
        Random random = new Random();
        int rand = random.nextInt(50)+50;
        this.ptVie = rand;
    }

    /**
     * Récupère les dégâts d'attaque de la créature.
     * @return Dégâts d'attaque
     */
    public int getDegAtt() {
        return degAtt;
    }

    /**
     * Modifie les dégâts d'attaque de la créature.
     * @param degAtt Dégâts d'attaque à attribuer
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    /**
     * Récupère les points de parade de la créature.
     * @return Points de parade
     */
    public int getPtPar() {
        return ptPar;
    }

    /**
     * Récupère le nom de la créature.
     * @return Nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom de la créature.
     * @param nom Nom à attribuer
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Modifie les points de parade de la créature.
     * @param ptPar Points de parade à attribuer
     */
    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    /**
     * Récupère la page d'attaque de la créature.
     * @return Page d'attaque
     */
    public int getPageAtt() {
        return pageAtt;
    }

    /**
     * Modifie la page d'attaque de la créature.
     * @param pageAtt Page d'attaque à attribuer
     */
    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    /**
     * Récupère la page de parade de la créature.
     * @return Page de parade
     */
    public int getPagePar() {
        return pagePar;
    }

    /**
     * Modifie la page de parade de la créature.
     * @param pagePar Page de parade à attribuer
     */
    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }

    /**
     * Récupère la position de la créature.
     * @return Position
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     * Modifie la position de la créature.
     * @param pos Position à attribuer
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    /**
     * Récupère l'inventaire de la créature.
     * @return Inventaire
     */
    public ArrayList<ObjetNumero> getInventaire() {
        return inventaire;
    }

    /**
     * Modifie l'inventaire de la créature.
     * @param inventaire Inventaire à attribuer
     */
    public void setInventaire(ArrayList<ObjetNumero> inventaire) {
        this.inventaire = inventaire;
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
     * Calcule la distance entre deux créatures donnés.
     *
     * @param c1 Première créature
     * @param c2 Deuxième créature
     * @return Distance en float
     */
    public float distance_crea(Creature c1, Creature c2) {
        Point2D p1 = c1.getPos() ;
        Point2D p2 = c2.getPos() ;
        int x1 = p1.getX();
        int x2 = p2.getX();
        int y1 = p1.getY();
        int y2 = p2.getY();
        return (float) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
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
    }

    /**
     * Déplace la créature de manière aléatoire dans un monde continu en 2D de type sphère (50x50).
     * Si la créature dépasse la limite en x ou en y, elle réapparaît de l'autre côté du plateau.
     *
     * @param c La créature à déplacer.
     */
    public void deplace(Creature c) {
        Random rand = new Random();
        int deltaX = rand.nextBoolean() ? 1 : -1;
        int deltaY = rand.nextBoolean() ? 1 : -1;
        int currentX = c.getPos().getX();
        int currentY = c.getPos().getY();
        int newX = currentX + deltaX;
        if (newX > 50) {
            newX = 0;
        } else if (newX < 0) {
            newX = 50;
        }
        int newY = currentY + deltaY;
        if (newY > 50) {
            newY = 0;
        } else if (newY < 0) {
            newY = 50;
        }
        c.getPos().setX(newX);
        c.getPos().setY(newY);
    }

    /**
     * Déplace la créature tout en prenant en compte la mémoire des positions des autres créatures.
     *
     * @param creature La créature à déplacer.
     * @param liste Liste des autres créatures.
     * @param liste_objets Liste des objets sur le terrain.
     */
    public void deplace_memoire(Creature creature, ArrayList<Creature> liste, ArrayList<Objet> liste_objets) {
        ArrayList<Point2D> positions = new ArrayList<>();
        for (int i = 0; i < liste.size(); i++) {
            positions.add(liste.get(i).getPos());
        }
        Point2D pos = creature.getPos();
        while (positions.contains(pos)) {
            deplace(creature);
            pos = creature.getPos();
        }
        for (Objet obj : liste_objets) {
            if (pos.equals(obj.getPos())) {
                ObjetNumero inv = new ObjetNumero(obj, inventaire.size() + 1);
                inventaire.add(inv);
            }
        }
    }
    
    /**
    * Renvoie la position de la créature sous forme de vecteur (liste d'entiers).
    * Les coordonnées x et y de la position de la créature sont ajoutées à une liste.
    *
    * @param crea La créature dont la position est à retourner.
    * @return Un ArrayList contenant la position de la créature sous forme de deux entiers (x, y).
    */
    public ArrayList<Integer> retourpos(Creature crea) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(crea.getPos().getX());
        a.add(crea.getPos().getY());
        return a;
    }
    

    /**
     * Affiche les informations de la créature.
     */
    public void affiche() {
        System.out.println("Creature{" + "ptVie=" + ptVie + ", degAtt=" + degAtt + ", ptPar=" + ptPar
                + ", pageAtt=" + pageAtt + ", pagePar=" + pagePar + ", pos=" + pos + '}');
    }

    /**
     * Ajoute des points de vie à la créature.
     * @param point Points de vie à ajouter
     */
    public void recuperePointDeVie(int point) {
        this.ptVie = this.ptVie + point;
        if (this.ptVie > 100) {
            this.ptVie = 100;  // un personnage ne peut pas avoir plus de 100 points de vie
        }
    }

    /**
     * Vérifie si la position de la créature est à l'intérieur de la zone occupée par d'autres créatures.
     * 
     * @param creature La créature à vérifier.
     * @param liste Liste des autres créatures.
     * @return true si la position est à l'intérieur, false sinon.
     */
    public boolean pos_interieur(Creature creature, ArrayList<Creature> liste) {
        for (int i = 0; i < liste.size(); i++) {
            if ((creature.getPos()).equals((liste.get(i).getPos()))) {
                return true;
            }
        }
        return false;
    }

    /**
    * Permet à une créature d'utiliser un objet passé en paramètre.
     * Applique les effets de l'objet (bonus et/ou malus) à la créature.
     *
     * @param obj L'objet à utiliser par la créature.
     */
    public void utiliser(Objet obj) {
        // Vérifie le type de l'objet et applique les effets correspondants
        switch (obj.getNom()) {
            case "Champignon":
                // Le Champignon fait perdre 50 points de vie mais augmente d'autres attributs
                this.ptVie -= 50;
                if (this.ptVie < 0) {
                    this.ptVie = 0; // Les points de vie ne peuvent pas être négatifs
                }
               this.degAtt += 25;
               this.pageAtt += 25;
               this.pagePar += 25;
               System.out.println("Vous avez utilisé un Champignon.\n Vous perdez 50 points de vie mais gagnez 25 points en dégâts d'attaque, vitesse d'attaque, et vitesse de parade.");
               break;

            case "PotionSoin":
                // La PotionSoin restaure 50 points de vie
                this.ptVie += 50;
                if (this.ptVie > 100) {
                    this.ptVie = 100; // Les points de vie ne peuvent pas dépasser 100
                }
                System.out.println("Vous avez utilisé une PotionSoin.\n Vous gagnez 50 points de vie.");
                break;

            case "Burger":
                // Le Burger apporte 25 points de vie, mais diminue pageAtt et pagePar de 25 points
               this.ptVie += 25;
                   if (this.ptVie > 100) {
                   this.ptVie = 100; // Les points de vie ne peuvent pas dépasser 100
               }
                this.pageAtt -= 25;
                this.pagePar -= 25;
                // Les attributs pageAtt et pagePar ne peuvent pas descendre en dessous de 0
                if (this.pageAtt < 0) {
                    this.pageAtt = 0;
                }
                if (this.pagePar < 0) {
                    this.pagePar = 0;
                }
               System.out.println("Vous avez mangé un Burger.\n Vous gagnez 25 points de vie mais perdez 25 points d'attaque et de parade.");
               break;

            default:
                System.out.println("Cet objet n'est pas utilisable.");
                break;
        }
    }
    
    /**
     * Permet d'afficher l'inventaire de la créature.
     */
    
    public void affiche_inventaire(){
        System.out.println(inventaire) ;
    }
    
    /**
     * Retourne une chaîne de caractères représentant les attributs de l'archer
     * pour la sauvegarde dans un fichier texte.
     *
     * @return String Les attributs de l'archer sous forme de texte.
     */
    public String getTexteSauvegarde() {
        return "Archer;" + getNom() + ";" + getPos().getX() + ";" + getPos().getY() + ";"
                + getPtVie() + ";" + getDegAtt() + ";" + getPageAtt() + ";" + getPagePar();
    }
    
}
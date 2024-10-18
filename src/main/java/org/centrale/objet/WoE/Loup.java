package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Classe représentant un loup, un type de monstre dans le jeu.
 * Le loup hérite des attributs de base des monstres et implémente les
 * fonctionnalités de combat via l'interface Combattant.
 */
public class Loup extends Monstre implements Combattant {
    
    /**
     * Constructeur avec tous les paramètres pour créer un loup.
     * 
     * @param n Nom du loup.
     * @param ptVie Points de vie du loup.
     * @param degAtt Dégâts d'attaque du loup.
     * @param ptPar Points de parade du loup.
     * @param pageAtt Page d'attaque (probabilité de réussir une attaque).
     * @param pagePar Page de parade (probabilité de réussir une parade).
     * @param pos Position du loup sur la carte.
     * @param inventaire Inventaire d'objets que possède le loup.
     */
    public Loup(String n, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos, ArrayList<ObjetNumero> inventaire) {
        super(n, ptVie, degAtt, ptPar, pageAtt, pagePar, pos, inventaire);
    }
    
    /**
     * Constructeur de copie pour créer un loup à partir d'un autre loup.
     * 
     * @param l Le loup à copier.
     */
    public Loup(Loup l) {
        super(l);
    }
    
    /**
     * Constructeur par défaut pour créer un loup avec des valeurs par défaut.
     */
    public Loup() {
        super();
    }

    /**
     * Récupère les points de vie du loup.
     * 
     * @return Points de vie du loup.
     */
    public int getPtVie() {
        return ptVie;
    }

    /**
     * Récupère les dégâts d'attaque du loup.
     * 
     * @return Dégâts d'attaque du loup.
     */
    public int getDegAtt() {
        return degAtt;
    }

    /**
     * Récupère les points de parade du loup.
     * 
     * @return Points de parade du loup.
     */
    public int getPtPar() {
        return ptPar;
    }

    /**
     * Récupère la page d'attaque du loup.
     * 
     * @return Page d'attaque du loup.
     */
    public int getPageAtt() {
        return pageAtt;
    }

    /**
     * Récupère la page de parade du loup.
     * 
     * @return Page de parade du loup.
     */
    public int getPagePar() {
        return pagePar;
    }

    /**
     * Récupère la position du loup sur la carte.
     * 
     * @return Position du loup.
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     * Modifie les points de vie du loup.
     * 
     * @param ptVie Les nouveaux points de vie du loup.
     */
    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    /**
     * Modifie les dégâts d'attaque du loup.
     * 
     * @param degAtt Les nouveaux dégâts d'attaque du loup.
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    /**
     * Modifie les points de parade du loup.
     * 
     * @param ptPar Les nouveaux points de parade du loup.
     */
    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    /**
     * Modifie la page d'attaque du loup.
     * 
     * @param pageAtt La nouvelle page d'attaque du loup.
     */
    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    /**
     * Modifie la page de parade du loup.
     * 
     * @param pagePar La nouvelle page de parade du loup.
     */
    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }

    /**
     * Modifie la position du loup sur la carte.
     * 
     * @param pos La nouvelle position du loup.
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    /**
     * Méthode permettant au loup de combattre une créature au corps à corps.
     * Si la créature est à une distance de 1, le loup tente une attaque.
     * 
     * @param c La créature que le loup attaque.
     */
    @Override
    public void combattre(Creature c) {
        Random rand = new Random();
        double distance = this.pos.distanceTo(c.getPos());

        if (distance == 1) {  // Combat au corps à corps (proche)
            int jetAttaque = rand.nextInt(100) + 1;
            if (jetAttaque <= this.pageAtt) {  // Loup réussit son attaque
                System.out.println("Le loup attaque " + c.getNom() + " avec succès !");
                int jetParade = rand.nextInt(100) + 1;
                if (jetParade <= c.getPagePar()) {  // Parade réussie
                    int degats = this.degAtt - c.getPtPar();
                    degats = Math.max(degats, 0);  // Évite les dégâts négatifs
                    c.setPtVie(c.getPtVie() - degats);
                    System.out.println(c.getNom() + " a paré l'attaque ! Il lui reste " + c.getPtVie() + " points de vie.");
                } else {  // Parade échouée
                    c.setPtVie(c.getPtVie() - this.degAtt);
                    System.out.println(c.getNom() + " n'a pas paré ! Il lui reste " + c.getPtVie() + " points de vie.");
                }
            } else {
                System.out.println("Le loup rate son attaque contre " + c.getNom() + ".");
            }
        } else {
            System.out.println("Le loup est trop loin pour attaquer.");
        }
    }

    /**
     * Crée plusieurs loups aléatoirement positionnés sur la carte 
     * et les ajoute à la liste des créatures.
     * 
     * @param liste Liste des créatures présentes sur la carte.
     * @param liste_objets Liste des objets présents sur la carte.
     */
    public void crea_loup(ArrayList<Creature> liste, ArrayList<Objet> liste_objets) {
        String n = "Loup";
        Loup arch = new Loup();
        deplace_memoire(arch, liste, liste_objets);
        arch.setNom(n);
        arch.setPtVie();
        liste.add(arch);
        
    }
    
    /**
     * Retourne une chaîne de caractères représentant les attributs du loup
     * pour la sauvegarde dans un fichier texte.
     *
     * @return String Les attributs de l'archer sous forme de texte.
     */
    
    public String getTexteSauvegarde() {
        return "Loup;" + getNom() + ";" + getPos().getX() + ";" + getPos().getY() + ";"
                + getPtVie() + ";" + getDegAtt() + ";" + getPageAtt() + ";" + getPagePar() ;
    }
    
}
package org.centrale.objet.WoE;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe représentant un archer, un type de personnage qui utilise des flèches pour attaquer à distance.
 * L'archer hérite des attributs d'un personnage et implémente les méthodes de l'interface Combattant.
 * 
 */
public class Archer extends Personnage implements Combattant {
    private int nbFleches; // Nombre de flèches que possède l'archer
    
    /**
     * Constructeur de l'archer avec tous les paramètres.
     * 
     * @param n Nom de l'archer.
     * @param pV Points de vie de l'archer.
     * @param dA Dégâts d'attaque de l'archer.
     * @param pPar Points de parade de l'archer.
     * @param paAtt Page d'attaque (probabilité de réussir une attaque).
     * @param paPar Page de parade (probabilité de réussir une parade).
     * @param distAttMax Distance d'attaque maximale de l'archer.
     * @param p Position de l'archer sur la carte.
     * @param nbFleches Nombre de flèches que possède l'archer.
     * @param inventaire Inventaire d'objets que possède l'archer.
     */
    public Archer(String n, int pV, int dA, int pPar, int paAtt, int paPar, int distAttMax, Point2D p, int nbFleches, ArrayList<ObjetNumero> inventaire) {
        super(n, pV, dA, pPar, paAtt, paPar, distAttMax, p, inventaire);
        this.nbFleches = nbFleches;
    }

    /**
     * Constructeur de copie pour créer un archer à partir d'un autre archer.
     * 
     * @param a Archer à copier.
     */
    public Archer(Archer a) {
        super(a);
        this.nbFleches = a.nbFleches;
    }
    
    /**
     * Constructeur avec un nom seulement.
     * 
     * @param n Nom de l'archer.
     */
    public Archer(String n) {
        super();
        this.nom = n;
    }    
    
    /**
     * Constructeur par défaut de l'archer.
     */
    public Archer() {
        super();
    }

    /**
     * Récupère le nombre de flèches que possède l'archer.
     * 
     * @return Le nombre de flèches.
     */
    public int getNbFleches() {
        return nbFleches;
    }

    /**
     * Définit le nombre de flèches de l'archer.
     * 
     * @param nbFleches Le nouveau nombre de flèches.
     */
    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }

    /**
     * Méthode permettant à l'archer de combattre une créature.
     * Si la créature est à portée de tir, l'archer tente une attaque à distance.
     * 
     * @param c La créature que l'archer attaque.
     */
    @Override
    public void combattre(Creature c) {
        Random rand = new Random();
        double distance = this.pos.distanceTo(c.getPos());

        if ((distance > 1 && distance <= this.getDistAttMax())&&(this.nbFleches != 0)) {  // Combat à distance
            int jetAttaque = rand.nextInt(100) + 1;
            if (jetAttaque <= this.pageAtt) {  // Attaque réussie
                c.setPtVie(c.getPtVie() - this.degAtt);
                System.out.println("L'archer tire et touche " + c.getNom() + ", infligeant " + this.degAtt + " dégâts.");
            } else {
                System.out.println("L'archer rate son tir sur " + c.getNom() + ".");
            }
            this.nbFleches = this.nbFleches - 1; // L'archer utilise une flèche.
        } else {
            if (this.nbFleches == 0){
                System.out.println("Vous êtes à court de flèches") ;
            }else{
                System.out.println("La cible est hors de portée pour un tir à distance.");
            }
        }
    }

    /**
     * Affiche les informations de l'archer, y compris le nombre de flèches restantes.
     */
    @Override
    public void affiche() {
        super.affiche();
        System.out.println("Nombre de flèches: " + nbFleches);
    }
    
    /**
     * Crée un certain nombre d'archers aléatoirement positionnés sur la carte et les ajoute à la liste des créatures.
     * 
     * @param liste Liste des créatures.
     * @param liste_objets Liste des objets sur la carte.
     */
    public void crea_archer(ArrayList<Creature> liste, ArrayList<Objet> liste_objets) {
        String n = "Archer";
        Archer arch = new Archer();
        Random random = new Random() ;
        int x = random.nextInt(50) ;
        int y = random.nextInt(50) ;
        Point2D pos = new Point2D(x,y) ;
        arch.setPos(pos) ;
        deplace_memoire(arch, liste, liste_objets);
        arch.setNom(n);
        arch.setPtVie();
        liste.add(arch);
        
    }
    
    /**
     * Retourne une chaîne de caractères représentant les attributs de l'archer
     * pour la sauvegarde dans un fichier texte.
     *
     * @return String Les attributs de l'archer sous forme de texte.
     */
    @Override
    public String getTexteSauvegarde() {
        return "Archer;" + getNom() + ";" + getPos().getX() + ";" + getPos().getY() + ";"
                + getPtVie() + ";" + getDegAtt() + ";" + getPageAtt() + ";" + getPagePar() + ";"
                + getDistAttMax()+";"+getNbFleches();
    }

}

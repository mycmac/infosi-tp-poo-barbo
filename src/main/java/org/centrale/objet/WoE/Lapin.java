package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Classe représentant un lapin, un type de monstre dans le jeu. 
 * Le lapin hérite des attributs de base des monstres.
 */
public class Lapin extends Monstre {

    /**
     * Constructeur de la classe Lapin avec tous les paramètres.
     * 
     * @param n Nom du lapin.
     * @param ptVie Points de vie du lapin.
     * @param degAtt Dégâts d'attaque du lapin.
     * @param ptPar Points de parade du lapin.
     * @param pageAtt Page d'attaque (probabilité de réussir une attaque).
     * @param pagePar Page de parade (probabilité de réussir une parade).
     * @param pos Position du lapin sur la carte.
     * @param inventaire Inventaire d'objets que possède le lapin.
     */
    public Lapin(String n, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos, ArrayList<ObjetNumero> inventaire) {
        super(n, ptVie, degAtt, ptPar, pageAtt, pagePar, pos, inventaire);
    }

    /**
     * Constructeur de copie pour créer un lapin à partir d'un autre lapin.
     * 
     * @param i Le lapin à copier.
     */
    public Lapin(Lapin i) {
        super(i);
    }

    /**
     * Constructeur par défaut de la classe Lapin.
     */
    public Lapin() {
        super();
    }

    /**
     * Crée plusieurs lapins aléatoirement positionnés sur la carte 
     * et les ajoute à la liste des créatures.
     * 
     * @param liste Liste des créatures présentes sur la carte.
     * @param liste_objets Liste des objets présents sur la carte.
     */
    public void crea_lapin(ArrayList<Creature> liste, ArrayList<Objet> liste_objets) {
        String n = "Lapin";
        Lapin arch = new Lapin();
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
     * Retourne une chaîne de caractères représentant les attributs du lapin
     * pour la sauvegarde dans un fichier texte.
     *
     * @return String Les attributs de l'archer sous forme de texte.
     */
    
    public String getTexteSauvegarde() {
        return "Lapin;" + getNom() + ";" + getPos().getX() + ";" + getPos().getY() + ";"
                + getPtVie() + ";" + getDegAtt() + ";" + getPageAtt() + ";" + getPagePar();
    }


}
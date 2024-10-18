package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Classe représentant un paysan dans le jeu.
 * Le paysan est un type de personnage sans particularité spécifique, mais il hérite des attributs de base d'un personnage.
 * Cette classe hérite de la classe Personnage.
 */
public class Paysan extends Personnage {

    /**
     * Constructeur avec paramètres pour créer un paysan avec des valeurs spécifiques.
     * 
     * @param n Nom du paysan.
     * @param pV Points de vie du paysan.
     * @param dA Dégâts d'attaque du paysan.
     * @param pPar Points de parade du paysan.
     * @param paAtt Page d'attaque (probabilité de réussir une attaque).
     * @param paPar Page de parade (probabilité de réussir une parade).
     * @param dMax Distance d'attaque maximale du paysan.
     * @param p Position du paysan sur la carte.
     * @param inventaire Inventaire d'objets que possède le paysan.
     */
    public Paysan(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p, ArrayList<ObjetNumero> inventaire) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p, inventaire);
    }

    /**
     * Constructeur de copie pour créer un paysan à partir d'un autre paysan.
     * 
     * @param p Le paysan à copier.
     */
    public Paysan(Paysan p) {
        super(p);
    }

    /**
     * Constructeur par défaut pour créer un paysan avec des valeurs par défaut.
     */
    public Paysan() {
        super();
    }

    /**
     * Affiche les informations du paysan, y compris un message indiquant qu'il n'a pas de particularité supplémentaire.
     */
    @Override
    public void affiche() {
        super.affiche();
        System.out.println("Paysan sans particularité supplémentaire.");
    }

    /**
     * Crée plusieurs paysans aléatoirement positionnés sur la carte et les ajoute à la liste des créatures.
     * 
     * @param liste Liste des créatures présentes sur la carte.
     * @param liste_objets Liste des objets présents sur la carte.
     */
    public void crea_paysan(ArrayList<Creature> liste, ArrayList<Objet> liste_objets) {
        String n = "Paysan" ;
        Paysan arch = new Paysan();
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
                + getDistAttMax();
    }
    
}
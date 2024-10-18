package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe représentant un guerrier, un type de personnage spécialisé dans le combat au corps à corps.
 * Le guerrier utilise une épée et peut attaquer les créatures à courte distance.
 */
public class Guerrier extends Personnage implements Combattant {
    private Epee e = new Epee(); // L'épée utilisée par le guerrier
    

    /**
     * Constructeur de la classe Guerrier avec tous les paramètres.
     * 
     * @param n Nom du guerrier.
     * @param pV Points de vie du guerrier.
     * @param dA Dégâts d'attaque du guerrier.
     * @param pPar Points de parade du guerrier.
     * @param paAtt Page d'attaque (probabilité de réussir une attaque).
     * @param paPar Page de parade (probabilité de réussir une parade).
     * @param dMax Distance d'attaque maximale du guerrier.
     * @param p Position du guerrier sur la carte.
     * @param e L'épée du guerrier.
     * @param inventaire Inventaire des objets que possède le guerrier.
     */
    public Guerrier(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p, Epee e, ArrayList<ObjetNumero> inventaire) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p, inventaire);
        this.e = e;
    }

    /**
     * Constructeur de copie pour créer un guerrier à partir d'un autre guerrier.
     * 
     * @param g Le guerrier à copier.
     */
    public Guerrier(Guerrier g) {
        super(g);
        this.e = g.e;
    }

    /**
     * Constructeur par défaut de la classe Guerrier.
     * Il attribue une puissance aléatoire comprise entre 25 et 100 à l'épée 
     */
    public Guerrier() {
        super() ;        
        Random random = new Random() ;
        int rand = random.nextInt(75) + 25 ;
        e.setPuissance(rand) ;
    }

    /**
     * Méthode permettant au guerrier de combattre une créature au corps à corps.
     * Si la créature est à une distance de 1, le guerrier tente une attaque.
     * 
     * @param c La créature que le guerrier attaque.
     */
    @Override
    public void combattre(Creature c) {
        Random rand = new Random();
        double distance = this.pos.distanceTo(c.getPos());

        if (distance == 1) {  // Combat au corps à corps
            int jetAttaque = rand.nextInt(100) + 1;
            if (jetAttaque <= this.pageAtt) {  // Attaque réussie
                System.out.println("Le guerrier attaque " + c.getNom() + " avec succès !");
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
                System.out.println("Le guerrier rate son attaque contre " + c.getNom() + ".");
            }
        } else {
            System.out.println("La cible est trop loin pour un combat au corps à corps.");
        }
    }

    /**
     * Affiche les informations du guerrier, y compris l'épée utilisée.
     */
    @Override
    public void affiche() {
        super.affiche();
        //System.out.println("Nombre de flèches: " + e);
    }

    /**
     * Crée plusieurs guerriers aléatoirement positionnés sur la carte 
     * et les ajoute à la liste des créatures.
     * 
     * @param liste Liste des créatures présentes sur la carte.
     * @param liste_objets Liste des objets présents sur la carte.
     */
    public void crea_guerrier(ArrayList<Creature> liste, ArrayList<Objet> liste_objets) {
        String n = "Guerrier";
        Guerrier g = new Guerrier();
        Random random = new Random() ;
        int x = random.nextInt(50) ;
        int y = random.nextInt(50) ;
        Point2D pos = new Point2D(x,y) ;
        g.setPos(pos) ;
        deplace_memoire(g, liste, liste_objets);
        g.setNom(n);
        g.setPtVie();
        liste.add(g);
        
    }
    
    /**
     * Retourne une chaîne de caractères représentant les attributs du guerrier
     * pour la sauvegarde dans un fichier texte.
     *
     * @return String Les attributs de l'archer sous forme de texte.
     */
    @Override
    public String getTexteSauvegarde() {
        return "Guerrier;" + getNom() + ";" + getPos().getX() + ";" + getPos().getY() + ";"
                + getPtVie() + ";" + getDegAtt() + ";" + getPageAtt() + ";" + getPagePar() + ";"
                + getDistAttMax();
    }

}
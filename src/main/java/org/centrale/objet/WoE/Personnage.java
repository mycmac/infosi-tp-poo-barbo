package org.centrale.objet.WoE;

import java.util.Random;

public abstract class Personnage extends Creature {
    private int distAttMax;

    // Constructeur par défaut
    public Personnage() {
        super();  // Appel au constructeur par défaut de Creature
        this.nom = null;
        this.distAttMax = 0;
    }

    // Constructeur avec paramètres
    public Personnage(String n, int pV, int dA, int pPar, int paAtt, int paPar, int distAttMax, Point2D p) {
        super(pV, dA, pPar, paAtt, paPar, p);  // Appel au constructeur de Creature
        this.nom = n;
        this.distAttMax = distAttMax;
    }
    public Personnage(int a){
        super(a);
        switch (a){
            case 1 : 
                this.distAttMax = 5; 
                break;
            case 2 : 
                 this.distAttMax = 1;
                 break;
                  
            case 3 :                 
                this.distAttMax = 0;
                break;

        }
    }

    // Constructeur de copie
    public Personnage(Personnage pers) {
        super(pers);  // Appel au constructeur de copie de Creature
        this.nom = pers.nom;
        this.distAttMax = pers.distAttMax;
    }

    // Accesseurs et mutateurs pour les attributs spécifiques à Personnage

    public int getDistAttMax() {
        return distAttMax;
    }

    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    /*@Override
    public void deplace() {
        Random rand = new Random();
        // Générer des déplacements aléatoires sur l'axe X et Y
        int dx = rand.nextInt(3) - 1;  // Valeurs possibles : -1, 0, 1
        int dy = rand.nextInt(3) - 1;  // Valeurs possibles : -1, 0, 1

        // Déplacer le personnage en ajoutant dx et dy à sa position actuelle
        pos.translate(dx, dy);

        System.out.println("Personnage déplacé à la position : " + pos);
    }
*/
    @Override
    public void affiche() {
        System.out.println("Nom :" + nom + ", " + "Point de vie "+ ptVie + ", "+degAtt+ ", "+ ptPar + ", "+ pageAtt +", " + distAttMax + ", " + "Position :"+ pos);
    }
    
/*    
    @Override
    public float distance(Point2D p){
        return (float) Math.sqrt(Math.pow(p.getY() - this.pos.getY(), 2) + Math.pow(p.getX() - this.pos.getX(), 2));
    }
*/
    @Override
    public void combattre(Creature c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

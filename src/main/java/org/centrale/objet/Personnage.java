package com.mycompany.projet_git;
import java.util.Random;
public class Personnage {
    private String nom ;
    private int ptVie ;
    private int degAtt ;
    private int ptPar ;
    private int pageAtt ;
    private int pagePar ; 
    private int distAttMax ;
    private Point2D pos ;
    
    //Constructeur par défaut 
    
    public Personnage(){
        this.nom = null;
        this.ptVie = 0 ;
        this.degAtt = 0 ;
        this.ptPar = 0 ;
        this.pageAtt = 0 ;
        this.pagePar = 0 ;
        this.distAttMax = 0 ;
        this.pos = new Point2D() ;
    }
    
    //Constructeur avec paramètres
    
    public Personnage(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dmax, Point2D p){
        this.nom = n;
        this.ptVie = pV ;
        this.degAtt = dA ;
        this.ptPar = pPar ;
        this.pageAtt = paAtt ;
        this.pagePar = paPar ;
        this.distAttMax = dmax ;
        this.pos = p ;
    }
    
    //Constructeur de copie
    
    public Personnage(Personnage pers){
        this.nom = pers.nom;
        this.ptVie = pers.ptVie ;
        this.degAtt = pers.degAtt ;
        this.ptPar = pers.ptPar ;
        this.pageAtt = pers.pageAtt ;
        this.pagePar = pers.pagePar ;
        this.distAttMax = pers.distAttMax ;
        this.pos = pers.pos ;
    }
    
    //Accesseur pour le nom
    
    public String getNom(){
        return nom ;
    }
    
    public void setNom(String n){
        this.nom = n;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }

    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    public int getPtVie() {
        return ptVie;
    }

    public int getDegAtt() {
        return degAtt;
    }

    public int getPtPar() {
        return ptPar;
    }

    public int getPageAtt() {
        return pageAtt;
    }

    public int getPagePar() {
        return pagePar;
    }

    public int getDistAttMax() {
        return distAttMax;
    }

    public Point2D getPos() {
        return pos;
    }
    
    public void deplace() {
        Random rand = new Random();
        // Générer des déplacements aléatoires sur l'axe X et Y
        int dx = rand.nextInt(3) - 1;  // Valeurs possibles : -1, 0, 1
        int dy = rand.nextInt(3) - 1;  // Valeurs possibles : -1, 0, 1

        // Déplacer le personnage en ajoutant dx et dy à sa position actuelle
        pos.translate(dx, dy);

        System.out.println("Personnage déplacé à la position : " + pos);
    }
    
    public void affiche() {
        System.out.println("Nom :" + nom + ", " + "Point de vie "+ ptVie + ", "+degAtt+ ", "+ ptPar + ", "+ pageAtt +", " + distAttMax + ", " + "Position :"+ pos);
    }
}

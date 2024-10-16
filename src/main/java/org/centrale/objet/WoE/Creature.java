package org.centrale.objet.WoE;
import java.util.ArrayList;
import java.util.Random;
/**
 * Classe abstraite représentant une créature dans le jeu. 
 * Chaque créature a des points de vie, des capacités d'attaque et de parade, ainsi qu'une position dans l'espace.
 */
public abstract class Creature implements deplacable {
    /**
     * Points de vie de la créature.
     * La créature perd des points de vie lorsqu'elle subit des attaques.
     */
    protected int ptVie; 

    /**
     * Nom de la créature.
     * Sert à identifier la créature dans le jeu.
     */
    protected String nom; 

    /**
     * Dégâts d'attaque de la créature.
     * Représente la force de l'attaque de la créature lorsqu'elle combat une autre créature.
     */
    protected int degAtt;

    /**
     * Points de parade de la créature.
     * Représente la capacité de la créature à se défendre contre les attaques ennemies.
     */
    protected int ptPar;  

    /**
     * Page d'attaque de la créature.
     * Représente la vitesse avec laquelle la créature peut attaquer dans un tour de jeu.
     */
    protected int pageAtt;  

    /**
     * Page de parade de la créature.
     * Représente la vitesse avec laquelle la créature peut se défendre dans un tour de jeu.
     */
    protected int pagePar;  

    /**
     * Position de la créature dans l'espace de jeu.
     * Représente la position de la créature sur la grille de jeu.
     */
    protected Point2D pos; 

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
            /**
            * Points de vie de la créature.
            */
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
    /**
 * Permet de créer un personage avec les caractétistiques qui lui correspondent
 *
 * @param 1 archer 
 * @param 2 Guerrier
 * @param 3 Paysan 
 * @param 4 Loup 
 * @param 5 Lapin
 */
    public Creature(int a){   // cette fonction permeet de créer des personnage avec les proba 
        Random rand = new Random();
        this.ptVie = 100;
        this.pos = new Point2D(); 
        this.pos.setX(25);
        this.pos.setY(25);
        switch (a) {
            case 1:
                this.degAtt = rand.nextInt(21) +40  ;
                this.ptPar = rand.nextInt(11) +30  ;
                this.pageAtt =rand.nextInt(11) +60  ;
                this.pagePar = rand.nextInt(11) +40  ;
                //this.pos = new Point2D(); 
                break;
            case 2:
                this.degAtt = rand.nextInt(21) +60  ;
                this.ptPar = rand.nextInt(11) +30  ;
                this.pageAtt =rand.nextInt(11) +70  ;
                this.pagePar = rand.nextInt(11) +40  ;
                //this.pos = new Point2D();
                break;
            case 3:
                this.degAtt = 0 ;
                this.ptPar = rand.nextInt(11) +30  ;
                this.pageAtt =0  ;
                this.pagePar = rand.nextInt(11) +10  ;
                //this.pos = new Point2D();
                break;
            case 4:
                this.degAtt = rand.nextInt(21) +50  ;
                this.ptPar = 0 ;
                this.pageAtt =rand.nextInt(11) +60  ;
                this.pagePar = rand.nextInt(11) +10  ;
                //this.pos = new Point2D(); 
                break;
            case 5:
                this.degAtt = rand.nextInt(11) +20  ;
                this.ptPar = 0 ;
                this.pageAtt =rand.nextInt(11) +60  ;
                this.pagePar = rand.nextInt(11) +10  ;
                //this.pos = new Point2D();   
                break; 
                
        }

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
    public void setPtVie(){
        Random random = new Random();
        int rand = random.nextInt(100);
        this.ptVie = rand; 
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
        //System.out.println("Creature déplacée à la position : " + pos);
    }

    /**
     * Affiche les informations de la créature.
     */
    public void affiche() {
        System.out.println("Creature{" + "ptVie=" + ptVie + ", degAtt=" + degAtt + ", ptPar=" + ptPar
                + ", pageAtt=" + pageAtt + ", pagePar=" + pagePar + ", pos=" + pos + '}');
    }
        /**
     * Récupère des points de vie. Le total ne doit pas dépasser 100.
     *
     * @param point Le nombre de points à récupérer.
     */
    public void recuperePointDeVie(int point){
        this.ptVie= this.ptVie+point; 
        if (this.ptVie> 100){
            this.ptVie=100;// un personnage ne peut pas avoir plus de 100 point de vie
        }
    }
    
    /**
     * Renvoie la position de la créature sous forme de liste.
     *
     * @param crea La créature dont on souhaite la position.
     * @return Une liste d'entiers représentant la position (x, y).
     */
    public ArrayList<Integer> retourpos(Creature crea){ // met la position sous forme de vecteur 
        ArrayList<Integer> a= new ArrayList<>();
        a.add(crea.getPos().getX());
        a.add(crea.getPos().getY()); 
        return a; 
        
    }
    /**
 * Déplace la créature vers une case libre (non occupée).
 * 
 * Cette méthode tente de déplacer la créature vers une nouvelle position. 
 * Elle prend en compte la liste des autres créatures pour s'assurer que 
 * la position cible n'est pas déjà occupée.
 *
 * @param crea La créature à déplacer.
 * @param a La liste des autres créatures pour vérifier la disponibilité des cases.
 */
    public void dplt_case_libre(Creature crea, ArrayList<Creature> a){
        ArrayList<ArrayList<Integer >> position_crea = new ArrayList<>();
        ArrayList<Integer> position_act= new ArrayList<>();
        for (int y=0; y < a.size();y++ ){    // créer un vecteur de poosition 
            position_crea.add(retourpos(a.get(y)));       
        } 
        do{ 
            crea.deplace();
            if(crea.getPos().getX()< 0){ // evite d'avoir une boucle infinie on remet la position à 0 
                crea.getPos().setX(0);
            }
            if(crea.getPos().getY()< 0){
                crea.getPos().setY(0);
            }
            if(crea.getPos().getY() > 50 ){
                crea.getPos().setY(50);
            }
            if(crea.getPos().getY()> 50){
                crea.getPos().setY(50);
            }
            position_act = retourpos(crea);
            
         
            
        }while(position_crea.contains(position_act) || (crea.getPos().getX()< 0) || (crea.getPos().getY()< 0)|| (crea.getPos().getX()>50) || (crea.getPos().getY()> 50 ) );
    }
    /**
 * Affiche les informations des créatures à portée d'attaque du personnage.
 *
 * Cette méthode parcourt la liste des créatures et vérifie si elles se trouvent 
 * à une distance inférieure ou égale à la distance d'attaque maximale du personnage.
 * Si c'est le cas, elle affiche la position et le nom de ces créatures.
 *
 * @param a La liste des créatures dans l'environnement.
 * @param crea Le personnage dont on vérifie la portée d'attaque.
 */
    public void affiche_monstre(ArrayList<Creature> a, Personnage crea){
        for(int i=0; i<a.size();i++){
            if(a.get(i).getPos().distanceTo(crea.getPos())<=crea.getDistAttMax()){
                System.out.print(a.get(i).getPos());
                System.out.println(a.get(i).getNom());

            }
        }
    }
    /**
 * Recherche une créature par son nom dans une liste de créatures.
 *
 * Cette méthode parcourt la liste des créatures et retourne celle qui a le même nom
 * que le nom fourni en paramètre. Si aucune créature avec ce nom n'est trouvée,
 * elle retourne `null`.
 *
 * @param nom Le nom de la créature à rechercher.
 * @param a La liste des créatures dans l'environnement.
 * @return La créature correspondante au nom, ou `null` si elle n'est pas trouvée.
 */
    public Creature retournecrea(String nom,ArrayList<Creature> a){
        for(int i=0; i<a.size();i++){
            if(a.get(i).getNom().equals(nom)){
                return a.get(i);
            }
        }
        return null;
    }
    /**
 * Déplace tous les monstres dans la liste de créatures en utilisant la méthode
 * de déplacement `dplt_case_libre`.
 *
 * Cette méthode parcourt la liste de créatures (monstres) et pour chaque monstre,
 * elle appelle la fonction `dplt_case_libre` pour déplacer le monstre dans une
 * case vide de l'environnement (sans chevaucher une autre créature et à l'intérieur des limites).
 * 
 * @param a La liste des créatures (monstres) à déplacer.
 */
    public void deplacemonstre(ArrayList<Creature> a){
        for(int i=0; i<a.size();i++){
            dplt_case_libre(a.get(i),  a);
        }
            
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;
import java.util.ArrayList;

public class World {
    private Lapin bugs1= new Lapin();
    private Lapin bugs2= new Lapin();
    private Archer robin=new Archer();
    private Paysan peon= new Paysan();
    private Archer guillaumeT = new Archer() ;
    //private Guerrier grosBill = new Guerrier();
    //private Loup wolfie = new Wolfie();
    
    
    public World(){
        
    }
    
    public void creerMondeAlea() {
        
        Random generateurAleatoire = new Random();  // Assurez-vous que vous avez un générateur aléatoire
        /*
        // Position du Lapin
        int xl = generateurAleatoire.nextInt(100);
        int yl = generateurAleatoire.nextInt(100);
        bugs1.getPos().setX(xl);
        bugs1.getPos().setY(yl);

        // Position de l'Archer
        int xar, yar;
        do {
            xar = generateurAleatoire.nextInt(100);
            yar = generateurAleatoire.nextInt(100);
        } while (xl == xar && yl == yar);  // Vérifie que l'Archer n'est pas à la même position que le Lapin
        robin.getPos().setX(xar);
        robin.getPos().setY(yar);

        // Position du Paysan
        int xpa, ypa;
        do {
            xpa = generateurAleatoire.nextInt(100);
            ypa = generateurAleatoire.nextInt(100);
        } while ((xl == xpa && yl == ypa) || (xar == xpa && yar == ypa));  // Vérifie que le Paysan n'est pas à la même position que le Lapin ou l'Archer
        peon.getPos().setX(xpa);
        peon.getPos().setY(ypa);
        
        int x2, y2;
        do {
            x2 = generateurAleatoire.nextInt(100);
            y2 = generateurAleatoire.nextInt(100);
        } while ((xpa == x2 && ypa == y2) ||(xl == x2 && yl == y2) || (xar == x2 && yar == y2));                                           // Vérifie que le lapin2 n'est pas à la même position que le Paysan 
        bugs2.getPos().setX(x2);
        bugs2.getPos().setY(y2);
        
        int xgu, ygu;
        do {
            xgu = generateurAleatoire.nextInt(100);
            ygu = generateurAleatoire.nextInt(100);
        } while ((x2 == xgu && y2 == ygu )||(xpa == xgu && ypa == ygu) ||(xl == xgu && yl == ygu) || (xar == xgu && yar == ygu));  // Vérifie que guillaume n'est pas à la même position que le Paysan Lapin2
        guillaumeT.getPos().setY(ygu);
        guillaumeT.getPos().setX(xgu);
        /*
        int xgro, ygro;
        do {
            xgro = generateurAleatoire.nextInt(100);
            ygro = generateurAleatoire.nextInt(100);
        } while ((xgro == xgu && ygro == ygu)||(x2 == xgro && y2 == ygro )||(xpa == xgro && ypa == ygro) ||(xl == xgro && yl == ygro) || (xar == xgro && yar == ygro));  // Vérifie que guillaume n'est pas à la même position que le Paysan Lapin2
        grosBill.getPos().setY(ygro);        
        grosBill.getPos().setX(xgro);   
        
          int xwol, ywol;
        do {
            xwol = generateurAleatoire.nextInt(100);
            ywol = generateurAleatoire.nextInt(100);
        } while ((xwol == xgro && ywol == ygro)||(xwol == xgu && ywol == ygu)||(x2 == xwol && y2 == ywol )||(xpa == xwol && ypa == ywol) ||(xl == xwol && yl == ywol) || (xar == xwol && yar == ywol));  // Vérifie que guillaume n'est pas à la même position que le Paysan Lapin2
        wolfie.getPos().setY(ywol);        
        wolfie.getPos().setX(xwol);   
        */
        
        
        // Affichage des positions initiales ( inutile car on a la fonction afiche wolrd 
        /*System.out.println("Position initiale de bugs (Lapin) : " + bugs.getPos());
        System.out.println("Position initiale de robin (Archer) : " + robin.getPos());
        //System.out.println("Position initiale de peon (Paysan) : " + peon.getPos());
        System.out.println("Position initiale de guillaumeT (Archer) : " + guillaumeT.getPos());

        // Déplacement aléatoire des personnages
        bugs.deplace();
        robin.deplace();
        //peon.deplace();
        //guillaumeT.deplace();

        // Affichage des positions après déplacement
        System.out.println("\nAprès déplacement :");
        //System.out.println("Position de bugs (Lapin) : " + bugs.getPos());
        System.out.println("Position de robin (Archer) : " + robin.getPos());
        //System.out.println("Position de peon (Paysan) : " + peon.getPos());
        System.out.println("Position initiale de guillaumeT (Archer) : " + guillaumeT.getPos());      
    }
    public void tourdejeu(){
        
    }
    
    public void afichewworld(){
        System.out.println("Position bugs1 : " + bugs1.getPos());
        System.out.println("Position bugs2 : " + bugs2.getPos());
        System.out.println("Position robin: " + robin.getPos());
        System.out.println("Position peon : " + peon.getPos());
        System.out.println("Position guillaumeT : " + guillaumeT.getPos());
        /*System.out.println("Position grosbill  : " + grosBill.getPos());
        System.out.println("Position wolfi : " + wolfie.getPos());
    }
    */
    ArrayList<Creature> cre_monde = new ArrayList<>(); 
    ArrayList<Objet> obj_monde = new ArrayList<>();

    public void creation(){
        
        Archer a = new Archer() ;
        a.crea_archer(liste_creatures) ;
        
        
        Guerrier g = new Guerrier();
        g.crea_guerrier(liste_creatures);
        
        Paysan p = new Paysan();
        p.crea_paysan(liste_creatures);
        
        Loup l = new Loup();
        l.crea_loup(liste_creatures);
        
        Lapin lap = new Lapin();
        lap.crea_lapin(liste_creatures);
        
        Epee e = new Epee();
        e.crea_epee(liste_objets);
        
        PotionSoin pot = new PotionSoin();
        pot.crea_potion_soin(liste_objets);
        
        
        
    }
   
        
}



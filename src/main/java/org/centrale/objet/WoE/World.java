/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;

public class World {
    private Lapin bugs1= new Lapin();
    private Lapin bugs2= new Lapin();
    private Archer robin=new Archer();
    private Paysan peon= new Paysan();
    private Archer guillaumeT = new Archer(robin) ;
    //private Guerrier grosBill = new Guerrier();
    //private Loup wolfie = new Wolfie();
    
    
    public World(){
        
    }
    
    public void creerMondeAlea() {
        
        Random generateurAleatoire = new Random();  // Assurez-vous que vous avez un générateur aléatoire

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
        } while (xpa == x2 && ypa == y2);  // Vérifie que le lapin2 n'est pas à la même position que le Paysan 
        robin.getPos().setX(x2);
        robin.getPos().setY(y2);
        
        int xgu, ygu;
        do {
            xgu = generateurAleatoire.nextInt(100);
            ygu = generateurAleatoire.nextInt(100);
        } while (x2 == xgu && y2 == ygu);  // Vérifie que guillaume n'est pas à la même position que le Paysan Lapin2
        robin.getPos().setY(ygu);

    
        
        
        // Affichage des positions initiales
        //System.out.println("Position initiale de bugs (Lapin) : " + bugs.getPos());
        System.out.println("Position initiale de robin (Archer) : " + robin.getPos());
        //System.out.println("Position initiale de peon (Paysan) : " + peon.getPos());
        System.out.println("Position initiale de guillaumeT (Archer) : " + guillaumeT.getPos());

        // Déplacement aléatoire des personnages
        //bugs.deplace();
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
}


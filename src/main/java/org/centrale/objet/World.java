/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;

public class World {
    private Lapin bugs= new Lapin();
    private Archer robin=new Archer();
    private Paysan peon= new Paysan();
    private Archer guillaumeT = new Archer(robin) ;
    
    
    public void World(){
        
    }
    
    public void creerMondeAlea() {
        
        Random generateurAleatoire = new Random();  // Assurez-vous que vous avez un générateur aléatoire

        // Position du Lapin
        int xl = generateurAleatoire.nextInt(100);
        int yl = generateurAleatoire.nextInt(100);
        bugs.getPos().setX(xl);
        bugs.getPos().setY(yl);

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
    
        
        
        // Affichage des positions initiales
        //System.out.println("Position initiale de bugs (Lapin) : " + bugs.getPos());
        System.out.println("Position initiale de robin (Archer) : " + robin.getPos());
        //System.out.println("Position initiale de peon (Paysan) : " + peon.getPos());
        System.out.println("Position initiale de guillaumeT (Archer) : " + guillaumeT.getPos());

        // Déplacement aléatoire des personnages
        //bugs.deplace();
        robin.deplace();
        //peon.deplace();
        guillaumeT.deplace();

        // Affichage des positions après déplacement
        System.out.println("\nAprès déplacement :");
        //System.out.println("Position de bugs (Lapin) : " + bugs.getPos());
        System.out.println("Position de robin (Archer) : " + robin.getPos());
        //System.out.println("Position de peon (Paysan) : " + peon.getPos());
        System.out.println("Position initiale de guillaumeT (Archer) : " + guillaumeT.getPos());
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;
import java.util.ArrayList;

public class World {
    /* Déclaration de créatures mais commentées
    private Lapin bugs1 = new Lapin();  // Déclaration d'un Lapin nommé bugs1
    private Lapin bugs2 = new Lapin();  // Déclaration d'un Lapin nommé bugs2
    private Archer robin = new Archer();  // Déclaration d'un Archer nommé robin
    private Paysan peon = new Paysan();  // Déclaration d'un Paysan nommé peon
    private Archer guillaumeT = new Archer();  // Déclaration d'un Archer nommé guillaumeT
    //private Guerrier grosBill = new Guerrier();  // Déclaration d'un Guerrier (commenté)
    //private Loup wolfie = new Wolfie();  // Déclaration d'un Loup (commenté)
    */
    
    // Liste des créatures et des objets présents dans le monde
    ArrayList<Creature> liste_creatures = new ArrayList<>();  // Liste des créatures
    ArrayList<Objet> liste_objets = new ArrayList<>();  // Liste des objets

    /*
    La méthode 'creation' permet de créer un certain nombre d'archers, de paysans, de guerriers, etc.
    Chaque fonction a.crea_... permet d'ajouter des créatures ou des objets dans les listes respectives.
    */

    public void creation(){
        // Création et ajout des créatures à la liste 'liste_creatures'
        Archer a = new Archer();  // Création d'un nouvel Archer
        a.crea_archer(liste_creatures);  // Ajout de 20 archers à la liste des créatures
        
        Guerrier g = new Guerrier();  // Création d'un nouveau Guerrier
        g.crea_guerrier(liste_creatures);  // Ajout de 20 guerriers à la liste des créatures
        
        Paysan p = new Paysan();  // Création d'un nouveau Paysan
        p.crea_paysan(liste_creatures);  // Ajout de 20 paysans à la liste des créatures
        
        Loup l = new Loup();  // Création d'un nouveau Loup
        l.crea_loup(liste_creatures);  // Ajout de 20 loups à la liste des créatures
        
        Lapin lap = new Lapin();  // Création d'un nouveau Lapin
        lap.crea_lapin(liste_creatures);  // Ajout de 20 lapins à la liste des créatures
        
        // Création et ajout des objets à la liste 'liste_objets'
        Epee e = new Epee();  // Création d'une nouvelle épée
        e.crea_epee(liste_objets);  // Ajout de 20 épées à la liste des objets
        
        PotionSoin pot = new PotionSoin();  // Création d'une nouvelle potion de soin
        pot.crea_potion_soin(liste_objets);  // Ajout de 20 potions de soin à la liste des objets
        
        // Commenté: Code qui additionne les points de vie de toutes les créatures et les affiche
//        int longueur = liste_creatures.size();
//        int pvTotal = 0; 
//        for (int i = 0; i < longueur; i++) {
//            pvTotal = pvTotal + liste_creatures.get(i).getPtVie();  // Additionne les points de vie des créatures
//        }
        
        // Affichage des positions de toutes les créatures
        for (int i = 0; i < liste_creatures.size(); i++) {
            System.out.println("Position " + liste_creatures.get(i).getNom() + liste_creatures.get(i).getPos());  // Affiche le nom et la position de chaque créature
        }
    }
}


    














































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



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet;

import java.util.Random;

public class World {

    private Lapin bugs = new Lapin();
    private Archer robin = new Archer();
    private Paysan peon = new Paysan();
    private Archer guillaumeT= new Archer(robin);
    

    public World() {

    }

    public void creerMondeAlea() {
        Random generateurAleatoire = new Random();  // Assurez-vous que vous avez un générateur aléatoire

        // Position du Lapin
        int xl = generateurAleatoire.nextInt(100);
        int yl = generateurAleatoire.nextInt(100);
        bugs.getPos().setx(xl);
        bugs.getPos().sety(yl);

        // Position de l'Archer
        int xar, yar;
        do {
            xar = generateurAleatoire.nextInt(100);
            yar = generateurAleatoire.nextInt(100);
        } while (xl == xar && yl == yar);  // Vérifie que l'Archer n'est pas à la même position que le Lapin
        robin.getPos().setx(xar);
        robin.getPos().sety(yar);

        // Position du Paysan
        int xpa, ypa;
        do {
            xpa = generateurAleatoire.nextInt(100);
            ypa = generateurAleatoire.nextInt(100);
        } while ((xl == xpa && yl == ypa) || (xar == xpa && yar == ypa));  // Vérifie que le Paysan n'est pas à la même position que le Lapin ou l'Archer
        peon.getPos().setx(xpa);
        peon.getPos().sety(ypa);
    }

}

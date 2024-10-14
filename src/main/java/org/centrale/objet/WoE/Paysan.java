/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Random;

public class Paysan extends Personnage {

    public Paysan(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
    }

    public Paysan(Paysan p) {
        super(p);
    }

    public Paysan() {
        super();
    }
    public Paysan(int a ) {
        super(a );
    }
    @Override
    public void affiche() {
        super.affiche();
        System.out.println("Paysan sans particularité supplémentaire.");
    }
    public void  crea_paysan(ArrayList<Creature> a){
    Random random= new Random();
    int alea = random.nextInt(100);

    for (int i=0; i<20; i++ ){ // on met 20 pour placer les 100 protaganistes 
        String n = "Paysan" + i;
        Paysan pa= new Paysan();
        pa.setNom(n);
        pa.setPtVie();
        pa.dplt_case_libre(pa,a);
        a.add(pa);
    }
    } 
}

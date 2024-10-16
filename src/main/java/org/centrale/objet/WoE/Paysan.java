/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Random;

public class Paysan extends Personnage {

    // Constructeur avec paramètres pour initialiser un Paysan avec des caractéristiques spécifiques
    public Paysan(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);  // Appel au constructeur de Personnage avec les mêmes paramètres
    }

    // Constructeur de copie pour créer un Paysan à partir d'un autre Paysan
    public Paysan(Paysan p) {
        super(p);  // Appel au constructeur de copie de Personnage
    }

    // Constructeur par défaut pour créer un Paysan sans initialisation d'attributs
    public Paysan() {
        super();  // Appel au constructeur par défaut de Personnage
    }

    // Constructeur avec un entier pour initialiser le Paysan avec un paramètre spécifique
    public Paysan(int a ) {
        super(a );  // Appel au constructeur de Personnage avec un paramètre entier
    }

    // Méthode pour afficher les caractéristiques du Paysan
    @Override
    public void affiche() {
        super.affiche();  // Appel à la méthode affiche() de la classe Personnage pour afficher les attributs communs
        System.out.println("Paysan sans particularité supplémentaire.");  // Affichage spécifique au Paysan
    }

    // Méthode pour créer 20 paysans et les ajouter à une liste
    public void  crea_paysan(ArrayList<Creature> a){
        Random random= new Random();  // Création d'un générateur de nombres aléatoires
        int alea = random.nextInt(100);  // Génération d'un nombre aléatoire entre 0 et 99

        for (int i=0; i<20; i++ ){  // Boucle pour créer 20 paysans
            String n = "Paysan" + i;  // Nom du paysan généré dynamiquement
            Paysan pa= new Paysan(3);  // Création d'un nouveau paysan avec l'ID 3
            pa.setNom(n);  // Assignation du nom au paysan
            pa.setPtVie();  // Initialisation des points de vie du paysan
            pa.dplt_case_libre(pa,a);  // Déplacement du paysan vers une case libre
            a.add(pa);  // Ajout du paysan à la liste de créatures
        }
    }
}


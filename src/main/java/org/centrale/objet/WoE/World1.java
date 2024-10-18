/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.Iterator ;

public class World1 {
/*    
    public World1(){
        
    }
    
        // Liste des créatures
    LinkedList<Creature> liste_creatures_lc = new LinkedList<>();

    // Méthode qui calcule le nombre total de points de vie avec une boucle basée sur la taille
    public void calculerPointsDeVieAvecTaille_lc() {
        
        Random rand = new Random();

        // Créer des instances de tes créatures
        Archer archer = new Archer();
        Guerrier guerrier = new Guerrier();
        Paysan paysan = new Paysan();
        Loup loup = new Loup();
        Lapin lapin = new Lapin();

        // Associer chaque méthode à un numéro dans une Map
        Map<Integer, Runnable> actions = new HashMap<>();
        actions.put(1, () -> archer.crea_archer_lc(liste_creatures_lc));
        actions.put(2, () -> guerrier.crea_guerrier_lc(liste_creatures_lc));
        actions.put(3, () -> paysan.crea_paysan_lc(liste_creatures_lc));
        actions.put(4, () -> loup.crea_loup_lc(liste_creatures_lc));
        actions.put(5, () -> lapin.crea_lapin_lc(liste_creatures_lc));

        // Boucle jusqu'à avoir 100 créatures dans la LinkedList
        while (liste_creatures_lc.size() != 100) {
            int alea = rand.nextInt(5) + 1;  // Génère un nombre aléatoire entre 1 et 5
            actions.get(alea).run();         // Exécute l'action correspondante
        }
        
        long startTime = System.nanoTime(); // Démarrage du chronomètre

        int totalPointsDeVie = 0;
        for (int i = 0; i < liste_creatures_lc.size(); i++) {
            totalPointsDeVie += liste_creatures_lc.get(i).getPtVie(); // Assurez-vous que cette méthode existe
        }

        long endTime = System.nanoTime(); // Arrêt du chronomètre
        long duration = endTime - startTime; // Durée en nanosecondes

        System.out.println("Temps avec boucle basée sur la taille : " + duration + " nanosecondes");
        System.out.println("Total points de vie (taille) : " + totalPointsDeVie);
    }

    // Méthode qui calcule le nombre total de points de vie avec une boucle basée sur les itérateurs
    public void calculerPointsDeVieAvecIterateur_lc() {
        
        Random rand = new Random();

        // Créer des instances de tes créatures
        Archer archer = new Archer();
        Guerrier guerrier = new Guerrier();
        Paysan paysan = new Paysan();
        Loup loup = new Loup();
        Lapin lapin = new Lapin();

        // Associer chaque méthode à un numéro dans une Map
        Map<Integer, Runnable> actions = new HashMap<>();
        actions.put(1, () -> archer.crea_archer_lc(liste_creatures_lc));
        actions.put(2, () -> guerrier.crea_guerrier_lc(liste_creatures_lc));
        actions.put(3, () -> paysan.crea_paysan_lc(liste_creatures_lc));
        actions.put(4, () -> loup.crea_loup_lc(liste_creatures_lc));
        actions.put(5, () -> lapin.crea_lapin_lc(liste_creatures_lc));

        // Boucle jusqu'à avoir 100 créatures dans la LinkedList
        while (liste_creatures_lc.size() != 100) {
            int alea = rand.nextInt(5) + 1;  // Génère un nombre aléatoire entre 1 et 5
            actions.get(alea).run();         // Exécute l'action correspondante
        }
        
        long startTime = System.nanoTime(); // Démarrage du chronomètre

        int totalPointsDeVie = 0;
        Iterator<Creature> iterator = liste_creatures_lc.iterator();
        while (iterator.hasNext()) {
            totalPointsDeVie += iterator.next().getPtVie(); // Assurez-vous que cette méthode existe
        }

        long endTime = System.nanoTime(); // Arrêt du chronomètre
        long duration = endTime - startTime; // Durée en nanosecondes

        System.out.println("Temps avec boucle basée sur les itérateurs : " + duration + " nanosecondes");
        System.out.println("Total points de vie (itérateur) : " + totalPointsDeVie);
    }
    
    
        // Liste des créatures sous forme d'ArrayList
    ArrayList<Creature> liste_creatures = new ArrayList<>();

    // Méthode qui calcule le nombre total de points de vie avec une boucle basée sur la taille
    public void calculerPointsDeVieAvecTaille() {
        
        Random rand = new Random();

        // Création des instances des créatures
        Archer archer = new Archer();
        Guerrier guerrier = new Guerrier();
        Paysan paysan = new Paysan();
        Loup loup = new Loup();
        Lapin lapin = new Lapin();

        // Associer chaque méthode à un numéro dans une Map
        Map<Integer, Runnable> actions = new HashMap<>();
        actions.put(1, () -> archer.crea_archer(liste_creatures));
        actions.put(2, () -> guerrier.crea_guerrier(liste_creatures));
        actions.put(3, () -> paysan.crea_paysan(liste_creatures));
        actions.put(4, () -> loup.crea_loup(liste_creatures));
        actions.put(5, () -> lapin.crea_lapin(liste_creatures));
        

        // Boucle jusqu'à avoir 100 créatures
        while (liste_creatures.size() != 100) {
            int alea = rand.nextInt(5) + 1;  // Génère un nombre aléatoire entre 1 et 5
            actions.get(alea).run();         // Exécute l'action correspondante
        }
        
        long startTime = System.nanoTime(); // Démarrage du chronomètre

        int totalPointsDeVie = 0;
        for (int i = 0; i < liste_creatures.size(); i++) {
            totalPointsDeVie += liste_creatures.get(i).getPtVie(); // Assurez-vous que cette méthode existe
        }

        long endTime = System.nanoTime(); // Arrêt du chronomètre
        long duration = endTime - startTime; // Durée en nanosecondes

        System.out.println("Temps avec boucle basée sur la taille (ArrayList) : " + duration + " nanosecondes");
        System.out.println("Total points de vie (taille - ArrayList) : " + totalPointsDeVie);
    }

    // Méthode qui calcule le nombre total de points de vie avec une boucle basée sur les itérateurs
    public void calculerPointsDeVieAvecIterateur() {
        
        Random rand = new Random();

        // Création des instances des créatures
        Archer archer = new Archer();
        Guerrier guerrier = new Guerrier();
        Paysan paysan = new Paysan();
        Loup loup = new Loup();
        Lapin lapin = new Lapin();

        // Associer chaque méthode à un numéro dans une Map
        Map<Integer, Runnable> actions = new HashMap<>();
        actions.put(1, () -> archer.crea_archer(liste_creatures));
        actions.put(2, () -> guerrier.crea_guerrier(liste_creatures));
        actions.put(3, () -> paysan.crea_paysan(liste_creatures));
        actions.put(4, () -> loup.crea_loup(liste_creatures));
        actions.put(5, () -> lapin.crea_lapin(liste_creatures));
        

        // Boucle jusqu'à avoir 100 créatures
        while (liste_creatures.size() != 100) {
            int alea = rand.nextInt(5) + 1;  // Génère un nombre aléatoire entre 1 et 5
            actions.get(alea).run();         // Exécute l'action correspondante
        }
        
        long startTime = System.nanoTime(); // Démarrage du chronomètre

        int totalPointsDeVie = 0;
        Iterator<Creature> iterator = liste_creatures.iterator();
        while (iterator.hasNext()) {
            totalPointsDeVie += iterator.next().getPtVie(); // Assurez-vous que cette méthode existe
        }

        long endTime = System.nanoTime(); // Arrêt du chronomètre
        long duration = endTime - startTime; // Durée en nanosecondes

        System.out.println("Temps avec boucle basée sur les itérateurs (ArrayList) : " + duration + " nanosecondes");
        System.out.println("Total points de vie (itérateur - ArrayList) : " + totalPointsDeVie);
    }
    
 
*/
}

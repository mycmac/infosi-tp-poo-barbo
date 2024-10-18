package org.centrale.objet.WoE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * La classe World2 représente le monde du jeu, contenant les créatures, 
 * les objets, et gérant les actions du joueur. Elle est responsable 
 * de la création du monde, de la gestion des tours de jeu et de l'affichage graphique.
 */
public class World2 {

    /** Liste des créatures présentes dans le monde. */
    protected ArrayList<Creature> liste_creatures;

    /** Le joueur du jeu, qui contrôle un personnage. */
    protected Joueur joueur;

    /** Liste des objets présents sur le terrain. */
    protected ArrayList<Objet> liste_objets;

    /** Référence au nuage toxique présent dans le monde. */
    protected NuageToxique nuage;
    
    
    /**Compteur qui permet de connaître le nombre de tour depuis 
     * lequel le nuage toxique existe.
     */
    protected int compteur_nuage ;

    /**
     * Constructeur par défaut qui initialise le monde avec des créatures, des objets 
     * et un joueur.
     */
    public World2() {
        // Initialiser les attributs dans le constructeur
        liste_objets = new ArrayList<>();
        liste_creatures = new ArrayList<>();
        joueur = new Joueur();  // Crée un nouveau joueur
    }

    /**
     * Crée le monde en générant des créatures, des objets et un joueur.
     * Place aléatoirement des créatures et des objets sur la carte. 
     * Génère un nuage toxique de manière aléatoire.
     */
    public void creation_monde() {

        Random rand = new Random();

        // Créer des instances de créatures (archer, guerrier, paysan, etc.)
        Archer archer = new Archer();
        Guerrier guerrier = new Guerrier();
        Paysan paysan = new Paysan();
        Loup loup = new Loup();
        Lapin lapin = new Lapin();

        // Associer des actions à des numéros dans une map pour créer des créatures
        Map<Integer, Runnable> actions = new HashMap<>();
        actions.put(1, () -> archer.crea_archer(liste_creatures, liste_objets));
        actions.put(2, () -> guerrier.crea_guerrier(liste_creatures, liste_objets));
        actions.put(3, () -> paysan.crea_paysan(liste_creatures, liste_objets));
        actions.put(4, () -> loup.crea_loup(liste_creatures, liste_objets));
        actions.put(5, () -> lapin.crea_lapin(liste_creatures, liste_objets));

        // Boucle jusqu'à avoir 2 créatures dans la liste
        while (liste_creatures.size() != 10) {
            int alea = rand.nextInt(5) + 1;  // Génère un nombre aléatoire entre 1 et 5
            actions.get(alea).run();         // Exécute l'action correspondante
        }

        // Création d'un nuage toxique de manière aléatoire
        Random random = new Random();
        int al = random.nextInt(1) + 1;
        if (al == 1) {
            NuageToxique nuage_tox = new NuageToxique();
            nuage_tox.crea_nuage(liste_objets); 
            compteur_nuage = 1;  // Date de création du nuage
        }

        // Création de 100 objets aléatoirement placés sur la carte
        Objet objet = new Objet();
        while (liste_objets.size() != 10) {
            objet.crea_objet(liste_objets);
        }

        // Création du joueur et ramassage des objets
        joueur.creePerso();
        joueur.rammasser_objet(liste_objets);

        // Affichage graphique du jeu avec une grille
        Personnage joueur_perso = joueur.getPersonnage();
        JeuGrille jeuGrille = new JeuGrille(joueur_perso, liste_creatures, liste_objets, nuage);
        JFrame frame = new JFrame("Grille de jeu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(jeuGrille);  // Ajouter la grille à la fenêtre
        frame.pack();  // Ajuster la taille de la fenêtre
        frame.setVisible(true);  // Afficher la fenêtre

        // Mise à jour de la grille après création du monde
        jeuGrille.mettreAJourGrille(joueur_perso, liste_creatures, liste_objets, nuage);
    }

    /**
     * Retourne la liste des créatures présentes dans le monde.
     *
     * @return Liste des créatures.
     */
    public ArrayList<Creature> getListeCreatures() {
        return liste_creatures;
    }

    /**
     * Retourne le joueur du monde.
     *
     * @return Le joueur.
     */
    public Joueur getJoueur() {
        return joueur;
    }

    /**
     * Gère le déroulement d'un tour de jeu. Le joueur peut se déplacer, 
     * utiliser des objets ou attaquer des créatures.
     * Le nuage toxique est également déplacé si nécessaire.
     */
    public void tour_de_jeu() {
        Random random = new Random() ;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tapez 1 si vous voulez vous déplacer \n2 si vous voulez utiliser un objet depuis votre inventaire \n3 si vous voulez attaquer une créature \n4 si vous voulez sauvergarder votre partie");
        int x = scanner.nextInt();

        // Gestion du déplacement du joueur
        if (x == 1) {
            joueur.deplacement_joueur(liste_creatures);
            joueur.rammasser_objet(liste_objets);
        }

        // Utilisation d'un objet dans l'inventaire
        if (x == 2) {
            Personnage perso = joueur.getPersonnage();
            perso.affiche_inventaire();
            joueur.utiliserObjetInventaire();
        }

        // Attaque d'une créature
        if (x == 3) {
            joueur.attaquerPerso(liste_creatures);
        }
        
        //Sauvergarde d'une partie
        if (x==4){
            System.out.println("Entrez le nom du fichier de sauvegarde : ");
            String nomFichier = scanner.next();
            sauvegardePartie(nomFichier);
        }
        

        // Réaffichage graphique après les actions du joueur
        Personnage joueur_perso = joueur.getPersonnage();
        JeuGrille jeuGrille = new JeuGrille(joueur_perso, liste_creatures, liste_objets, nuage);
        JFrame frame = new JFrame("Grille de jeu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(jeuGrille);
        frame.pack();
        frame.setVisible(true);
        jeuGrille.mettreAJourGrille(joueur_perso, liste_creatures, liste_objets, nuage);

        // Gestion du nuage toxique
        NuageToxique nuage = new NuageToxique();
        if (!nuage.contientNuageToxique(liste_objets)) {
            int alea = random.nextInt(4)+1 ;
            if (alea>1){ // 75% de chance de création d'un nuage
                nuage.crea_nuage(liste_objets);
                compteur_nuage = 1;
            }
        } else {
            NuageToxique ce_nuage = nuage.selectionnerNuageToxique(liste_objets);
            while (compteur_nuage <= 5) {
                ce_nuage.deplace();
                compteur_nuage += 1;
            }
            if (compteur_nuage > 5) {
                liste_objets.remove(ce_nuage);
                compteur_nuage = 0 ;
            }
        }

        // Vérification si le joueur est dans le nuage toxique
        if (nuage.distance_crea_nuage(this.joueur.getPersonnage(), nuage) <= 3) {
            this.joueur.setPtVie(this.joueur.getPtVie() - 5);
            System.out.println("Vous êtes dans le nuage toxique, vous perdez 5 points de vie.");
            System.out.println("Points de vie restants : " + joueur.getPtVie());
        }
        
        
        
    }
    
    /**
     * Méthode pour charger une partie depuis un fichier texte.
     * 
     * @param nomFichier Le nom du fichier à charger.
     */
    public void chargerPartie(String nomFichier) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomFichier))) {
            String ligne;

            // Réinitialiser les listes
            liste_creatures.clear();
            liste_objets.clear();

            // Lire chaque ligne du fichier et recréer les éléments du jeu
            while ((ligne = reader.readLine()) != null) {
                String[] params = ligne.split(";");
                creerElementJeu(params[0], params); // Recréer les éléments du jeu
            }

            System.out.println("Partie chargée avec succès depuis " + nomFichier);
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement : " + e.getMessage());
        }
    }

    /**
     * Méthode auxiliaire pour créer un élément de jeu (Creature, Objet, Joueur, etc.)
     * à partir d'une ligne de texte.
     * 
     * @param type   Le type de l'élément (ex: "Archer", "Guerrier", "NuageToxique").
     * @param params Les paramètres de l'élément sous forme de tableau.
     */
    private void creerElementJeu(String type, String[] params) {
        switch (type) {
            case "Archer":
                // Création d'un archer à partir des paramètres
                Archer archer = new Archer();  // Utilise le constructeur par défaut
                archer.setNom(params[1]);  // Nom
                archer.setPos(new Point2D(Integer.parseInt(params[2]), Integer.parseInt(params[3])));  // Position
                archer.setPtVie(Integer.parseInt(params[4]));  // Points de vie
                archer.setDegAtt(Integer.parseInt(params[5]));  // Dégâts d'attaque
                archer.setPageAtt(Integer.parseInt(params[6]));  // Vitesse d'attaque
                archer.setPagePar(Integer.parseInt(params[7]));  // Vitesse de parade
                archer.setDistAttMax(Integer.parseInt(params[8]));  // Distance d'attaque maximale (spécifique à l'archer)
                liste_creatures.add(archer);
                break;

            case "Guerrier":
                Guerrier guerrier = new Guerrier();  // Utilise le constructeur par défaut
                guerrier.setNom(params[1]);
                guerrier.setPos(new Point2D(Integer.parseInt(params[2]), Integer.parseInt(params[3])));
                guerrier.setPtVie(Integer.parseInt(params[4]));
                guerrier.setDegAtt(Integer.parseInt(params[5]));
                guerrier.setPageAtt(Integer.parseInt(params[6]));
                guerrier.setPagePar(Integer.parseInt(params[7]));
                liste_creatures.add(guerrier);
                break;

            case "Paysan":
                Paysan paysan = new Paysan();  // Utilise le constructeur par défaut
                paysan.setNom(params[1]);
                paysan.setPos(new Point2D(Integer.parseInt(params[2]), Integer.parseInt(params[3])));
                paysan.setPtVie(Integer.parseInt(params[4]));
                liste_creatures.add(paysan);
                break;

            case "Loup":
                Loup loup = new Loup();  // Utilise le constructeur par défaut
                loup.setNom(params[1]);
                loup.setPos(new Point2D(Integer.parseInt(params[2]), Integer.parseInt(params[3])));
                loup.setPtVie(Integer.parseInt(params[4]));
                liste_creatures.add(loup);
                break;

            case "Lapin":
                Lapin lapin = new Lapin();  // Utilise le constructeur par défaut
                lapin.setNom(params[1]);
                lapin.setPos(new Point2D(Integer.parseInt(params[2]), Integer.parseInt(params[3])));
                lapin.setPtVie(Integer.parseInt(params[4]));
                liste_creatures.add(lapin);
                break;

            case "NuageToxique":
                NuageToxique nuageTox = new NuageToxique();  // Utilise le constructeur par défaut
                nuageTox.setPos(new Point2D(Integer.parseInt(params[1]), Integer.parseInt(params[2])));
                nuageTox.setDeg(Integer.parseInt(params[3]));
                nuage = nuageTox;
                break;

            case "Joueur":
                joueur = new Joueur();  // Utilise le constructeur par défaut
                joueur.getPersonnage().setNom(params[1]);
                joueur.getPersonnage().setPos(new Point2D(Integer.parseInt(params[2]), Integer.parseInt(params[3])));
                joueur.getPersonnage().setPtVie(Integer.parseInt(params[4]));
                joueur.getPersonnage().setDegAtt(Integer.parseInt(params[5]));
                joueur.getPersonnage().setPageAtt(Integer.parseInt(params[6]));
                joueur.getPersonnage().setPagePar(Integer.parseInt(params[7]));
                break;

            default:
                System.err.println("Type inconnu : " + type);
                break;
        }
    }
    
    /**
     * Méthode permettant de sauvegarder la partie dans un fichier.
     *
     * @param nomFichier Le nom du fichier de sauvegarde.
     */
    public void sauvegardePartie(String nomFichier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichier))) {
            // Sauvegarder le joueur
            writer.write(joueur.getTexteSauvegarde());
            writer.newLine();

            // Sauvegarder les créatures
            for (Creature creature : liste_creatures) {
                writer.write(creature.getTexteSauvegarde());
                writer.newLine();
            }

            // Sauvegarder les objets
            for (Objet objet : liste_objets) {
                writer.write(objet.getTexteSauvegarde());
                writer.newLine();
            }

            // Sauvegarder le nuage toxique s'il est présent
            if (nuage != null) {
                writer.write(nuage.getTexteSauvegarde());
                writer.newLine();
            }

            System.out.println("Partie sauvegardée avec succès dans " + nomFichier);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }
    
}
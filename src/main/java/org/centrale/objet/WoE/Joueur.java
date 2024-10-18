package org.centrale.objet.WoE;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe représentant un joueur dans le jeu. Un joueur possède un personnage
 * qui peut être soit un archer, soit un guerrier, et a la possibilité de
 * déplacer son personnage sur le terrain. Le joueur peut également créer son
 * personnage et choisir son type (archer ou guerrier) ainsi que son nom.
 */
public class Joueur {

    private Personnage personnage; // Le personnage contrôlé par le joueur

    /**
     * Récupère le personnage du joueur.
     *
     * @return Le personnage du joueur.
     */
    public Personnage getPersonnage() {
        return personnage;
    }

    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }
    
    /**
     * Retourne une chaîne de caractères représentant les attributs du joueur
     * pour la sauvegarde dans un fichier texte.
     *
     * @return String Les attributs de l'archer sous forme de texte.
     */
    public String getTexteSauvegarde() {
        return "Joueur;" + this.personnage.getTexteSauvegarde();
    }

    /**
     * Crée un personnage pour le joueur. Le joueur choisit entre un archer ou
     * un guerrier, puis donne un nom au personnage. Si le choix est invalide,
     * il sera demandé à nouveau.
     */
    public void creePerso() {
        Scanner scanner = new Scanner(System.in);

        // Choix du type de personnage
        int choix;
        do {
            System.out.println("Veuillez entrer 1 pour un archer, 2 pour un guerrier :");
            choix = scanner.nextInt();
        } while (choix != 1 && choix != 2);

        // Création du personnage en fonction du choix
        if (choix == 1) {
            Archer archer = new Archer();
            archer.setPtVie(100);
            archer.setDegAtt(50);
            archer.setDistAttMax(5);
            archer.setPageAtt(25);
            archer.setPagePar(25);
            archer.setNbFleches(20);
            Point2D pos = new Point2D(25, 25);
            archer.setPos(pos);
            this.personnage = archer;
        }
        if (choix == 2) {
            Guerrier guerrier = new Guerrier();
            guerrier.setPtVie(100);
            guerrier.setDegAtt(50);
            guerrier.setDistAttMax(1);
            guerrier.setPageAtt(25);
            guerrier.setPagePar(25);
            Point2D pos = new Point2D(25, 25);
            guerrier.setPos(pos);
            this.personnage = guerrier;
        }

        // Saisie du nom du personnage
        scanner.nextLine(); // Consomme la nouvelle ligne
        System.out.println("Veuillez entrer le nom du personnage :");
        this.personnage.setNom(scanner.nextLine());
    }

    /**
     * Permet de calculer la distance entre le personnage contrôlé par le joueur
     * et une créature en entrée
     *
     * @param perso Personnage que le joueur contrôle
     * @param c Créature avec laquelle on veut connaître la distance
     * @return
     */
    public float distance_perso_creature(Personnage perso, Creature c) {
        Point2D p1 = perso.getPos();
        Point2D p2 = c.getPos();
        int x1 = p1.getX();
        int x2 = p2.getX();
        int y1 = p1.getY();
        int y2 = p2.getY();
        return (float) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    /**
     * Permet au joueur de combattre une créature qui se situe à sa portée
     * d'attaque.
     *
     * @param liste_creatures Liste des créatures présentes sur le terrain.
     */
    public void attaquerPerso(ArrayList<Creature> liste_creatures) {
        Scanner scanner = new Scanner(System.in);
        Iterator<Creature> it = liste_creatures.iterator();

        while (it.hasNext()) {
            Creature c = it.next();

            // Vérifie si la créature est à portée
            if (distance_perso_creature(personnage, c) <= personnage.distAttMax) {
                System.out.print("C'est un : " + c.getNom() + ". Il a " + c.getPtVie() + " points de vie. Vous pouvez l'attaquer ! \nTapez 1 si vous voulez attaquer, 2 sinon: ");
                int x = scanner.nextInt();

                // Si le joueur veut attaquer et que ce n'est ni un Lapin ni un Paysan
                if (x == 1) {
                    if (!(c instanceof Lapin || c instanceof Paysan)) {
                        personnage.combattre(c);  // Attaque la créature
                        if (c.getPtVie() <= 0) {
                            it.remove();  // Supprime la créature de la liste si elle est morte
                        }
                    } else {
                        // Message si la créature ne peut pas être attaquée
                        System.out.println("Vous ne pouvez pas attaquer " + c.getNom() + " car il/elle est pacifique.");
                    }
                }
            }
        }
        System.out.println("Il n'y a plus de créatures à attaquer.");
    }

    /**
     * Permet au joueur de déplacer son personnage à une position spécifiée sans
     * chevaucher la position d'une autre créature.
     *
     * @param creatures Liste des créatures présentes sur le terrain.
     */
    public void deplacement_joueur(ArrayList<Creature> creatures) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> positions = new ArrayList<>();

        // Collecte les positions des créatures
        for (Creature creature : creatures) {
            positions.add(this.personnage.retourpos(creature));
        }

        // Saisie des coordonnées de déplacement
        int x, y;
        ArrayList<Integer> newPosition = new ArrayList<>();
        do {
            System.out.println("Choisir x et y entre [0,50] :");
            x = scanner.nextInt();
            y = scanner.nextInt();
            newPosition.clear();
            newPosition.add(x);
            newPosition.add(y);
            // Vérifie si la position est déjà occupée
            if (positions.contains(newPosition)) {
                System.out.println("Impossible de se placer sur cette case, elle est déjà occupée par une autre créature.");
            }
        } while (positions.contains(newPosition));

        // Mise à jour de la position du personnage
        this.personnage.getPos().setX(x);
        this.personnage.getPos().setY(y);
    }

    /**
     * Permet au joueur de ramasser un objet automatiquement dès lors qu'il est
     * placé sur la même case qu'un objet
     *
     * @param liste_objets La liste des objets présents sur le terrain
     */
    public void rammasser_objet(ArrayList<Objet> liste_objets) {
        Point2D pos = this.personnage.getPos();
        Iterator<Objet> iterator = liste_objets.iterator();

        while (iterator.hasNext()) {
            Objet obj = iterator.next();
            if (pos.equals(obj.getPos())) {
                ObjetNumero inv = new ObjetNumero(obj, this.personnage.inventaire.size() + 1);
                this.personnage.inventaire.add(inv);
                System.out.println("Vous avez ramassé : " + obj.getNom());
                iterator.remove();  // Utiliser iterator.remove() pour supprimer l'objet en toute sécurité
            }
        }
    }

    /**
     * Permet au joueur de sélectionner un objet dans l'inventaire de son
     * personnage et de l'utiliser en fonction du numéro associé à l'objet.
     */
    public void utiliserObjetInventaire() {
        // Affichage de l'inventaire du personnage
        if (this.personnage.getInventaire().isEmpty()) {
            System.out.println("L'inventaire est vide.");
            return;
        }

        System.out.println("Voici votre inventaire :");
        for (ObjetNumero objet : this.personnage.getInventaire()) {
            System.out.println("Numéro: " + objet.getNumero() + " - Objet: " + objet.getNom());
        }

        // Demande du numéro de l'objet à utiliser
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer le numéro de l'objet que vous voulez utiliser :");
        int numero = scanner.nextInt();

        // Recherche de l'objet correspondant dans l'inventaire
        boolean objetTrouve = false;
        for (ObjetNumero objet : this.personnage.getInventaire()) {
            if (objet.getNumero() == numero) {
                objetTrouve = true;
                // Utilisation de l'objet
                this.personnage.utiliser(objet.getObj());
                System.out.println("Vous avez utilisé l'objet: " + objet.getNom());
                System.out.println("Points de vie : " + personnage.getPtVie());
                System.out.println("Dégats d'attaque : " + personnage.getDegAtt());
                System.out.println("Vitesse d'attaque : " + personnage.getPageAtt());
                System.out.println("Vitesse de parade : " + personnage.getPagePar());
                personnage.inventaire.remove(objet); // Suppression de l'objet de l'inventaire
                break;
            }
        }

        // Réorganisation des numéros après suppression
        if (objetTrouve) {
            // Réattribuer les numéros dans l'ordre
            for (int i = 0; i < this.personnage.inventaire.size(); i++) {
                this.personnage.inventaire.get(i).setNumero(i + 1);  // Les numéros commencent à 1
            }
        } else {
            System.out.println("Numéro invalide, aucun objet ne correspond.");
        }
    }

    /**
     * Retourne le nombre de points de vie restants du personnage contrôlé par
     * le joueur.
     *
     * @return
     */
    public int getPtVie() {
        return personnage.getPtVie();
    }

    /**
     * Permet de définir le points de vie du joueur
     *
     * @param i Points de vie qu'on veut attribuer au joueur
     */
    public void setPtVie(int i) {
        personnage.setPtVie(i);
    }

}

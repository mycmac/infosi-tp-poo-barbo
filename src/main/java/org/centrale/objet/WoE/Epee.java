package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe représentant une épée dans le jeu, qui est un type d'objet. 
 * L'épée possède un attribut supplémentaire : la puissance de l'épée, qui peut varier.
 */
public class Epee extends Objet {

    private int puissance; // Puissance de l'épée
    
    /**
     * Constructeur de l'épée avec nom, position et puissance spécifiés.
     * 
     * @param nom Le nom de l'épée.
     * @param pos La position de l'épée dans le jeu.
     * @param puissance La puissance de l'épée.
     */
    public Epee(String nom, Point2D pos, int puissance) {
        super(nom, pos);
        this.puissance = puissance;
    }
    
    /**
     * Constructeur par défaut de l'épée. 
     * La puissance est initialisée à 0.
     */
    public Epee() {
        super();
        this.puissance = 0;
    }

    /**
     * Définit la puissance de l'épée.
     * 
     * @param p La nouvelle puissance de l'épée.
     */
    public void setPuissance(int p) {
        this.puissance = p;
    }

    /**
     * Constructeur de copie pour créer une nouvelle épée à partir d'une autre.
     * 
     * @param e L'épée à copier.
     */
    public Epee(Epee e) {
        super(e);
        this.puissance = e.puissance;
    }

    /**
     * Récupère la puissance de l'épée.
     * 
     * @return La puissance de l'épée.
     */
    public int getPuissance() {
        return puissance;
    }

    /**
     * Crée plusieurs épées aléatoires avec des noms générés, 
     * et les ajoute à la liste des objets du jeu.
     * 
     * @param liste La liste des objets du jeu.
     */
    public void crea_epee(ArrayList<Objet> liste) {
        Random random = new Random();
        int rand = random.nextInt(100);
        for (int i = 0; i < rand; i++) {
            String n = "Archer" + i;
            Epee arch = new Epee();
            arch.setNom(n);
            liste.add(arch);
        }
    }
}
package org.centrale.objet.WoE;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Classe représentant la grille de jeu où sont affichés le personnage principal, les créatures,
 * et les objets. Cette grille est une représentation visuelle du jeu sous forme de cases.
 * Elle permet de dessiner et de mettre à jour la position du personnage, des créatures,
 * des objets, ainsi que du nuage toxique.
 */
public class JeuGrille extends JPanel {

    /** Taille d'une case dans la grille. */
    private final int TAILLE_CASE = 20;

    /** Taille de la grille (50x50 cases). */
    private final int TAILLE_GRILLE = 50;

    /** Le personnage principal du jeu. */
    private Personnage personnage;

    /** Liste des créatures présentes dans la grille. */
    private List<Creature> creatures;

    /** Liste des objets présents dans la grille. */
    private List<Objet> objets;

    /** Nuage toxique présent dans la grille (s'il y en a un). */
    private NuageToxique nuage;

    /** Référence à la fenêtre principale (JFrame) pour l'affichage graphique. */
    private JFrame frame;

    /**
     * Constructeur qui initialise la grille avec le personnage principal, la liste des créatures,
     * la liste des objets et le nuage toxique. Crée également une fenêtre (JFrame) pour afficher
     * la grille qui reste ouverte pendant toute la durée du jeu.
     * 
     * @param personnage Le personnage principal du jeu.
     * @param creatures La liste des créatures présentes dans le jeu.
     * @param objets La liste des objets présents dans le jeu.
     * @param nuage Le nuage toxique présent (ou non) sur le terrain.
     */
    public JeuGrille(Personnage personnage, List<Creature> creatures, List<Objet> objets, NuageToxique nuage) {
        this.personnage = personnage;
        this.creatures = creatures;
        this.objets = objets;
        this.nuage = nuage;
        setPreferredSize(new Dimension(TAILLE_GRILLE * TAILLE_CASE, TAILLE_GRILLE * TAILLE_CASE));

        // Créer la fenêtre (JFrame) et l'ajouter une seule fois lors de l'initialisation
        frame = new JFrame("Grille de jeu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);  // Ajouter la grille à la fenêtre
        frame.pack();  // Ajuster la taille de la fenêtre
        frame.setVisible(true);  // Afficher la fenêtre
    }

    /**
     * Méthode de rendu graphique utilisée pour dessiner la grille de jeu, le personnage principal,
     * les créatures, les objets, et le nuage toxique sur le panneau. Cette méthode est appelée automatiquement
     * lorsque le composant doit être redessiné.
     * 
     * @param g L'objet {@link Graphics} utilisé pour dessiner sur le composant.
     *          Il fournit les méthodes nécessaires pour dessiner les différentes entités.
     * 
     * Dessin des éléments :
     * <ul>
     *   <li>La grille est dessinée sous forme de carrés de taille fixe définie par {@code TAILLE_CASE}.</li>
     *   <li>Le personnage principal est dessiné en bleu.</li>
     *   <li>Les créatures sont dessinées en rouge, chacune dans sa propre position.</li>
     *   <li>Les objets normaux sont dessinés en vert, et les nuages toxiques sont dessinés en noir et occupent 3x3 cases.</li>
     * </ul>
     * 
     * Conditions de vérification :
     * <ul>
     *   <li>La position du personnage est vérifiée avant d'être dessinée pour éviter les erreurs de nullité.</li>
     *   <li>Chaque créature et objet est vérifié avant d'être dessiné pour s'assurer que ni l'objet ni sa position ne sont nulles.</li>
     * </ul>
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dessiner la grille
        for (int y = 0; y < TAILLE_GRILLE; y++) {
            for (int x = 0; x < TAILLE_GRILLE; x++) {
                g.drawRect(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE); // Dessiner chaque case
            }
        }

        // Vérifier que le personnage n'est pas null avant de dessiner
        if (personnage != null && personnage.getPos() != null) {
            g.setColor(Color.BLUE); // Couleur pour le personnage principal
            g.fillRect(personnage.getPos().getX() * TAILLE_CASE, personnage.getPos().getY() * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
        }

        // Vérifier que la liste de créatures n'est pas null avant de dessiner
        if (creatures != null) {
            g.setColor(Color.RED); // Couleur pour les créatures
            for (Creature creature : creatures) {
                if (creature != null && creature.getPos() != null) {
                    g.fillRect(creature.getPos().getX() * TAILLE_CASE, creature.getPos().getY() * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
                }
            }
        }

        // Vérifier que la liste des objets n'est pas null avant de dessiner
        if (objets != null) {
            for (Objet obj : objets) {
                if (obj != null && obj.getPos() != null) {
                    // Si l'objet est un NuageToxique, dessiner un plus grand carré noir
                    if (obj instanceof NuageToxique) {
                        g.setColor(Color.BLACK);
                        g.fillRect(obj.getPos().getX() * TAILLE_CASE, obj.getPos().getY() * TAILLE_CASE, 3 * TAILLE_CASE, 3 * TAILLE_CASE);
                    } else {
                        // Autres objets en vert
                        g.setColor(Color.GREEN);
                        g.fillRect(obj.getPos().getX() * TAILLE_CASE, obj.getPos().getY() * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
                    }
                }
            }
        }
    }

    /**
     * Méthode pour mettre à jour la grille lorsque le personnage, les créatures, ou les objets
     * sont déplacés. Cette méthode permet de redessiner la grille avec les nouvelles positions
     * et met également à jour la position du nuage toxique. Si une ancienne fenêtre existe, elle est
     * fermée avant de créer une nouvelle fenêtre.
     * 
     * @param personnage Le personnage principal avec sa nouvelle position.
     * @param creatures La liste des créatures avec leurs nouvelles positions.
     * @param objets La liste des objets avec leurs nouvelles positions.
     * @param nuage Le nuage toxique avec sa nouvelle position (s'il est présent sur le terrain).
     */
    public void mettreAJourGrille(Personnage personnage, List<Creature> creatures, List<Objet> objets, NuageToxique nuage) {
        // Fermer l'ancienne fenêtre si elle existe
        if (frame != null) {
            frame.dispose();  // Ferme la fenêtre
        }

        // Mettre à jour les entités
        this.personnage = personnage;
        this.creatures = creatures;
        this.objets = objets;
        this.nuage = nuage;

        // Créer une nouvelle fenêtre
        frame = new JFrame("Grille de jeu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);  // Ajouter la grille à la fenêtre
        frame.pack();  // Ajuster la taille de la fenêtre
        frame.setVisible(true);  // Afficher la nouvelle fenêtre

        repaint(); // Redessiner la grille avec les nouvelles positions
    }
}
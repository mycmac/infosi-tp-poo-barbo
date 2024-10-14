package org.centrale.objet.WoE;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class JeuGrille extends JPanel {

    private final int TAILLE_CASE = 20;  // Taille d'une case dans la grille
    private final int TAILLE_GRILLE = 50; // Taille de la grille (50x50)
    private Personnage personnage; // Ton personnage principal
    private List<Creature> creatures; // Liste des créatures (ex : archers)

    // Constructeur qui reçoit le personnage et la liste des créatures
    public JeuGrille(Personnage personnage, List<Creature> creatures) {
        this.personnage = personnage;
        this.creatures = creatures;
        setPreferredSize(new Dimension(TAILLE_GRILLE * TAILLE_CASE, TAILLE_GRILLE * TAILLE_CASE));
    }

    // Méthode pour dessiner la grille, le personnage et les créatures
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dessiner la grille
        for (int y = 0; y < TAILLE_GRILLE; y++) {
            for (int x = 0; x < TAILLE_GRILLE; x++) {
                g.drawRect(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE); // Dessiner chaque case
            }
        }
        
        // Dessiner le personnage (on suppose qu'il a des coordonnées x et y)
        g.setColor(Color.BLUE); // Couleur pour le personnage principal
        g.fillRect(personnage.getPos().getX() * TAILLE_CASE, personnage.getPos().getY() * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);

        // Dessiner les créatures (archers, guerriers, etc.)
        g.setColor(Color.RED); // Couleur pour les créatures
        for (Creature creature : creatures) {
            g.fillRect(creature.getPos().getX() * TAILLE_CASE, creature.getPos().getY() * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
        }
    }

    // Méthode pour mettre à jour la grille si on déplace un personnage ou une créature
    public void mettreAJourGrille(Personnage personnage, List<Creature> creatures) {
        this.personnage = personnage;
        this.creatures = creatures;
        repaint(); // Redessiner la grille avec les nouvelles positions
    }


}
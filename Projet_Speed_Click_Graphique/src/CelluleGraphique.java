/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.awt.Graphics;
import javax.swing.JButton;
import projet_speed_click.Bouton;

/**
 * Classe représentant graphiquement une cellule de la grille de jeu.
 * Étend JButton pour permettre l'interaction utilisateur.
 */
public class CelluleGraphique extends JButton {
    private final int largeur;  // Largeur en pixels de la cellule
    private final int hauteur;  // Hauteur en pixels de la cellule
    private final Bouton boutonAssocie;  // Bouton associé à la cellule

    /**
     * Constructeur de la classe CelluleGraphique.
     *
     * @param boutonAssociee Bouton associé à la cellule.
     * @param l              Largeur en pixels de la cellule.
     * @param h              Hauteur en pixels de la cellule.
     */
    public CelluleGraphique(Bouton boutonAssocie, int l, int h) {
        this.boutonAssocie = boutonAssocie;
        this.largeur = l;
        this.hauteur = h;

        // Configure le texte du bouton lors de la création
        this.setText(boutonAssocie.toString());
    }

    /**
     * Méthode gérant le dessin de la cellule.
     *
     * @param g Graphics utilisé pour le dessin.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Aucun besoin de configurer le texte ici car cela a été fait dans le constructeur.
        // Si nécessaire, d'autres opérations de dessin peuvent être ajoutées ici.
    }
}



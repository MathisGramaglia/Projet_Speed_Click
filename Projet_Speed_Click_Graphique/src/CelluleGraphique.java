/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import projet_speed_click.Bouton;

/**
 * Classe représentant graphiquement une cellule de la grille de jeu.
 * Étend JButton pour permettre l'interaction utilisateur.
 */
public class CelluleGraphique extends JButton {
    private final int ligne;
    private final int colonne;

    public CelluleGraphique(Bouton boutonAssocie, int l, int h, int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;

        this.setText(boutonAssocie.toString());
        
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ajoutez ici le code que vous souhaitez exécuter lorsque le bouton est cliqué
                System.out.println("Bouton à la ligne " + ligne + ", colonne " + colonne + " cliqué !");
            }
        });
    }
}




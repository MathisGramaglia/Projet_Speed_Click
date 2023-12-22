/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projet_speed_click;

/**
 *
 * @author mathi
 */
public class Projet_Speed_Click {

    /**
     * Méthode principale qui crée une instance de la classe Partie avec une grille prédéfinie
     * et lance le jeu Speed-Click en appelant la méthode jouerPartie().
     *
     * @param args Les arguments de la ligne de commande (non utilisés ici).
     */
    public static void main(String[] args) {
        Partie partie = new Partie(3, 3, 30000); // Grille de 3x3, durée de 30 secondes
        partie.jouerPartie();
    }
}

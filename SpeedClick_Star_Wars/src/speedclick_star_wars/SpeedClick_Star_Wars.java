/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package speedclick_star_wars;

/**
 * Classe principale pour le jeu SpeedClick Star Wars.
 * Cette classe contient le point d'entrée de l'application et initialise la fenêtre d'accueil (WelcomeWindow).
 * 
 * @author Mathi
 * @version 1.0
 */

import javax.swing.SwingUtilities;

public class SpeedClick_Star_Wars {

    /**
     * Méthode principale de l'application, qui initialise la fenêtre d'accueil (WelcomeWindow) et la rend visible.
     * 
     * @param args les arguments de ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WelcomeWindow welcomeWindow = new WelcomeWindow();
            welcomeWindow.setVisible(true);
        });
    }
}




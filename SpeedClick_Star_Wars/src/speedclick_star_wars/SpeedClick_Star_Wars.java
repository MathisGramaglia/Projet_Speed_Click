/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package speedclick_star_wars;

import javax.swing.SwingUtilities;

/**
 *
 * @author mathi
 */
public class SpeedClick_Star_Wars {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WelcomeWindow welcomeWindow = new WelcomeWindow();
            welcomeWindow.setVisible(true);
        });
    }
}

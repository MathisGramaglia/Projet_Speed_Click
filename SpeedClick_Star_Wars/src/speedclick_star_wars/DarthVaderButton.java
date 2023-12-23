/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package speedclick_star_wars;
/**
 *
 * @author mathi
 */
import javax.swing.*;
import java.awt.*;

public class DarthVaderButton {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Star Wars Button Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);

            // Chargez l'image de Darth Vader (à partir du package par défaut)
            ImageIcon darthVaderIcon = new ImageIcon(WelcomeWindow.class.getResource("/resources/ImDV.jpg"));

            // Créez un bouton avec l'image de Darth Vader
            JButton button = new JButton(darthVaderIcon);
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            button.setContentAreaFilled(false);

            frame.getContentPane().add(button);
            frame.setVisible(true);
        });
    }
}
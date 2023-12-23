/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package speedclick_star_wars;
/**
 *
 * @author mathi
 */
import java.awt.BorderLayout;
import javax.swing.*;

public class FinalWindow extends JFrame {
    public FinalWindow(String message) {
        setTitle("Fin du Jeu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);  // Maximise la fenêtre
        setUndecorated(true);  // Enlève la barre de titre et les bordures

        JLabel messageLabel = new JLabel(message, SwingConstants.CENTER);
        JButton exitButton = new JButton("Quitter");
        exitButton.addActionListener(e -> System.exit(0));

        setLayout(new BorderLayout());
        add(messageLabel, BorderLayout.CENTER);
        add(exitButton, BorderLayout.SOUTH);
    }
}

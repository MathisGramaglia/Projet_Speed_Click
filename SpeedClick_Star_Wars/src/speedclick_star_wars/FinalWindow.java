/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package speedclick_star_wars;
/**
 * Fenêtre de fin de jeu.
 * Cette classe crée une fenêtre Swing affichant un message de fin de jeu et un bouton "Quitter".
 * 
 * @author Mathi
 * @version 1.0
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Fenêtre de fin de jeu pour Speed Click - Édition Star Wars.
 * Affiche un message de fin de jeu et propose une option pour quitter l'application.
 */
public class FinalWindow extends JFrame {

    public FinalWindow(int score) {
        setTitle("Fin du Jeu - Speed Click Star Wars");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.BLACK);
        setLayout(new BorderLayout());

        String finalMessage = "<html><h1 style='color: white; text-align: center;'>Fin de la partie</h1>"
                             + "<h2 style='color: yellow;'>Votre score est : " + score + "</h2>"
                             + "<h3 style='color: white;'>Reviendrez-vous pour améliorer votre score, jeune Padawan?</h3></html>";
        JLabel messageLabel = new JLabel(finalMessage, SwingConstants.CENTER);
        add(messageLabel, BorderLayout.CENTER);

        JButton exitButton = new JButton("Retour sur Tatooine");
        exitButton.addActionListener(e -> System.exit(0));
        styleButton(exitButton);
        add(exitButton, BorderLayout.SOUTH);
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 15));
        button.setForeground(Color.YELLOW);
        button.setBackground(Color.DARK_GRAY);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FinalWindow finalWindow = new FinalWindow(42); // Score de test
            finalWindow.setVisible(true);
        });
    }
}


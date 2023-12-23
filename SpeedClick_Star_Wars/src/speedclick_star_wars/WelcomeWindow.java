/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package speedclick_star_wars;
/**
 * Fenêtre de bienvenue du jeu Speed Click.
 * Cette classe représente la fenêtre de bienvenue du jeu Speed Click, qui accueille les joueurs
 * et propose un bouton "Jouer" pour démarrer le jeu.
 * 
 * @author Mathi
 * @version 1.0
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Fenêtre de bienvenue pour le jeu Speed Click - Édition Star Wars.
 * Cette classe crée une fenêtre de bienvenue avec des options pour commencer le jeu ou afficher les règles.
 */
public class WelcomeWindow extends JFrame {

    /**
     * Constructeur pour la fenêtre de bienvenue.
     */
    public WelcomeWindow() {
        setTitle("Bienvenue sur Speed Click - Star Wars Edition");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);

        // Configuration du fond d'écran noir
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK); // Fond noir

        // Label de bienvenue avec style Star Wars et texte en blanc
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));
        welcomePanel.setBackground(Color.BLACK); // Fond noir
        welcomePanel.add(Box.createVerticalGlue());

        JLabel welcomeLabel = new JLabel("<html><h1 style='color: white; text-align: center;'>Bienvenue sur le jeu Speed-Click Star Wars</h1><h2 style='color: white;'>Que la force soit avec vous</h2></html>", SwingConstants.CENTER);
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcomePanel.add(welcomeLabel);

        // Bouton pour commencer à jouer
        JButton playButton = new JButton("Jouer");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameWindow gameWindow = new GameWindow();
                gameWindow.setVisible(true);
                dispose();
            }
        });
        configureButton(playButton);
        welcomePanel.add(playButton);

        // Bouton pour afficher les règles
        JButton rulesButton = new JButton("Règles");
        rulesButton.addActionListener(e -> showRulesDialog());
        configureButton(rulesButton);
        welcomePanel.add(rulesButton);

        welcomePanel.add(Box.createVerticalGlue());
        add(welcomePanel, BorderLayout.CENTER);
    }

    /**
     * Configure le style d'un bouton.
     * @param button Le bouton à configurer.
     */
    private void configureButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    /**
     * Affiche un dialogue avec les règles du jeu.
     */
    private void showRulesDialog() {
        JOptionPane.showMessageDialog(this, 
            "<html><h1>Règles du jeu</h1><p>Cliquez sur autant de boutons allumés que possible en 30 secondes. " +
            "Chaque clic correct augmente votre score, mais attention aux erreurs !</p>" +
            "<p>Que la force soit avec vous dans cette quête rapide et pleine de défis !</p></html>",
            "Règles du jeu", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WelcomeWindow welcomeWindow = new WelcomeWindow();
            welcomeWindow.setVisible(true);
        });
    }
}





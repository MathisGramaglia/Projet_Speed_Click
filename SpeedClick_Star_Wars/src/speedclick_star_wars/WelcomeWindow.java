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

public class WelcomeWindow extends JFrame {
    /**
     * Constructeur de la fenêtre de bienvenue.
     * Initialise le titre, la mise en page, le label de bienvenue et le bouton "Jouer".
     */
    public WelcomeWindow() {
        setTitle("Bienvenue sur Speed Click");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);  // Maximise la fenêtre
        setUndecorated(true);  // Enlève la barre de titre et les bordures

        JLabel welcomeLabel = new JLabel("Bienvenue sur le jeu Speed-Click", SwingConstants.CENTER);
        JButton playButton = new JButton("Jouer");
        playButton.addActionListener((ActionEvent e) -> {
            GameWindow gameWindow = new GameWindow();
            gameWindow.setVisible(true);
            dispose();
        });

        setLayout(new BorderLayout());
        add(welcomeLabel, BorderLayout.CENTER);
        add(playButton, BorderLayout.SOUTH);
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package speedclick_star_wars;
/**
 * Fenêtre principale du jeu SpeedClick.
 * Cette classe représente la fenêtre principale du jeu SpeedClick, qui contient le panneau de jeu (GamePanel)
 * et un bouton "Quitter" permettant de quitter le jeu.
 * 
 * @author Mathi
 * @version 1.0
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameWindow extends JFrame {
    /**
     * Constructeur de la fenêtre du jeu SpeedClick.
     * Initialise le titre, la mise en page, le panneau de jeu, le gestionnaire de jeu et le bouton "Quitter".
     */
    public GameWindow() {
        setTitle("Speed Click");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);

        GamePanel gamePanel = new GamePanel();
        GameManager gameManager = new GameManager(gamePanel);
        gamePanel.setGameManager(gameManager);

        JButton quitButton = new JButton("Quitter");
        quitButton.addActionListener((ActionEvent e) -> {
            int option = JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de vouloir quitter le jeu ?", "Quitter le jeu", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                System.exit(0); // Quitte l'application
            }
        });

        add(gamePanel);
        add(quitButton, BorderLayout.SOUTH);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package speedclick_star_wars;
/**
 * Panneau de jeu pour le jeu SpeedClick.
 * Cette classe représente le panneau de jeu qui contient les boutons et le score du jeu SpeedClick.
 * 
 * @author Mathi
 * @version 1.0
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import javax.swing.JOptionPane;

public class GamePanel extends JPanel {
    private GameManager gameManager;
    private JButton[][] buttons = new JButton[3][3];
    private JLabel scoreLabel;

    /**
     * Constructeur du panneau de jeu.
     * Initialise la mise en page du panneau, le label du score et les boutons.
     */
    public GamePanel() {
        setLayout(new BorderLayout());
        initializeScoreLabel();
        initializeButtons();
    }

    /**
     * Définit le gestionnaire de jeu associé à ce panneau.
     * 
     * @param gameManager Le gestionnaire de jeu.
     */
    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
        updateButtonStates();
    }

    private void initializeScoreLabel() {
        scoreLabel = new JLabel("Score: 0", SwingConstants.CENTER);
        add(scoreLabel, BorderLayout.NORTH);
    }

    private void initializeButtons() {
        JPanel gridPanel = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton();
                final int row = i;
                final int col = j;
                button.addActionListener((ActionEvent e) -> {
                    gameManager.handleButtonClick(row, col);
                    updateButtonStates();
                    updateScore();
                });
                buttons[i][j] = button;
                gridPanel.add(button);
            }
        }
        add(gridPanel, BorderLayout.CENTER);
    }

    /**
     * Met à jour l'état des boutons en fonction de l'état du jeu (allumé ou éteint).
     */
    public void updateButtonStates() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameManager.isButtonLit(i, j)) {
                    buttons[i][j].setBackground(Color.YELLOW);
                } else {
                    buttons[i][j].setBackground(null);
                }
            }
        }
    }

    /**
     * Met à jour le score affiché dans le label.
     */
    public void updateScore() {
        scoreLabel.setText("Score: " + gameManager.getScore());
    }

    /**
     * Gère la fin du temps de jeu en affichant un message de fin et en proposant de rejouer ou de quitter le jeu.
     */
    public void timeUp() {
        int option = JOptionPane.showConfirmDialog(this, "Temps écoulé! Votre score est : " + gameManager.getScore() + "\nVoulez-vous rejouer ?", "Fin de la partie", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            gameManager.resetGame();
            updateButtonStates();
            updateScore();
        } else {
            System.exit(0); // Ferme l'application
        }
    }
}

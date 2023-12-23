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

/**
 * Panneau de jeu pour le jeu SpeedClick - Édition Star Wars.
 * Cette classe représente le panneau de jeu qui contient les boutons et le score du jeu SpeedClick.
 * Elle gère l'affichage et l'interaction avec les boutons du jeu, ainsi que l'affichage du score.
 */
public class GamePanel extends JPanel {
    private GameManager gameManager;
    private JButton[][] buttons = new JButton[3][3];
    private JLabel scoreLabel;
    private Timer gameTimer;
    /**
     * Construit et initialise le panneau de jeu.
     */
    public GamePanel() {
        setBackground(Color.BLACK); 
        setLayout(new BorderLayout());
        initializeScoreLabel();
        initializeButtons();
        initializeTimer();
    }
    /**
     * Associe un gestionnaire de jeu à ce panneau.
     * @param gameManager Le gestionnaire de jeu à associer.
     */
    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
        updateButtonStates();
    }
    /**
     * Initialise le label pour le score.
     */
    private void initializeScoreLabel() {
        scoreLabel = new JLabel("Score: 0", SwingConstants.CENTER);
        scoreLabel.setForeground(Color.WHITE); 
        add(scoreLabel, BorderLayout.NORTH);
    }
    /**
     * Initialise les boutons du jeu.
     */
    private void initializeButtons() {
        JPanel gridPanel = new JPanel(new GridLayout(3, 3));
        gridPanel.setBackground(Color.BLACK);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton();
                button.setFont(new Font("Monospaced", Font.BOLD, 12));
                button.setForeground(Color.BLACK); 
                button.setBackground(Color.WHITE); 
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
     * Initialise et démarre le timer du jeu.
     */
    private void initializeTimer() {
        gameTimer = new Timer(30000, (e) -> timeUp()); // Timer pour 30 secondes
        gameTimer.start();
    }
    /**
     * Met à jour l'état des boutons en fonction de leur état actuel dans le jeu (allumé ou éteint).
     */
    public void updateButtonStates() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameManager.isButtonLit(i, j)) {
                    buttons[i][j].setBackground(Color.BLACK);
                    buttons[i][j].setForeground(Color.BLACK);
                    buttons[i][j].setText("_/﹋\\_\n(҂`_´)\n<,︻╦╤─ ҉ - -\n_/﹋\\_");
                } else {
                    buttons[i][j].setBackground(Color.WHITE);
                    buttons[i][j].setForeground(Color.BLACK);
                    buttons[i][j].setText("");
                }
            }
        }
    }
    /**
     * Met à jour le score affiché.
     */
    public void updateScore() {
        scoreLabel.setText("Score: " + gameManager.getScore());
    }
    /**
     * Gère la fin du temps de jeu, affiche un message de fin et propose de rejouer ou de quitter le jeu.
     */
    public void timeUp() {
    gameTimer.stop();
    int option = JOptionPane.showConfirmDialog(this, 
        "Temps écoulé! Votre score est : " + gameManager.getScore() + 
        "\nÊtes-vous sûr de vouloir retourner sur Tatooine ?",
        "Fin de la partie", JOptionPane.YES_NO_OPTION);
    
    if (option == JOptionPane.YES_OPTION) {
        System.exit(0); // Ferme l'application si le joueur veut retourner sur Tatooine
    } else {
        resetGame(); // Réinitialise le jeu si le joueur veut continuer à jouer
    }
}

/**
 * Réinitialise le jeu pour commencer une nouvelle partie.
 */
private void resetGame() {
    gameManager.resetGame();
    updateScore();
    updateButtonStates();
    gameTimer.start(); // Redémarre le timer pour la nouvelle partie
}

}




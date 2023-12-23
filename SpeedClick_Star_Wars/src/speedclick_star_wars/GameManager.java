/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package speedclick_star_wars;
/**
 * Gestionnaire du jeu SpeedClick.
 * Cette classe gère la logique du jeu, notamment l'allumage aléatoire des boutons, la gestion du score et le chronomètre.
 * 
 * @author Mathi
 * @version 1.0
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class GameManager {
    private boolean[][] litButtons = new boolean[3][3];
    private int score = 0;
    private Random random = new Random();
    private Timer timer;
    private GamePanel gamePanel;

    /**
     * Constructeur du gestionnaire de jeu.
     * 
     * @param gamePanel Le panneau de jeu associé à ce gestionnaire.
     */
    public GameManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        lightUpRandomButton();
        initializeTimer();
        lightUpRandomButton();
    }

    private void initializeTimer() {
        timer = new Timer(10000, (ActionEvent e) -> {
            timer.stop();
            gamePanel.timeUp();
        });
        timer.start();
    }

    /**
     * Gère le clic sur un bouton de jeu.
     * Augmente le score si le bouton est allumé, sinon diminue le score.
     * 
     * @param row La ligne du bouton cliqué.
     * @param col La colonne du bouton cliqué.
     */
    public void handleButtonClick(int row, int col) {
        if (litButtons[row][col]) {
            score++;
        } else {
            score--;
        }
        lightUpRandomButton();
    }

    private void lightUpRandomButton() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                litButtons[i][j] = false;
            }
        }
        int row = random.nextInt(3);
        int col = random.nextInt(3);
        litButtons[row][col] = true;
    }

    /**
     * Vérifie si un bouton spécifique est allumé.
     * 
     * @param row La ligne du bouton à vérifier.
     * @param col La colonne du bouton à vérifier.
     * @return true si le bouton est allumé, sinon false.
     */
    public boolean isButtonLit(int row, int col) {
        return litButtons[row][col];
    }

    /**
     * Obtient le score actuel du jeu.
     * 
     * @return Le score actuel.
     */
    public int getScore() {
        return score;
    }

    /**
     * Réinitialise le jeu en remettant le score à zéro, en allumant un bouton aléatoire et en réinitialisant le chronomètre.
     */
    public void resetGame() {
        score = 0;
        lightUpRandomButton(); 
        initializeTimer();
    }
}


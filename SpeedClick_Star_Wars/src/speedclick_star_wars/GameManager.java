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
import java.awt.event.ActionEvent;
import java.util.Random;

public class GameManager {
    private boolean[][] litButtons = new boolean[3][3];
    private int score = 0;
    private Random random = new Random();
    private Timer timer;
    private GamePanel gamePanel;

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

    public boolean isButtonLit(int row, int col) {
        return litButtons[row][col];
    }

    public int getScore() {
        return score;
    }
    public void resetGame() {
    score = 0;
    lightUpRandomButton(); 
    initializeTimer();
}
}


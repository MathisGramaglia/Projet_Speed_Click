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
import java.awt.event.ActionEvent;

public class GamePanel extends JPanel {
    private GameManager gameManager;
    private JButton[][] buttons = new JButton[3][3];
    private JLabel scoreLabel;

    public GamePanel() {
        setLayout(new BorderLayout());
        initializeScoreLabel();
        initializeButtons();
    }

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

    public void updateScore() {
        scoreLabel.setText("Score: " + gameManager.getScore());
    }

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
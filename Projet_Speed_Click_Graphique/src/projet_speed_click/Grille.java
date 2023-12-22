/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_speed_click;
/**
 *
 * @author mathi
 */
import java.util.Random;
/**
 * La classe Grille représente la grille de boutons dans le jeu Speed-Click.
 * Les joueurs doivent cliquer sur les boutons allumés pour marquer des points.
 */
public class Grille {
    private Bouton[][] matriceBoutons;
    private int nbLignes;
    private int nbColonnes;
    private int boutonAllumeLigne;
    private int boutonAllumeColonne;
    private int score;
    
    /**
     * Constructeur de la classe Grille.
     *
     * @param nbLignes   Le nombre de lignes dans la grille.
     * @param nbColonnes Le nombre de colonnes dans la grille.
     */
    public Grille(int nbLignes, int nbColonnes) {
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        matriceBoutons = new Bouton[nbLignes][nbColonnes];
        initialiserGrille();
        score = 0;
        allumerBoutonAleatoire();
    }
    /**
     * Initialise la grille en créant des boutons éteints pour chaque cellule.
    * Cette méthode est appelée lors de la création d'une nouvelle instance de la classe Grille.
    */
    
    private void initialiserGrille() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceBoutons[i][j] = new Bouton(false);
            }
        }
    }
    public Bouton[][] getMatriceBoutons() {
        return matriceBoutons;
    }

   
    /**
     * Allume un bouton aléatoire dans la grille.
     */
    public void allumerBoutonAleatoire() {
    Random random = new Random();

    // Éteindre tous les boutons
    eteindreTousLesBoutons();

    boutonAllumeLigne = random.nextInt(nbLignes);
    boutonAllumeColonne = random.nextInt(nbColonnes);

    matriceBoutons[boutonAllumeLigne][boutonAllumeColonne].boutonAllume();
    }

    /**
     * Vérifie si un bouton à une position donnée est allumé.
     *
     * @param ligne    La ligne du bouton.
     * @param colonne  La colonne du bouton.
     * @return         True si le bouton est allumé, sinon False.
     */
    public boolean estBoutonAllume(int ligne, int colonne) {
        return matriceBoutons[ligne][colonne].getEtat();
    }
    
    /**
     * Éteint tous les boutons dans la grille.
     */
    public void eteindreTousLesBoutons() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceBoutons[i][j].boutonEteint();
            }
        }
    }
    /**
     * Vérifie si tous les boutons dans la grille sont éteints.
     *
     * @return True si tous les boutons sont éteints, sinon False.
     */
    public boolean tousLesBoutonsEteints() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (matriceBoutons[i][j].getEtat()) {
                    return false; 
                }
            }
        }
        return true;  // Si aucun bouton allumé, tous les boutons sont éteints
    }

    /**
     * Gère le clic sur un bouton correct.
     */
    public void boutonClique() {
        if (estBoutonAllume(boutonAllumeLigne, boutonAllumeColonne)) {
            score++;
        } else {
            score--;
        }

        // Éteindre le bouton précédent ici
        matriceBoutons[boutonAllumeLigne][boutonAllumeColonne].boutonEteint();

        // Afficher et mettre à jour le score à chaque clic
        System.out.println("Score actuel : " + score);

        // Allumer un nouveau bouton après chaque clic
        allumerBoutonAleatoire();
    }
        /**
     * Gère le clic sur un bouton incorrect.
     */
    public void boutonIncorrectClique() {
    score--;
    }

    /**
     * Obtient le score actuel de la grille.
     *
     * @return Le score actuel.
     */
    public int getScore() {
        return score;
    }
    /**
    * Modifie le score actuel de la grille avec la valeur spécifiée.
    *
    * @param nouveauScore Le nouveau score à définir.
    */
    public void setScore(int nouveauScore) {
        this.score = nouveauScore;
    }
    /**
    * Diminue le score actuel de la grille d'une unité.
    */
    public void decrementerScore() {
        score--;
    }
    
   /**
     * Affiche la représentation textuelle de la grille.
     *
     * @return Une représentation textuelle de la grille.
     */
    @Override
    public String toString() {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < nbLignes; i++) {
        for (int j = 0; j < nbColonnes; j++) {
            if (estBoutonAllume(i, j)) {
                sb.append("[O] "); // [O] pour représenter un bouton allumé
            } else {
                sb.append("[X] "); // [X] pour représenter un bouton éteint
            }
        }
        sb.append("\n");
    }

    return sb.toString();
    }    
}

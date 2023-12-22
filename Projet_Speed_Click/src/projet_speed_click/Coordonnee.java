/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_speed_click;
/**
 *
 * @author mathi
 */
/**
 * La classe Coordonnee représente les coordonnées d'une cellule dans une grille.
 * Elle est utilisée pour spécifier la position d'un bouton dans le jeu Speed-Click.
 */
public class Coordonnee {

    private int ligne;     // La ligne de la cellule
    private int colonne;   // La colonne de la cellule

    /**
     * Constructeur de la classe Coordonnee.
     *
     * @param ligne   La ligne de la cellule.
     * @param colonne La colonne de la cellule.
     */
    public Coordonnee(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
    }

    /**
     * Obtient la ligne de la cellule.
     *
     * @return La ligne de la cellule.
     */
    public int getLigne() {
        return ligne;
    }

    /**
     * Obtient la colonne de la cellule.
     *
     * @return La colonne de la cellule.
     */
    public int getColonne() {
        return colonne;
    }
}


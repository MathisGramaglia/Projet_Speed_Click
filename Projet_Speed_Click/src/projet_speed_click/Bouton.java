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
 * La classe Bouton représente un bouton dans le jeu Speed-Click.
 * Chaque bouton peut être allumé ou éteint.
 */
public class Bouton {

    private boolean etat; // true si le bouton est allumé, sinon false

    /**
     * Constructeur de la classe Bouton.
     *
     * @param unEtat État initial du bouton (allumé ou éteint).
     */
    public Bouton(boolean unEtat) {
        etat = unEtat;
    }

    /**
     * Éteint le bouton.
     */
    public void boutonEteint() {
        etat = false;
    }

    /**
     * Allume le bouton.
     */
    public void boutonAllume() {
        etat = true;
    }

    /**
     * Vérifie si le bouton est éteint.
     *
     * @return True si le bouton est éteint, sinon False.
     */
    public boolean boutonEstEteint() {
        return !etat;
    }

    /**
     * Obtient l'état actuel du bouton.
     *
     * @return True si le bouton est allumé, sinon False.
     */
    public boolean getEtat() {
        return etat;
    }

    /**
     * Représentation textuelle du bouton.
     *
     * @return "O" si le bouton est allumé, sinon "X".
     */
    @Override
    public String toString() {
        return etat ? "O" : "X";
    }
}


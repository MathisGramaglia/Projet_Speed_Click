/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_speed_click;
/**
 *
 * @author mathi
 */
import java.util.Timer;
import java.util.TimerTask;

/**
 * La classe Chronometre permet de mesurer le temps écoulé pendant une période spécifiée.
 * Elle utilise un objet Timer pour déclencher une tâche à intervalles réguliers.
 */
public class Chronometre {

    private Timer timer;      // Objet Timer pour la gestion des tâches planifiées
    private long duree;       // Durée totale du chronomètre en millisecondes
    private long tempsDebut;  // Temps auquel le chronomètre a été démarré
    private boolean enCours;  // Indique si le chronomètre est en cours

    /**
     * Constructeur de la classe Chronometre.
     *
     * @param duree La durée totale du chronomètre en millisecondes.
     */
    public Chronometre(long duree) {
        this.duree = duree;
        this.enCours = false;
    }

    /**
     * Démarre le chronomètre.
     * Si le chronomètre n'est pas déjà en cours, il crée un Timer et planifie une tâche pour vérifier le temps écoulé.
     */
    public void demarrer() {
        if (!enCours) {
            timer = new Timer();
            tempsDebut = System.currentTimeMillis();
            timer.scheduleAtFixedRate(new TimerTask() {
                public void run() {
                    if (tempsEcoule() >= duree) {
                        arreter();
                    }
                }
            }, 0, 1000); // répète la tâche toutes les secondes
            enCours = true;
        }
    }

    /**
     * Arrête le chronomètre.
     * Si le chronomètre est en cours, il annule la tâche planifiée par le Timer.
     */
    public void arreter() {
        if (enCours) {
            timer.cancel();
            enCours = false;
        }
    }

    /**
     * Obtient le temps écoulé depuis le démarrage du chronomètre.
     *
     * @return Le temps écoulé en millisecondes.
     */
    public long tempsEcoule() {
        if (enCours) {
            long tempsActuel = System.currentTimeMillis();
            long tempsEcoule = tempsActuel - tempsDebut;

            // Assurez-vous de ne pas dépasser la durée totale spécifiée
            return Math.min(tempsEcoule, duree);
        } else {
            return 0;
        }
    }

    /**
     * Vérifie si le chronomètre est en cours.
     *
     * @return True si le chronomètre est en cours, sinon False.
     */
    public boolean estEnCours() {
        return enCours;
    }

    /**
     * Obtient la durée totale du chronomètre.
     *
     * @return La durée totale en millisecondes.
     */
    public long getDuree() {
        return duree;
    }
}


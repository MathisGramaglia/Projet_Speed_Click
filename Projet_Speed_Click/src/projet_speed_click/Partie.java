/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_speed_click;
/**
 *
 * @author mathi
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * La classe Partie représente une session de jeu dans Speed-Click.
 * Les joueurs doivent cliquer sur des boutons allumés dans une grille pendant une durée définie.
 * Le but est d'obtenir le meilleur score possible dans le temps imparti.
 */
public class Partie {
    private Grille grille;
    private Chronometre chronometre;
    private boolean enCours;
    private Map<Integer, int[]> touches;
    private boolean debutPartie;
    private long tempsDebutPartie;

/**
     * Constructeur de la classe Partie.
     *
     * @param nbLignes           Le nombre de lignes dans la grille.
     * @param nbColonnes         Le nombre de colonnes dans la grille.
     * @param dureePartieMillis  La durée totale de la partie en millisecondes.
     */
    public Partie(int nbLignes, int nbColonnes, int dureePartieMillis) {
        grille = new Grille(nbLignes, nbColonnes);
        chronometre = new Chronometre(dureePartieMillis);
        enCours = false;
        debutPartie = true;

        // Initialisez la correspondance des touches avec les touches numériques
        touches = new HashMap<>();
        int touche = 1;
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                touches.put(touche, new int[]{i, j});
                touche++;
            }
        }
    }

    /**
     * Méthode principale pour jouer une partie de Speed-Click.
     * Gère l'interaction avec l'utilisateur, le déroulement du jeu, et affiche les résultats.
     */
    public void jouerPartie() {
    Scanner scanner = new Scanner(System.in);

    boolean jouerNouvellePartie = true;

    while (jouerNouvellePartie) {
        // Affichage du message d'introduction
        System.out.println("Bienvenue sur Speed-Click, pour jouer entrez \"jouer\".");

        // Attente de la commande 'jouer' pour démarrer la partie
        while (!scanner.nextLine().equalsIgnoreCase("jouer")) {
            System.out.println("Pour jouer, entrez \"jouer\".");
        }

        System.out.println("La partie commence maintenant!");

        demarrerPartie();

        long tempsDebutPartie = System.currentTimeMillis(); // Enregistrez le temps de début de la partie

        while (enCours && chronometre.estEnCours()) {
            System.out.println("Appuyez sur une touche correspondant a un bouton (1-9) : ");

            try {
                int touche = scanner.nextInt();

                if (touches.containsKey(touche)) {
                    int[] coordonnees = touches.get(touche);
                    clicBouton(coordonnees[0], coordonnees[1]);
                } else {
                    System.out.println("Touche non valide. Appuyez sur une touche correspondant a un bouton (1-9).");
                }
            } catch (Exception e) {
                System.out.println("Erreur lors de la saisie. Assurez-vous de saisir un nombre valide (1-9).");
                scanner.nextLine(); // Nettoyer la ligne incorrecte du scanner
            }

            // Vérifiez si le temps écoulé est supérieur ou égal à la durée spécifiée
            if (System.currentTimeMillis() - tempsDebutPartie >= chronometre.getDuree()) {
                arreterPartie();
            }
        }

        // Affichez le résultat de la partie terminée
        System.out.println("Partie terminee. Score final : " + grille.getScore());

        // Demandez à l'utilisateur s'il souhaite jouer une nouvelle partie
        jouerNouvellePartie = scanner.nextLine().equalsIgnoreCase("jouer");
    }

    System.out.println("Merci d'avoir joue a Speed-Click. Au revoir !");
    scanner.close();
}
    /**
     * Démarre une nouvelle partie.
     * Initialise la grille, active le chronomètre, et affiche la grille de départ.
     */
    public void demarrerPartie() {
        if (!enCours) {
            grille.eteindreTousLesBoutons();

            if (debutPartie) {
                grille.allumerBoutonAleatoire();
                enCours = true;
                tempsDebutPartie = System.currentTimeMillis(); // Enregistrez le temps de début de la partie
                chronometre.demarrer();
                afficherGrille();
                debutPartie = false;
            } else {
                grille.allumerBoutonAleatoire();
                enCours = true;

                // Si ce n'est pas le début de la partie, vérifiez si le temps écoulé est déjà supérieur ou égal à la durée spécifiée
                if (!chronometre.estEnCours() && chronometre.tempsEcoule() >= chronometre.getDuree()) {
                    arreterPartie();
                    return;
                }

                chronometre.demarrer();
                System.out.println("Nouvelle partie !");
                afficherGrille();
            }
        } else {
            System.out.println("La partie est deja en cours !");
        }
    }
    /**
     * Arrête la partie en cours.
     * Désactive le chronomètre et prépare la classe pour une nouvelle partie.
     */
    public void arreterPartie() {
        if (enCours) {
            chronometre.arreter(); // Utiliser la méthode arreter du chronomètre
            enCours = false;
            debutPartie = true; // Réinitialiser pour la prochaine partie
        } else {
            System.out.println("Aucune partie en cours !");
        }
    }
    /**
     * Gère le clic sur un bouton de la grille.
     *
     * @param ligne    La ligne du bouton cliqué.
     * @param colonne  La colonne du bouton cliqué.
     */
    public void clicBouton(int ligne, int colonne) {
    if (enCours) {
        if (!chronometre.estEnCours()) {
            chronometre.demarrer();
            tempsDebutPartie = System.currentTimeMillis();
            System.out.println("La partie a commence !");
        }

        // Vérifiez si le bouton actuel est correctement allumé
        if (grille.estBoutonAllume(ligne, colonne)) {
            grille.boutonClique();
            afficherGrille();

            // Vérifiez si tous les boutons sont éteints après chaque clic
            if (grille.tousLesBoutonsEteints()) {
                arreterPartie();
            }
        } else {
            System.out.println("Erreur de clic ! Score diminue.");

            // Diminuez le score si le bouton n'était pas allumé
            grille.boutonIncorrectClique();

            // Afficher et mettre à jour le score à chaque clic
            System.out.println("Score actuel : " + grille.getScore());
            afficherGrille();
        }

        // Ajoutez cette condition pour vérifier si le temps écoulé est supérieur ou égal à la durée spécifiée
        if (chronometre.estEnCours() && chronometre.tempsEcoule() >= chronometre.getDuree()) {
            arreterPartie();
        }
    } else {
        System.out.println("Aucune partie en cours !");
    }
}

    /**
     * Affiche la grille actuelle et le temps écoulé depuis le début de la partie.
     */
    public void afficherGrille() {
        System.out.println(grille);
        System.out.println("Temps ecoule : " + (chronometre.tempsEcoule() / 1_000) + " secondes");
    }
}

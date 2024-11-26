package com.beatthemall;

import java.util.ArrayList;

public class Carte {
    private String lieu;
    private String nom;
    private int debut;
    private int fin;
    private int etape;
    private ArrayList<Case> cases;

    public Carte(String lieu, String nom, int debut, int fin, int etape, ArrayList<Case> cases) {
        this.lieu = lieu;
        this.nom = nom;
        this.debut = debut;
        this.fin = fin;
        this.etape = etape;
        this.cases = cases;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDebut() {
        return debut;
    }

    public void setDebut(int debut) {
        this.debut = debut;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public int getEtape() {
        return etape;
    }

    public void setEtape(int etape) {
        this.etape = etape;
    }

    public String afficherEtape(int e) {
        StringBuilder str = new StringBuilder();

        // Contenu de la carte, chaque ligne pour chaque coordonnée
        // Affichage du haut, du milieu et du bas de chaque personnage
        for (int ligne = 0; ligne < 4; ligne++) {
            for (int i = e * 10; i <= e * 10 + 10; i++) {
                boolean estPersonnage = false;

                // Vérification pour afficher une porte (début ou fin d'étape)
                if (i % 10 == 0) {
                    if (ligne == 0) {
                        str.append("  ╓══╗  "); // Partie supérieure de la porte
                    } else if (ligne == 1) {
                        str.append("  ║  ║  "); // Partie centrale de la porte
                    } else if (ligne == 2) {
                        str.append("  ║  ║  "); // Partie inférieure de la porte
                    } else if (ligne == 3) {
                        str.append("        "); // Partie inférieure vide pour la porte
                    }
                    continue; // Passe au prochain index car la porte est prioritaire
                }

                // Affichage des personnages (Héros et Ennemis)
                for (Case aCase : cases) {
                    Personnage personnage = aCase.getPersonnage();
                    if (personnage.getCoordonnee() == i) {
                        estPersonnage = true;
                        if (personnage instanceof Hero) {
                            if (ligne == 0) {
                                str.append("  O  "); // Ligne 0 : tête du héros
                            } else if (ligne == 1) {
                                str.append(" /|\\ "); // Ligne 1 : corps du héros
                            } else if (ligne == 2) {
                                str.append(" / \\ "); // Ligne 2 : jambes du héros
                            } else if (ligne == 3) {
                                str.append("  " + i + "  "); // Ligne 3 : index
                            }
                        } else if (personnage instanceof Ennemi) {
                            if (ligne == 0) {
                                str.append("  X  "); // Ligne 0 : tête de l'ennemi
                            } else if (ligne == 1) {
                                str.append(" /|\\ "); // Ligne 1 : corps de l'ennemi
                            } else if (ligne == 2) {
                                str.append(" / \\ "); // Ligne 2 : jambes de l'ennemi
                            } else if (ligne == 3) {
                                str.append("  " + i + "  "); // Ligne 3 : index
                            }
                        }
                        break; // Un seul personnage par case
                    }
                }

                // Si aucune porte ni personnage, afficher une case vide
                if (!estPersonnage) {
                    if (ligne == 0 || ligne == 1) {
                        str.append("     "); // Vide pour les lignes 0 et 1
                    } else if (ligne == 2) {
                        str.append("  .  "); // Point pour la ligne 2
                    } else if (ligne == 3) {
                        str.append("  " + i + "  "); // Index pour la ligne 3
                    }
                }
            }
            str.append("\n"); // Passage à la ligne suivante pour chaque ligne de l'ASCII
        }

        return str.toString();
    }

    public void afficherCarte() {
        StringBuilder str = new StringBuilder();
        int nombreEtapes = (fin - debut + 1) / 10;

        for (int e = 0; e < nombreEtapes; e++) {
            str.append(afficherEtape(e));
        }

        System.out.println(str.toString());
    }

    public String toString() {
        StringBuilder str = new StringBuilder();

        // Calculer la longueur des chaînes pour ajuster l'espacement
        int maxLength = Math.max(nom.length(), lieu.length());
        int padding = 41 - maxLength; // Le cadre a une largeur fixe de 41 caractères, ajuster le padding

        str.append("╔═══════════════════════════════════════════╗\n");
        str.append("║   Carte : ").append(nom);
        for (int i = nom.length(); i < padding; i++) {
            str.append(" ");
        }

        str.append("║\n");
        str.append("║   Lieu  : ").append(lieu);
        for (int i = lieu.length(); i < padding; i++) {
            str.append(" ");
        }

        str.append("║\n");
        str.append("║   Étape : ").append(etape);
        for (int i = String.valueOf(etape).length(); i < padding; i++) {
            str.append(" ");
        }

        str.append("║\n");
        str.append("╚═══════════════════════════════════════════╝\n\n");

        return str.toString();
    }
}
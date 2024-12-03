package com.beatthemall;

import java.util.ArrayList;

/**
 * Représente une carte avec des étapes composées de cases.
 * Chaque carte a un lieu, un nom, un nombre d'étapes, 
 * et une matrice de cases représentant les étapes.
 */
public class Carte {
    /** Le lieu où se trouve la carte. */
    private String lieu;

    /** Le nom de la carte. */
    private String nom;

    /** Le nombre d'étapes de la carte. */
    private int nbEtape;

    /** Les cases représentant les étapes de la carte. */
    private ArrayList<ArrayList<Case>> cases;

    /**
     * Constructeur de la classe Carte.
     *
     * @param lieu    Le lieu où se trouve la carte.
     * @param nom     Le nom de la carte.
     * @param nbEtape Le nombre d'étapes de la carte.
     * @param cases   La matrice des cases de la carte.
     */
    public Carte(String lieu, String nom, int nbEtape, ArrayList<ArrayList<Case>> cases) {
        this.lieu = lieu;
        this.nom = nom;
        this.nbEtape = nbEtape;
        this.cases = cases;
    }

    /**
     * Obtient le lieu de la carte.
     *
     * @return Le lieu de la carte.
     */
    public String getLieu() {
        return lieu;
    }

    /**
     * Définit le lieu de la carte.
     *
     * @param lieu Le nouveau lieu de la carte.
     */
    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    /**
     * Obtient le nom de la carte.
     *
     * @return Le nom de la carte.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de la carte.
     *
     * @param nom Le nouveau nom de la carte.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtient le nombre d'étapes de la carte.
     *
     * @return Le nombre d'étapes.
     */
    public int getNbEtape() {
        return nbEtape;
    }

    /**
     * Définit le nombre d'étapes de la carte.
     *
     * @param nbEtape Le nouveau nombre d'étapes.
     */
    public void setNbEtape(int nbEtape) {
        this.nbEtape = nbEtape;
    }

    /**
     * Obtient la matrice des cases de la carte.
     *
     * @return La matrice des cases.
     */
    public ArrayList<ArrayList<Case>> getCases() {
        return cases;
    }

    /**
     * Définit la matrice des cases de la carte.
     *
     * @param cases La nouvelle matrice des cases.
     */
    public void setCases(ArrayList<ArrayList<Case>> cases) {
        this.cases = cases;
    }

    /**
     * Vérifie si tous les ennemis dans une étape sont morts.
     *
     * @param cases Les cases de l'étape.
     * @return {@code true} si tous les ennemis sont morts, sinon {@code false}.
     */
    public boolean isAllEnnemiDeadByEtape(ArrayList<Case> cases) {
        boolean res = true;
        for (Case aCase : cases) {
            Personnage personnage = aCase.getPersonnage();
            if (personnage instanceof Ennemi) {
                if (personnage.getPv() > 0) {
                    res = false;
                }
            }
        }
        return res;
    }

    /**
     * Affiche une étape de la carte sous forme ASCII.
     *
     * @param cases Les cases de l'étape.
     * @return Une chaîne de caractères représentant l'étape.
     */
    public String afficherEtape(ArrayList<Case> cases) {
        StringBuilder str = new StringBuilder();

        for (int ligne = 0; ligne < 4; ligne++) {
            boolean estPersonnage = false;

            if (ligne == 0) {
                str.append("  ╓══╗  ");
            } else if (ligne == 1) {
                str.append("  ║  ║  ");
            } else if (ligne == 2) {
                str.append("  ║  ║  ");
            } else if (ligne == 3) {
                str.append("        ");
            }

            for (int i = 0; i < cases.size(); i++) {
                Personnage personnage = cases.get(i).getPersonnage();
                if (personnage != null) {
                    estPersonnage = true;
                    if (personnage instanceof Hero) {
                        if (ligne == 0) {
                            str.append("  O  ");
                        } else if (ligne == 1) {
                            str.append(" /|\\ ");
                        } else if (ligne == 2) {
                            str.append(" / \\ ");
                        } else if (ligne == 3) {
                            str.append("  ").append(i).append("  ");
                        }
                    } else if (personnage instanceof Ennemi) {
                        if (ligne == 0) {
                            str.append("  X  ");
                        } else if (ligne == 1) {
                            str.append(" /|\\ ");
                        } else if (ligne == 2) {
                            str.append(" / \\ ");
                        } else if (ligne == 3) {
                            str.append("  ").append(i).append("  ");
                        }
                    }
                } else {
                    if (ligne == 0 || ligne == 1) {
                        str.append("     ");
                    } else if (ligne == 2) {
                        str.append("  .  ");
                    } else if (ligne == 3) {
                        str.append("  ").append(i).append("  ");
                    }
                }
            }

            if (ligne == 0) {
                str.append("  ╓══╗  ");
            } else if (ligne == 1) {
                str.append("  ║  ║  ");
            } else if (ligne == 2) {
                str.append("  ║  ║  ");
            } else if (ligne == 3) {
                str.append("        ");
            }
            str.append("\n");
        }
        return str.toString();
    }

    /**
     * Affiche l'ensemble de la carte, étape par étape.
     */
    public void afficherCarte() {
        StringBuilder str = new StringBuilder();

        for (ArrayList<Case> etape : cases) {
            str.append(afficherEtape(etape));
        }

        System.out.println(str.toString());
    }

    /**
     * Retourne une représentation textuelle de la carte.
     *
     * @return Une chaîne de caractères décrivant la carte.
     */
    public String toString() {
        StringBuilder str = new StringBuilder();

        int maxLength = Math.max(nom.length(), lieu.length());
        int padding = 41 - maxLength;

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
        str.append("║   Étape : ").append(nbEtape);
        for (int i = String.valueOf(nbEtape).length(); i < padding; i++) {
            str.append(" ");
        }

        str.append("║\n");
        str.append("╚═══════════════════════════════════════════╝\n\n");

        return str.toString();
    }
}

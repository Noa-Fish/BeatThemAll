package com.beatthemall;

import java.util.ArrayList;

public class Carte {
    private String lieu;
    private String nom;
    private int nbEtape;
    private ArrayList<ArrayList<Case>> cases;

    public Carte(String lieu, String nom,int nbEtape, ArrayList<ArrayList<Case>> cases) {
        this.lieu = lieu;
        this.nom = nom;
        this.nbEtape = nbEtape;
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


    public int getNbEtape() {
        return nbEtape;
    }

    public void setNbEtape(int nbEtape) {
        this.nbEtape = nbEtape;
    }

    public ArrayList<ArrayList<Case>> getCases() {return cases;}

    public void setCases(ArrayList<ArrayList<Case>> cases) {this.cases = cases;}

    public boolean isAllEnnemiDeadByEtape(ArrayList<Case> cases) {
        boolean res = true;
        for ( Case aCase : cases ){
            Personnage personnage = aCase.getPersonnage();
            if (personnage instanceof Ennemi){
                if (personnage.getPv()>0){
                    res = false;
                }
            }
        }

        return res;
    }

    public String afficherEtape(ArrayList<Case> cases) {
        StringBuilder str = new StringBuilder();

        for (int ligne = 0; ligne < 4; ligne++) {
            boolean estPersonnage = false;

            if (ligne == 0) {
                str.append("  ╓══╗  "); // Partie supérieure de la porte
            } else if (ligne == 1) {
                str.append("  ║  ║  "); // Partie centrale de la porte
            } else if (ligne == 2) {
                str.append("  ║  ║  "); // Partie inférieure de la porte
            } else if (ligne == 3) {
                str.append("        "); // Partie inférieure vide pour la porte
            }

            // Affichage des personnages (Héros et Ennemis)
            for (int i = 0; i < cases.size(); i++) {
                Personnage personnage = cases.get(i).getPersonnage();
                if (personnage != null) {
                    estPersonnage = true;
                    if (personnage instanceof Hero) {
                        if (ligne == 0) {
                            str.append("  O  "); // Ligne 0 : tête du héros
                        } else if (ligne == 1) {
                            str.append(" /|\\ "); // Ligne 1 : corps du héros
                        } else if (ligne == 2) {
                            str.append(" / \\ "); // Ligne 2 : jambes du héros
                        } else if (ligne == 3) {
                            str.append("  ").append(i).append("  "); // Ligne 3 : index
                        }
                    } else if (personnage instanceof Ennemi) {
                        if (ligne == 0) {
                            str.append("  X  "); // Ligne 0 : tête de l'ennemi
                        } else if (ligne == 1) {
                            str.append(" /|\\ "); // Ligne 1 : corps de l'ennemi
                        } else if (ligne == 2) {
                            str.append(" / \\ "); // Ligne 2 : jambes de l'ennemi
                        } else if (ligne == 3) {
                            str.append("  ").append(i).append("  "); // Ligne 3 : index
                        }
                    }
                }else {
                    if (ligne == 0 || ligne == 1) {
                        str.append("     "); // Vide pour les lignes 0 et 1
                    } else if (ligne == 2) {
                        str.append("  .  "); // Point pour la ligne 2
                    } else if (ligne == 3) {
                        str.append("  ").append(i).append("  "); // Index pour la ligne 3
                    }
                }
            }
            if (ligne == 0) {
                str.append("  ╓══╗  "); // Partie supérieure de la porte
            } else if (ligne == 1) {
                str.append("  ║  ║  "); // Partie centrale de la porte
            } else if (ligne == 2) {
                str.append("  ║  ║  "); // Partie inférieure de la porte
            } else if (ligne == 3) {
                str.append("        "); // Partie inférieure vide pour la porte
            }
            str.append("\n");
        }
         // Passage à la ligne suivante pour chaque ligne de l'ASCII
        return str.toString();
    }

    public void afficherCarte() {
        StringBuilder str = new StringBuilder();

        for (ArrayList<Case> etape : cases) {
            str.append(afficherEtape(etape));
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
        str.append("║   Étape : ").append(nbEtape);
        for (int i = String.valueOf(nbEtape).length(); i < padding; i++) {
            str.append(" ");
        }

        str.append("║\n");
        str.append("╚═══════════════════════════════════════════╝\n\n");

        return str.toString();
    }
}
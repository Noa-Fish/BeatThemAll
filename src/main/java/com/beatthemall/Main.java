// Nousseïba Tazani et Noa Watel
package com.beatthemall;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void afficherTitre() {
        System.out.println("  ____             _     _____ _                         _    _ _ \n" + " | __ )  ___  __ _| |_  |_   _| |__   ___ _ __ ___      / \\  | | | \n" + " |  _ \\ / _ \\/ _` | __|   | | | '_ \\ / _ \\ '_ ` _ \\    / _ \\ | | | \n" + " | |_) |  __/ (_| | |_    | | | | | |  __/ | | | | |  / ___ \\| | | \n" + " |____/ \\___|\\__,_|\\__|   |_| |_| |_|\\___|_| |_| |_| /_/   \\_\\_|_| \n");
    }

    public static void afficherEtape(int etape) {
        System.out.println("       --------------------- Etape "+etape+" -----------------------");
    }

    // Méthode générique pour valider les choix de l'utilisateur
    public static int validerChoix(int maxChoix, String message) {
        Scanner scanner = new Scanner(System.in);
        int choix;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                choix = scanner.nextInt();
                if (choix >= 0 && choix < maxChoix) {
                    return choix;
                }
            }
            System.out.println("Erreur, veuillez entrer un choix valide.");
            scanner.nextLine(); // Consomme l'entrée invalide
        }
    }

    // Créer une étape à partir de la liste de cases
    public static ArrayList<Case> creerEtape(int taille, ArrayList<Case> cases) {
        ArrayList<Case> etape = new ArrayList<>();
        for (int i = 0; i < taille; i++) etape.add(new Case());
        for (Case c : cases) {
            if (c.getPersonnage() != null && c.getPersonnage().getPv() > 0) {
                int position = c.getPersonnage().getCoordonnee();
                if (position >= 0 && position < taille) {
                    etape.set(position, c);
                }
            }
        }
        return etape;
    }

    // Choix du héros
    public static Hero choixHero() {
        ArrayList<Hero> heros = new ArrayList<>();
        heros.add(new Hero("hero0", 180, 2, 1, 0, 1, new Matrix()));
        heros.add(new Hero("hero1", 180, 2, 1, 0, 1, new Soin()));
        heros.add(new Hero("hero2", 180, 2, 1, 0, 1, new OneShot()));

        for (int i = 0; i < heros.size(); i++) {
            System.out.println(i + ". " + heros.get(i));
        }
        int choix = validerChoix(heros.size(), "Choisissez un héros : ");
        System.out.println("Héros choisi : " + heros.get(choix));
        return heros.get(choix);
    }

    // Choix de la carte
    public static Carte choixCarte(Hero hero) {
        // Étape 1
        ArrayList<Case> casesEtape1 = new ArrayList<>();
        casesEtape1.add(new Case(hero));
        casesEtape1.add(new Case(new Ennemi("ennemi1", 1, 1, 1, 5, 1)));
        casesEtape1.add(new Case(new Ennemi("ennemi2", 1, 1, 1, 9, 1)));

        // Étape 2
        ArrayList<Case> casesEtape2 = new ArrayList<>();
        casesEtape2.add(new Case(new Ennemi("ennemi3", 1, 1, 1, 5, 1)));
        casesEtape2.add(new Case(new Ennemi("ennemi4", 1, 1, 1, 9, 1)));

        // Étape 3
        ArrayList<Case> casesEtape3 = new ArrayList<>();
        casesEtape3.add(new Case(new Ennemi("ennemi5", 1, 1, 1, 5, 1)));
        casesEtape3.add(new Case(new Ennemi("ennemi6", 1, 1, 1, 9, 1)));

        // Étapes complètes
        ArrayList<ArrayList<Case>> cases = new ArrayList<>();
        cases.add(creerEtape(10, casesEtape1));
        cases.add(creerEtape(10, casesEtape2));
        cases.add(creerEtape(10, casesEtape3));

        Carte carte = new Carte("Forêt", "Mission 1", cases.size(), cases);

        System.out.println("0.\n" + carte);
        validerChoix(1, "Choisissez une carte : ");
        return carte;
    }

    public static void main(String[] args) {
        afficherTitre();
        Hero hero = choixHero();
        Carte carte = choixCarte(hero);

        int etape = 0;
        while (etape < carte.getCases().size()) {
            afficherEtape(etape);
            ArrayList<Case> casesEtape = carte.getCases().get(etape);
            carte.getCases().set(etape, creerEtape(casesEtape.size(), casesEtape));
            System.out.println(carte.afficherEtape(casesEtape));

            System.out.println("Choisissez une action :\n1. Avancer\n2. Reculer\n3. Attaquer");
            int choix = validerChoix(4, "Action : ");

            switch (choix) {
                case 1 -> {
                    hero.avance(casesEtape);
                }
                case 2 -> {
                    hero.recule();
                }
                case 3 -> {
                    System.out.println("Choisissez un ennemi à attaquer :");
                    ArrayList<Integer> indicesEnnemis = new ArrayList<>();
                    for (int i = 0; i < casesEtape.size(); i++) {
                        if (casesEtape.get(i).getPersonnage() instanceof Ennemi) {
                            System.out.println(indicesEnnemis.size() + ". " + casesEtape.get(i).getPersonnage());
                            indicesEnnemis.add(i);
                        }
                    }

                    if (indicesEnnemis.isEmpty()) {
                        System.out.println("Aucun ennemi à attaquer !");
                    } else {
                        int choix2 = validerChoix(indicesEnnemis.size(), "Ennemi : ");
                        int indexReel = indicesEnnemis.get(choix2);
                        hero.attaquer(casesEtape.get(indexReel).getPersonnage());
                    }
                }
                default -> System.out.println("Choix invalide.");
            }

            carte.getCases().set(etape, creerEtape(casesEtape.size(), casesEtape));

            if (carte.isAllEnnemiDeadByEtape(casesEtape)) {
                etape++;
                if (etape < carte.getCases().size()) {
                    hero.setCoordonnee(0);
                    carte.getCases().get(etape).set(0, new Case(hero));
                }
            }
        }
        System.out.println("GAGNÉ !!!");
    }
}
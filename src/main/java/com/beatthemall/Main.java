//Implémentation des héros, ennemis et cartes
// Nousseïba Tazani et Noa Watel
package com.beatthemall;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

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
        heros.add(new Hero("Archer Sylvestre", 120, 60, 60, 0, 1, new Matrix()));
        heros.add(new Hero("Mage des Éléments", 180, 40, 80, 0, 1, new Soin()));
        heros.add(new Hero("Paladin Sacré", 100, 100, 20, 0, 1, new OneShot()));

        for (int i = 0; i < heros.size(); i++) {
            System.out.println(i + ". " + heros.get(i));
        }
        int choix = validerChoix(heros.size(), "Choisissez un héros : ");
        System.out.println("Héros choisi : " + heros.get(choix));
        return heros.get(choix);
    }

    // Choix de la carte
    public static Carte choixCarte(Hero hero) {
        //Création Carte 1
        // Étape 1
        ArrayList<Case> casesEtape11 = new ArrayList<>();
        casesEtape11.add(new Case(hero));
        casesEtape11.add(new Case(new Ennemi("Brigand", 120, 60, 40, 5, 1)));
        casesEtape11.add(new Case(new Ennemi("Brigand", 120, 60, 40, 9, 1)));

        // Étape 2
        ArrayList<Case> casesEtape12 = new ArrayList<>();
        casesEtape12.add(new Case(new Ennemi("Catcheur", 250, 80, 60, 3, 1)));
        casesEtape12.add(new Case(new Ennemi("Catcheur", 250, 80, 60, 7, 1)));
        casesEtape12.add(new Case(new Ennemi("Brigand", 120, 60, 40, 9, 1)));

        // Étape 3
        ArrayList<Case> casesEtape13 = new ArrayList<>();
        casesEtape13.add(new Case(new Ennemi("Catcheur", 250, 80, 60, 4, 1)));
        casesEtape13.add(new Case(new Ennemi("Gangster", 100, 80, 40, 9, 3)));

        // Étapes complètes
        ArrayList<ArrayList<Case>> cases1 = new ArrayList<>();
        cases1.add(creerEtape(10, casesEtape11));
        cases1.add(creerEtape(10, casesEtape12));
        cases1.add(creerEtape(10, casesEtape13));

        //Création Carte 2
        // Étape 1
        ArrayList<Case> casesEtape21 = new ArrayList<>();
        casesEtape21.add(new Case(hero));
        casesEtape21.add(new Case(new Ennemi("Brigand", 120, 60, 40, 2, 1)));
        casesEtape21.add(new Case(new Ennemi("Brigand", 120, 60, 40, 4, 1)));
        casesEtape21.add(new Case(new Ennemi("Brigand", 120, 60, 140, 8, 1)));

        // Étape 2
        ArrayList<Case> casesEtape22 = new ArrayList<>();
        casesEtape22.add(new Case(new Ennemi("Catcheur", 250, 80, 60, 3, 1)));
        casesEtape22.add(new Case(new Ennemi("Catcheur", 250, 80, 60, 7, 1)));
        casesEtape22.add(new Case(new Ennemi("Gangster", 100, 80, 40, 9, 3)));

        // Étapes complètes
        ArrayList<ArrayList<Case>> cases2 = new ArrayList<>();
        cases2.add(creerEtape(10, casesEtape21));
        cases2.add(creerEtape(10, casesEtape22));

        //Création Carte 3
        // Étape 1
        ArrayList<Case> casesEtape31 = new ArrayList<>();
        casesEtape31.add(new Case(hero));
        casesEtape31.add(new Case(new Ennemi("Brigand", 120, 60, 40, 5, 1)));
        casesEtape31.add(new Case(new Ennemi("Catcheur", 250, 80, 60, 9, 1)));

        // Étape 2
        ArrayList<Case> casesEtape32 = new ArrayList<>();
        casesEtape32.add(new Case(new Ennemi("Catcheur", 250, 80, 60, 3, 1)));
        casesEtape32.add(new Case(new Ennemi("Catcheur", 250, 80, 60, 7, 1)));
        casesEtape32.add(new Case(new Ennemi("Brigand", 120, 60, 40, 9, 1)));

        // Étape 3
        ArrayList<Case> casesEtape33 = new ArrayList<>();
        casesEtape33.add(new Case(new Ennemi("Gangster", 100, 80, 40, 4, 3)));
        casesEtape33.add(new Case(new Ennemi("Gangster", 100, 80, 40, 9, 3)));

        // Étapes complètes
        ArrayList<ArrayList<Case>> cases3 = new ArrayList<>();
        cases3.add(creerEtape(10, casesEtape31));
        cases3.add(creerEtape(10, casesEtape32));
        cases3.add(creerEtape(10, casesEtape33));

        ArrayList<Carte> cartes = new ArrayList<>();
        cartes.add(new Carte(("Forêt Enchantée", "Mission 1", cases1.size(), cases1)));
        cartes.add(new Carte(("Désert des Mirages", "Mission 2", cases2.size(), cases2)));
        cartes.add(new Carte(("Île Perdue", "Mission 3", cases3.size(), cases3)));

        for (int i = 0; i < cartes.size(); i++) {
            System.out.println(i + ". " + cartes.get(i));
        }
        int choix = validerChoix(cartes.size(), "Choisissez une carte : ");
        System.out.println("Carte choisie : " + cartes.get(choix));
        return cartes.get(choix);
    
    }


    private static void attaquerEnnemi(Hero hero, ArrayList<Case> casesEtape) {
        ArrayList<Integer> indicesEnnemis = new ArrayList<>();
        System.out.println("Choisissez un ennemi à attaquer :");

        // Récupérer et afficher les ennemis
        for (int i = 0; i < casesEtape.size(); i++) {
            if (casesEtape.get(i).getPersonnage() instanceof Ennemi) {
                System.out.println(indicesEnnemis.size() + ". " + casesEtape.get(i).getPersonnage());
                indicesEnnemis.add(i);
            }
        }

        // Gérer le cas où il n'y a pas d'ennemis
        if (indicesEnnemis.isEmpty()) {
            System.out.println("Aucun ennemi à attaquer !");
            return;
        }

        // Valider le choix et attaquer l'ennemi
        int choix = validerChoix(indicesEnnemis.size(), "Ennemi : ");
        int indexReel = indicesEnnemis.get(choix);
        hero.attaquer(casesEtape.get(indexReel).getPersonnage());
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

            System.out.println("Choisissez une action :\n1. Avancer\n2. Reculer\n3. Attaquer\n4. Attaque Spéciale");
            int choix = validerChoix(5, "Action : ");

            switch (choix) {
                case 1 -> hero.avance(casesEtape);
                case 2 -> hero.recule();
                case 3 -> {
                    Random random = new Random();
                    int attaques = random.nextInt(5) + 1;
                    System.out.println("Le héros attaque " + attaques + " fois !");
                    for (int i = 0; i < attaques; i++) {
                        attaquerEnnemi(hero, casesEtape);
                    }
                }
                case 4 -> hero.utiliserCapaciteSpeciale(casesEtape);
                default -> System.out.println("Choix invalide.");
            }

            // Phase d'attaque des ennemis
            for (Case c : casesEtape) {
                if (c.getPersonnage() instanceof Ennemi ennemi && ennemi.getPv() > 0) {
                    ennemi.attaquer(hero);
                }
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
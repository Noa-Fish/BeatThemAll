//Nousseïba Tazana & Noa Watel
package com.beatthemall;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = com.beatthemall.utils.LoggerManager.getInstance().getLogger(Main.class.getName());

    public static void afficherTitre() {
        LOGGER.log(Level.INFO, """
                ____             _     _____ _                         _    _ _ 
               | __ )  ___  __ _| |_  |_   _| |__   ___ _ __ ___      / \\  | | | 
               |  _ \\ / _ \\/ _` | __|   | | | '_ \\ / _ \\ '_ ` _ \\    / _ \\ | | | 
               | |_) |  __/ (_| | |_    | | | | | |  __/ | | | | |  / ___ \\| | | 
               |____/ \\___|\\__,_|\\__|   |_| |_| |_|\\___|_| |_| |_| /_/   \\_\\_|_|
               """);
    }

    public static void afficherEtape(int etape) {
        LOGGER.log(Level.INFO, String.format("--------------------- Etape %d -----------------------", etape));
    }

    public static int validerChoix(int maxChoix, String message) {
        Scanner scanner = new Scanner(System.in);
        int choix;
        while (true) {
            LOGGER.log(Level.INFO, message);
            if (scanner.hasNextInt()) {
                choix = scanner.nextInt();
                if (choix >= 0 && choix < maxChoix) {
                    return choix;
                }
            }
            LOGGER.log(Level.WARNING, "Erreur, veuillez entrer un choix valide.");
            scanner.nextLine();
        }
    }

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

    public static Hero choixHero() {
        ArrayList<Hero> heros = new ArrayList<>();
        heros.add(new Hero("Archer Sylvestre", 120, 60, 60, 0, 1, new OneShot()));
        heros.add(new Hero("Mage des Éléments", 180, 40, 80, 0, 1, new Soin()));
        heros.add(new Hero("Paladin Sacré", 100, 100, 20, 0, 1, new OneShot()));

        LOGGER.log(Level.INFO, "Liste des héros disponibles :");
        for (int i = 0; i < heros.size(); i++) {
            LOGGER.log(Level.INFO, String.format(".%d : %s", i, heros.get(i)));
        }

        int choix = validerChoix(heros.size(), "Choisissez un héros : ");
        LOGGER.log(Level.INFO, String.format("Héros choisi : %s", heros.get(choix)));
        return heros.get(choix);
    }

    public static Carte choixCarte(Hero hero) {
        // Création des cartes
        ArrayList<ArrayList<Case>> cases1 = new ArrayList<>();
        cases1.add(creerEtape(10, new ArrayList<>(List.of(new Case(hero), new Case(new Ennemi("Brigand", 120, 60, 40, 5, 1)), new Case(new Ennemi("Brigand", 120, 60, 40, 9, 1))))));
        cases1.add(creerEtape(10, new ArrayList<>(List.of(new Case(new Ennemi("Catcheur", 250, 80, 60, 3, 1)), new Case(new Ennemi("Catcheur", 250, 80, 60, 7, 1)), new Case(new Ennemi("Brigand", 120, 60, 40, 9, 1))))));
        cases1.add(creerEtape(10, new ArrayList<>(List.of(new Case(new Ennemi("Catcheur", 250, 80, 60, 4, 1)), new Case(new Ennemi("Gangster", 100, 80, 40, 9, 3))))));

        ArrayList<ArrayList<Case>> cases2 = new ArrayList<>();
        cases2.add(creerEtape(10, new ArrayList<>(List.of(new Case(hero), new Case(new Ennemi("Brigand", 120, 60, 40, 2, 1)), new Case(new Ennemi("Brigand", 120, 60, 140, 8, 1))))));
        cases2.add(creerEtape(10, new ArrayList<>(List.of(new Case(new Ennemi("Catcheur", 250, 80, 60, 3, 1)), new Case(new Ennemi("Gangster", 100, 80, 40, 9, 3))))));

        ArrayList<Carte> cartes = new ArrayList<>();
        cartes.add(new Carte("Forêt Enchantée", "Mission 1", cases1.size(), cases1));
        cartes.add(new Carte("Désert des Mirages", "Mission 2", cases2.size(), cases2));

        LOGGER.log(Level.INFO, "Liste des cartes disponibles :");
        for (int i = 0; i < cartes.size(); i++) {
            LOGGER.log(Level.INFO, String.format("%d.\n%s", i, cartes.get(i)));
        }

        int choix = validerChoix(cartes.size(), "Choisissez une carte : ");
        LOGGER.log(Level.INFO, String.format("Carte choisie :\n%s", cartes.get(choix)));
        return cartes.get(choix);
    
    }


    private static void attaquerEnnemi(Hero hero, ArrayList<Case> casesEtape) {
        ArrayList<Integer> indicesEnnemis = new ArrayList<>();
        LOGGER.log(Level.INFO, "Choisissez un ennemi à attaquer :");

        // Récupérer et afficher les ennemis
        for (int i = 0; i < casesEtape.size(); i++) {
            if (casesEtape.get(i).getPersonnage() instanceof Ennemi) {
                LOGGER.log(Level.INFO, String.format("%d. %s", indicesEnnemis.size(), casesEtape.get(i).getPersonnage()));
                indicesEnnemis.add(i);
            }
        }

        // Gérer le cas où il n'y a pas d'ennemis
        if (indicesEnnemis.isEmpty()) {
            LOGGER.log(Level.INFO, "Aucun ennemi à attaquer !");
            return;
        }

        // Valider le choix et attaquer l'ennemi
        int choix = validerChoix(indicesEnnemis.size(), "Ennemi : ");
        int indexReel = indicesEnnemis.get(choix);
        hero.attaquer(casesEtape.get(indexReel).getPersonnage());
    }

    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "Nousseïba Tazana & Noa Watel");
        afficherTitre();
        Hero hero = choixHero();
        Carte carte = choixCarte(hero);

        int etape = 0;
        while (etape < carte.getCases().size() && hero.getPv() > 0) {
            afficherEtape(etape);
            ArrayList<Case> casesEtape = carte.getCases().get(etape);
            carte.getCases().set(etape, creerEtape(casesEtape.size(), casesEtape));
            LOGGER.log(Level.INFO, carte.afficherEtape(casesEtape));

            LOGGER.log(Level.INFO, "Choisissez une action :\n1. Avancer\n2. Reculer\n3. Attaquer\n4. Attaque Spéciale");
            int choix = validerChoix(5, "Action : ");

            // Phase d'attaque des ennemis
            for (Case c : casesEtape) {
                if (c.getPersonnage() instanceof Ennemi ennemi && ennemi.getPv() > 0) {
                    ennemi.attaquer(hero);
                }
            }

            switch (choix) {
                case 1 -> hero.avance(casesEtape);
                case 2 -> hero.recule();
                case 3 -> {
                    Random random = new Random();
                    int attaques = random.nextInt(5) + 1;
                    LOGGER.log(Level.INFO, "Le héros attaque " + attaques + " fois !");
                    for (int i = 0; i < attaques; i++) {
                        attaquerEnnemi(hero, casesEtape);
                    }
                }
                case 4 -> hero.utiliserCapaciteSpeciale(casesEtape);
                default -> LOGGER.log(Level.WARNING, "Choix invalide.");
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
        if (hero.getPv() > 0){
            LOGGER.log(Level.INFO, "GAGNÉ !!!");
        }else{
            LOGGER.log(Level.INFO, "PERDU !!!");
        }
    }
}
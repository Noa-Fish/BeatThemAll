// Nousseïba Tazani et Noa Watel
package com.beatthemall;

import java.util.ArrayList;
import java.util.Scanner;
import com.beatthemall.Hero;
import com.beatthemall.Carte;
import com.beatthemall.Ennemi;
import com.beatthemall.Matrix;
import com.beatthemall.Soin;
import com.beatthemall.OneShot;

public class Main {

    public static void afficherTitre(){
        System.out.println("  ____             _     _____ _                         _    _ _ \n" +
                " | __ )  ___  __ _| |_  |_   _| |__   ___ _ __ ___      / \\  | | | \n" +
                " |  _ \\ / _ \\/ _` | __|   | | | '_ \\ / _ \\ '_ ` _ \\    / _ \\ | | | \n" +
                " | |_) |  __/ (_| | |_    | | | | | |  __/ | | | | |  / ___ \\| | | \n" +
                " |____/ \\___|\\__,_|\\__|   |_| |_| |_|\\___|_| |_| |_| /_/   \\_\\_|_| \n");
    }

    public static Hero choixHero(){
        // Création d'une liste pour stocker des héros
        ArrayList<Hero> heros = new ArrayList<Hero>();

        // Ajout de différents héros avec leurs attributs et attaques spéciales
        heros.add(new Hero("hero0", 180, 1, 1, 0, 1, new Matrix()));
        heros.add(new Hero("hero1", 180, 1, 1, 0, 1, new Soin()));
        heros.add(new Hero("hero2", 180, 1, 1, 0, 1, new OneShot()));

        // Création d'une liste pour enregistrer les index valides des héros
        ArrayList<String> validIndexes = new ArrayList<>();

        for (int i = 0; i < heros.size(); i++) {
            validIndexes.add(String.valueOf(i)); // Ajoute l'index sous forme de chaîne de caractères
            System.out.println(i + ".  " + heros.get(i)); // Affiche l'index et le héros correspondant
        }

        // Préparation pour lire l'entrée utilisateur
        Scanner myObj = new Scanner(System.in);
        System.out.println("Choose a Hero: ");

        // Lecture de l'index du héros choisi par l'utilisateur
        String heroIndex = myObj.nextLine();

        // Vérification que l'entrée utilisateur correspond à un index valide
        while (!validIndexes.contains(heroIndex)) {
            System.out.println("Error, please choose a valid index: "); // Message d'erreur
            heroIndex = myObj.nextLine(); // Demande de ressaisie
        }

        // Affiche le héros sélectionné par l'utilisateur
        System.out.println("Chosen Hero: " + heros.get(Integer.parseInt(heroIndex)));
        return heros.get(Integer.parseInt(heroIndex));
    }

    public static Carte choixCarte(Hero hero){
        Ennemi ennemi1 = new Ennemi("ennemi1",180,1,1,5,1);
        Ennemi ennemi2 = new Ennemi("ennemi2",180,1,1,9,1);

        Ennemi ennemi3 = new Ennemi("ennemi3",180,1,1,15,1);
        Ennemi ennemi4 = new Ennemi("ennemi4",180,1,1,19,1);

        Ennemi ennemi5 = new Ennemi("ennemi5",180,1,1,25,1);
        Ennemi ennemi6 = new Ennemi("ennemi6",180,1,1,29,1);

        // Liste de personnages
        ArrayList<Case> cases = new ArrayList<Case>();
        cases.add(new Case(hero));
        cases.add(new Case(ennemi1));
        cases.add(new Case(ennemi2));
        cases.add(new Case(ennemi3));
        cases.add(new Case(ennemi4));
        cases.add(new Case(ennemi5));
        cases.add(new Case(ennemi6));

        // Crée une carte
        Carte carte = new Carte("Forêt", "Mission 1", 0, 30, 3, cases);


        ArrayList<Carte> cartes = new ArrayList<Carte>();
        cartes.add(carte);

        // Création d'une liste pour enregistrer les index valides des héros
        ArrayList<String> validIndexes = new ArrayList<>();

        for (int i = 0; i < cartes.size(); i++) {
            validIndexes.add(String.valueOf(i)); // Ajoute l'index sous forme de chaîne de caractères
            System.out.println(i + ".\n" + cartes.get(i)); // Affiche l'index et le héros correspondant
        }

        // Préparation pour lire l'entrée utilisateur
        Scanner myObj = new Scanner(System.in);
        System.out.println("Choose a Carte: ");

        // Lecture de l'index du héros choisi par l'utilisateur
        String carteIndex = myObj.nextLine();

        // Vérification que l'entrée utilisateur correspond à un index valide
        while (!validIndexes.contains(carteIndex)) {
            System.out.println("Error, please choose a valid index: "); // Message d'erreur
            carteIndex = myObj.nextLine(); // Demande de ressaisie
        }

        // Affiche le héros sélectionné par l'utilisateur
        System.out.println("Chosen Carte:\n" + cartes.get(Integer.parseInt(carteIndex)));
        return cartes.get(Integer.parseInt(carteIndex));
    }

    public static void main(String[] args) {
        afficherTitre();
        Hero hero = choixHero();
        Carte carte = choixCarte(hero);

        System.out.println("COORDONNEE : "+hero.getCoordonnee());
        System.out.println(carte.afficherEtape(0));

        hero.avance();

        System.out.println(carte.afficherEtape(0));

        hero.avance();

        System.out.println(carte.afficherEtape(0));
    }
}
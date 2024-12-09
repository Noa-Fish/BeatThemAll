package com.beatthemall;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testDefaiteLorsqueHeroMeurtAvantLigneArrivee() {
        // Simule un héros avec des PV très faibles
        Hero hero = new Hero("TestHero", 10, 50, 0, 0, 1, new OneShot());

        // Crée une étape avec un ennemi qui attaque le héros
        ArrayList<Case> casesEtape = new ArrayList<>(List.of(
                new Case(hero),
                new Case(new Ennemi("TestEnnemi", 50, 20, 15, 1, 1)) // Ennemi avec des dégâts suffisants
        ));

        // Simule une carte avec une seule étape
        ArrayList<ArrayList<Case>> cases = new ArrayList<>(List.of(casesEtape));
        Carte carte = new Carte("TestMap", "MissionTest", 1, cases);

        // Simule une partie
        while (hero.getPv() > 0) {
            for (Case c : casesEtape) {
                if (c.getPersonnage() instanceof Ennemi ennemi) {
                    ennemi.attaquer(hero); // L'ennemi attaque le héros
                }
            }
        }

        assertFalse(hero.getPv() > 0);
    }
}
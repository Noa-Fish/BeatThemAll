package com.beatthemall;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    void testAvancerAvecEnnemiDevant() {
        // Créer un héros avec une position initiale (par exemple, position 0)
        Hero hero = new Hero("TestHero", 100, 50, 30, 0, 0, new OneShot());

        // Créer un ennemi à la prochaine case (position 1)
        Ennemi ennemi = new Ennemi("TestEnnemi", 50, 20, 15, 1, 1);

        // La case 0 contient le héros, et la case 1 contient l'ennemi
        ArrayList<Case> casesEtape = new ArrayList<>(List.of(new Case(hero), new Case(ennemi)));

        // La carte avec une seule étape
        ArrayList<ArrayList<Case>> cases = new ArrayList<>(List.of(casesEtape));
        Carte carte = new Carte("TestMap", "MissionTest", 1, cases);

        // Vérifiez la position initiale du héros
        assertEquals(0, hero.getCoordonnee(), "Le héros doit commencer à la position 0.");

        // Le héros essaie d'avancer, mais il y a un ennemi à la case suivante
        hero.avance(casesEtape);

        // Vérifiez que la position du héros n'a pas changé (il ne doit pas avancer)
        assertEquals(0, hero.getCoordonnee(), "Le héros ne doit pas avancer car un ennemi bloque la route.");
    }

    @Test
    void testAvancerSansEnnemi() {
        // Créer un héros à la position 0
        Hero hero = new Hero("TestHero", 100, 50, 30, 0, 0, new OneShot());

        // Créer une case vide à la prochaine position (position 1)
        Ennemi ennemi = new Ennemi("TestEnnemi", 50, 20, 15, 1, 1);
        ArrayList<Case> casesEtape = new ArrayList<>(List.of(new Case(hero), new Case(null)));  // Pas d'ennemi ici

        // La carte avec une seule étape
        ArrayList<ArrayList<Case>> cases = new ArrayList<>(List.of(casesEtape));
        Carte carte = new Carte("TestMap", "MissionTest", 1, cases);

        // Vérifiez la position initiale du héros
        assertEquals(0, hero.getCoordonnee(), "Le héros doit commencer à la position 0.");

        // Le héros essaie d'avancer et doit réussir
        hero.avance(casesEtape);

        // Vérifiez que la position du héros a bien changé
        assertEquals(1, hero.getCoordonnee(), "Le héros doit avancer d'une position.");
    }

    @Test
    void testReculerSansEnnemi() {
        // Créer un héros à la position 1
        Hero hero = new Hero("TestHero", 100, 50, 30, 1, 0, new OneShot());

        // Créer une case vide à la position 0
        ArrayList<Case> casesEtape = new ArrayList<>(List.of(new Case(null), new Case(hero)));  // Pas d'ennemi ici

        // La carte avec une seule étape
        ArrayList<ArrayList<Case>> cases = new ArrayList<>(List.of(casesEtape));
        Carte carte = new Carte("TestMap", "MissionTest", 1, cases);

        // Vérifiez la position initiale du héros
        assertEquals(1, hero.getCoordonnee(), "Le héros doit commencer à la position 1.");

        // Le héros essaie de reculer et doit réussir
        hero.recule();

        // Vérifiez que la position du héros a bien changé
        assertEquals(0, hero.getCoordonnee(), "Le héros doit reculer d'une position.");
    }

    @Test
    void testReculerAvecEnnemi() {
        // Créer un héros à la position 1
        Hero hero = new Hero("TestHero", 100, 50, 30, 0, 0, new OneShot());
        ArrayList<Case> casesEtape = new ArrayList<>(List.of( new Case(hero)));

        // La carte avec une seule étape
        ArrayList<ArrayList<Case>> cases = new ArrayList<>(List.of(casesEtape));
        Carte carte = new Carte("TestMap", "MissionTest", 1, cases);

        // Vérifiez la position initiale du héros
        assertEquals(0, hero.getCoordonnee(), "Le héros doit commencer à la position 0.");

        // Le héros essaie de reculer, mais l'ennemi bloque
        hero.recule();

        // La position du héros ne doit pas changer, il doit être à la position 1
        assertEquals(0, hero.getCoordonnee(), "Le héros ne peut pas reculer car un ennemi bloque la route.");
    }

}
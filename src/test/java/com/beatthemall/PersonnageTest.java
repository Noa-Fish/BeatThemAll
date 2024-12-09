package com.beatthemall;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PersonnageTest {

    @Test
    void attaquer() {
        Hero hero = new Hero("Chevalier", 100, 50, 0, 0, 1, new OneShot());
        Ennemi ennemi = new Ennemi("Gobelin", 50, 0, 0, 1, 1);

        ArrayList<Case> etape = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            etape.add(new Case());
        }
        etape.set(ennemi.getCoordonnee(), new Case(ennemi));
        etape.set(hero.getCoordonnee(), new Case(hero));

        assertEquals(50, ennemi.getPv(), "L'ennemi devrait avoir 50 PV au départ.");

        hero.setCoordonnee(0);
        hero.attaquer(ennemi);

        assertEquals(0, ennemi.getPv(), "L'ennemi devrait avoir 0 PV après l'attaque.");

        assertNull(etape.get(5).getPersonnage(), "L'ennemi devrait avoir disparu du plateau.");
    }
}
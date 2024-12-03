package com.beatthemall;

import java.util.ArrayList;

/**
 * Implémentation de l'interface {@code AttaqueSpeciale} représentant une capacité spéciale appelée "Matrix".
 * Cette capacité permet au personnage d'esquiver les attaques pendant une durée déterminée.
 */
public class Matrix implements AttaqueSpeciale {

    /**
     * Exécute la capacité spéciale "Matrix" sur une cible.
     * Cette capacité permet au personnage d'esquiver toutes les attaques pendant 2 tours.
     *
     * @param cible Le personnage sur lequel la capacité est appliquée.
     */
    @Override
    public void executer(ArrayList<Case> cases) {
        // TODO: Logique pour esquiver les attaques pendant 2 tours
        System.out.println("esquive");
    }
}

package com.beatthemall;

import java.util.ArrayList;

/**
 * Implémentation de l'interface {@code AttaqueSpeciale} représentant une capacité spéciale appelée "OneShot".
 * Cette capacité élimine instantanément tous les ennemis d'une étape.
 */
public class OneShot implements AttaqueSpeciale {

    /**
     * Exécute la capacité spéciale "OneShot" sur une cible.
     * Si la cible est un ennemi, elle est immédiatement éliminée, ainsi que tous les autres ennemis de l'étape.
     *
     * @param cible Le personnage sur lequel la capacité est appliquée.
     */
    @Override
    public void executer(ArrayList<Case> cases) {
        System.out.println("One shot");
        for (int i = 0; i < cases.size(); i++) {
            Personnage personnage = cases.get(i).getPersonnage();
            if ( personnage instanceof Ennemi) {
                personnage.setPv(0);
            }
        }
    }
}


package com.beatthemall;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Implémentation de l'interface {@code AttaqueSpeciale} représentant une capacité spéciale appelée "OneShot".
 * Cette capacité élimine instantanément tous les ennemis d'une étape.
 */
public class OneShot implements AttaqueSpeciale {

    private static final Logger LOGGER = com.beatthemall.utils.LoggerManager.getInstance().getLogger(Main.class.getName());

    /**
     * Exécute la capacité spéciale "OneShot" sur une cible.
     * Si la cible est un ennemi, elle est immédiatement éliminée, ainsi que tous les autres ennemis de l'étape.
     *
     * @param cases La liste de case de l'étape.
     */
    @Override
    public void executer(ArrayList<Case> cases) {
        LOGGER.info("Attaque spécale utilisé : One shot");
        for (int i = 0; i < cases.size(); i++) {
            Personnage personnage = cases.get(i).getPersonnage();
            if ( personnage instanceof Ennemi) {
                personnage.setPv(0);
            }
        }
    }
}


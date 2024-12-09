package com.beatthemall;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Classe représentant une capacité spéciale de soin.
 * Cette capacité permet à un personnage de se soigner entièrement en récupérant tous ses points de vie.
 */
public class Soin implements AttaqueSpeciale {

    private static final Logger LOGGER = com.beatthemall.utils.LoggerManager.getInstance().getLogger(Main.class.getName());

    /**
     * Exécute la capacité spéciale de soin.
     * Cette méthode permet de soigner entièrement le personnage ciblé, en réinitialisant ses points de vie.
     * La logique exacte de guérison est à implémenter selon les règles du jeu.
     *
     * @param cases La liste de case de l'étape.
     */
    @Override
    public void executer(ArrayList<Case> cases) {
        LOGGER.info("Attaque spécale utilisé : Soin");
        for (int i = 0; i < cases.size(); i++) {
            Personnage personnage = cases.get(i).getPersonnage();
            if ( personnage instanceof Hero) {
                personnage.setPv(180);
            }
        }
    }
}

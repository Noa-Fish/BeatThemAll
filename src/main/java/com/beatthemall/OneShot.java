package com.beatthemall;

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
    public void executer(Personnage cible) {
        if (cible instanceof Ennemi) {
            // TODO: Logique pour éliminer tous les ennemis de l'étape
            System.out.println("One shot");
        }
    }
}


package com.beatthemall;

/**
 * Classe représentant une capacité spéciale de soin.
 * Cette capacité permet à un personnage de se soigner entièrement en récupérant tous ses points de vie.
 */
public class Soin implements AttaqueSpeciale {

    /**
     * Exécute la capacité spéciale de soin.
     * Cette méthode permet de soigner entièrement le personnage ciblé, en réinitialisant ses points de vie.
     * La logique exacte de guérison est à implémenter selon les règles du jeu.
     *
     * @param cible Le personnage ciblé par la capacité de soin.
     */
    @Override
    public void executer(Personnage cible) {
        // TODO: Logique pour se soigner entièrement
        System.out.println("Soin");
    }
}

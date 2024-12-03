package com.beatthemall;

/**
 * Représente un ennemi dans le jeu, qui est un type spécifique de personnage.
 */
public class Ennemi extends Personnage {

    /**
     * Constructeur pour créer un ennemi avec les attributs spécifiés.
     *
     * @param nom              Le nom de l'ennemi.
     * @param pv               Les points de vie de l'ennemi.
     * @param force            La force de l'ennemi, utilisée pour infliger des dégâts.
     * @param defense          La défense de l'ennemi, utilisée pour réduire les dégâts reçus.
     * @param coordonnee       La position de l'ennemi sur la carte.
     * @param distanceAttaque  La portée d'attaque de l'ennemi.
     */
    public Ennemi(String nom, int pv, int force, int defense, int coordonnee, int distanceAttaque) {
        super(nom, pv, force, defense, coordonnee, distanceAttaque);
    }
}

package com.beatthemall;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Représente un héros dans le jeu, qui est un type spécifique de personnage avec des capacités spéciales.
 */
public class Hero extends Personnage {

    private static final Logger LOGGER = com.beatthemall.utils.LoggerManager.getInstance().getLogger(Main.class.getName());

    /** Indique si la capacité spéciale du héros a déjà été utilisée. */
    private boolean capaciteUtilisee = false;

    /** L'attaque spéciale associée au héros. */
    private AttaqueSpeciale attaqueSpeciale;

    /**
     * Constructeur pour créer un héros avec les attributs spécifiés.
     *
     * @param nom              Le nom du héros.
     * @param pv               Les points de vie du héros.
     * @param force            La force du héros, utilisée pour infliger des dégâts.
     * @param defense          La défense du héros, utilisée pour réduire les dégâts reçus.
     * @param coordonnee       La position du héros sur la carte.
     * @param distanceAttaque  La portée d'attaque du héros.
     * @param attaqueSpeciale  L'attaque spéciale du héros.
     */
    public Hero(String nom, int pv, int force, int defense, int coordonnee, int distanceAttaque, AttaqueSpeciale attaqueSpeciale) {
        super(nom, pv, force, defense, coordonnee, distanceAttaque);
        this.capaciteUtilisee = false;
        this.attaqueSpeciale = attaqueSpeciale;
    }

    public void utiliserCapaciteSpeciale(ArrayList<Case> cases) {
        if (!capaciteUtilisee) {
            attaqueSpeciale.executer(cases);
            capaciteUtilisee = true;
        } else {
            LOGGER.info("Capacité déjà utilisée !");
        }
    }

    /**
     * Avance le héros d'une case dans l'étape actuelle, si la case suivante est libre.
     *
     * @param casesEtape La liste des cases de l'étape actuelle.
     * @throws IllegalStateException si la case suivante est occupée.
     */
    public void avance(ArrayList<Case> casesEtape) {
        if (casesEtape.get(this.getCoordonnee() + 1).getPersonnage() == null) {
            this.setCoordonnee(this.getCoordonnee() + 1);
        } else {
            LOGGER.warning("Erreur : impossible d'avancer.");
        }
    }

    /**
     * Recule le héros d'une case, si la position actuelle le permet.
     */
    public void recule() {
        if (this.getCoordonnee() - 1 >= 0) {
            this.setCoordonnee(this.getCoordonnee() - 1);
        }
    }
}

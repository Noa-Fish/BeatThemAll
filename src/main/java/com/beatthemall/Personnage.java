package com.beatthemall;

import java.util.logging.Logger;

/**
 * Classe représentant un personnage générique dans le jeu.
 * Un personnage possède des caractéristiques telles que des points de vie, une force, une défense, 
 * une position (coordonnée) et une distance d'attaque.
 */
public class Personnage {

    private static final Logger LOGGER = com.beatthemall.utils.LoggerManager.getInstance().getLogger(Main.class.getName());

    private String nom;
    private int pv;
    private int force;
    private int defense;
    private int coordonnee;
    private int distanceAttaque;

    /**
     * Constructeur de la classe {@code Personnage}.
     *
     * @param nom             Le nom du personnage.
     * @param pv              Les points de vie du personnage.
     * @param force           La force d'attaque du personnage.
     * @param defense         La défense du personnage.
     * @param coordonnee      La position actuelle du personnage sur le plateau.
     * @param distanceAttaque La distance maximale à laquelle le personnage peut attaquer.
     */
    public Personnage(String nom, int pv, int force, int defense, int coordonnee, int distanceAttaque) {
        this.nom = nom;
        this.pv = pv;
        this.force = force;
        this.defense = defense;
        this.coordonnee = coordonnee;
        this.distanceAttaque = distanceAttaque;
    }

    /**
     * Retourne le nom du personnage.
     *
     * @return Le nom du personnage.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom du personnage.
     *
     * @param nom Le nouveau nom du personnage.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne les points de vie du personnage.
     *
     * @return Les points de vie.
     */
    public int getPv() {
        return pv;
    }

    /**
     * Modifie les points de vie du personnage.
     *
     * @param pv Les nouveaux points de vie.
     */
    public void setPv(int pv) {
        this.pv = pv;
    }

    /**
     * Retourne la force du personnage.
     *
     * @return La force d'attaque.
     */
    public int getForce() {
        return force;
    }

    /**
     * Modifie la force du personnage.
     *
     * @param force La nouvelle force.
     */
    public void setForce(int force) {
        this.force = force;
    }

    /**
     * Retourne la défense du personnage.
     *
     * @return La défense.
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Modifie la défense du personnage.
     *
     * @param defense La nouvelle défense.
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * Retourne la position actuelle du personnage sur le plateau.
     *
     * @return La coordonnée du personnage.
     */
    public int getCoordonnee() {
        return coordonnee;
    }

    /**
     * Modifie la position actuelle du personnage sur le plateau.
     *
     * @param coordonnee La nouvelle coordonnée.
     */
    public void setCoordonnee(int coordonnee) {
        this.coordonnee = coordonnee;
    }

    /**
     * Retourne la distance maximale d'attaque du personnage.
     *
     * @return La distance d'attaque.
     */
    public int getDistanceAttaque() {
        return distanceAttaque;
    }

    /**
     * Modifie la distance maximale d'attaque du personnage.
     *
     * @param distanceAttaque La nouvelle distance d'attaque.
     */
    public void setDistanceAttaque(int distanceAttaque) {
        this.distanceAttaque = distanceAttaque;
    }

    /**
     * Permet au personnage d'attaquer une cible si elle est à portée.
     * Les dégâts infligés sont calculés comme la force du personnage moins la défense de la cible.
     * Si la cible est hors de portée ou si sa défense est trop élevée, l'attaque échoue.
     *
     * @param cible Le personnage ciblé par l'attaque.
     */
    public void attaquer(Personnage cible) {
        int distance = Math.abs(this.getCoordonnee() - cible.getCoordonnee());

        if (distance <= this.getDistanceAttaque()) {
            int degats = this.getForce() - cible.getDefense();

            if (degats > 0) {
                cible.setPv(cible.getPv() - degats);
                LOGGER.info(this.getNom() + " attaque " + cible.getNom() + " et inflige " + degats + " points de dégâts.");
            } else {
                LOGGER.info(this.getNom() + " attaque " + cible.getNom() + ", mais la défense de " + cible.getNom() + " est trop élevée !");
            }
        } else {
            LOGGER.info(this.getNom() + " ne peut pas attaquer " + cible.getNom() + " : la cible est hors de portée !");
        }
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères des attributs du personnage.
     *
     * @return Une chaîne contenant les informations du personnage.
     */
    @Override
    public String toString() {
        return "Personnage{" +
                "nom='" + nom + '\'' +
                ", pv=" + pv +
                ", force=" + force +
                ", defense=" + defense +
                ", coordonnee=" + coordonnee +
                ", distanceAttaque=" + distanceAttaque +
                '}';
    }
}



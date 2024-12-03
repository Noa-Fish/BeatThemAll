package com.beatthemall;

/**
 * Représente une case contenant potentiellement un personnage.
 */
public class Case {
    /** Le personnage présent sur la case, ou {@code null} si la case est vide. */
    private Personnage personnage;

    /**
     * Constructeur par défaut qui initialise une case vide.
     */
    public Case() {
        this.personnage = null;
    }

    /**
     * Constructeur qui initialise une case avec un personnage.
     *
     * @param personnage Le personnage à placer sur la case.
     */
    public Case(Personnage personnage) {
        this.personnage = personnage;
    }

    /**
     * Obtient le personnage présent sur la case.
     *
     * @return Le personnage sur la case, ou {@code null} si la case est vide.
     */
    public Personnage getPersonnage() {
        return personnage;
    }

    /**
     * Définit le personnage présent sur la case.
     *
     * @param personnage Le personnage à placer sur la case.
     */
    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }

    /**
     * Vérifie si la case est vide.
     *
     * @return {@code true} si la case est vide, sinon {@code false}.
     */
    public boolean estVide() {
        return personnage == null;
    }

    /**
     * Retourne une représentation textuelle de la case.
     *
     * @return Une chaîne de caractères décrivant la case et son personnage.
     */
    @Override
    public String toString() {
        return "Case{" +
                "personnage=" + personnage +
                '}';
    }
}

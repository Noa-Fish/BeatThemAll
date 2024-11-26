package com.beatthemall;

public class Personnage {
    private String nom;
    private int pv;
    private int force;
    private int defense;
    private int coordonnee;
    private int distanceAttaque;

    public Personnage(String nom, int pv, int force, int defense, int coordonnee, int distanceAttaque) {
        this.nom = nom;
        this.pv = pv;
        this.force = force;
        this.defense = defense;
        this.coordonnee = coordonnee;
        this.distanceAttaque = distanceAttaque;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getCoordonnee() {
        return coordonnee;
    }

    public void setCoordonnee(int coordonnee) {
        this.coordonnee = coordonnee;
    }

    public int getDistanceAttaque() {
        return distanceAttaque;
    }

    public void setDistanceAttaque(int distanceAttaque) {
        this.distanceAttaque = distanceAttaque;
    }

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


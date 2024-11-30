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

    public void attaquer(Personnage cible) {
        int distance = Math.abs(this.getCoordonnee() - cible.getCoordonnee());

        if (distance <= this.getDistanceAttaque()) {
            int degats = this.getForce() - cible.getDefense();

            if (degats > 0) {
                cible.setPv(cible.getPv() - degats);
                System.out.println(this.getNom() + " attaque " + cible.getNom() + " et inflige " + degats + " points de dégâts.");
            } else {
                System.out.println(this.getNom() + " attaque " + cible.getNom() + ", mais la défense de " + cible.getNom() + " est trop élevée !");
            }
        } else {
            System.out.println(this.getNom() + " ne peut pas attaquer " + cible.getNom() + " : la cible est hors de portée !");
        }
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


package com.beatthemall;

public class Case {
    private Personnage personnage;

    public Case() {
        this.personnage = null;
    }

    public Case(Personnage personnage) {
        this.personnage = personnage;
    }

    public Personnage getPersonnage() {
        return personnage;
    }

    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }

    public boolean estVide() {
        return personnage == null;
    }
}
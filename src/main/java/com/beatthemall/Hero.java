package com.beatthemall;

import java.util.ArrayList;

public class Hero extends Personnage {
    private boolean capaciteUtilisee = false;
    private AttaqueSpeciale attaqueSpeciale;

    public Hero(String nom, int pv, int force, int defense, int coordonnee, int distanceAttaque, AttaqueSpeciale attaqueSpeciale) {
        super(nom, pv, force, defense, coordonnee, distanceAttaque);
        this.capaciteUtilisee = false;
        this.attaqueSpeciale = attaqueSpeciale;
    }

    public void utiliserCapaciteSpeciale(ArrayList<Case> cases) {
        if (!capaciteUtilisee) {
            attaqueSpeciale.executer(cases);
            capaciteUtilisee = true;
        }
        else{
            System.out.println("Capacité déjà utilisée !");
        }
    }

    public void avance(ArrayList<Case> casesEtape) {
        if (casesEtape.get(this.getCoordonnee() + 1).getPersonnage() == null) {
            this.setCoordonnee(this.getCoordonnee() + 1);
        } else System.out.println("Erreur : impossible d'avancer.");
    }

    public void recule() {

        if (this.getCoordonnee() - 1 >= 0){
            this.setCoordonnee(this.getCoordonnee() - 1);
        }
    }
}

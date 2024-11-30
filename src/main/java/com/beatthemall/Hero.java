package com.beatthemall;

public class Hero extends Personnage {
    private boolean capaciteUtilisee = false;
    private AttaqueSpeciale attaqueSpeciale;

    public Hero(String nom, int pv, int force, int defense, int coordonnee, int distanceAttaque, AttaqueSpeciale attaqueSpeciale) {
        super(nom, pv, force, defense, coordonnee, distanceAttaque);
        this.capaciteUtilisee = false;
        this.attaqueSpeciale = attaqueSpeciale;
    }

    public void utiliserCapaciteSpeciale(Personnage cible) {
        if (!capaciteUtilisee) {
            attaqueSpeciale.executer(cible);
            capaciteUtilisee = true;
        }
        else{
            System.out.println("Capacité déjà utilisée !");
        }
    }

    public void avance() {
        this.setCoordonnee(this.getCoordonnee() + 1);
    }

    public void recule() {

        if (this.getCoordonnee() - 1 >= 0){
            this.setCoordonnee(this.getCoordonnee() - 1);
        }
    }
}

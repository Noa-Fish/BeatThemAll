public class Ennemi extends Personnage {

    public Ennemi(String nom, int pv, int force, int defense, int coordonnee, int distanceAttaque){
            super(nom, pv, force, defense, coordonnee, distanceAttaque);
    }
    
    public void capaciteSpeciale() {
        System.out.println("cameamea");
    }
}
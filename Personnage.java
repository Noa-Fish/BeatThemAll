public abstract class Personnage {

        public String nom;
        public int pv;
        public int force;
        public int defense;
        public int coordonnee;
        public int distanceAttaque;
    
        public Personnage(String nom, int pv, int force, int defense, int coordonnee, int distanceAttaque) {
            this.nom = nom;
            this.pv = pv;
            this.force = force;
            this.defense = defense;
            this.coordonnee = coordonnee;
            this.distanceAttaque = distanceAttaque;
        }
    
        
        public abstract void capaciteSpeciale();
    
        public void avance() {
            coordonnee += 1;
        }
    
        public void recul() {
            coordonnee -= 1;
        }
    
        public int getPv() {
            return pv;
        }
    
        public void setPv(int pv) {
            this.pv = pv;
        }
    
}

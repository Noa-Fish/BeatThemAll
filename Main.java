// Nousseïba Tazani et Noa Watel
public class Main {
    public static void main(String[] args) {
        Ennemi noa = new Ennemi("noa",180,1,1,1,1);
        Hero nousseiba = new Hero("nousseiba",180,1,1,1,1,new Matrix());
        nousseiba.utiliserCapaciteSpeciale(noa);
        nousseiba.utiliserCapaciteSpeciale(noa);
    }
}
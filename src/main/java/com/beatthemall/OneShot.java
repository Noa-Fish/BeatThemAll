package com.beatthemall;

import java.util.ArrayList;

public class OneShot implements AttaqueSpeciale {
    @Override
    public void executer(ArrayList<Case> cases) {
        System.out.println("One shot");
        for (int i = 0; i < cases.size(); i++) {
            Personnage personnage = cases.get(i).getPersonnage();
            if ( personnage instanceof Ennemi) {
                personnage.setPv(0);
            }
        }
    }
}

package com.beatthemall;

import java.util.ArrayList;

public class Soin implements AttaqueSpeciale {
    @Override
    public void executer(ArrayList<Case> cases) {
        // TODO: Logique pour se soigner entièrement
        System.out.println("Soin");
        for (int i = 0; i < cases.size(); i++) {
            Personnage personnage = cases.get(i).getPersonnage();
            if ( personnage instanceof Hero) {
                personnage.setPv(180);
            }
        }
    }
}
package com.example.cc.boterkaaseieren;

import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

/**
 * Created by cc on 30-11-2015.
 */
public class Spel {
    private ImageButton[][] tegels = new ImageButton[3][3];
    private ArrayList<Speler> spelers = new ArrayList<Speler>();
    private Speler beurt;

    public Spel(ArrayList<ImageButton> lijst, String str_spelers) {
        int volgende=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tegels[i][j] = lijst.get(volgende);
                volgende++;
            }
        }
        spelers.add(new Gebruiker(lijst));
        beurt = spelers.get(0);
        if (str_spelers.equals("1v1")) {

            spelers.add(new Gebruiker(lijst));

        } else {
            //if (str_spelers.equals("1vAi")){
            spelers.add(new Computerspeler(lijst));
        }
        spelers.get(0).setImage("X");
        spelers.get(1).setImage("O");

    }

    public void volgendezet(ImageButton knop) {
        beurt.zetSpelen(knop);
        if(isUitgespeeld()){
            lockImageButtons();
            Log.d("winnaar", "speler");
        }

        //verandert van beurt
        if (beurt.equals(spelers.get(0))) {
            //check of de speler tegen computer speelt
            if (spelers.get(1) instanceof Computerspeler) {
                spelers.get(1).zetSpelen(knop);
                if(isUitgespeeld()){
                    lockImageButtons();
                    Log.d("winnaar","computer");
                }
            } else {
                beurt = spelers.get(1);
            }


        } else if (beurt.equals(spelers.get(1)))

        {
            beurt = spelers.get(0);

        }
    }




    private void lockImageButtons() {
        // maakt de imagebuttons niet meer clickbaar
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tegels[i][j].setClickable(false);
            }
        }
    }

    private boolean isUitgespeeld() {
        boolean uitgespeeld = false;
        // TODO laten zien hoe er gewonnen is
        // TODO juiste manier vinden om te zien welke rij hetzelfde is background lukt niet
        // horizontale controle
        Log.d("back1",""+tegels[0][0].getBackground().);
        Log.d("back2",""+tegels[0][1].getBackground().getCurrent());
        Log.d("back3",""+tegels[0][2].getBackground());
        Log.d("check1",""+(!tegels[0][0].isClickable()));
        Log.d("check2", "" + tegels[0][0].getBackground().equals(tegels[0][1].getBackground()));
        Log.d("check3", "" + tegels[0][0].getBackground().equals(tegels[0][1].getBackground()));
        Log.d("checktot",""+(!tegels[0][0].isClickable()&&tegels[0][0].getBackground().equals(tegels[0][1].getBackground()) && tegels[0][0].getBackground().equals(tegels[0][2].getBackground())));
        if (!tegels[0][0].isClickable()&&tegels[0][0].getBackground().equals(tegels[0][1].getBackground()) && tegels[0][0].getBackground().equals(tegels[0][2].getBackground())) {
            uitgespeeld = true;
            Log.d("hori ","1");

        }
        if (!tegels[1][0].isClickable()&&tegels[1][0].getBackground().equals(tegels[1][1].getBackground()) && tegels[1][0].getBackground().equals(tegels[1][2].getBackground())) {
            uitgespeeld = true;
            Log.d("hori ","2");

        }
        if (!tegels[2][0].isClickable()&&tegels[2][0].getBackground().equals(tegels[2][1].getBackground()) && tegels[2][0].getBackground().equals(tegels[2][2].getBackground())) {
            uitgespeeld = true;
            Log.d("hori ","3");
        }

        //verticale controle

        if (!tegels[0][0].isClickable()&&tegels[0][0].getBackground().equals(tegels[1][0].getBackground()) && tegels[0][0].getBackground().equals(tegels[2][0].getBackground())) {
            uitgespeeld = true;
            Log.d("verti ","1");
        }
        if (!tegels[0][1].isClickable()&&tegels[0][1].getBackground().equals(tegels[1][1].getBackground()) && tegels[0][1].getBackground().equals(tegels[2][1].getBackground())) {
            uitgespeeld = true;
            Log.d("verti ","2");
        }
        if (!tegels[0][2].isClickable()&&tegels[0][2].getBackground().equals(tegels[1][2].getBackground()) && tegels[0][2].getBackground().equals(tegels[2][2].getBackground())) {
            uitgespeeld = true;
            Log.d("verti ","3");
        }

        //controle diogonaal
        if (!tegels[0][0].isClickable()&&tegels[0][0].getBackground().equals(tegels[1][1].getBackground()) && tegels[0][0].getBackground().equals(tegels[2][2].getBackground())) {
            uitgespeeld = true;
            Log.d("dio ","linksrechts");
        }
        if (!tegels[0][2].isClickable()&&tegels[0][2].getBackground().equals(tegels[1][1].getBackground()) && tegels[0][2].getBackground().equals(tegels[2][0].getBackground())) {
            uitgespeeld = true;
            Log.d("dio ","rechtlinks");
        }
        Log.d("uitgespeeld ",""+uitgespeeld);
        return uitgespeeld;
    }
}

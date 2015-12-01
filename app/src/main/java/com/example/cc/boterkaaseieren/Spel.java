package com.example.cc.boterkaaseieren;

import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

/**
 * Created by cc on 30-11-2015.
 */
public class Spel {
    private ImageButton [][] tegels=new ImageButton [3][3];
    private ArrayList<Speler> spelers=new ArrayList<Speler>();
    private Speler beurt;
    public Spel(ArrayList<ImageButton> lijst, String str_spelers){
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                tegels[i][j]= lijst.get(i+j);
            }
        }
        spelers.add(new Gebruiker(lijst));
        beurt= spelers.get(0);
        if (str_spelers.equals("1v1")){

            spelers.add(new Gebruiker(lijst));
        }
        else if (str_spelers.equals("1vAi")){
            spelers.add(new Computerspeler(lijst));
        }
    }
    public void volgendezet(ImageButton knop){
        if (beurt.equals(spelers.get(0))){
            spelers.get(0).zetSpelen(knop);
            beurt=spelers.get(1);
        }
        else if(beurt.equals(spelers.get(1))){
            spelers.get(1).zetSpelen(knop);
            beurt=spelers.get(0);
        }
    }
}

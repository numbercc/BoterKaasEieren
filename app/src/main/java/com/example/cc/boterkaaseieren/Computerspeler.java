package com.example.cc.boterkaaseieren;

import android.widget.ImageButton;

import java.util.ArrayList;

/**
 * Created by cc on 1-12-2015.
 */
public class Computerspeler extends Speler {
    public Computerspeler(ArrayList<ImageButton> lijst){
        boterKaasEireren=lijst;
    }

    @Override
    public void zetSpelen(ImageButton knop) {
        ArrayList<ImageButton> mogelijkeZetten=getMogelijkeZetten();
        int randomgetal=(int)(Math.random()*(double)mogelijkeZetten.size());
        // hier zet je de image om naar iets anders. ook is het nodig  de image knop niet clickbaar maken
        //mogelijkeZetten.get(randomgetal).seti
        //mogelijkeZetten.get(randomgetal).setClickable(false);
    }
    private ArrayList<ImageButton> getMogelijkeZetten(){
        // zoekt alle mogelijke zetten die de computer kan doen
        ArrayList<ImageButton>  mogelijkeZet=new ArrayList<ImageButton>();
        for (ImageButton knop:boterKaasEireren) {
            if(!knop.isClickable()){
                mogelijkeZet.add(knop);
            }
        }

        return mogelijkeZet;
    }
}

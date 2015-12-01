package com.example.cc.boterkaaseieren;

import android.util.Log;
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
        Log.d("mogelijke zetten",""+mogelijkeZetten.size());
        int randomgetal=(int)(Math.random()*(double)mogelijkeZetten.size());
        // hier zet je de image om naar iets anders. ook is het nodig  de image knop niet clickbaar maken
        if(image.equals("X")) {
            mogelijkeZetten.get(randomgetal).setImageResource(R.drawable.x);
            mogelijkeZetten.get(randomgetal).setTag("X");
        }
        else{
            //mogelijkeZetten.get(randomgetal).setImageResource(R.drawable.dot);
            mogelijkeZetten.get(randomgetal).setBackgroundColor(100);
            mogelijkeZetten.get(randomgetal).setTag("O");
        }
        mogelijkeZetten.get(randomgetal).setClickable(false);
    }
    private ArrayList<ImageButton> getMogelijkeZetten(){
        // zoekt alle mogelijke zetten die de computer kan doen
        ArrayList<ImageButton>  mogelijkeZet=new ArrayList<ImageButton>();
        for (ImageButton knop:boterKaasEireren) {
            if(knop.isClickable()){
                mogelijkeZet.add(knop);
            }
        }

        return mogelijkeZet;
    }
}

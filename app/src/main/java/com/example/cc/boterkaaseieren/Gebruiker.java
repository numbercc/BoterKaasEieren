package com.example.cc.boterkaaseieren;

import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

/**
 * Created by cc on 1-12-2015.
 */
public class Gebruiker extends Speler{
    public Gebruiker(ArrayList<ImageButton> lijst){
        boterKaasEireren=lijst;
    }
    @Override
    public void zetSpelen(ImageButton geklikteKnop) {
        for (ImageButton knop:boterKaasEireren) {
            if(geklikteKnop.equals(knop)){
                // hier gaat de speler een zet doen knop moet ook niet klikbaar maken
                //knop.seti
               // knop.setClickable(false);
            }
        }
    }
}

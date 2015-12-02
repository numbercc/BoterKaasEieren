package com.example.cc.boterkaaseieren;

import android.media.Image;
import android.widget.ImageButton;

import java.util.ArrayList;

/**
 * Created by cc on 30-11-2015.
 */
public abstract class Speler {
    protected String image;
    protected String naam;
    protected ArrayList<ImageButton> boterKaasEireren;

    public void setImage(String image) {
        this.image = image;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public abstract void zetSpelen(ImageButton knop);
}

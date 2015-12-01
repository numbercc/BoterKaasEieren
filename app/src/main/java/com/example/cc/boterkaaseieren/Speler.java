package com.example.cc.boterkaaseieren;

import android.widget.ImageButton;

import java.util.ArrayList;

/**
 * Created by cc on 30-11-2015.
 */
public abstract class Speler {
    protected String ZetImage;
    protected ArrayList<ImageButton> boterKaasEireren;

    public String getZetImage() {
        return ZetImage;
    }

    public void setZetImage(String zetImage) {
        ZetImage = zetImage;
    }
    public abstract void zetSpelen(ImageButton knop);
}

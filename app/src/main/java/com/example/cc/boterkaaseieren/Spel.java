package com.example.cc.boterkaaseieren;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by cc on 30-11-2015.
 */
public class Spel implements Parcelable{
    private ImageButton[][] tegels = new ImageButton[3][3];
    private ArrayList<Speler> spelers = new ArrayList<>();
    private Speler beurt;

    public Spel(ArrayList<ImageButton> lijst, String str_spelers) {

        matrixMaken(lijst);
        spelers.add(new Gebruiker(lijst));
        beurt = spelers.get(0);
        //spelers.add(new Gebruiker(lijst));
        if (str_spelers.equals("1v1")) {

            spelers.add(new Gebruiker(lijst));
            spelers.get(1).setNaam("speler 2");

        } else if (str_spelers.equals("1vAi")){
            spelers.add(new Computerspeler(lijst));
            spelers.get(1).setNaam("AI");
        }
        spelers.get(0).setImage("X");
        spelers.get(0).setNaam("speler 1");
        spelers.get(1).setImage("O");

    }
    public void matrixMaken(ArrayList<ImageButton> lijst){

        int volgende=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tegels[i][j] = lijst.get(volgende);
                volgende++;
            }
        }
    }

    public void setTegels(ArrayList<ImageButton> tegels) {
        matrixMaken(tegels);
        for (Speler speler:spelers) {
            speler.setBoterKaasEireren(tegels);
        }
    }

    public ImageButton[][] getTegels() {
        return tegels;
    }

    protected Spel(Parcel in) {
    }

    public static final Creator<Spel> CREATOR = new Creator<Spel>() {
        @Override
        public Spel createFromParcel(Parcel in) {
            return new Spel(in);
        }

        @Override
        public Spel[] newArray(int size) {
            return new Spel[size];
        }
    };

    public Speler volgendezet(ImageButton knop) {
        Speler winnaar=null;
        beurt.zetSpelen(knop);
        if(isUitgespeeld()){
            lockImageButtons();
            winnaar=beurt;
        }
        else{
        //verandert van beurt
        if (beurt.equals(spelers.get(0))) {
            //check of de speler tegen computer speelt
            if (spelers.get(1) instanceof Computerspeler) {
                spelers.get(1).zetSpelen(knop);
                if(isUitgespeeld()){
                    lockImageButtons();
                    winnaar=spelers.get(1);
                }
            } else {
                beurt = spelers.get(1);
            }


        } else if (beurt.equals(spelers.get(1)))

        {
            beurt = spelers.get(0);

        }}
        return winnaar;
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
        if (!tegels[0][0].isClickable()&&tegels[0][0].getTag().equals(tegels[0][1].getTag()) && tegels[0][0].getTag().equals(tegels[0][2].getTag())) {
            uitgespeeld = true;


        }
        if (!tegels[1][0].isClickable()&&tegels[1][0].getTag().equals(tegels[1][1].getTag()) && tegels[1][0].getTag().equals(tegels[1][2].getTag())) {
            uitgespeeld = true;


        }
        if (!tegels[2][0].isClickable()&&tegels[2][0].getTag().equals(tegels[2][1].getTag()) && tegels[2][0].getTag().equals(tegels[2][2].getTag())) {
            uitgespeeld = true;

        }

        //verticale controle

        if (!tegels[0][0].isClickable()&&tegels[0][0].getTag().equals(tegels[1][0].getTag()) && tegels[0][0].getTag().equals(tegels[2][0].getTag())) {
            uitgespeeld = true;

        }
        if (!tegels[0][1].isClickable()&&tegels[0][1].getTag().equals(tegels[1][1].getTag()) && tegels[0][1].getTag().equals(tegels[2][1].getTag())) {
            uitgespeeld = true;

        }
        if (!tegels[0][2].isClickable()&&tegels[0][2].getTag().equals(tegels[1][2].getTag()) && tegels[0][2].getTag().equals(tegels[2][2].getTag())) {
            uitgespeeld = true;

        }

        //controle diogonaal
        if (!tegels[0][0].isClickable()&&tegels[0][0].getTag().equals(tegels[1][1].getTag()) && tegels[0][0].getTag().equals(tegels[2][2].getTag())) {
            uitgespeeld = true;

        }
        if (!tegels[0][2].isClickable()&&tegels[0][2].getTag().equals(tegels[1][1].getTag()) && tegels[0][2].getTag().equals(tegels[2][0].getTag())) {
            uitgespeeld = true;

        }

        return uitgespeeld;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}

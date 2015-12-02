package com.example.cc.boterkaaseieren;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spel spel;
    Bundle bundle;
    ArrayList<ImageButton> knopLijst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bundle = getIntent().getExtras();
        String spelers = getIntent().getStringExtra("spelers");
        Log.i("create", "" + spelers);
        spelMaken("" + spelers);
    }

    private void spelMaken(String spelers) {
        knopLijst = new ArrayList<>();
        knopLijst.add((ImageButton) findViewById((R.id.button1)));
        knopLijst.add((ImageButton) findViewById((R.id.button2)));
        knopLijst.add((ImageButton) findViewById((R.id.button3)));
        knopLijst.add((ImageButton) findViewById((R.id.button4)));
        knopLijst.add((ImageButton) findViewById((R.id.button5)));
        knopLijst.add((ImageButton) findViewById((R.id.button6)));
        knopLijst.add((ImageButton) findViewById((R.id.button7)));
        knopLijst.add((ImageButton) findViewById((R.id.button8)));
        knopLijst.add((ImageButton) findViewById((R.id.button9)));
        spel = new Spel(knopLijst, spelers);
        ((TextView) findViewById(R.id.speler1)).setText("Speler 1");
        Log.i("speler", spelers);
        if (spelers.equals("1v1")) {
            ((TextView) findViewById(R.id.speler2)).setText("Speler 2");
        } else if (spelers.equals("1vAi")) {
            ((TextView) findViewById(R.id.speler2)).setText("AI");
        }
    }


    public void onClick(View v) {
        ImageButton buttonClicked = (ImageButton) findViewById(v.getId());
        Speler winnaar = spel.volgendezet(buttonClicked);
        if (winnaar != null) {
            Toast.makeText(this, "Winnaar is " + winnaar.getNaam(), Toast.LENGTH_LONG).show();
        }
    }


    public void reset(View view) {
        for (ImageButton knop : knopLijst) {
            knop.setImageResource(android.R.color.transparent);
            knop.setClickable(true);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable("game", spel);
        //outState.putParcelable("list",  knopLijst);  // TODO figure out how to save the game state
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        spel = (Spel) savedInstanceState.get("game");
        // knopLijst = (ArrayList<ImageButton>) savedInstanceState.get("list");  //TODO figure out how to save the game statefor (int i = 0; i < 3; i++) {
        knopLijst=new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                knopLijst.add(spel.getTegels()[i][j]);
            }
        }
        ((ImageButton) findViewById((R.id.button1))).setBackground(knopLijst.get(0).getBackground());
        ((ImageButton) findViewById((R.id.button2))).setBackground(knopLijst.get(1).getBackground());
        ((ImageButton) findViewById((R.id.button3))).setBackground(knopLijst.get(2).getBackground());
        ((ImageButton) findViewById((R.id.button4))).setBackground(knopLijst.get(3).getBackground());
        ((ImageButton) findViewById((R.id.button5))).setBackground(knopLijst.get(4).getBackground());
        ((ImageButton) findViewById((R.id.button6))).setBackground(knopLijst.get(5).getBackground());
        ((ImageButton) findViewById((R.id.button7))).setBackground(knopLijst.get(6).getBackground());
        ((ImageButton) findViewById((R.id.button8))).setBackground(knopLijst.get(7).getBackground());
        ((ImageButton) findViewById((R.id.button9))).setBackground(knopLijst.get(8).getBackground());


    }

}

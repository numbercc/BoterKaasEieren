package com.example.cc.boterkaaseieren;

import android.os.Bundle;
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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spel spel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        Bundle bundle = getIntent().getExtras();
        String spelers=bundle.getParcelable("spelers");
        Log.i("create",""+spelers);
        spelMaken("" + bundle.getParcelable("spelers"));
    }
    private void spelMaken(String spelers){
        ArrayList<ImageButton> knopLijst=new ArrayList<ImageButton>();
        knopLijst.add((ImageButton) findViewById((R.id.button1)));
        knopLijst.add((ImageButton)findViewById((R.id.button2)));
        knopLijst.add((ImageButton)findViewById((R.id.button3)));
        knopLijst.add((ImageButton)findViewById((R.id.button4)));
        knopLijst.add((ImageButton)findViewById((R.id.button5)));
        knopLijst.add((ImageButton)findViewById((R.id.button6)));
        knopLijst.add((ImageButton) findViewById((R.id.button7)));
        knopLijst.add((ImageButton) findViewById((R.id.button8)));
        knopLijst.add((ImageButton) findViewById((R.id.button9)));
        spel = new Spel(knopLijst,spelers);
        ((TextView)findViewById(R.id.speler1)).setText("Speler 1");
        Log.i("speler",spelers);
        if (spelers.equals("1v1")){
            ((TextView)findViewById(R.id.speler2)).setText("Speler 2");
        }
        else if(spelers.equals("1vAi")){
            ((TextView)findViewById(R.id.speler2)).setText("AI");
        }
    }


    public void onClick(View v){
        ImageButton buttonClicked=(ImageButton) findViewById(v.getId());
        spel.volgendezet(buttonClicked);
    }


}

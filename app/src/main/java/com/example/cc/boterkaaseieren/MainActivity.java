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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private ArrayList<Button> knopLijst=new ArrayList<Button>();
    private Speler speler1=new Speler();
    private Speler speler2=new Speler();
    private Speler spelerBeurt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        speler1.setZetImage("X");
        speler2.setZetImage("O");
        spelerBeurt=speler1;

        knopLijst.add((Button) findViewById((R.id.button1)));
        knopLijst.add((Button)findViewById((R.id.button2)));
        knopLijst.add((Button)findViewById((R.id.button3)));
        knopLijst.add((Button)findViewById((R.id.button4)));
        knopLijst.add((Button)findViewById((R.id.button5)));
        knopLijst.add((Button)findViewById((R.id.button6)));
        knopLijst.add((Button) findViewById((R.id.button7)));
        knopLijst.add((Button) findViewById((R.id.button8)));
        knopLijst.add((Button) findViewById((R.id.button9)));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void onClick(View v){
        Button buttonClicked=(Button) findViewById(v.getId());
        for (Button knop:knopLijst) {
            if(buttonClicked.equals(knop)){
                knop.setText(spelerBeurt.getZetImage());
            }
        }
        //check();
        volgendeZet();
    }
    private void volgendeZet(){
        if (spelerBeurt.equals(speler1)){
            spelerBeurt=speler2;
        }
        else{
            spelerBeurt=speler1;
        }
    }

}

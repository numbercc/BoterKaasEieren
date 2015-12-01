package com.example.cc.boterkaaseieren;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Created by cc on 1-12-2015.
 */
public class MenuActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void onClick(View view) {
        String speler;
        if (view.getId()==R.id.rdb_1vAi){
            speler="1vAi";
        }
        else{
            speler="1v1";
        }
        Log.i("Spel",speler);
        Intent intent = new Intent(this, MainActivity.class);
        Bundle bundle=new Bundle();
        bundle.putString("spelers",speler);
        intent.putExtras(bundle);
        startActivityForResult(intent, 0);
    }
}

package com.example.cc.boterkaaseieren;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

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
        RadioButton rb= (RadioButton)findViewById(R.id.rdb_1vAi);
        if (rb.isChecked()){
            speler="1vAi";
        }
        else{
            speler="1v1";
        }
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("spelers", speler);
        startActivity(intent);
    }
}

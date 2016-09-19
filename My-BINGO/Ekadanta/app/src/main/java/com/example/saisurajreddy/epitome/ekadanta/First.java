package com.example.saisurajreddy.epitome.ekadanta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by SaiSurajReddy on 11/25/2015.
 */
public class First extends Activity {
    Button newgame,instruction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);

        //referencing
        newgame=(Button)findViewById(R.id.buttonNG);
        instruction=(Button)findViewById(R.id.buttonINS);

        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Second.class);
                startActivity(i);
            }
        });

        instruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Third.class);
                startActivity(i);
            }
        });
    }
}

package com.example.saisurajreddy.epitome.ekadanta;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by SaiSurajReddy on 11/27/2015.
 */
public class Third extends Activity {
    Button but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);

        //referencing
        but=(Button)findViewById(R.id.back);

        //back onClickListener
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

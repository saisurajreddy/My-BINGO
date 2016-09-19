package com.example.saisurajreddy.epitome.ekadanta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by SaiSurajReddy on 12/18/2015.
 */
public class UserWinFlag extends Activity {
    Button ok,vc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userwinflag);

        //referencing
        ok=(Button)findViewById(R.id.uwfOK);
        vc=(Button)findViewById(R.id.uwfVC);

        //onCliclListener
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        vc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

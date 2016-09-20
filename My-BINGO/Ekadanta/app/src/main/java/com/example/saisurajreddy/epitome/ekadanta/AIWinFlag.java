package com.example.saisurajreddy.epitome.ekadanta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by SaiSurajReddy on 12/18/2015.
 */
public class AIWinFlag extends Activity {
    Button ok,vc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aiwinflag);

        //referencing
        ok=(Button)findViewById(R.id.awfOK);
        vc=(Button)findViewById(R.id.awfVC);

        //catching variables
        Intent i=getIntent();
        final int[] temp=i.getIntArrayExtra("elements");
        final int[] switches=i.getIntArrayExtra("switches");

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
                Intent i5=new Intent(getApplicationContext(),Chit.class);
                i5.putExtra("elements",temp);
                i5.putExtra("switches",switches);
                startActivity(i5);
            }
        });
    }
}

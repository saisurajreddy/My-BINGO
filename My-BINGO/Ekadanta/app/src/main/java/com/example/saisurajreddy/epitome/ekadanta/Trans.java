package com.example.saisurajreddy.epitome.ekadanta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by SaiSurajReddy on 11/29/2015.
 */
public class Trans extends Activity {
    Button but;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trans);

        //referncing
        but=(Button)findViewById(R.id.transOK);
        tv=(TextView)findViewById(R.id.transTV);

        //cathing the variable
        Intent i=getIntent();
        int temp=i.getIntExtra("var",0);

        //updating the tv
        if((temp/10)==0) {
            tv.setText("  <"+temp+">");
        } else{
            tv.setText(" <"+temp+">");
        }

        //but onclicklistener
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

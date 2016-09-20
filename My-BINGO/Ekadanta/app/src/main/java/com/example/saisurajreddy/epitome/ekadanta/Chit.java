package com.example.saisurajreddy.epitome.ekadanta;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by SaiSurajReddy on 12/25/2016.
 */
public class Chit extends Activity {
    Button[][] ba=new Button[5][5];
    Button ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chit);

        //referencing
        ba[0][0]=(Button)findViewById(R.id.button6);
        ba[0][1]=(Button)findViewById(R.id.button7);
        ba[0][2]=(Button)findViewById(R.id.button8);
        ba[0][3]=(Button)findViewById(R.id.button9);
        ba[0][4]=(Button)findViewById(R.id.button10);
        ba[1][0]=(Button)findViewById(R.id.button11);
        ba[1][1]=(Button)findViewById(R.id.button12);
        ba[1][2]=(Button)findViewById(R.id.button13);
        ba[1][3]=(Button)findViewById(R.id.button14);
        ba[1][4]=(Button)findViewById(R.id.button15);
        ba[2][0]=(Button)findViewById(R.id.button16);
        ba[2][1]=(Button)findViewById(R.id.button17);
        ba[2][2]=(Button)findViewById(R.id.button18);
        ba[2][3]=(Button)findViewById(R.id.button19);
        ba[2][4]=(Button)findViewById(R.id.button20);
        ba[3][0]=(Button)findViewById(R.id.button21);
        ba[3][1]=(Button)findViewById(R.id.button22);
        ba[3][2]=(Button)findViewById(R.id.button23);
        ba[3][3]=(Button)findViewById(R.id.button24);
        ba[3][4]=(Button)findViewById(R.id.button25);
        ba[4][0]=(Button)findViewById(R.id.button26);
        ba[4][1]=(Button)findViewById(R.id.button27);
        ba[4][2]=(Button)findViewById(R.id.button28);
        ba[4][3]=(Button)findViewById(R.id.button29);
        ba[4][4]=(Button)findViewById(R.id.button30);
        ok=(Button)findViewById(R.id.chitOK);

        //catching variables
        Intent i=getIntent();
        final int[] temp=i.getIntArrayExtra("elements");
        final int[] switches=i.getIntArrayExtra("switches");
        int index=0;

        //updating buttons text
        for(int in=0;in<5;in++){
            for(int jn=0;jn<5;jn++){
                ba[in][jn].setText(""+temp[index]);
                if(switches[index]==1){
                    ba[in][jn].setBackgroundColor(Color.RED);
                }
                index++;
            }
        }

        //onClickListeners
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

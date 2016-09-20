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
    boolean mainFlag;

    @Override
    public void onBackPressed() {
        Intent intent=new Intent();
        intent.putExtra("flag",mainFlag);
        setResult(2,intent);
        finish();
    }

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
        final boolean flag=i.getBooleanExtra("flag",false);
        mainFlag=flag;

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
                Intent intent=new Intent();
                intent.putExtra("flag",flag);
                setResult(2,intent);
                finish();
            }
        });
    }
}

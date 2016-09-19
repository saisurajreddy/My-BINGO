package com.example.saisurajreddy.epitome.ekadanta;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by SaiSurajReddy on 11/25/2015.
 */
public class Second extends Activity {
    Button butb,buti,butn,butg,buto;
    int i=1,n=0,flag=0,bingo[][]={{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
    int[][] user=new int[5][5];
    int[] userMarkings=new int[12];
    Button[][] ba=new Button[5][5];

    //ai
    Bc bc=new Bc();
    Button butGO;
    Button tempButton;

    //announces that game has been completed by user
    private void announcer() {
        if(n==5) {
            Toast t=Toast.makeText(getApplicationContext(),"BINGO", Toast.LENGTH_SHORT);
            t.show();
            Intent i=new Intent(getApplicationContext(),UserWinFlag.class);
            startActivity(i);
            finish();
        }
    }

    //announces that game has been completed by ai
    private void announcer_AI(){
        Toast t=Toast.makeText(getApplicationContext(),"BC: BINGO", Toast.LENGTH_SHORT);
        t.show();
    }

    //checking whether bingo array has filled correctly or not
    private void res() {
        for(int j=0;j<5;j++) {
            for(int k=0;k<5;k++) {
                System.out.print(bingo[j][k]+"\t");
            }
            System.out.print("\n");
        }
    }

    //this switches the buttons from first mode to second mode after the condition is met
    private void check(){
        if(i==26){
            for(int in=0;in<5;in++){
                for(int jn=0;jn<5;jn++){
                    ba[in][jn].setEnabled(true);
                }
            }
            butb.setEnabled(true);
            buti.setEnabled(true);
            butn.setEnabled(true);
            butg.setEnabled(true);
            buto.setEnabled(true);
            flag=1;
        }
    }

    //checks whether user wins or not
    private boolean bingo_result(){
        int counter=0;
        for(int in=0;in<12;in++){
            if(userMarkings[in]==5){
                counter++;
            }
        }
        System.out.println(counter+" "+n);
        return (boolean)(counter>n);
    }

    //prints user markings array
    private void markerViewer(){
        for(int in=0;in<12;in++){
            System.out.print(userMarkings[in]+" ");
        }
        System.out.println("");
    }

    //blocks every 5x5 array button
    private void all_off(){
        for(int in=0;in<5;in++){
            for(int jn=0;jn<5;jn++){
                ba[in][jn].setEnabled(false);
            }
        }
    }

    //unblocks the selected elements in 5x5 array of buttons based on bingo array
    private void selected_on(){
        for(int in=0;in<5;in++){
            for(int jn=0;jn<5;jn++){
                if(bingo[in][jn]==0){
                    ba[in][jn].setEnabled(true);
                }
            }
        }
    }

    //it marks the user markings array
    private void userMarker(int r,int c){
        userMarkings[r]++;
        userMarkings[5+c]++;
        if(r==c){
            userMarkings[10]++;
        }
        if(r+c==4) {
            userMarkings[11]++;
        }
    }

    //it marks the button based on its value
    private void button_marker(int value){
        int i=0,j=0,flag=0;
        for(i=0;i<5;i++){
            for(j=0;j<5;j++){
                if(value==user[i][j]){
                    flag=1;
                    break;
                }
            }
            if(flag==1){
                break;
            }
        }
        bingo[i][j]=1;
        ba[i][j].setBackgroundColor(Color.RED);
        ba[i][j].setTextColor(Color.WHITE);
        ba[i][j].setEnabled(false);
        System.out.println("ai"+i+" "+j);
        userMarker(i,j);
        markerViewer();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2) {
            String message=data.getStringExtra("MESSAGE");
            boolean flag=data.getBooleanExtra("flag",false);
            if(flag){
                Intent i=new Intent(getApplicationContext(),AIWinFlag.class);
                startActivity(i);
                announcer_AI();
                finish();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

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
        butb=(Button)findViewById(R.id.button);
        buti=(Button)findViewById(R.id.button2);
        butn=(Button)findViewById(R.id.button3);
        butg=(Button)findViewById(R.id.button4);
        buto=(Button)findViewById(R.id.button5);
        butGO=(Button)findViewById(R.id.buttonGO);

        //blocking BINGO and GO Button's
        butb.setEnabled(false);
        buti.setEnabled(false);
        butn.setEnabled(false);
        butg.setEnabled(false);
        buto.setEnabled(false);
        butGO.setEnabled(false);

        //initializing the ai chit
        bc.initializer();

        //invocation of ai
        butGO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag=false;
                int pval=bc.predict(Integer.parseInt((tempButton.getText()).toString()));
                flag=bc.bingo();
                Intent it=new Intent(getApplicationContext(),Trans.class);
                it.putExtra("var",pval);
                it.putExtra("flag",flag);
                //startActivity(it);
                startActivityForResult(it, 2);
                button_marker(pval);
                res();
                selected_on();
                butGO.setEnabled(false);
            }
        });

        //this is 5x5 array onClickListeners setting
        for(int in=0;in<5;in++){
            for(int jn=0;jn<5;jn++){
                final int tempi=in,tempj=jn;
                ba[in][jn].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(flag==0) {
                            ba[tempi][tempj].setText(""+i);
                            i++;
                            ba[tempi][tempj].setEnabled(false);
                            user[tempi][tempj]=i-1;
                            check();
                        } else {
                            bingo[tempi][tempj]=1;
                            ba[tempi][tempj].setBackgroundColor(Color.RED);
                            ba[tempi][tempj].setTextColor(Color.WHITE);
                            ba[tempi][tempj].setEnabled(false);
                            System.out.println("user"+tempi+" "+tempj);
                            userMarker(tempi,tempj);
                            markerViewer();
                            butGO.setEnabled(true);
                            tempButton=ba[tempi][tempj];
                            butGO.setEnabled(true);
                            all_off();
                        }
                    }
                });
            }
        }

        //these are bingo button onClickListeners
        butb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bingo_result()) {
                    butb.setBackgroundColor(Color.RED);
                    butb.setTextColor(Color.WHITE);
                    butb.setEnabled(false);
                    n++;
                    announcer();
                } else {
                    Toast t = Toast.makeText(getApplicationContext(), "Ooops!!! Blocks are not matched", Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });
        buti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bingo_result()) {
                    buti.setBackgroundColor(Color.RED);
                    buti.setTextColor(Color.WHITE);
                    buti.setEnabled(false);
                    n++;
                    announcer();
                } else {
                    Toast t = Toast.makeText(getApplicationContext(), "Ooops!!! Blocks are not matched", Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });
        butn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bingo_result()) {
                    butn.setBackgroundColor(Color.RED);
                    butn.setTextColor(Color.WHITE);
                    butn.setEnabled(false);
                    n++;
                    announcer();
                } else {
                    Toast t = Toast.makeText(getApplicationContext(), "Ooops!!! Blocks are not matched", Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });
        butg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bingo_result()) {
                    butg.setBackgroundColor(Color.RED);
                    butg.setTextColor(Color.WHITE);
                    butg.setEnabled(false);
                    n++;
                    announcer();
                } else {
                    Toast t = Toast.makeText(getApplicationContext(), "Ooops!!! Blocks are not matched", Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });
        buto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bingo_result()) {
                    buto.setBackgroundColor(Color.RED);
                    buto.setTextColor(Color.WHITE);
                    buto.setEnabled(false);
                    n++;
                    announcer();
                } else {
                    Toast t = Toast.makeText(getApplicationContext(), "Ooops!!! Blocks are not matched", Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });

    }
}

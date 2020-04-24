package com.example.androidrevisited;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int scoreA,foulsA,scoreB,foulsB;
    TextView tvScoreA1,tvLabelFoulA,tvScoreA2,tvScoreB1,tvLabelFoulB,tvScoreB2;
    Button btnA1,btnA2,btnA3,btnA4,btnB1,btnB2,btnB3,btnB4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //resetting the scores
        reset();
        //loading view elements
        //text views
        tvScoreA1 = (TextView)findViewById(R.id.tvScoreA1);
        tvLabelFoulA = (TextView)findViewById(R.id.tvLabelFoulA);
        tvScoreA2 = (TextView)findViewById(R.id.tvScoreA2);
        tvScoreB1 = (TextView)findViewById(R.id.tvScoreB1);
        tvLabelFoulB = (TextView)findViewById(R.id.tvLabelFoulB);
        tvScoreB2 = (TextView)findViewById(R.id.tvScoreB2);

        //buttons
        btnA1 = (Button)findViewById(R.id.btnA1);
        btnA2 = (Button)findViewById(R.id.btnA2);
        btnA3 = (Button)findViewById(R.id.btnA3);
        btnA4 = (Button)findViewById(R.id.btnA4);
        btnB1 = (Button)findViewById(R.id.btnB1);
        btnB2 = (Button)findViewById(R.id.btnB2);
        btnB3 = (Button)findViewById(R.id.btnB3);
        btnB4 = (Button)findViewById(R.id.btnB4);
        btnB4.setVisibility(View.INVISIBLE);
        btnA4.setVisibility(View.INVISIBLE);


        showAlertDialog();
       //Dialog dialog = new
        //Baseball Scores App: Track both runs and outs
        //American Football Scores App: Add a button for each of the 4 amounts of points a team can score in american football.
        //Football Scores app: Track both points and fouls

    }

    public void refreshViews(){
        tvScoreA1.setText(""+scoreA);
        tvScoreA2.setText(""+foulsA);
        tvScoreB1.setText(""+scoreB);
        tvScoreB2.setText(""+foulsB);
    }

    public void increaseScoreA(int point){
        scoreA = scoreA + point;
        refreshViews();
    }
    public void increaseFoulA(int point){
        foulsA = foulsA + point;
        refreshViews();
    }
    public void increaseScoreB(int point){
        scoreB = scoreB + point;
        refreshViews();
    }
    public void increaseFoulB(int point){
        foulsB = foulsB + point;
        refreshViews();
    }
    /**
     *
     * @param gametype - 0 for American Football, 1 for base ball, 2 for Football
     */
    private void loadGame(int gametype){

        //make UI changes
        switch (gametype) {
            case 0:
                Toast.makeText(MainActivity.this, "Selected American Football", Toast.LENGTH_LONG).show();
                //btn 1 for score - +1, btn2 for fouls +1
                btnA1.setText("Score");
                btnA2.setText("Foul");
                btnB1.setText("Score");
                btnB2.setText("Foul");
                btnA3.setVisibility(View.INVISIBLE);
                btnB3.setVisibility(View.INVISIBLE);
                break;
            case 1:
                //btn 1 for score - +1, btn2 for fouls +1
                btnA1.setText("Score");
                btnA2.setText("Foul");
                btnB1.setText("Score");
                btnB2.setText("Foul");
                btnA3.setVisibility(View.INVISIBLE);
                btnB3.setVisibility(View.INVISIBLE);
                Toast.makeText(MainActivity.this, "Selected Baseball", Toast.LENGTH_LONG).show();
                break;
            case 2:
                //btn 1 for Goals - +1, btn2 for fouls +1
                btnA1.setText("Score");
                btnA2.setText("Foul");
                btnB1.setText("Score");
                btnB2.setText("Foul");
                btnA3.setVisibility(View.INVISIBLE);
                btnB3.setVisibility(View.INVISIBLE);
                Toast.makeText(MainActivity.this, "Selected Football", Toast.LENGTH_LONG).show();
                break;
        }
        reset();
        btnA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseScoreA(1);
            }
        });
        btnA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseFoulA(1);
            }
        });
        btnB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseScoreB(1);
            }
        });
        btnB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseFoulB(1);
            }
        });
    }

    public void reset()
    {
        scoreA=0;
        foulsA=0;
        scoreB=0;
        foulsB=0;
    }

    private void showAlertDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Choose the Game (default is football");
        String[] items = {"American Football","Baseball","Football"};
        int checkedItem = 1;

        alertDialog.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                loadGame(which);
                dialog.dismiss();
            }
        });
        AlertDialog alert = alertDialog.create();
        alert.setCanceledOnTouchOutside(false);
        alert.show();
    }

    public void resetVal(View view) {
        reset();
        refreshViews();
    }
}

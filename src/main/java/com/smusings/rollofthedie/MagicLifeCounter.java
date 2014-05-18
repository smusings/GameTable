package com.smusings.rollofthedie;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class MagicLifeCounter extends SetUpActivity {

    private ArrayAdapter<String> aaP1;
    private ArrayAdapter<String> aaP2;
    Number player_health=20;
    TextView player1;
    TextView player2;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.magic_life_counter);

        player1=(TextView) findViewById(R.id.Player1);
        player2=(TextView) findViewById(R.id.Player2);

        player1.setText(player_health.toString());
        player2.setText(player_health.toString());

        //player one buttons
        Button p1plus1 = (Button) findViewById(R.id.plusOne1);
        Button p1plus5 = (Button) findViewById(R.id.plusFive1);
        Button p1minus1 = (Button) findViewById(R.id.minusOne1);
        Button p1minus5 = (Button) findViewById(R.id.minusFive1);
        Button p1reset = (Button) findViewById(R.id.player1reset);

        //player two buttons
        Button p2plus1 = (Button) findViewById(R.id.plusOne2);
        Button p2plus5 = (Button) findViewById(R.id.plusFive2);
        Button p2minus1 = (Button) findViewById(R.id.minusOne2);
        Button p2minus5 = (Button) findViewById(R.id.minusFive2);
        Button p2reset = (Button) findViewById(R.id.player2reset);

        //player one buttons
        p1plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String health = player1.getText().toString();
                final int phealth = Integer.parseInt(health);
                Number skr=phealth+1;
                player1.setText(skr.toString());
            }
        });

        p1plus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String health = player1.getText().toString();
                final int phealth = Integer.parseInt(health);
                Number skr=phealth+5;
                player1.setText(skr.toString());
            }
        });
        p1minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String health = player1.getText().toString();
                final int phealth = Integer.parseInt(health);
                Number skr=phealth-1;
                player1.setText(skr.toString());
            }
        });
        p1minus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String health = player1.getText().toString();
                final int phealth = Integer.parseInt(health);
                Number skr=phealth-5;
                player1.setText(skr.toString());
            }
        });
        p1reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1.setText(player_health.toString());
            }
        });

        //Player two buttons
        p2plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String health = player2.getText().toString();
                final int phealth = Integer.parseInt(health);
                Number skr=phealth+1;
                player2.setText(skr.toString());
            }
        });
        p2plus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String health = player2.getText().toString();
                final int phealth = Integer.parseInt(health);
                Number skr=phealth+5;
                player2.setText(skr.toString());
            }
        });
        p2minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String health = player2.getText().toString();
                final int phealth = Integer.parseInt(health);
                Number skr=phealth-1;
                player2.setText(skr.toString());
            }
        });
        p2minus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String health = player2.getText().toString();
                final int phealth = Integer.parseInt(health);
                Number skr=phealth-5;
                player2.setText(skr.toString());
            }
        });
        p2reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player2.setText(player_health.toString());
            }
        });
    }

    public void resetHealth(View view){
        Number twohg= 30;

        player1.setText(twohg.toString());
        player2.setText(twohg.toString());
    }
}

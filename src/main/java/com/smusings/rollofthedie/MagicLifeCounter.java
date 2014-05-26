package com.smusings.rollofthedie;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MagicLifeCounter extends SetUpActivity
    implements PlayerOneFragment.Player1Listener,
    PlayerTwoFragment.Player2Listener{
    private ArrayList<String> Player1Press;
    private ArrayList<String> Player2Press;


    public void player1Press (String ph) {
        int ph1 = Integer.valueOf(ph);
        if ( ph1 == 0) {
            player1.setText(Integer.toString(player_health));
        } else {
            String phealth = player1.getText().toString();
            int p1health = Integer.valueOf(phealth);
            int health = p1health + ph1;
            player1.setText(Integer.toString(health));
        }
    }

    public void player2Press (String ph) {
        int ph2 = Integer.valueOf(ph);
        if ( ph2 == 0) {
            player2.setText(Integer.toString(player_health));
        } else {
            String phealth = player2.getText().toString();
            int p2health = Integer.valueOf(phealth);
            int health = p2health + ph2;
            player2.setText(Integer.toString(health));
        }
    }

    int player_health=20;
    TextView player1;
    TextView player2;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.magic_life_counter);

        //set up onCreate
        player1=(TextView) findViewById(R.id.Player1);
        player2=(TextView) findViewById(R.id.Player2);

        //sets life to 20 on start
        player1.setText(Integer.toString(player_health));
        player2.setText(Integer.toString(player_health));

        //create ArrayList
        Player1Press=new ArrayList<String>();
        Player2Press=new ArrayList<String>();
    }

    public void resetHealth(View view){
        Number twohg= 30;
        player1.setText(twohg.toString());
        player2.setText(twohg.toString());
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_clear:
                player1.setText(Integer.toString(player_health));
                player2.setText(Integer.toString(player_health));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

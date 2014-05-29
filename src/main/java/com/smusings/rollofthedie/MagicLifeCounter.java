package com.smusings.rollofthedie;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class MagicLifeCounter extends SetUpActivity
    implements PlayerOneFragment.Player1Listener,
    PlayerTwoFragment.Player2Listener{

    int player_health=20;
    TextView player1;
    TextView player2;
    TextView poison1;
    TextView poison2;


    public void player1Press (String ph) {
        int ph1 = Integer.valueOf(ph);
        if ( ph1 >= -5 && ph1 <= 5) {
            String phealth = player1.getText().toString();
            int p1health = Integer.valueOf(phealth);
            int health = p1health + ph1;
            player1.setText(Integer.toString(health));
        } if (ph1 == -10){
                String poison=poison1.getText().toString();
                int p1posion=Integer.valueOf(poison);
                int health=p1posion-1;
                poison1.setText(Integer.toString(health));
        } else if (ph1==10) {
            String poison=poison1.getText().toString();
            int p1posion=Integer.valueOf(poison);
            int health=p1posion+1;
            poison1.setText(Integer.toString(health));
        }
    }

    public void player2Press (String ph) {
        int ph2 = Integer.valueOf(ph);
        if ( ph2 >= -5 && ph2 <= 5) {
            String phealth = player2.getText().toString();
            int p2health = Integer.valueOf(phealth);
            int health = p2health + ph2;
            player2.setText(Integer.toString(health));
        } if (ph2 == -10){
            String poison=poison2.getText().toString();
            int p2posion=Integer.valueOf(poison);
            int health=p2posion-1;
            poison2.setText(Integer.toString(health));
        } else if (ph2==10) {
            String poison=poison2.getText().toString();
            int p2posion=Integer.valueOf(poison);
            int health=p2posion+1;
            poison2.setText(Integer.toString(health));
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        getActionBar().setDisplayHomeAsUpEnabled(false);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.magic_life_counter);

        //set up onCreate
        player1=(TextView) findViewById(R.id.Player1);
        player2=(TextView) findViewById(R.id.Player2);
        poison1=(TextView) findViewById(R.id.poison1);
        poison2=(TextView) findViewById(R.id.poison2);

        //sets life to 20 on start
        player1.setText(Integer.toString(player_health));
        player2.setText(Integer.toString(player_health));
        poison1.setText(Integer.toString(0));
        poison2.setText(Integer.toString(0));
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_clear:
                player1.setText(Integer.toString(player_health));
                player2.setText(Integer.toString(player_health));
                poison1.setText(Integer.toString(0));
                poison2.setText(Integer.toString(0));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

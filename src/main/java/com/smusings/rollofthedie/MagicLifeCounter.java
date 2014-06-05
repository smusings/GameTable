package com.smusings.rollofthedie;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class MagicLifeCounter extends SetUpActivity
    implements PlayerOneFragment.Player1Listener,
        PlayerTwoFragment.Player2Listener{

    //the setup
    int player_health=20;
    TextView player1;
    TextView player2;
    TextView poison1;
    TextView poison2;

    public void player1Press (Number ph1) {
        //logic for health
        int ph = Integer.valueOf(ph1.intValue());
        String phealth = player1.getText().toString();
        int p1health = Integer.valueOf(phealth);
        int health = p1health + ph;
        player1.setText(Integer.toString(health));
    }
    public void player1Str(String pht1){
        //logic for poison counters
        int pht=Integer.valueOf(pht1);
        String poison=poison1.getText().toString();
        int p1posion=Integer.valueOf(poison);
        int poisonV=p1posion+pht;
        poison1.setText(Integer.toString(poisonV));
    }

    public void player2Press (Number ph) {
        //logic for health
        int ph2 = Integer.valueOf(ph.intValue());
        String phealth = player2.getText().toString();
        int p2health = Integer.valueOf(phealth);
        int health = p2health + ph2;
        player2.setText(Integer.toString(health));
    }
    public void player2Str(String pht){
        //logic for poison counters
        int pht2=Integer.valueOf(pht);
        String poison=poison2.getText().toString();
        int p2posion=Integer.valueOf(poison);
        int poisonV=p2posion+pht2;
        poison2.setText(Integer.toString(poisonV));
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

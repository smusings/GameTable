package com.smusings.rollofthedie;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MagicLifeCounter extends Activity {


    public Player1LifeCounterFragment player1LC;
    public Player2LifeCounterFragment player2LC;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.magic_life_counter);

        //defines the support fragments
        player1LC = (Player1LifeCounterFragment)
                getFragmentManager().findFragmentById(R.id.p1buttons);
        player2LC = (Player2LifeCounterFragment)
                getFragmentManager().findFragmentById(R.id.p2buttons);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_clear:
                //resets the health for both players
                player1LC.resetHealth();
                player2LC.resetHealth();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

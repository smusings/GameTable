package com.smusings.rollofthedie;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;

public class MagicLifeCounter extends FragmentActivity {


    public Player1LifeCounterFragment player1LC;
    public Player2LifeCounterFragment player2LC;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.magic_life_counter);

        //defines the support fragments
        player1LC = (Player1LifeCounterFragment) getSupportFragmentManager().findFragmentById(R.id.p1buttons);
        player2LC = (Player2LifeCounterFragment) getSupportFragmentManager().findFragmentById(R.id.p2buttons);
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

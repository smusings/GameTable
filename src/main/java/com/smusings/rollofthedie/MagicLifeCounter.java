package com.smusings.rollofthedie;

import android.os.Bundle;
import android.view.MenuItem;

public class MagicLifeCounter extends SetUpActivity{


    public Player1LifeCounterFragment player1LC;
    public Player2LifeCounterFragment player2LC;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.magic_life_counter);

        player1LC=(Player1LifeCounterFragment) getSupportFragmentManager().findFragmentById(R.id.p1buttons);
        player2LC=(Player2LifeCounterFragment) getSupportFragmentManager().findFragmentById(R.id.p2buttons);
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_clear:
                player1LC=(Player1LifeCounterFragment) getSupportFragmentManager().findFragmentById(R.id.p1buttons);
                player2LC=(Player2LifeCounterFragment) getSupportFragmentManager().findFragmentById(R.id.p2buttons);

                player1LC.resetHealth();
                player2LC.resetHealth();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}

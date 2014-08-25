package com.smusings.rollofthedie;

import android.os.Bundle;
import android.view.MenuItem;

public class MagicLifeCounter extends SetUpActivity{

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.magic_life_counter);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_clear:
                Player1LifeCounterFragment f1=(Player1LifeCounterFragment) getSupportFragmentManager().findFragmentById(R.id.p1buttons);
                Player2LifeCounterFragment f2=(Player2LifeCounterFragment) getSupportFragmentManager().findFragmentById(R.id.p2buttons);

                f1.resetHealth();
                f2.resetHealth();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}

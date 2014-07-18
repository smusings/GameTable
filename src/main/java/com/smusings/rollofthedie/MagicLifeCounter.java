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
                LifeCounterFragment f1=(LifeCounterFragment) getSupportFragmentManager().findFragmentById(R.id.p1buttons);
                LifeCounterFragment f2=(LifeCounterFragment) getSupportFragmentManager().findFragmentById(R.id.p1buttons);

                f1.resetHealth();
                f2.resetHealth();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

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
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

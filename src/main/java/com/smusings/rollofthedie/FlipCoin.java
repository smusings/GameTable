package com.smusings.rollofthedie;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class FlipCoin extends SetUpActivity {

    TextView cf;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flip_coin);
    }

    public void coinFlip(View view) {
        cf=(TextView) findViewById(R.id.flipResult);
        int flip_coin = (int) Math.ceil(Math.random() * 2);
        if (flip_coin == 1) {
            cf.setText("Heads");
        } else {
            cf.setText("Tails");
        }
    }
}

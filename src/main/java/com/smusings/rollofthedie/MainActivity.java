package com.smusings.rollofthedie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends SetUpActivity{

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

    public void lifeCounter(View v){
        Intent intent=new Intent(this, MagicLifeCounter.class);
        startActivity(intent);

    };

    public void dieRoll(View v){
        Intent intent=new Intent(this, DieRoll.class);
        startActivity(intent);

    };

    public void flipCoin(View v){
            ImageView cf=(ImageView)findViewById(R.id.flipResult);
            int flip_coin = (int) Math.ceil(Math.random() * 2);
            if (flip_coin == 1) {
                cf.setImageResource(R.drawable.heads);
            } else {
                cf.setImageResource(R.drawable.tails);
            }
        }
}

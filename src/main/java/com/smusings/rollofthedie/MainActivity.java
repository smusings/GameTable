package com.smusings.rollofthedie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends SetUpActivity
implements CoinFlipFragment.OnNewFlipListener{

    //logic for coin flips
    public void onNewFlip(String result){
        ImageView cf=(ImageView)findViewById(R.id.flipResult);
        int flip=Integer.parseInt(result);
        if (flip == 1) {
            cf.setImageResource(R.drawable.heads);
        } else {
            cf.setImageResource(R.drawable.tails);
        }

    }

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

}

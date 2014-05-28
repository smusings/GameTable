package com.smusings.rollofthedie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
       Intent intent=new Intent(this, FlipCoin.class);
        startActivity(intent);
    };
}

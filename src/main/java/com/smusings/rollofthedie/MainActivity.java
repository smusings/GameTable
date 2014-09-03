package com.smusings.rollofthedie;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends SetUpActivity{

    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

    public void lifeCounter(View v){
        Intent intent = new Intent(this, MagicLifeCounter.class);
        startActivity(intent);
    };

    public void dieRoll(View v){
        Intent intent = new Intent(this, DieRoll.class);
        startActivity(intent);
    };

    public void coinFlip(View v){
        ImageView cf = (ImageView)findViewById(R.id.flipResult);
        Drawable dHeads = getResources().getDrawable(R.drawable.heads);
        Drawable dTails = getResources().getDrawable(R.drawable.tails);

        //both do heads for testing atm
        int flip_coin = (int) Math.ceil(Math.random() * 2);
        if (flip_coin == 1){
            cf.setImageDrawable(dHeads);
            cf.setTag(R.drawable.heads);
        }
        else if (flip_coin == 2) {
            cf.setImageDrawable(dTails);
            cf.setTag(R.drawable.tails);
        }
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_clear:
                ImageView cf = (ImageView)findViewById(R.id.flipResult);
                cf.setImageResource(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

package com.smusings.rollofthedie;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class About extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Resources myResources = getResources();

        String about = "This app was made and designed by sleepless musings using eclipse." +
                " All icons, backgrounds, and other images were made using the GIMP editor, and Android Asset Studio." +
                " Any feedback is appreciated and can be sent to sleeplessmusings@gmail.com";

        // Create the text view
        TextView textView = new TextView(this);
        textView.setTextSize(15);
        textView.setText(about);
        textView.setTextColor(myResources.getColor(R.color.White));

        // Set the text view as the activity layout
        setContentView(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.about, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_about:
                Intent intent = new Intent(this, About.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

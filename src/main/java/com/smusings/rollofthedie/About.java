package com.smusings.rollofthedie;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

public class About extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Resources myResources = getResources();

        String about = "This app was made and designed by sleepless musings using eclipse." +
                "\nAll icons, backgrounds, and other images were made using the GIMP editor, and Android Asset Studio." +
                "\n Any feedback is appreciated and can be sent to sleeplessmusings@gmail.com";

        // Create the text view
        TextView textView = new TextView(this);
        textView.setTextSize(15);
        textView.setText(about);
        textView.setTextColor(myResources.getColor(R.color.White));

        // Set the text view as the activity layout
        setContentView(textView);
    }
}

package com.smusings.rollofthedie;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Player2LifeCounterFragment extends Fragment{

    public static final String PREF_COUNT2 = "MyPrefsCount2";

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        TextView playerhealth = (TextView)getView().findViewById(R.id.PlayerHealth);
        TextView poisonhealth = (TextView)getView().findViewById(R.id.poison_health);

        SharedPreferences pref = getActivity().getSharedPreferences(PREF_COUNT2, 0);
        String health1 = pref.getString("health2", "20");
        String poison1 = pref.getString("poison2", "0");
        playerhealth.setText(health1);
        poisonhealth.setText(poison1);
    }

    public TextView playerhealth;
    public TextView poisonhealth;
    public Button p2plus1;
    public Button p2plus5;
    public Button p2minus1;
    public Button p2minus5;
    public Button p2poison1;
    public Button p2poisonMin1;


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.life_counter_fragment, container, false);

        //player one buttons
        playerhealth = (TextView)view.findViewById(R.id.PlayerHealth);
        poisonhealth = (TextView)view.findViewById(R.id.poison_health);
        p2plus1 = (Button) view.findViewById(R.id.plusOne);
        p2plus5 = (Button) view.findViewById(R.id.plusFive);
        p2minus1 = (Button) view.findViewById(R.id.minusOne);
        p2minus5 = (Button) view.findViewById(R.id.minusFive);
        p2poison1 = (Button) view.findViewById(R.id.poisonAddOne);
        p2poisonMin1 = (Button) view.findViewById(R.id.poisonMinOne);

        playerhealth.setText("20");
        poisonhealth.setText("0");

        //sends the number along to an activity
        p2plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p1health = Integer.valueOf(playerhealth.getText().toString());
                int health = p1health + 1;
                playerhealth.setText(Integer.toString(health));
            }
        });
        p2plus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p1health = Integer.valueOf(playerhealth.getText().toString());
                int health = p1health + 5;
                playerhealth.setText(Integer.toString(health));
            }
        });
        p2minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p1health = Integer.valueOf(playerhealth.getText().toString());
                int health = p1health - 1;
                playerhealth.setText(Integer.toString(health));
            }
        });

        p2minus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p1health = Integer.valueOf(playerhealth.getText().toString());
                int health = p1health - 5;
                playerhealth.setText(Integer.toString(health));
            }
        });

        //string to get rid of confusing logic in activity
        p2poison1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p1health = Integer.valueOf(poisonhealth.getText().toString());
                int health = p1health + 1;
                poisonhealth.setText(Integer.toString(health));
            }
        });
        p2poisonMin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p1health = Integer.valueOf(poisonhealth.getText().toString());
                int health = p1health - 1;
                poisonhealth.setText(Integer.toString(health));
            }
        });
        return view;
    }

    public void resetHealth(){
        playerhealth.setText("20");
        poisonhealth.setText("0");
    }

    public void onPause(){
        super.onPause();

        SharedPreferences pref = getActivity().getSharedPreferences(PREF_COUNT2, 0);
        SharedPreferences.Editor edt=pref.edit();
        edt.putString("health2", playerhealth.getText().toString());
        edt.putString("poison2", poisonhealth.getText().toString());

        edt.commit();
    }
}

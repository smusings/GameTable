package com.smusings.rollofthedie;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Player1LifeCounterFragment extends Fragment{

    public static final String PREF_COUNT1 = "MyPrefsCount1";

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        TextView playerhealth = (TextView)getView().findViewById(R.id.PlayerHealth);
        TextView poisonhealth = (TextView)getView().findViewById(R.id.poison_health);

        SharedPreferences pref = getActivity().getSharedPreferences(PREF_COUNT1, 0);
        String health1 = pref.getString("health1", "20");
        String poison1 = pref.getString("poison1", "0");
        playerhealth.setText(health1);
        poisonhealth.setText(poison1);
    }

    public TextView playerhealth;
    public TextView poisonhealth;
    public Button p1plus1;
    public Button p1plus5;
    public Button p1minus1;
    public Button p1minus5;
    public Button p1poison1;
    public Button p1poisonMin1;


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.life_counter_fragment, container, false);

        //player one buttons
        playerhealth = (TextView)view.findViewById(R.id.PlayerHealth);
        poisonhealth = (TextView)view.findViewById(R.id.poison_health);
        p1plus1 = (Button) view.findViewById(R.id.plusOne);
        p1plus5 = (Button) view.findViewById(R.id.plusFive);
        p1minus1 = (Button) view.findViewById(R.id.minusOne);
        p1minus5 = (Button) view.findViewById(R.id.minusFive);
        p1poison1 = (Button) view.findViewById(R.id.poisonOne);
        p1poisonMin1 = (Button) view.findViewById(R.id.poisonMinOne);

        playerhealth.setText("20");
        poisonhealth.setText("0");

        //sends the number along to an activity
        p1plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p1health = Integer.valueOf(playerhealth.getText().toString());
                int health = p1health + 1;
                playerhealth.setText(Integer.toString(health));
            }
        });
        p1plus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p1health = Integer.valueOf(playerhealth.getText().toString());
                int health = p1health + 5;
                playerhealth.setText(Integer.toString(health));
            }
        });
        p1minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p1health = Integer.valueOf(playerhealth.getText().toString());
                int health = p1health - 1;
                playerhealth.setText(Integer.toString(health));
            }
        });

        p1minus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p1health = Integer.valueOf(playerhealth.getText().toString());
                int health = p1health - 5;
                playerhealth.setText(Integer.toString(health));
            }
        });

        //string to get rid of confusing logic in activity
        p1poison1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p1health = Integer.valueOf(poisonhealth.getText().toString());
                int health = p1health + 1;
                poisonhealth.setText(Integer.toString(health));
            }
        });
        p1poisonMin1.setOnClickListener(new View.OnClickListener() {
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
        TextView playerhealth = (TextView)getView().findViewById(R.id.PlayerHealth);
        TextView poisonhealth = (TextView)getView().findViewById(R.id.poison_health);


        playerhealth.setText("20");
        poisonhealth.setText("0");
    }

    public void onPause(){
        super.onPause();


        TextView playerhealth = (TextView)getView().findViewById(R.id.PlayerHealth);
        TextView poisonhealth = (TextView)getView().findViewById(R.id.poison_health);

        SharedPreferences pref = getActivity().getSharedPreferences(PREF_COUNT1, 0);
        SharedPreferences.Editor edt = pref.edit();
        edt.putString("health1", playerhealth.getText().toString());
        edt.putString("poison1", poisonhealth.getText().toString());

        edt.commit();
    }
}

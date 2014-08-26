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

    public static final String PREF_COUNT2="MyPrefsCount2";

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        TextView playerhealth=(TextView)getView().findViewById(R.id.PlayerHealth);
        TextView poisonhealth=(TextView)getView().findViewById(R.id.poison_health);

        SharedPreferences pref=getActivity().getSharedPreferences(PREF_COUNT2, 0);
        String health1=pref.getString("health2", "20");
        String poison1=pref.getString("poison2", "0");
        playerhealth.setText(health1);
        poisonhealth.setText(poison1);
    }


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.life_counter_fragment, container, false);

        //player one buttons
        final TextView playerhealth=(TextView)view.findViewById(R.id.PlayerHealth);
        final TextView poisonhealth=(TextView)view.findViewById(R.id.poison_health);
        Button p1plus1 = (Button) view.findViewById(R.id.plusOne);
        Button p1plus5 = (Button) view.findViewById(R.id.plusFive);
        Button p1minus1 = (Button) view.findViewById(R.id.minusOne);
        Button p1minus5 = (Button) view.findViewById(R.id.minusFive);
        Button p1poison1 = (Button) view.findViewById(R.id.poisonOne);
        Button p1poisonMin1=(Button) view.findViewById(R.id.poisonMinOne);

        Number initial=20;
        Number poisoninitial=0;

        String health=initial.toString();
        String poisonh=poisoninitial.toString();

        playerhealth.setText(health);
        poisonhealth.setText(poisonh);

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
        TextView playerhealth=(TextView)getView().findViewById(R.id.PlayerHealth);
        TextView poisonhealth=(TextView)getView().findViewById(R.id.poison_health);

        Number health=20;
        Number poison=0;

        playerhealth.setText(health.toString());
        poisonhealth.setText(poison.toString());
    }

    public void onPause(){
        super.onPause();


        TextView playerhealth=(TextView)getView().findViewById(R.id.PlayerHealth);
        TextView poisonhealth=(TextView)getView().findViewById(R.id.poison_health);

        SharedPreferences pref=getActivity().getSharedPreferences(PREF_COUNT2, 0);
        SharedPreferences.Editor edt=pref.edit();
        edt.putString("health2", playerhealth.getText().toString());
        edt.putString("poison2", poisonhealth.getText().toString());

        edt.commit();
    }
}

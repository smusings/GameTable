package com.smusings.rollofthedie;

import android.app.Fragment;
import android.content.SharedPreferences;
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
        View view = inflater.inflate(R.layout.life_counter_fragment, container, false);

        //player one buttons
        playerhealth = (TextView)view.findViewById(R.id.PlayerHealth);
        poisonhealth = (TextView)view.findViewById(R.id.poison_health);
        p1plus1 = (Button) view.findViewById(R.id.plusOne);
        p1plus5 = (Button) view.findViewById(R.id.plusFive);
        p1minus1 = (Button) view.findViewById(R.id.minusOne);
        p1minus5 = (Button) view.findViewById(R.id.minusFive);
        p1poison1 = (Button) view.findViewById(R.id.poisonAddOne);
        p1poisonMin1 = (Button) view.findViewById(R.id.poisonMinOne);

        playerhealth.setText("20");
        poisonhealth.setText("0");

        //sends the number along to an activity
        //plus
        p1plus1.setOnClickListener(health_math);
        p1plus5.setOnClickListener(health_math);
        //minus
        p1minus1.setOnClickListener(health_math);
        p1minus5.setOnClickListener(health_math);

        //poison health
        p1poison1.setOnClickListener(poison_math);
        p1poisonMin1.setOnClickListener(poison_math);
        return view;
    }

    View.OnClickListener health_math = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int n = 0;
            if (v == p1plus1){
                n = 1;
            }
            else if (v == p1plus5){
                n = 5;
            }
            else if (v == p1minus1){
                n = -1;
            }
            else if (v == p1minus5){
                n = -5;
            }
            playerhealth.setText(Integer.toString(
                    life_total_maths(n, playerhealth)));
        }
    };

    View.OnClickListener poison_math = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int n = 0;
            if (v == p1poison1){
                n = 1;
            }
            else if (v == p1poisonMin1){
                n = -1;
            }
            poisonhealth.setText(Integer.toString(
                    life_total_maths(n, poisonhealth)));
        }
    };

    public int life_total_maths(int n, TextView tv){
        return Integer.valueOf(tv.getText().toString()) + n;
    }

    public void resetHealth(){
        //resets the health of the player
        playerhealth.setText("20");
        poisonhealth.setText("0");
    }

    public void onPause(){
        super.onPause();

        SharedPreferences pref = getActivity().getSharedPreferences(PREF_COUNT1, 0);
        SharedPreferences.Editor edt = pref.edit();
        edt.putString("health1", playerhealth.getText().toString());
        edt.putString("poison1", poisonhealth.getText().toString());

        edt.commit();
    }
}
package com.smusings.rollofthedie;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class LifeCounterFragment extends Fragment{
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
                Number ph1=1;
                int ph = Integer.valueOf(ph1.intValue());
                String phealth = playerhealth.getText().toString();
                int p1health = Integer.valueOf(phealth);
                int health = p1health + ph;
                playerhealth.setText(Integer.toString(health));
            }
        });
        p1plus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number ph1=5;
                int ph = Integer.valueOf(ph1.intValue());
                String phealth = playerhealth.getText().toString();
                int p1health = Integer.valueOf(phealth);
                int health = p1health + ph;
                playerhealth.setText(Integer.toString(health));
            }
        });
        p1minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number ph1=(-1);
                int ph = Integer.valueOf(ph1.intValue());
                String phealth = playerhealth.getText().toString();
                int p1health = Integer.valueOf(phealth);
                int health = p1health + ph;
                playerhealth.setText(Integer.toString(health));
            }
        });

        p1minus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number ph1=(-5);
                int ph = Integer.valueOf(ph1.intValue());
                String phealth = playerhealth.getText().toString();
                int p1health = Integer.valueOf(phealth);
                int health = p1health + ph;
                playerhealth.setText(Integer.toString(health));
            }
        });

        //string to get rid of confusing logic in activity
        p1poison1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number pht1=1;
                int ph = Integer.valueOf(pht1.intValue());
                String poisonh = poisonhealth.getText().toString();
                int p1health = Integer.valueOf(poisonh);
                int health = p1health + ph;
                poisonhealth.setText(Integer.toString(health));
            }
        });
        p1poisonMin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number pht1=-1;
                int ph = Integer.valueOf(pht1.intValue());
                String poisonh = poisonhealth.getText().toString();
                int p1health = Integer.valueOf(poisonh);
                int health = p1health + ph;
                poisonhealth.setText(Integer.toString(health));
            }
        });
        return view;
    }

    public void resetHealth(){
        TextView playerhealth=(TextView)getView().findViewById(R.id.PlayerHealth);
        TextView poisonhealth=(TextView)getView().findViewById(R.id.poison_health);

        Number n=0;

        playerhealth.setText(n.toString());
        poisonhealth.setText(n.toString());
    }
}

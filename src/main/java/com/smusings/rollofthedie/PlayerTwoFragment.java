package com.smusings.rollofthedie;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class PlayerTwoFragment extends Fragment{
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.player_two_buttons, container, false);

        //player one buttons
        Button p2plus1 = (Button) view.findViewById(R.id.plusOne2);
        Button p2plus5 = (Button) view.findViewById(R.id.plusFive2);
        Button p2minus1 = (Button) view.findViewById(R.id.minusOne2);
        Button p2minus5 = (Button) view.findViewById(R.id.minusFive2);
        Button p2poison1 = (Button) view.findViewById(R.id.poisonOne2);
        Button p2poisonMin1=(Button) view.findViewById(R.id.poisonMinOne2);

        p2plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number ph=1;
                player2Listener.player2Press(ph);
            }
        });
        p2plus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number ph=5;
                player2Listener.player2Press(ph);
            }
        });
        p2minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number ph=(-1);
                player2Listener.player2Press(ph);
            }
        });

        p2minus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number ph=(-5);
                player2Listener.player2Press(ph);
            }
        });
        //string to get rid of confusing logic in activity
        p2poison1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number pht=1;
                player2Listener.player2Str(pht.toString());
            }
        });
        p2poisonMin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number pht=-1;
                player2Listener.player2Str(pht.toString());
            }
        });
        return view;
    }

    public interface Player2Listener{
        public void player2Press(Number ph);
        public void player2Str(String pht);
    }

    private Player2Listener player2Listener;

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);

        try{
            player2Listener=(Player2Listener)activity;
        } catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+
                    " must implement OnPressListener");
        }
    }
}

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
        Button p2reset = (Button) view.findViewById(R.id.player2reset);

        p2plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number ph=1;
                player2Listener.player2Press(ph.toString());
            }
        });
        p2plus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number ph=5;
                player2Listener.player2Press(ph.toString());
            }
        });
        p2minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number ph=(-1);
                player2Listener.player2Press(ph.toString());
            }
        });

        p2minus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number ph=(-5);
                player2Listener.player2Press(ph.toString());
            }
        });

        p2reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number ph=0;
                player2Listener.player2Press(ph.toString());
            }
        });
        return view;

    }

    public interface Player2Listener{
        public void player2Press(String ph);
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

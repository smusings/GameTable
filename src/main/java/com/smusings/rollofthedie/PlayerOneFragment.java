package com.smusings.rollofthedie;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class PlayerOneFragment extends Fragment{
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.player_one_buttons, container, false);

        //player one buttons
        Button p1plus1 = (Button) view.findViewById(R.id.plusOne1);
        Button p1plus5 = (Button) view.findViewById(R.id.plusFive1);
        Button p1minus1 = (Button) view.findViewById(R.id.minusOne1);
        Button p1minus5 = (Button) view.findViewById(R.id.minusFive1);
        Button p1poison1 = (Button) view.findViewById(R.id.poisonOne1);
        Button p1poisonMin1=(Button) view.findViewById(R.id.poisonMinOne1);

        p1plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number ph=1;
                player1Listener.player1Press(ph.toString());
            }
        });
        p1plus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number ph=5;
                player1Listener.player1Press(ph.toString());
            }
        });
        p1minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number ph=(-1);
                player1Listener.player1Press(ph.toString());
            }
        });

        p1minus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number ph=(-5);
                player1Listener.player1Press(ph.toString());
            }
        });

        p1poison1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number ph=10;
                player1Listener.player1Press(ph.toString());
            }
        });
        p1poisonMin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number ph=-10;
                player1Listener.player1Press(ph.toString());
            }
        });
        return view;

    }

    public interface Player1Listener{
        public void player1Press(String ph);
    }

    private Player1Listener player1Listener;

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);

        try{
            player1Listener=(Player1Listener)activity;
        } catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+
                    " must implement OnPressListener");
        }
    }
}

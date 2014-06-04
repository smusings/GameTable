package com.smusings.rollofthedie;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class CoinFlipFragment extends Fragment {
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        //set up the view and inflate the layout we are using
        View view = inflater.inflate(R.layout.coin_flip_fragment, container, false);

        //sets up the button and what to do on press
        Button flipcoin=(Button)view.findViewById(R.id.flipCoin);

        flipcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //logic that will
                int flip_coin = (int) Math.ceil(Math.random() * 2);
                String result=Integer.toString(flip_coin);
                onNewFlipListener.onNewFlip(result);
            }
        });
        return view;
    }

    //setting up a listener to send results to another activity
    public interface OnNewFlipListener{
        public void onNewFlip(String result);
    }

    private OnNewFlipListener onNewFlipListener;

    //gives error if needed
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        try{
            onNewFlipListener=(OnNewFlipListener)activity;
        } catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+
                    " must implement OnNewFlipListener");
        }
    }
}

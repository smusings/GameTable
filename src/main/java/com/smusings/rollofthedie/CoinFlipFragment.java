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
        View view = inflater.inflate(R.layout.coin_flip_fragment, container, false);
        Button flipcoin=(Button)view.findViewById(R.id.flipCoin);

        flipcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int flip_coin = (int) Math.ceil(Math.random() * 2);
                String result=Integer.toString(flip_coin);
                onNewFlipListener.onNewFlip(result);

            }
        });

        return view;
    }

    public interface OnNewFlipListener{
        public void onNewFlip(String result);
    }

    private OnNewFlipListener onNewFlipListener;

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

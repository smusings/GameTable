package com.smusings.rollofthedie;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class DieRollFragment extends Fragment {

    public Button die4;
    public Button die6;
    public Button die8;
    public Button die10;
    public Button die12;
    public Button die20;
	
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.activity_die_roll_fragment, container, false);

		//the die
		die6 = (Button)view.findViewById(R.id.die6);
		die4 = (Button)view.findViewById(R.id.die4);
		die8 = (Button)view.findViewById(R.id.die8);
		die10 = (Button)view.findViewById(R.id.die10);
		die12 = (Button)view.findViewById(R.id.die12);
		die20 = (Button)view.findViewById(R.id.die20);

        //each button press will roll a number between 1 and what is assigned to it, put that number
        //into the string and send it via listener to an activity that calls it up
		die4.setOnClickListener(dieRollClickListener);
		die6.setOnClickListener(dieRollClickListener);
		die8.setOnClickListener(dieRollClickListener);
		die10.setOnClickListener(dieRollClickListener);
		die12.setOnClickListener(dieRollClickListener);
        die20.setOnClickListener(dieRollClickListener);

		return view;
	}

    View.OnClickListener dieRollClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String message = "null";
            if (((Button)v) == die4){
                message = "Your 4-sided die roll came up a " + rollResult(4);
            }
            else if (((Button)v) == die6){
                message = "Your 6-sided die roll came up a " +  + rollResult(6);
            }
            else if (((Button)v) == die8){
                message = "Your 8-sided die roll came up a " + rollResult(8);
            }
            else if (((Button)v) == die10){
                message = "Your 10-sided die roll came up a " + rollResult(10);
            }
            else if (((Button)v) == die12){
                message = "Your 12-sided die roll came up a " + rollResult(12);
            }
            else if (((Button)v) == die20){
                message = "Your 20-sided die roll came up a " + rollResult(20);
            }
            onNewRollListener.onNewRoll(message);
        }
    };

    public int rollResult(int roll){
        return (int)(Math.random() * ((roll - 1) +1)+ 1);
    }
    //the listener that sends it along
    //the listener locks for a new String message to send to an activity
	public interface OnNewRollListener{
		public void onNewRoll(String message);
	}
	
	private OnNewRollListener onNewRollListener;
	
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		try{
			onNewRollListener = (OnNewRollListener)activity;
		} catch (ClassCastException e){
			throw new ClassCastException(activity.toString()+
					" must implement OnNewRollListener");
		}
	}

}

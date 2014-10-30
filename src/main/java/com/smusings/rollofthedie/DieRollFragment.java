package com.smusings.rollofthedie;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;

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

    public int rollResult(int roll) {
        Random random = new Random();
        return (random.nextInt(roll) + 1);
    }

    View.OnClickListener dieRollClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String message = "null";
            if (((Button) v) == die4){
                message = "Your D4 came up a " + rollResult(4);
            }
            else if (((Button) v) == die6){
                message = "Your D6 came up a " +  + rollResult(6);
            }
            else if (((Button) v) == die8){
                message = "Your D8 came up a " + rollResult(8);
            }
            else if (((Button) v) == die10){
                message = "Your D10 came up a " + rollResult(10);
            }
            else if (((Button) v) == die12){
                message = "Your D12 came up a " + rollResult(12);
            }
            else if (((Button) v) == die20){
                message = "Your D20 came up a " + rollResult(20);
            }
            onNewRollListener.onNewRoll(message);
        }
    };

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

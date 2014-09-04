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
		die4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int Roll_four = (int)Math.ceil(Math.random()*4);
				String message = "Your four sided die roll came up a "+Roll_four;
				onNewRollListener.onNewRoll(message);
			}
		});
		
		die6.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				int Roll_six = (int)Math.ceil(Math.random()*6);
				String message = "Your six sided die roll came up a "+Roll_six;
				onNewRollListener.onNewRoll(message);
			}
		});
		
		die8.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				int Roll_eight = (int)Math.ceil(Math.random()*8);
				String message = "Your eight sided die roll came up a "+Roll_eight;
				onNewRollListener.onNewRoll(message);
			}
		});
		
		die10.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {	
				int Roll_ten = ((int)Math.ceil(Math.random()*10));
				String message = "Your ten sided die roll came up a "+Roll_ten;
				onNewRollListener.onNewRoll(message);
			}
		});
		
		die12.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				int Roll_twelve = ((int)Math.ceil(Math.random()*12));
				String message = "Your twelve sided die roll came up a "+Roll_twelve;
				onNewRollListener.onNewRoll(message);
			}
		});
		
		die20.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View v) {
				int Roll_twnty = (int)Math.ceil(Math.random()*20);
				String message = "Your twenty sided die roll came up a "+Roll_twnty;
				onNewRollListener.onNewRoll(message);
				
			}
		});
		return view;
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

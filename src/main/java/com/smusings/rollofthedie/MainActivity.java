package com.smusings.rollofthedie;

import java.util.ArrayList;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

public class MainActivity extends FragmentActivity
	implements DieRollFragment.OnNewRollListener{
	private ArrayAdapter<String>aa;
	private ArrayList<String> DieRolls;

	public void onNewRoll(String message){
		aa.insert(message, 0);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.activity_main);
		
		//references to UI widgets
		FragmentManager fm = getFragmentManager();
		RollListFragment rollListFragment=
				(RollListFragment)fm.findFragmentById(R.id.RollListFragment);
		
		//Create the array list
		DieRolls=new ArrayList<String>();
		
		//Create the Array Adapter to bind the array to the list view
		int resID=R.layout.roll_list_item;
		aa=new ArrayAdapter<String>(this, resID, DieRolls);

		
		//Bind the Array Adapter to the list view
		rollListFragment.setListAdapter(aa);
		
		
		

	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		MenuInflater menuInflater=getMenuInflater();
		menuInflater.inflate(R.layout.menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()){
		case R.id.menu_about:
			Intent intent=new Intent(this, About.class);
			startActivity(intent);
			return true;
		
		case R.id.menu_delete:
			aa.clear();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}

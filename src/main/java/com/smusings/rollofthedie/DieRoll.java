package com.smusings.rollofthedie;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class DieRoll extends Activity
        implements DieRollFragment.OnNewRollListener
{

    public ArrayAdapter<String> aa;
    public ArrayList<String>    DieRolls;
    public RollListFragment     rollListFragment;


    public void onNewRoll(String message)
    {
        aa.insert(message, 0);
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.die_roll);

        //references to UI widgets
        FragmentManager fm = getFragmentManager();
        rollListFragment =
                (RollListFragment) fm.findFragmentById(R.id.RollListFrag);

        //Create the array list
        DieRolls = new ArrayList<String>();

        //Create the Array Adapter to bind the array to the list view
        int resID = R.layout.roll_list_item;
        aa    = new ArrayAdapter<String>(this, resID, DieRolls);

        //Bind the Array Adapter to the list view
        rollListFragment.setListAdapter(aa);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_clear:
                aa.clear();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}


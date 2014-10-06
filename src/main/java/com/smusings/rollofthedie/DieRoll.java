package com.smusings.rollofthedie;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class DieRoll extends MainActivity
        implements DieRollFragment.OnNewRollListener {

    public ArrayAdapter<String> aa;
    public ArrayList<String> DieRolls;
    public RollListFragment rollListFragment;
    public DieRollFragment dieRollFragment;


    public void onNewRoll(String message) {
        aa.insert(message, 0);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.die_roll);

        //references to UI widgets
        FragmentManager fm = getSupportFragmentManager();
        rollListFragment =
                (RollListFragment) fm.findFragmentById(R.id.RollListFrag);
        dieRollFragment =
                (DieRollFragment) fm.findFragmentById(R.id.DieRollFrag);

        //Create the array list
        DieRolls = new ArrayList<String>();

        //Create the Array Adapter to bind the array to the list view
        int resID = R.layout.roll_list_item;
        aa = new ArrayAdapter<String>(this, resID, DieRolls);


        //Bind the Array Adapter to the list view
        rollListFragment.setListAdapter(aa);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_clear:
                aa.clear();
                return true;
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}


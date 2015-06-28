package com.poolschool2.drill;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.poolschool2.SafetyDrill.DuckAndCover;
import com.poolschool2.SafetyDrill.HalfTableSafety;
import com.poolschool2.SafetyDrill.SafetyOrNot;
import com.poolschool.poolschool.R;

/**
 * Created by OWNER-PC on 4/13/2015.
 */
public class SafetyDrills extends Activity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.safetydrill);

        populateListView();
        registerClickCallback();

    }
    private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.safetyListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                if(position==0){
                    Intent intent;
                    intent = new Intent(getApplicationContext(),HalfTableSafety.class);
                    startActivity(intent);
                }
                else if(position==1){
                    Intent intent;
                    intent = new Intent(getApplicationContext(),DuckAndCover.class);
                    startActivity(intent);
                }
                else if(position==2){
                    Intent intent;
                    intent = new Intent(getApplicationContext(),SafetyOrNot.class);
                    startActivity(intent);
                }

            }
        });
    }

    private void populateListView() {
        //create list of Item
        String[] cueBallControlDrills = {"HalfTableSafety", "Duck And Cover", "Safety Or Not"};

        //build adapter  context, layout to use, item to display
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.cueballcontrollist,cueBallControlDrills);

        //configure
        ListView list = (ListView) findViewById(R.id.safetyListView);
        list.setAdapter(adapter);
    }

}

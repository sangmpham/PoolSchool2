package com.poolschool2.drill;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.poolschool2.CueBallControlDrills.ProgressiveDrill1;
import com.poolschool2.CueBallControlDrills.ProgressivePositionDrill2;
import com.poolschool2.CueBallControlDrills.ProgressivePositionDrill3;
import com.poolschool.poolschool.R;

/**
 * Created by OWNER-PC on 4/11/2015.
 */
public class CueBallControl extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cueballcontrol);

        populateListView();
        registerClickCallback();
    }

    private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.cueBallControlListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;

                //set the action taken when listview is click
                if(position==0){
                    Intent intent;
                    intent = new Intent(getApplicationContext(),ProgressiveDrill1.class);
                    startActivity(intent);
                }
                else if(position==1){
                    Intent intent;
                    intent = new Intent(getApplicationContext(),ProgressivePositionDrill2.class);
                    startActivity(intent);
                }
                else if(position==2){
                    Intent intent;
                    intent = new Intent(getApplicationContext(),ProgressivePositionDrill3.class);
                    startActivity(intent);
                }

            }
        });
    }

    private void populateListView() {
        //create list of Item
        String[] cueBallControlDrills = {"Progressive Drill 1", "Progressive Drill 2", "Progressive Drill 3"};

        //build adapter  context, layout to use, item to display
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.cueballcontrollist,cueBallControlDrills);

        //configure
        ListView list = (ListView) findViewById(R.id.cueBallControlListView);
        list.setAdapter(adapter);
    }





}

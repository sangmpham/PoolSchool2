package com.poolschool2.drill;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.poolschool2.KickDrill.KickIt;
import com.poolschool2.KickDrill.ProgressiveKicking1;
import com.poolschool2.KickDrill.ProgressiveKicking2;
import com.poolschool.poolschool.R;

public class KickDrills extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kick_drills);

        populateListView();
        registerClickCallback();
    }


    private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.kickListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;

                //set the action taken when listview is click
                if (position == 0) {
                    Intent intent;
                    intent = new Intent(getApplicationContext(), KickIt.class);
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent;
                    intent = new Intent(getApplicationContext(), ProgressiveKicking1.class);
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent;
                    intent = new Intent(getApplicationContext(), ProgressiveKicking2.class);
                    startActivity(intent);
                }

            }
        });
    }

    private void populateListView() {
        //create list of Item
        String[] cueBallControlDrills = {"Kick It", "Progressive Kicking Drill 1", "Progressive Kicking Drill 2"};

        //build adapter  context, layout to use, item to display
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.cueballcontrollist,cueBallControlDrills);

        //configure
        ListView list = (ListView) findViewById(R.id.kickListView);
        list.setAdapter(adapter);
    }
}

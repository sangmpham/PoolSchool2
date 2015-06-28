package com.poolschool2.drill;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.poolschool.poolschool.R;
import com.poolschool2.shotMakingDrills.AimToWin;
import com.poolschool2.shotMakingDrills.Pocket9Drill;
import com.poolschool2.shotMakingDrills.RailShot;

public class ShotMakingDrillList extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shotmakingdrill);

        populateListView();
        registerClickCallback();

    }
    private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.shotMakingListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //set the action taken when listview is click
                if(position==0){
                    Intent intent;
                    intent = new Intent(getApplicationContext(),AimToWin.class);
                    startActivity(intent);
                }
                else if(position==1){
                    Intent intent;
                    intent = new Intent(getApplicationContext(),RailShot.class);
                    startActivity(intent);
                }
                else if(position==2){
                    Intent intent;
                    intent = new Intent(getApplicationContext(),Pocket9Drill.class);
                    startActivity(intent);
                }


            }
        });
    }

    private void populateListView() {
        //create list of Item
        String[] cueBallControlDrills = {"Aim To Win", "Rail Shot","Pocket the 9"};

        //build adapter  context, layout to use, item to display
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.cueballcontrollist, cueBallControlDrills);

        //configure
        ListView list = (ListView) findViewById(R.id.shotMakingListView);
        list.setAdapter(adapter);
    }


}

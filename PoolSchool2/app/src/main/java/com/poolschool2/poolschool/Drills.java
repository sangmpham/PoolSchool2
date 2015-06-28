package com.poolschool2.poolschool;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.poolschool2.drill.CueBallControl;
import com.poolschool2.drill.KickDrills;
import com.poolschool2.drill.SafetyDrills;
import com.poolschool2.drill.ShotMakingDrillList;
import com.poolschool.poolschool.R;


/**
 * Created by OWNER-PC on 4/11/2015.
 */
    public class Drills extends Activity {
        private Button cueBallControl, safety, kick, shotMaking;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drills);
        addListenerOnButton();

    }
    public void addListenerOnButton(){

        cueBallControl = (Button) findViewById(R.id.cueBallControl);
        cueBallControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(), CueBallControl.class);
                startActivity(intent);
            }
        });

        safety = (Button) findViewById(R.id.safety);
        safety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(), SafetyDrills.class);
                startActivity(intent);
            }
        });
        kick = (Button) findViewById(R.id.kick);
        kick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(), KickDrills.class);
                startActivity(intent);
            }
        });
        shotMaking =(Button) findViewById(R.id.shotMaking);
        shotMaking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(), ShotMakingDrillList.class);
                startActivity(intent);
            }
        });
    }

}

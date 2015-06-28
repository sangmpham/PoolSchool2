package com.poolschool2.poolschool;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.poolschool2.league.League;
import com.poolschool2.fundamental.FundamentalList;
import com.poolschool.poolschool.R;

public class MainActivity extends Activity implements View.OnClickListener{
    private ImageButton fundamental,league,drill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drill = (ImageButton) findViewById(R.id.drill);
        fundamental = (ImageButton) findViewById(R.id.fundamental);
        league = (ImageButton) findViewById(R.id.league);

        drill.setOnClickListener(this);
        fundamental.setOnClickListener(this);
        league.setOnClickListener(this);


    }

    @Override
    public void onClick(View v){

        if(v==drill)
            startActivity(new Intent(this, Drills.class));
        else if(v==fundamental)
            startActivity(new Intent(this, FundamentalList.class));
        else if(v==league)
            startActivity(new Intent(this, League.class));

    }



}

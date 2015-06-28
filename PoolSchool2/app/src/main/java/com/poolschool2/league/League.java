package com.poolschool2.league;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.poolschool.poolschool.R;


public class League extends Activity {
    private Button BCA8Ball, BCA9Ball, viewPrevious;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league);



        addListenerOnButton();
    }
   public void addListenerOnButton(){

        BCA8Ball = (Button) findViewById(R.id.BCA8ballLeagueButton);
        BCA8Ball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(), BCA8League.class);
                startActivity(intent);
            }
        });

        BCA9Ball = (Button) findViewById(R.id.BCA9BallLeagueButton);
        BCA9Ball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(), Ball9League.class);
                startActivity(intent);
            }
        });

       viewPrevious =(Button)findViewById(R.id.viewPreviousSessionButton);
       viewPrevious.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               Intent intent;
               intent = new Intent(getApplicationContext(), ViewPreviousSession.class);
               startActivity(intent);

           }
       });

    }



}

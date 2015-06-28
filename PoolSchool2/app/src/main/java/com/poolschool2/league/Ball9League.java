package com.poolschool2.league;

import android.app.Activity;
import android.os.Bundle;

import com.poolschool.poolschool.R;

import java.util.ArrayList;

public class Ball9League extends Activity {
    ArrayList<Ball9LeagueScoreClass> myLeague = new ArrayList<Ball9LeagueScoreClass>();
    ArrayList<Ball9LeagueScoreClass> myAwayLeague = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bca9league);

        /*for(int i=0;i<5;i++){
            myLeague.add(new Ball9LeagueScoreClass());
            myAwayLeague.add(new Ball9LeagueScoreClass());
        }
*/

       // populateListView();
       // registerClickCallback();
    }


   /* private void populateListView() {
        ArrayAdapter<Ball9LeagueScoreClass> adapter = new MyListAdapter();
        ArrayAdapter<Ball9LeagueScoreClass> adapterAway = new MyListAdapter2();
        ListView list = (ListView) findViewById(R.id.ball9HomeTeamListView);
        ListView listAway = (ListView) findViewById(R.id.ball9AwayTeamListView);
        list.setAdapter(adapter);
        listAway.setAdapter(adapterAway);
    }
    private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.ball9HomeTeamListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                Ball9LeagueScoreClass clickPlayer = myLeague.get(position);

            }
        });
    }
    private class MyListAdapter2 extends ArrayAdapter<Ball9LeagueScoreClass>{
        public MyListAdapter2(){
            super(Ball9League.this, R.layout.ball9leaguescorestruct, myAwayLeague);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            //make sure we have a view
            View itemView = convertView;
            if(itemView == null){
                itemView = getLayoutInflater().inflate(R.layout.ball9leaguescorestruct, parent, false);
            }
            //find the player
            Ball9LeagueScoreClass currentPlay = myAwayLeague.get(position);


            //fill the view player name and each score
            TextView playerName = (TextView)itemView.findViewById(R.id.playerName);
            playerName.setText(currentPlay.getName());

            TextView score1 = (TextView)itemView.findViewById(R.id.playerScore1);
            score1.setText("" + currentPlay.getScore1());

            TextView score2 = (TextView)itemView.findViewById(R.id.playerScore2);
            score2.setText(""+currentPlay.getScore2());

            TextView score3 = (TextView)itemView.findViewById(R.id.playerScore3);
            score3.setText(""+currentPlay.getScore3());

            TextView score4 = (TextView)itemView.findViewById(R.id.playerScore4);
            score4.setText(""+currentPlay.getScore4());

            TextView score5 = (TextView)itemView.findViewById(R.id.playerScore5);
            score5.setText(""+currentPlay.getScore5());

            return itemView;

        }


    }

    private class MyListAdapter extends ArrayAdapter<Ball9LeagueScoreClass>{
        public MyListAdapter(){
            super(Ball9League.this, R.layout.ball9leaguescorestruct, myLeague);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            //make sure we have a view
            View itemView = convertView;
            if(itemView == null){
                itemView = getLayoutInflater().inflate(R.layout.ball9leaguescorestruct, parent, false);
            }
            //find the player
            Ball9LeagueScoreClass currentPlay = myLeague.get(position);


            //fill the view player name and each score
            TextView playerName = (TextView)itemView.findViewById(R.id.playerName);
            playerName.setText(currentPlay.getName());

            TextView score1 = (TextView)itemView.findViewById(R.id.playerScore1);
            score1.setText("" + currentPlay.getScore1());

            TextView score2 = (TextView)itemView.findViewById(R.id.playerScore2);
            score2.setText(""+currentPlay.getScore2());

            TextView score3 = (TextView)itemView.findViewById(R.id.playerScore3);
            score3.setText(""+currentPlay.getScore3());

            TextView score4 = (TextView)itemView.findViewById(R.id.playerScore4);
            score4.setText(""+currentPlay.getScore4());

            TextView score5 = (TextView)itemView.findViewById(R.id.playerScore5);
            score5.setText(""+currentPlay.getScore5());

            return itemView;

        }


       }


*/


}

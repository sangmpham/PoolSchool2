package com.poolschool2.league;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import com.poolschool.poolschool.R;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class LeagueSearchResult extends Activity {
    private FileInputStream fis;
    private String fileName;
    private String[] teamName;
    private ArrayList<ArrayList<BCA8LeaguePlayer>> myPlayer = new ArrayList<>();
    private ArrayList<String> homeTeamName = new ArrayList<>();
    private ArrayList<String> awayTeamName = new ArrayList<>();
    private ArrayList<String> homeTeamTotal = new ArrayList<>();
    private ArrayList<String> awayTeamTotal = new ArrayList<>();
    private ArrayList<EditText> playerName= new ArrayList<>();
    private ArrayList<EditText> playerTotal = new ArrayList<>();
    private ArrayList<EditText> playerAve = new ArrayList<>();
    private ArrayList<ArrayList<EditText>> playerScores = new ArrayList<ArrayList<EditText>>();
    private EditText homeTeamNameEditText ;
    private EditText awayTeamNameEditText;
    //private int[] homeTeamCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.league_search_result);



        teamName = getIntent().getExtras().getStringArray("key");


        fileName = teamName[0];
        System.out.println("****************************"+teamName[0] + teamName[1]);

        createPlayerAve();
        createPlayerScores();
        createPlayerNameList();
        createPlayerTotal();
        createHomeTeamAndAwayTeamNameAndTotal();
        readFile();

    }

    private void readFile() {
        String line;

        try{
            fis = openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader buffReader = new BufferedReader(isr);


            while((line =buffReader.readLine()) != null) {
                Scanner nextName = new Scanner(line);

                homeTeamName.add(nextName.next());//get home team name
                myPlayer.add(new ArrayList<BCA8LeaguePlayer>());


                while (nextName.hasNext()) {
                    if(nextName.next().equals("@"))
                        break;
                    else{
                        myPlayer.get(myPlayer.size()).add(new BCA8LeaguePlayer());
                        myPlayer.get(myPlayer.size()).get(myPlayer.get(myPlayer.size()).size()).setAve(Integer.parseInt(nextName.next()));
                        myPlayer.get(myPlayer.size()).get(myPlayer.get(myPlayer.size()).size()).setPlayerName(nextName.next());
                        myPlayer.get(myPlayer.size()).get(myPlayer.get(myPlayer.size()).size()).setScore1(Integer.parseInt(nextName.next()));
                        myPlayer.get(myPlayer.size()).get(myPlayer.get(myPlayer.size()).size()).setScore2(Integer.parseInt(nextName.next()));
                        myPlayer.get(myPlayer.size()).get(myPlayer.get(myPlayer.size()).size()).setScore3(Integer.parseInt(nextName.next()));
                        myPlayer.get(myPlayer.size()).get(myPlayer.get(myPlayer.size()).size()).setTotal(Integer.parseInt(nextName.next()));
                        //homeTeamCount++;


                    }

                }
                awayTeamName.add(nextName.next());//get away team name
                while (nextName.hasNext()) {
                    if(nextName.next().equals("@"))
                        break;
                    else{
                        myPlayer.get(myPlayer.size()).add(new BCA8LeaguePlayer());
                        myPlayer.get(myPlayer.size()).get(myPlayer.get(myPlayer.size()).size()).setAve(Integer.parseInt(nextName.next()));
                        myPlayer.get(myPlayer.size()).get(myPlayer.get(myPlayer.size()).size()).setPlayerName(nextName.next());
                        myPlayer.get(myPlayer.size()).get(myPlayer.get(myPlayer.size()).size()).setScore1(Integer.parseInt(nextName.next()));
                        myPlayer.get(myPlayer.size()).get(myPlayer.get(myPlayer.size()).size()).setScore2(Integer.parseInt(nextName.next()));
                        myPlayer.get(myPlayer.size()).get(myPlayer.get(myPlayer.size()).size()).setScore3(Integer.parseInt(nextName.next()));
                        myPlayer.get(myPlayer.size()).get(myPlayer.get(myPlayer.size()).size()).setTotal(Integer.parseInt(nextName.next()));
                        //homeTeamCount++;


                    }

                }
                homeTeamTotal.add(nextName.next());
                awayTeamTotal.add(nextName.next());

            }

            for(int i=0;i<myPlayer.size();i++){
                for(int j=0;j<myPlayer.get(i).size();j++){
                    System.out.print(myPlayer.get(i).get(j).getAve() + " " + myPlayer.get(i).get(j).getPlayerName() + " " + myPlayer.get(i).get(j).getScore1());
                }
            }

        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("Cant open file for reading BCA8Leageu");
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.out.println("Cant reading from file BCA8Leageu");
        }
    }
    private void createHomeTeamAndAwayTeamNameAndTotal(){
        homeTeamNameEditText =(EditText)findViewById(R.id.BCA8PreviousResultHomeTeamName);
        awayTeamNameEditText = (EditText)findViewById(R.id.BCA8PreviousResultScoreAwayTeamName);
        // homeTeamTotalTextView=(TextView)findViewById(R.id.BCA8HomeTeamTotalScore);
        //awayTeamTotalTextView=(TextView)findViewById(R.id.BCA8AwayTeamTotalScore);

    }

    //initialize playerTotal
    private void createPlayerTotal(){
        playerTotal.add((EditText)findViewById(R.id.BCA8PreviousResultPlayer1Total));
        playerTotal.add((EditText)findViewById(R.id.BCA8PreviousResultPlayer2Total));
        playerTotal.add((EditText)findViewById(R.id.BCA8PreviousResultPlayer3Total));
        playerTotal.add((EditText)findViewById(R.id.BCA8PreviousResultPlayer4Total));
        playerTotal.add((EditText)findViewById(R.id.BCA8PreviousResultPlayer5Total));
        playerTotal.add((EditText)findViewById(R.id.BCA8PreviousResultPlayer6Total));
        playerTotal.add((EditText)findViewById(R.id.BCA8PreviousResultPlayer7Total));
        playerTotal.add((EditText)findViewById(R.id.BCA8PreviousResultPlayer8Total));
        playerTotal.add((EditText)findViewById(R.id.BCA8PreviousResultPlayer9Total));
        playerTotal.add((EditText)findViewById(R.id.BCA8PreviousResultPlayer10Total));
    }

    //initialize playerName with 10 player
    private void createPlayerNameList() {
        playerName.add((EditText) findViewById(R.id.BCA8PreviousResultPlayer1Name));
        playerName.add((EditText) findViewById(R.id.BCA8PreviousResultPlayer2Name));
        playerName.add((EditText) findViewById(R.id.BCA8PreviousResultPlayer3Name));
        playerName.add((EditText) findViewById(R.id.BCA8PreviousResultPlayer4Name));
        playerName.add((EditText) findViewById(R.id.BCA8PreviousResultPlayer5Name));
        playerName.add((EditText) findViewById(R.id.BCA8PreviousResultPlayer6Name));
        playerName.add((EditText) findViewById(R.id.BCA8PreviousResultPlayer7Name));
        playerName.add((EditText) findViewById(R.id.BCA8PreviousResultPlayer8Name));
        playerName.add((EditText) findViewById(R.id.BCA8PreviousResultPlayer9Name));
        playerName.add((EditText) findViewById(R.id.BCA8PreviousResultPlayer10Name));

       // for(int i=0;i<playerName.size();i++){
            //playerName.get(i).setText(null);
        //}

    }

    //initialize playerScore 3 score per player
    private void createPlayerScores(){
        playerScores.add(new ArrayList<EditText>());
        playerScores.get(0).add((EditText)findViewById(R.id.BCA8PreviousResultPlayer1Score1));
        playerScores.get(0).add((EditText)findViewById(R.id.BCA8PreviousResultPlayer1Score2));
        playerScores.get(0).add((EditText)findViewById(R.id.BCA8PreviousResultPlayer1Score3));

        playerScores.add(new ArrayList<EditText>());
        playerScores.get(1).add((EditText) findViewById(R.id.BCA8PreviousResultPlayer2Score1));
        playerScores.get(1).add((EditText)findViewById(R.id.BCA8PreviousResultPlayer2Score2));
        playerScores.get(1).add((EditText) findViewById(R.id.BCA8PreviousResultPlayer2Score3));

        playerScores.add(new ArrayList<EditText>());
        playerScores.get(2).add((EditText) findViewById(R.id.BCA8PreviousResultPlayer3Score1));
        playerScores.get(2).add((EditText)findViewById(R.id.BCA8PreviousResultPlayer3Score2));
        playerScores.get(2).add((EditText)findViewById(R.id.BCA8PreviousResultPlayer3Score3));

        playerScores.add(new ArrayList<EditText>());
        playerScores.get(3).add((EditText) findViewById(R.id.BCA8PreviousResultPlayer4Score1));
        playerScores.get(3).add((EditText)findViewById(R.id.BCA8PreviousResultPlayer4Score2));
        playerScores.get(3).add((EditText)findViewById(R.id.BCA8PreviousResultPlayer4Score3));

        playerScores.add(new ArrayList<EditText>());
        playerScores.get(4).add((EditText) findViewById(R.id.BCA8PreviousResultPlayer5Score1));
        playerScores.get(4).add((EditText)findViewById(R.id.BCA8PreviousResultPlayer5Score2));
        playerScores.get(4).add((EditText)findViewById(R.id.BCA8PreviousResultPlayer5Score3));

        playerScores.add(new ArrayList<EditText>());
        playerScores.get(5).add((EditText) findViewById(R.id.BCA8PreviousResultPlayer6Score1));
        playerScores.get(5).add((EditText)findViewById(R.id.BCA8PreviousResultPlayer6Score2));
        playerScores.get(5).add((EditText)findViewById(R.id.BCA8PreviousResultPlayer6Score3));

        playerScores.add(new ArrayList<EditText>());
        playerScores.get(6).add((EditText) findViewById(R.id.BCA8PreviousResultPlayer7Score1));
        playerScores.get(6).add((EditText)findViewById(R.id.BCA8PreviousResultPlayer7Score2));
        playerScores.get(6).add((EditText)findViewById(R.id.BCA8PreviousResultPlayer7Score3));

        playerScores.add(new ArrayList<EditText>());
        playerScores.get(7).add((EditText) findViewById(R.id.BCA8PreviousResultPlayer8Score1));
        playerScores.get(7).add((EditText)findViewById(R.id.BCA8PreviousResultPlayer8Score2));
        playerScores.get(7).add((EditText)findViewById(R.id.BCA8PreviousResultPlayer8Score3));

        playerScores.add(new ArrayList<EditText>());
        playerScores.get(8).add((EditText) findViewById(R.id.BCA8PreviousResultPlayer9Score1));
        playerScores.get(8).add((EditText)findViewById(R.id.BCA8PreviousResultPlayer9Score2));
        playerScores.get(8).add((EditText)findViewById(R.id.BCA8PreviousResultPlayer9Score3));

        playerScores.add(new ArrayList<EditText>());
        playerScores.get(9).add((EditText) findViewById(R.id.BCA8PreviousResultPlayer10Score1));
        playerScores.get(9).add((EditText)findViewById(R.id.BCA8PreviousResultPlayer10Score2));
        playerScores.get(9).add((EditText)findViewById(R.id.BCA8PreviousResultPlayer10Score3));
    }

    private void createPlayerAve(){
        playerAve.add((EditText) findViewById(R.id.BCA8PreviousResultPlayer1Avg));
        playerAve.add((EditText) findViewById(R.id.BCA8PreviousResultPlayer2Avg));
        playerAve.add((EditText) findViewById(R.id.BCA8PreviousResultPlayer3Avg));
        playerAve.add((EditText) findViewById(R.id.BCA8PreviousResultPlayer4Avg));
        playerAve.add((EditText) findViewById(R.id.BCA8PreviousResultPlayer5Avg));
        playerAve.add((EditText) findViewById(R.id.BCA8PreviousResultPlayer6Avg));
        playerAve.add((EditText) findViewById(R.id.BCA8PreviousResultPlayer7Avg));
        playerAve.add((EditText) findViewById(R.id.BCA8PreviousResultPlayer8Avg));
        playerAve.add((EditText) findViewById(R.id.BCA8PreviousResultPlayer9Avg));
        playerAve.add((EditText) findViewById(R.id.BCA8PreviousResultPlayer10Avg));
    }


}



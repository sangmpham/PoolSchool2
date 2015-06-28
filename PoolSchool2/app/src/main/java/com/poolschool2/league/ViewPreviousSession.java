package com.poolschool2.league;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.poolschool.poolschool.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ViewPreviousSession extends Activity {
    private String allHomeTeamFile;
    private String allAwayTeamFile;
    private ArrayList<String> homeTeamNameFromFile = new ArrayList<>();
    private ArrayList<String> awayTeamNameFromFile = new ArrayList<>();
    private String[] teamName ;
    private FileInputStream fis;
    private ArrayList<String> homeTeamName = new ArrayList<>();
    private ArrayList<String> awayTeamName = new ArrayList<>();
    private ArrayList<Integer> homeTeamTotal = new ArrayList<>();
    private ArrayList<Integer> awayTeamTotal = new ArrayList<>();
    private ArrayList<BCA8LeaguePlayer> playerStat = new ArrayList<>();
    private Button search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_previous_session);

        teamName = new String[2];


        allHomeTeamFile = "BCA8HomeTeamFile2.txt";
        allAwayTeamFile = "BCA8AwayTeamFile2.txt";

        readTeamFile(allHomeTeamFile, homeTeamNameFromFile);
        readTeamFile(allAwayTeamFile, awayTeamNameFromFile);

        populateHomeListView();
        populateAwayListView();
        registerClickCallback();
        addListenerOnButton();
    }

    public void addListenerOnButton(){


        search =(Button)findViewById(R.id.previoussessionsearch);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;
                intent = new Intent(getApplicationContext(), LeagueSearchResult.class);
                intent.putExtra("key",teamName);

                startActivity(intent);

            }
        });

    }

    //get what the user chose for the away and home team.
    private void registerClickCallback() {
        ListView homeList = (ListView) findViewById(R.id.previousHomeSessionListView);
        homeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                teamName[0] = homeTeamNameFromFile.get(position).toString();

            }
        });

        ListView awayList = (ListView) findViewById(R.id.previousAwaySessionListView);
        awayList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                teamName[1] = awayTeamNameFromFile.get(position).toString();

            }
        });
    }

    //populate home listview
    private void populateHomeListView() {

        //build adapter  context, layout to use, item to display
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.cueballcontrollist,homeTeamNameFromFile);

        //configure
        ListView list = (ListView) findViewById(R.id.previousHomeSessionListView);
        list.setAdapter(adapter);
    }

    //populate away list view
    private void populateAwayListView() {
       String[] away = new String[awayTeamNameFromFile.size()];
       for(int i=0;i<awayTeamNameFromFile.size();i++){
            away[i]=awayTeamNameFromFile.get(i);
        }
        //build adapter  context, layout to use, item to display
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.cueballcontrollist, away);

        //configure
        ListView list = (ListView) findViewById(R.id.previousAwaySessionListView);
        list.setAdapter(adapter);
    }





    public void readTeamFile(String fileName, ArrayList<String> teamList) {

        String line;
        try {
            fis = openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader buffReader = new BufferedReader(isr);

            //get all home team name
            while ((line = buffReader.readLine()) != null) {
               teamList.add(line);
            }

            buffReader.close();
            isr.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Cant open file to read ViewPreviousSession!!!!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Can't read from file ViewPreviousSession");
        }


    }
}
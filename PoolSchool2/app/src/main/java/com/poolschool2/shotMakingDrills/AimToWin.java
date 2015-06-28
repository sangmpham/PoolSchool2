package com.poolschool2.shotMakingDrills;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;


import com.poolschool.poolschool.R;
import com.poolschool2.poolschool.SaveFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AimToWin extends Activity {
    private Button save, graph;
    private SaveFile toSave ;
    private String fileName; //file name to save to
    private RadioButton shot1,shot2,shot3,shot4,shot5,shot6,shot7;
    private int[] shotList;
    private OutputStreamWriter out;
    private File file;
    private String writeString;
    private FileOutputStream fos;//for output
    private FileInputStream fis;//for input
    private ArrayList<Integer> made = new ArrayList<>();//contain all the miss
    private ArrayList<Integer> miss = new ArrayList<>();//contain all the made



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aim_to_win);
        //toSave = new SaveFile(fileName);
        shotList = new int[7];
        shot1 =(RadioButton)findViewById(R.id.AimToWinRadio1);//get all radiobutton
        shot2 =(RadioButton)findViewById(R.id.AimToWinRadio2);
        shot3 =(RadioButton)findViewById(R.id.AimToWinRadio3);
        shot4 =(RadioButton)findViewById(R.id.AimToWinRadio4);
        shot5 =(RadioButton)findViewById(R.id.AimToWinRadio5);
        shot6 =(RadioButton)findViewById(R.id.AimToWinRadio6);
        shot7 =(RadioButton)findViewById(R.id.AimToWinRadio7);

        fileName = "aimToWin1.txt"; //text to save drill to
        addListenerOnButton();//listener to save or graph drill
    }
    public void addListenerOnButton() {
        //save the result of the drill
        save = (Button) findViewById(R.id.saveAimToWin);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeFile();
            }

        });

        //graph the result
        graph = (Button)findViewById(R.id.graphAimToWin);
        graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(), GraphAimToWin.class);
                startActivity(intent);
            }

        });

    }

    /*
    *method writeFile() save the drill result to file with date
     */
    public void writeFile(){
        //JSONArray data = new JSONArray();
        //JSONObject
        try {//save drill to file
            fos = openFileOutput(fileName, MODE_APPEND);//open file
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            fillShotList();//see which shot is made or miss
            createString();//cat all result to single string
            osw.write(writeString);//write string
            osw.close();
            fos.close();
            Toast.makeText(getBaseContext(), "Drill Saved", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Cant create file Aim To Win");
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Can't write to file Aim To Win");
        }

        clearRadioButton();

    }

    /*
    *method: readFile
    * read file name aimtowin.txt
    * this method is not need since i move the readfile to graph
     */
    public void readFile(){
        String line;

        String firstDate = null;
        String secondDate =null;



        try {
            fis = openFileInput(fileName);
            //InputStreamReader buffReader = new InputStreamReader(fis);

            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader buffReader = new BufferedReader(isr);
            //while ((line = buffReader.readLine()) != null) {
            while ((line=buffReader.readLine()) != null) {
                // line = buffReader.read();
                System.out.println("Line************************************" + line);
                Scanner scan = new Scanner(line);
                System.out.println("Date*********************" + firstDate);
                if (firstDate == null) {
                    firstDate = scan.next();
                    firstDate = firstDate + scan.next();
                    firstDate = firstDate + scan.next();
                    scan.next();
                    scan.next();
                    firstDate = firstDate + ", "+scan.next();

                    made.add(0);
                    miss.add(0);

                    while (scan.hasNextInt()) {
                        if (scan.nextInt() == 1)
                            made.set(made.size() - 1, (made.get(made.size() - 1)) + 1);
                        else
                            miss.set(miss.size() - 1, (miss.get(miss.size() - 1)) + 1);
                    }

                }else {
                    secondDate = scan.next();
                    secondDate = secondDate+ scan.next();
                    secondDate = secondDate + scan.next();
                    scan.next();
                    scan.next();
                    secondDate = secondDate + ", "+scan.next();
                    if (firstDate.equals(secondDate)) {
                        while (scan.hasNextInt()) {
                            if (scan.nextInt() == 1)
                                made.set(made.size() - 1, (made.get(made.size() - 1)) + 1);
                            else
                                miss.set(miss.size() - 1, (miss.get(miss.size() - 1)) + 1);
                        }
                    } else {

                        made.add(0);
                        miss.add(0);

                        while (scan.hasNextInt()) {
                            if (scan.nextInt() == 1)
                                made.set(made.size() - 1, (made.get(made.size() - 1)) + 1);
                            else
                                miss.set(miss.size() - 1, (miss.get(miss.size() - 1)) + 1);
                        }

                    }
                    firstDate = secondDate;
                }
               line=null;
            }
            buffReader.close();
            isr.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Aim To Win");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Aim to Win");
        }

      for(int i=0;i<made.size();i++){
          System.out.println("made=" + made.get(i) + " miss="+miss.get(i));
      }


    }

    /*
    createString create a string for all the drill result
     */
    public void createString() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateNoTime;
        writeString= "";


        dateNoTime = sdf.parse(sdf.format(new Date()));//create date without time

        writeString = dateNoTime.toString();
        for(int i=0;i<shotList.length;i++){//cat each drill result to writeString
            writeString = writeString + " " + shotList[i];
        }
        writeString=writeString + " "+ "\n";//add end of line for each session
        //System.out.println("Create String*****************************"+writeString);
    }

    //set all radio button to uncheck
    private void clearRadioButton(){
        shot1.setChecked(false);
        shot2.setChecked(false);
        shot3.setChecked(false);
        shot4.setChecked(false);
        shot5.setChecked(false);
        shot6.setChecked(false);
        shot7.setChecked(false);
    }

    /*
    //fillShotList()
    //method check if to see which shot he use made or miss
    // if radio button is check then made else miss
     */
    private void fillShotList(){
        if(shot1.isChecked())
            shotList[0] =1;
        else
            shotList[0]=0;

        if(shot2.isChecked())
            shotList[1] =1;
        else
            shotList[1]=0;

        if(shot3.isChecked())
            shotList[2] =1;
        else
            shotList[2]=0;

        if(shot4.isChecked())
            shotList[3] =1;
        else
            shotList[3]=0;

        if(shot5.isChecked())
            shotList[4] =1;
        else
            shotList[4]=0;

        if(shot6.isChecked())
            shotList[5] =1;
        else
            shotList[5]=0;

        if(shot7.isChecked())
            shotList[6] =1;
        else
            shotList[6]=0;

        for(int i=0;i<shotList.length;i++){
            System.out.println(shotList[i]);
        }
    }

}

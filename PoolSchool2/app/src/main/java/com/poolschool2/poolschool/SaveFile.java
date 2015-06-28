package com.poolschool2.poolschool;

import android.app.Activity;
import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by OWNER-PC on 5/16/2015.
 */
public class SaveFile extends Activity{
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private Date dateNoTime;
    private String fileName;
    private OutputStreamWriter out;
    private File file;

    public SaveFile(String fileName){
        try {
            dateNoTime = sdf.parse(sdf.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.fileName = fileName;
        file = new File(fileName);
        //create file if not exist
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Can't create file.SAveFile");
            }
        }
        //create outputstream
        try {
            out = new OutputStreamWriter(openFileOutput(fileName,0));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Can't create output stream. SAveFile");
        }

    }
    public void writeToFile(int[] A){
        String write;
        write = dateNoTime.toString();
        for(int i=0;i<A.length;i++){
            write.concat(" "+A[i]);
        }

    }

}

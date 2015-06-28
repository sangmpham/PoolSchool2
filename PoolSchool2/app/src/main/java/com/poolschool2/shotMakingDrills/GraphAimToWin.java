package com.poolschool2.shotMakingDrills;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.poolschool.poolschool.R;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class GraphAimToWin extends Activity {
    private FileInputStream fis;
    private String fileName;
    private ArrayList<Integer> made = new ArrayList<>();
    private ArrayList<Integer> miss = new ArrayList<>();
    private ArrayList<String> date = new ArrayList<>();
    private XYSeries series;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph_aim_towin);

        fileName = "aimToWin1.txt";
        readFile();

        //create chart
        //int count=1;
        series = new XYSeries("Aim To Win");
        for(int i=0;i<date.size();i++){
            series.add(i+1,(((made.get(i))/(float)(made.get(i)+miss.get(i)))*100));
        }
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        dataset.addSeries(series);
        //create renderer of graph
        XYSeriesRenderer renderer = new XYSeriesRenderer();
        renderer.setLineWidth(2);
        renderer.setColor(Color.RED);
        //include low and max value
        renderer.setDisplayBoundingPoints(true);
        //add point markers
        renderer.setPointStyle(PointStyle.CIRCLE);
        renderer.setPointStrokeWidth(3);

        //create renderer that control the full chart
        XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
        mRenderer.addSeriesRenderer(renderer);

        //avoid black boarder
        mRenderer.setMarginsColor(Color.argb(0x00, 0xff, 0x00, 0x00));//transparent margins
        //disable pan on two axis
        mRenderer.setPanEnabled(false, false);
        mRenderer.setChartTitle("Aim To Win");
        mRenderer.setChartTitleTextSize(40f);
        mRenderer.setYAxisMax(100);
        mRenderer.setYAxisMin(0);
        mRenderer.setXTitle("Days");
        mRenderer.setYTitle("Percentage");
        mRenderer.setShowGrid(true);//show grid

        //create the view
        GraphicalView chartView = ChartFactory.getLineChartView(GraphAimToWin.this, dataset, mRenderer);
        LinearLayout chartON = (LinearLayout)findViewById(R.id.LLChart);
        chartON.addView(chartView);
    }

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
                    date.add(firstDate);

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
                        date.add(secondDate);
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
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Graph AimToWin");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Graph AimToWin");
        }

        for(int i=0;i<made.size();i++){
            System.out.println("made=" + made.get(i) + " miss="+miss.get(i));
        }


    }
}

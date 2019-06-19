package com.example.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class BChart extends AppCompatActivity {

    BarChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bchart);

        mChart = (BarChart) findViewById(R.id.chart1);
        mChart.getDescription().setEnabled(false);


        mChart.setFitBars(true);

        ArrayList<BarEntry> yValues1 = new ArrayList<>();
        yValues1.add(new BarEntry(0,20));
        yValues1.add(new BarEntry(1,50));
        yValues1.add(new BarEntry(2, 60));
        yValues1.add(new BarEntry(3, 20));
        yValues1.add(new BarEntry(4,40));

        BarDataSet dataSet= new BarDataSet(yValues1,"Data set");
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        dataSet.setDrawValues(true);

        BarData data = new BarData ((dataSet));

        mChart.setData(data);
        mChart.invalidate();
        mChart.animateY(1000);
    }




}

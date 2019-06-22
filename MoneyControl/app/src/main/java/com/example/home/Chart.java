package com.example.home;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Chart extends AppCompatActivity {

    PieChart pieChart;
    //BarChart barChart;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        setTitle("Chart Report");

        Button chart1=(Button) findViewById(R.id.BarChartB);
        chart1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent chart1Intent=new Intent(getApplicationContext(), BChart.class);
                startActivity(chart1Intent);
            }
        });

        pieChart = (PieChart) findViewById(R.id.chart);
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 5, 5, 5);
        pieChart.setDragDecelerationFrictionCoef(0.9f);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(60f);
        pieChart.animateX(1000, Easing.EasingOption.EaseInCubic);
        ArrayList<PieEntry> yValues = new ArrayList<>();

        yValues.add(new PieEntry(20f, "Insurance"));
        yValues.add(new PieEntry(10f, "Gas"));
        yValues.add(new PieEntry(30f, "Rent"));
        yValues.add(new PieEntry(25f, "Food"));
        yValues.add(new PieEntry(15f, "Transport"));

        PieDataSet dataSet = new PieDataSet(yValues, "Expenses");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(7f);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData data = new PieData((dataSet));
        data.setValueTextColor(Color.WHITE);
        data.setValueTextSize(10f);

        pieChart.setData(data);



    }
}





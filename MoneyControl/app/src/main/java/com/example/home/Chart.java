package com.example.home;


import android.content.Intent;
import android.database.Cursor;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chart extends AppCompatActivity {

    PieChart pieChart;
    Cursor dbAllData;
    BarChart mChart;
    DatabaseHelper myDb = new DatabaseHelper(this);

    public static final String RENT = "Rent";
    public static final String FOOD = "Food";
    public static final String INTERNET = "Internet";
    public static final String ELECTRICITY = "Electricity Bill";

    public static final int DB_COLUMN_CATEGORY = 2;
    public static final int DB_COLUMN_AMOUNT = 5;

    Map<String, Integer> fullAmount;

    private HashMap<String, Integer> initializeCategories() {
        HashMap<String, Integer> categories = new HashMap<String, Integer>();
        categories.put(RENT, 0);
        categories.put(FOOD, 0);
        categories.put(INTERNET, 0);
        categories.put(ELECTRICITY, 0);
//        To add user defined categories, with the method bellow
//        categories = addUserCategories(categories);
        return categories;
    }

    private HashMap<String, Integer> addUserCategories(HashMap<String, Integer> categories) {
        Cursor dbCategories = myDb.getAllCategories();
        while (dbCategories.moveToNext()) {
            String userCategory = dbCategories.getString(DB_COLUMN_CATEGORY);
            if (!(userCategory == null)) {
                categories.put(userCategory, 0);
            }
        }
        return categories;
    }

    public Map calculateFullAmount() {
        Cursor dbAllData = myDb.getAllData();
        HashMap<String, Integer> sumByCategory = initializeCategories();

        while (dbAllData.moveToNext()) {
            String category = dbAllData.getString(DB_COLUMN_CATEGORY);
            Integer amount = dbAllData.getInt(DB_COLUMN_AMOUNT);

            if (category != null && sumByCategory.containsKey(category)) {
                Integer sum = sumByCategory.get(category) + amount;
                sumByCategory.put(category, sum);
            }
        }
        return cleanup(sumByCategory);
    }

    private Map cleanup(HashMap<String, Integer> cleanMap) {
        List<String> ceroValues = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : cleanMap.entrySet()) {
            if (entry.getValue() == 0){
                ceroValues.add(entry.getKey());
            }
        }
        for (String key:ceroValues){
            cleanMap.remove(key);
        }
        return cleanMap;
    }


    
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
        pieChart.setUsePercentValues(false);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(1, 1, 1, 1);
        pieChart.setDragDecelerationFrictionCoef(0.9f);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(60f);
        pieChart.animateX(1000, Easing.EasingOption.EaseInCubic);
        fullAmount = calculateFullAmount();

        ArrayList<PieEntry> yValues = new ArrayList<>();

        yValues.add(new PieEntry(fullAmount.get(RENT), ""));
        yValues.add(new PieEntry(fullAmount.get(FOOD), ""));
        yValues.add(new PieEntry(fullAmount.get(INTERNET), ""));
        yValues.add(new PieEntry(fullAmount.get(ELECTRICITY), ""));

        PieDataSet dataSet = new PieDataSet(yValues, "Expenses");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(7f);
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        PieData data = new PieData((dataSet));
        data.setValueTextColor(Color.WHITE);
        data.setValueTextSize(15f);

        pieChart.setData(data);

    }
}





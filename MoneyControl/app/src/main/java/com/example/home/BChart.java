package com.example.home;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BChart extends AppCompatActivity {
    DatabaseHelper myDb = new DatabaseHelper(this);
    Cursor dbAllData;
    BarChart mChart;
    public static final String RENT = "Rent";
    public static final String FOOD = "Food";
    public static final String INTERNET = "Internet";
    public static final String ELECTRICITY = "Electricity Bill";
    public static final int DB_COLUMN_CATEGORY = 2;
    public static final int DB_COLUMN_AMOUNT = 5;

    Map<String, Integer> fullAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bchart);

        mChart = (BarChart) findViewById(R.id.chart1);
        mChart.getDescription().setEnabled(false);
        mChart.setFitBars(true);
        dbAllData = myDb.getAllData();
        fullAmount = calculateFullAmount(dbAllData);

        mChartReload(getBarDataForFullAmount());

        final Button btnFood = (Button) findViewById(R.id.button_food);
        btnFood.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ArrayList<BarEntry> foodEntries = filterByCategory(FOOD, dbAllData);
                mChartReload(getBarData(foodEntries, FOOD));
            }
        });

        final Button btnRent = (Button) findViewById(R.id.button_rent);
        btnRent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ArrayList<BarEntry> foodEntries = filterByCategory(RENT, dbAllData);
                mChartReload(getBarData(foodEntries, RENT));
            }
        });

        final Button btnInternet = (Button) findViewById(R.id.button_internet);
        btnInternet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ArrayList<BarEntry> foodEntries = filterByCategory(INTERNET, dbAllData);
                mChartReload(getBarData(foodEntries, INTERNET));
            }
        });

        final Button btnElectricity = (Button) findViewById(R.id.button_electricity);
        btnElectricity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ArrayList<BarEntry> foodEntries = filterByCategory(ELECTRICITY, dbAllData);
                mChartReload(getBarData(foodEntries, ELECTRICITY));
            }
        });

        final Button btnAll = (Button) findViewById(R.id.button_all);
        btnAll.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mChartReload(getBarDataForFullAmount());
            }
        });

        Button chart2=(Button) findViewById(R.id.button_pieChart);
        chart2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent chartIntent=new Intent(getApplicationContext(), Chart.class);
                startActivity(chartIntent);
            }
        });
    }

    private void mChartReload(BarData barData) {
        mChart.setData(barData);
        mChart.invalidate();
        mChart.animateY(1000);
        mChart.setTouchEnabled(true);
        Legend legend = mChart.getLegend();
        legend.setEnabled(true);
    }

    public Map calculateFullAmount(Cursor dbData) {
        HashMap<String, Integer> sumByCategory = initializeCategories();

        while (dbData.moveToNext()) {
            String category = dbData.getString(DB_COLUMN_CATEGORY);
            Integer amount = dbData.getInt(DB_COLUMN_AMOUNT);

            if (category != null && sumByCategory.containsKey(category)) {
                Integer sum = sumByCategory.get(category) + amount;
                sumByCategory.put(category, sum);
            }
        }
        dbData.moveToPosition(-1);
        return sumByCategory;
    }

    private HashMap<String, Integer> initializeCategories() {
        HashMap<String, Integer> categories = new HashMap<String, Integer>();
        categories.put(RENT, 0);
        categories.put(FOOD, 0);
        categories.put(INTERNET, 0);
        categories.put(ELECTRICITY, 0);
//        Uncomment next line to add user defined categories, with the method bellow
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

    private ArrayList<BarEntry> filterByCategory(String filterCategory, Cursor dbData) {
        ArrayList<BarEntry> entries = new ArrayList<BarEntry>();
        int count = 0;
        while (dbData.moveToNext()) {
            String category = dbData.getString(DB_COLUMN_CATEGORY);
            int amount = dbData.getInt(DB_COLUMN_AMOUNT);
            if ((category != null) && category.equals(filterCategory)) {
                entries.add(new BarEntry(count, amount));
                count++;
            }
        }
        dbData.moveToPosition(-1);
        return entries;
    }

    private BarData getBarDataForFullAmount() {
        ArrayList<BarEntry> entries = new ArrayList<BarEntry>();
        entries.add(new BarEntry(0, fullAmount.get(RENT)));
        entries.add(new BarEntry(1, fullAmount.get(FOOD)));
        entries.add(new BarEntry(2, fullAmount.get(INTERNET)));
        entries.add(new BarEntry(3, fullAmount.get(ELECTRICITY)));
        return getBarData(entries,"All Categories");
    }

    private BarData getBarData(ArrayList<BarEntry> barEntries, String label) {
        BarDataSet dataSet = new BarDataSet(barEntries,label);
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setDrawValues(true);
        dataSet.setValueTextSize(15f);
        return new BarData((dataSet));
    }


}

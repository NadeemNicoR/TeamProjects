package com.example.home;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
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

import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;


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

    //Visibility of filters

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    //Switch category_switch;
    //Switch amount_switch;
    //Switch date_switch;
    Button btnFood;
    Button btnRent;
    Button btnInternet;
    Button btnElectricity;
    Button btnAll;
    Button btnLow;
    Button btnMedium;
    Button btnHigh;
    Button btnWeek;
    Button btnMonth;
    Button btnYear;
    Chart chartCategory;
    Chart chartAmount;
    Chart chartTime;
    //ViewCompat.SeteBackgroundcolor
    //NavigationView Nav_Bar;

    Map<String, Integer> fullAmount;
    Map<String, Integer> sizedFullAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bchart);

        mChart = (BarChart) findViewById(R.id.chart1);
        mChart.getDescription().setEnabled(false);
        mChart.setFitBars(true);
        dbAllData = myDb.getAllData();
        fullAmount = calculateFullAmount(dbAllData);
        // sizedFullAmount = calculateAmountBySize(dbAllData);

        mChartReload(getBarDataForFullAmount());

        btnFood = (Button) findViewById(R.id.button_food);
        btnRent = (Button) findViewById(R.id.button_rent);
        btnInternet = (Button) findViewById(R.id.button_internet);
        btnElectricity = (Button) findViewById(R.id.button_electricity);
        btnAll = (Button) findViewById(R.id.button_all);
        btnLow = (Button) findViewById(R.id.button_low);
        btnMedium = (Button) findViewById(R.id.button_medium);
        btnHigh = (Button) findViewById(R.id.button_high);
        btnWeek = (Button) findViewById(R.id.button_week);
        btnMonth = (Button) findViewById(R.id.button_month);
        btnYear = (Button) findViewById(R.id.button_year);

        //Initial state:
        btnFood.setVisibility(View.VISIBLE);
        btnRent.setVisibility(View.VISIBLE);
        btnInternet.setVisibility(View.VISIBLE);
        btnElectricity.setVisibility(View.VISIBLE);
        btnAll.setVisibility(View.VISIBLE);
        btnLow.setVisibility(View.INVISIBLE);
        btnMedium.setVisibility(View.INVISIBLE);
        btnHigh.setVisibility(View.INVISIBLE);
        btnWeek.setVisibility(View.INVISIBLE);
        btnMonth.setVisibility(View.INVISIBLE);
        btnYear.setVisibility(View.INVISIBLE);
        BarChart view1 = findViewById(R.id.chart2);
        view1.setVisibility(View.INVISIBLE);
        BarChart view2 = findViewById(R.id.chart3);
        view2.setVisibility(View.INVISIBLE);


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_bar);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {

                    case R.id.category_switch:
                        menuItem.setChecked(true);
                        makeVisibleCategory();
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.amount_switch:
                        menuItem.setChecked(true);
                        makeVisibleAmount();
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.date_switch:
                        menuItem.setChecked(true);
                        makeVisibleTime();
                        drawerLayout.closeDrawers();
                        return true;


                }

                return false;
            }
        });


        // Buttons for CATEGORY:

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

        // Buttons for AMOUNT


        // Buttons for TIME


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


    private void mChartReload(BarData barData1) {
        mChart.setData(barData1);
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

    /* public Map calculateAmountBySize(Cursor dbData) {
         HashMap<String, Integer> sumByAmountSize();

         while (dbData.moveToNext()) {
             String category = dbData.getString(DB_COLUMN_CATEGORY);
             Integer amount = dbData.getInt(DB_COLUMN_AMOUNT);

             if (category != null && sumByAmountSize.containsKey(category) && amount<100) {
                 Integer sum1 = sumByAmountSize.get(category) + amount;
                 sumByAmountSize.put(category, sum1);
             }
             if (category != null && sumByAmountSize.containsKey(category) && 500>amount && amount>=100) {
                 Integer sum2 = sumByAmountSize.get(category) + amount;
                 sumByAmountSize.put(category, sum2);
             }
             if (category != null && sumByAmountSize.containsKey(category) && amount>500) {
                 Integer sum3 = sumByAmountSize.get(category) + amount;
                 sumByAmountSize.put(category, sum3);
         }
         dbData.moveToPosition(-1);
         return sumByAmountSize;
     }*/
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
    /*private BarData getBarDataSizedForFullAmount() {
        ArrayList<BarEntry> entries1 = new ArrayList<BarEntry>();
        entries1.add(new BarEntry(0, sizedFullAmount.get(RENT)));
        entries1.add(new BarEntry(1, sizedFullAmount.get(FOOD)));
        entries1.add(new BarEntry(2, sizedFullAmount.get(INTERNET)));
        entries1.add(new BarEntry(3, sizedFullAmount.get(ELECTRICITY)));
        return getBarData(entries1,"All Categories");
    }*/


    private BarData getBarData(ArrayList<BarEntry> barEntries, String label) {
        BarDataSet dataSet = new BarDataSet(barEntries,label);
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setDrawValues(true);
        dataSet.setValueTextSize(15f);
        return new BarData((dataSet));
    }



    public void makeVisibleCategory(){
        btnFood.setVisibility(View.VISIBLE);
        btnRent.setVisibility(View.VISIBLE);
        btnInternet.setVisibility(View.VISIBLE);
        btnElectricity.setVisibility(View.VISIBLE);
        btnAll.setVisibility(View.VISIBLE);
        btnLow.setVisibility(View.INVISIBLE);
        btnMedium.setVisibility(View.INVISIBLE);
        btnHigh.setVisibility(View.INVISIBLE);
        btnWeek.setVisibility(View.INVISIBLE);
        btnMonth.setVisibility(View.INVISIBLE);
        btnYear.setVisibility(View.INVISIBLE);
        BarChart view1 = findViewById(R.id.chart1);
        view1.setVisibility(View.VISIBLE);
        BarChart view2 = findViewById(R.id.chart2);
        view2.setVisibility(View.INVISIBLE);
        BarChart view3 = findViewById(R.id.chart3);
        view3.setVisibility(View.INVISIBLE);
    }

    public void makeVisibleAmount(){
        btnFood.setVisibility(View.INVISIBLE);
        btnRent.setVisibility(View.INVISIBLE);
        btnInternet.setVisibility(View.INVISIBLE);
        btnElectricity.setVisibility(View.INVISIBLE);
        btnAll.setVisibility(View.INVISIBLE);
        btnLow.setVisibility(View.VISIBLE);
        btnMedium.setVisibility(View.VISIBLE);
        btnHigh.setVisibility(View.VISIBLE);
        btnWeek.setVisibility(View.INVISIBLE);
        btnMonth.setVisibility(View.INVISIBLE);
        btnYear.setVisibility(View.INVISIBLE);
        BarChart view1 = findViewById(R.id.chart1);
        view1.setVisibility(View.INVISIBLE);
        BarChart view2 = findViewById(R.id.chart2);
        view2.setVisibility(View.VISIBLE);
        BarChart view3 = findViewById(R.id.chart3);
        view3.setVisibility(View.INVISIBLE);
    }
    public void makeVisibleTime(){
        btnFood.setVisibility(View.INVISIBLE);
        btnRent.setVisibility(View.INVISIBLE);
        btnInternet.setVisibility(View.INVISIBLE);
        btnElectricity.setVisibility(View.INVISIBLE);
        btnAll.setVisibility(View.INVISIBLE);
        btnLow.setVisibility(View.INVISIBLE);
        btnMedium.setVisibility(View.INVISIBLE);
        btnHigh.setVisibility(View.INVISIBLE);
        btnWeek.setVisibility(View.VISIBLE);
        btnMonth.setVisibility(View.VISIBLE);
        btnYear.setVisibility(View.VISIBLE);
        BarChart view1 = findViewById(R.id.chart1);
        view1.setVisibility(View.INVISIBLE);
        BarChart view2 = findViewById(R.id.chart2);
        view2.setVisibility(View.INVISIBLE);
        BarChart view3 = findViewById(R.id.chart3);
        view3.setVisibility(View.VISIBLE);
    }



}
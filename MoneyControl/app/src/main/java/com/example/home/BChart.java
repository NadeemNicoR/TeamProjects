package com.example.home;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
    public static final int DB_COLUMN_DATE = 3;

    //Visibility of filters

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;


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
        final Button btnLow = (Button) findViewById(R.id.button_low);
        btnLow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Map filteredData = filterByAmount(dbAllData, 1, 99);
                mChartReload(getBarDataForAmountFilter(filteredData, "Less than 99"));
            }
        });

        final Button btnMedium = (Button) findViewById(R.id.button_medium);
        btnMedium.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Map filteredData = filterByAmount(dbAllData, 100, 500);
                mChartReload(getBarDataForAmountFilter(filteredData, "Between 100 and 500"));
            }
        });

        final Button btnHigh = (Button) findViewById(R.id.button_high);
        btnHigh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Map filteredData = filterByAmount(dbAllData, 501, 999999999);
                mChartReload(getBarDataForAmountFilter(filteredData, "Over 500"));
            }
        });

        Button btnChart=(Button) findViewById(R.id.button_pieChart);
        btnChart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent chart1Intent=new Intent(getApplicationContext(), Chart.class);
                startActivity(chart1Intent);
            }
        });

        // Buttons for TIME

        final Button btnWeek = (Button) findViewById(R.id.button_week);
        btnWeek.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Map filteredData = filterByWeek(dbAllData);
                mChartReload(getBarDataForTimeFilter(filteredData,"Weeks"));
            }
        });

        final Button btnMonth = (Button) findViewById(R.id.button_month);
        btnMonth.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Map filteredData = filterByMonth(dbAllData);
                mChartReload(getBarDataForTimeFilter(filteredData,"Months"));
            }
        });

        final Button btnYear = (Button) findViewById(R.id.button_year);
        btnYear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Map filteredData = filterByYear(dbAllData);
                mChartReload(getBarDataForTimeFilter(filteredData,"Years"));
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
        return filterByAmount(dbData, 0, 999999999);
    }

    public Map filterByAmount(Cursor dbData, int minimum, int maximum) {
        HashMap<String, Integer> sumByCategory = initializeCategories();

        while (dbData.moveToNext()) {
            String category = dbData.getString(DB_COLUMN_CATEGORY);
            Integer amount = dbData.getInt(DB_COLUMN_AMOUNT);
            Boolean categoryIsValid = category != null && sumByCategory.containsKey(category);
            Boolean amountIsValid = minimum <= amount && amount <= maximum;

            if (categoryIsValid && amountIsValid) {
                Integer sum = sumByCategory.get(category) + amount;
                sumByCategory.put(category, sum);
            }
        }
        dbData.moveToPosition(-1);
        return sumByCategory;
    }

    public Map filterByYear(Cursor dbData) {
        HashMap<Integer, Integer> sumByYear = initializeYears();

        while (dbData.moveToNext()) {
            Integer amount = dbData.getInt(DB_COLUMN_AMOUNT);
            Integer year = getYearNumber(dbData.getString(DB_COLUMN_DATE));

            Boolean yearIsValid = year != null && sumByYear.containsKey(year);
            if (yearIsValid) {
                Integer sum = sumByYear.get(year) + amount;
                sumByYear.put(year, sum);
            }
        }
        dbData.moveToPosition(-1);
        return cleanup(sumByYear);
    }

    public Map filterByMonth(Cursor dbData) {
        HashMap<Integer, Integer> sumByMonth = initializeMonths();

        while (dbData.moveToNext()) {
            Integer amount = dbData.getInt(DB_COLUMN_AMOUNT);
            Integer month = getMonthNumber(dbData.getString(DB_COLUMN_DATE));

            Boolean monthIsValid = month != null && sumByMonth.containsKey(month);
            if (monthIsValid) {
                Integer sum = sumByMonth.get(month) + amount;
                sumByMonth.put(month, sum);
            }
        }
        dbData.moveToPosition(-1);
        return cleanup(sumByMonth);
    }

    public Map filterByWeek(Cursor dbData) {
        HashMap<Integer, Integer> sumByWeek = initializeWeeks();

        while (dbData.moveToNext()) {
            Integer amount = dbData.getInt(DB_COLUMN_AMOUNT);
            Integer week = getWeekNumber(dbData.getString(DB_COLUMN_DATE));

            Boolean weekIsValid = week != null && sumByWeek.containsKey(week);
            if (weekIsValid) {
                Integer sum = sumByWeek.get(week) + amount;
                sumByWeek.put(week, sum);
            }
        }
        dbData.moveToPosition(-1);
        return cleanup(sumByWeek);
    }

    private Map cleanup(HashMap<Integer, Integer> cleanMap) {
        List<Integer> ceroValues = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : cleanMap.entrySet()) {
            if (entry.getValue() == 0){
                ceroValues.add(entry.getKey());
            }
        }
        for (int key:ceroValues){
            cleanMap.remove(key);
        }
        return cleanMap;
    }

    private Integer getYearNumber(String string) {
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(string);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int u = calendar.get(Calendar.YEAR);
            return u;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Integer getMonthNumber(String string) {
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(string);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.get(Calendar.MONTH);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Integer getWeekNumber(String string) {
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(string);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.get(Calendar.WEEK_OF_YEAR);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private HashMap<Integer, Integer> initializeMonths() {
        HashMap<Integer, Integer> months = new HashMap<Integer, Integer>();
        for (int month = 0; month < 12; month++) {
            months.put(month, 0);
        }
        return months;
    }

    private HashMap<Integer, Integer> initializeWeeks() {
        HashMap<Integer, Integer> weeks = new HashMap<Integer, Integer>();
        for (int week = 0; week < 52; week++) {
            weeks.put(week, 0);
        }
        return weeks;
    }

    private HashMap<Integer, Integer> initializeYears() {
        HashMap<Integer, Integer> years = new HashMap<Integer, Integer>();
        for (int year = 2009; year < 2020; year++) {
            years.put(year, 0);
        }
        return years;
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
        return getBarData(entries, "All Categories");
    }

    private BarData getBarDataForAmountFilter(Map<String, Integer> filteredData, String label) {
        ArrayList<BarEntry> entries = new ArrayList<BarEntry>();
        entries.add(new BarEntry(0, filteredData.get(RENT)));
        entries.add(new BarEntry(1, filteredData.get(FOOD)));
        entries.add(new BarEntry(2, filteredData.get(INTERNET)));
        entries.add(new BarEntry(3, filteredData.get(ELECTRICITY)));
        return getBarData(entries, label);
    }

    private BarData getBarDataForTimeFilter(Map<Integer,Integer> timeData, String label){
        ArrayList<BarEntry> entries = new ArrayList<BarEntry>();
        for(Map.Entry<Integer, Integer> entry : timeData.entrySet()) {
            entries.add(new BarEntry(entry.getKey(),entry.getValue()));
        }
        return getBarData(entries,label);
    }

    private BarData getBarData(ArrayList<BarEntry> barEntries, String label) {
        BarDataSet dataSet = new BarDataSet(barEntries, label);
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setDrawValues(true);
        dataSet.setValueTextSize(15f);
        return new BarData((dataSet));
    }


    public void makeVisibleCategory() {
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

    }

    public void makeVisibleAmount() {
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

    }

    public void makeVisibleTime() {
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

    }


}
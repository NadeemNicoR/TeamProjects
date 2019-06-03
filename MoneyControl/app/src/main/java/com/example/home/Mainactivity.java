package com.example.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class Mainactivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Main Menu");
        Button settings_Main=(Button) findViewById(R.id.Settings);
        settings_Main.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View W)
                {
                    Intent settingsIntent=new Intent(getApplicationContext(), Settings.class);
                    startActivity(settingsIntent);
                }
        });
        Button income=(Button) findViewById(R.id.Income);
        income.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent incomeIntent=new Intent(getApplicationContext(), Income.class);
                startActivity(incomeIntent);
            }
        });
        Button expense=(Button) findViewById(R.id.NewExpense);
        expense.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent expenseIntent=new Intent(getApplicationContext(), Newexpense.class);
                startActivity(expenseIntent);
            }
        });
    }
}

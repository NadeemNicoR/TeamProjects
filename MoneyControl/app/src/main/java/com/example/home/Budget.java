package com.example.home;

        import android.annotation.SuppressLint;
        import android.database.Cursor;
        import android.graphics.Color;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Spinner;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.List;

public class Budget extends AppCompatActivity {

    Spinner spinner_B;

    EditText editBudget_ID;
    EditText editAmount_B;
    EditText editCategory_B;
    EditText editDate_B;
    Spinner editTime;
    Button btnSave_B,btnDelete_B,btnView_B;
    DatabaseHelper myDb_B;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        myDb_B = new DatabaseHelper(this);
        editBudget_ID = (EditText)findViewById(R.id.budget_ID);
        editAmount_B = (EditText)findViewById(R.id.amount_B);
        editCategory_B = (EditText)findViewById(R.id.category_B);
        editDate_B = (EditText)findViewById(R.id.date_B);
        editTime = (Spinner) findViewById(R.id.Time);
        //Buttons
        btnSave_B = (Button)findViewById(R.id.button_saveB2);
        btnDelete_B = (Button)findViewById(R.id.button_deleteB2);
        btnView_B= (Button)findViewById(R.id.button_viewB2);
        Save_B();
        Delete_B();
        View_B();

        List<String> Ttime = new ArrayList<>();
        Ttime.add(0, "Year");
        Ttime.add("Semester");
        Ttime.add("Month");
        Ttime.add("Week");

        spinner_B = findViewById(R.id.Time);
        ArrayAdapter<String> adapter_B = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, Ttime);
        adapter_B.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_B.setAdapter(adapter_B);
        spinner_B.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
                ((TextView) parent.getChildAt(0)).setTextSize(20);
                String item = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    //Button methods

    public  void Save_B() { btnSave_B.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isInserted = myDb_B.insertData_B(editAmount_B.getText().toString(), editCategory_B.getText().toString(), editDate_B.getText().toString(),editTime.getSelectedItem().toString());
                    if(isInserted == true)
                        Toast.makeText(Budget.this,"Budget Inserted",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(Budget.this,"Budget not Inserted",Toast.LENGTH_SHORT).show();
                }
            }
    );
    }

    public void Delete_B() {
        btnDelete_B.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               Integer deletedRows = myDb_B.deleteData_B(editBudget_ID.getText().toString());
                                               if(deletedRows > 0)
                                                   Toast.makeText(Budget.this,"Data Deleted",Toast.LENGTH_SHORT).show();
                                               else
                                                   Toast.makeText(Budget.this,"Data not Deleted",Toast.LENGTH_SHORT).show();
                                           }
                                       }
        );
    }

    public void View_B() {
        btnView_B.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Cursor bdg = myDb_B.getAllData_B();
                                             if(bdg.getCount() == 0) {
                                                 showMessage("Error","Nothing found");
                                                 return;
                                             }
                                             StringBuffer buffer = new StringBuffer();
                                             while (bdg.moveToNext()) {
                                                 buffer.append("Budget ID :"+ bdg.getString(0)+"\n");
                                                 buffer.append("Amount :"+ bdg.getString(1)+"\n");
                                                 buffer.append("Category :"+ bdg.getString(2)+"\n");
                                                 buffer.append("Date :"+ bdg.getString(3)+"\n");
                                                 buffer.append("Time :"+ bdg.getString(4)+"\n");
                                             }
                                             showMessage("Budget",buffer.toString());
                                         }
                                     }
        );
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);

        TextView AmountRent = (TextView) findViewById(R.id.AmountRent);
        TextView AmountMovies = (TextView) findViewById(R.id.AmountMovies);
        TextView AmountElectricity = (TextView) findViewById(R.id.AmountElectricity);
        TextView AmountInternet = (TextView) findViewById(R.id.AmountInternet);
        TextView AmountFood = (TextView) findViewById(R.id.AmountFood);

        final EditText ThresholdRent = (EditText) findViewById(R.id.ThresholdRent);
        final EditText ThresholdMovies = (EditText) findViewById(R.id.ThresholdMovies);
        final EditText ThresholdElectricity = (EditText) findViewById(R.id.ThresholdElectricity);
        final EditText ThresholdInternet = (EditText) findViewById(R.id.ThresholdInternet);
        final EditText ThresholdFood = (EditText) findViewById(R.id.ThresholdFood);


        DatabaseHelper db = new DatabaseHelper(getApplicationContext());
        final Cursor s1 = db.getAllAmount1();
        AmountRent.setText(s1.toString());

        final Cursor s2 = db.getAllAmount2();
        AmountMovies.setText(s2.toString());

        final Cursor s3 = db.getAllAmount3();
        AmountElectricity.setText(s3.toString());

        final Cursor s4 = db.getAllAmount4();
        AmountInternet.setText(s4.toString());

        final Cursor s5 = db.getAllAmount5();
        AmountFood.setText(s5.toString());

        Button Save = (Button) findViewById(R.id.Save);
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a1 = s1.toString();
                String a2 = s2.toString();
                String a3 = s3.toString();
                String a4 = s4.toString();
                String a5 = s5.toString();

                if (a1 == ThresholdRent.toString() || a2 == ThresholdMovies.toString() || a3 == ThresholdElectricity.toString() || a4 == ThresholdInternet.toString() || a5 == ThresholdFood.toString())
                {
                    Toast.makeText(Budget.this,"You have reached the limit for rent",Toast.LENGTH_LONG).show();

                }
            }
        });*/




}

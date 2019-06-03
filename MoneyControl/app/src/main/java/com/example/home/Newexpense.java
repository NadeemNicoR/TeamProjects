package com.example.home;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.app.AlertDialog;
import android.database.Cursor;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Newexpense extends AppCompatActivity
{
    DatabaseHelper myDb;
    private Spinner spinner;
    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;

    EditText editDate, editExpenseId,editAmount, editNote;
    Spinner editCategory,editRecurrecny,editPaymentType,editCurrency;
    Button btnAddData;
    Button btnviewAll;
    Button btnDelete;
    Button btnviewUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_expense);
        setTitle("Expenses");
        List<String> Currency = new ArrayList<>();
        Currency.add(0, "Choose currency");
        Currency.add("Euro");
        Currency.add("Rupee");
        Currency.add("Lekë");
        Currency.add("Dollar");



        spinner = findViewById(R.id.editCurrencyField);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, Currency);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
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

        List<String> Payment_Method = new ArrayList<>();
        Payment_Method.add(0, "Choose payment");
        Payment_Method.add("Credit Card");
        Payment_Method.add("Cash");

        spinner1 = findViewById(R.id.editPaymentField);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, Payment_Method);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        List<String> Category = new ArrayList<>();
        Category.add(0, "Choose category");
        Category.add("Rent");
        Category.add("Food");
        Category.add("Internet");
        Category.add("Electricity Bill");
        Category.add("Movies");

        spinner2 = findViewById(R.id.editCategoryField);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, Category);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

        {
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

        List<String> Recurrence = new ArrayList<>();
        Recurrence.add(0, "Choose recurrence");
        Recurrence.add("None");
        Recurrence.add("Weekly");
        Recurrence.add("Monthly");
        Recurrence.add("Yearly");

        spinner3 = findViewById(R.id.editRecurrencyField);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, Recurrence);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
                ((TextView) parent.getChildAt(0)).setTextSize(20);
                String item = parent.getItemAtPosition(position).toString();

                /*if (item.equals("Choose Recurrence")) {
                    //do nothing
                } else {
                    Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
                    // here you can do anything else with the item selected
                }*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Button selectDate = findViewById(R.id.dateButton);
        final TextView date = findViewById(R.id.editDateField);
        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog= new DatePickerDialog(Newexpense.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                date.setText(day + "/" + month + "/" + year);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.show();
            }
        });

        myDb = new DatabaseHelper(this);


        editExpenseId = (EditText)findViewById(R.id.editExpenseIdField);
        editCategory = (Spinner)findViewById(R.id.editCategoryField);
        editDate = (EditText)findViewById(R.id.editDateField);
        editRecurrecny = (Spinner)findViewById(R.id.editRecurrencyField);
        editAmount=(EditText)findViewById(R.id.editAmountField);
        editPaymentType=(Spinner)findViewById(R.id.editPaymentField);
        editCurrency=(Spinner)findViewById(R.id.editCurrencyField);
        editNote=(EditText)findViewById(R.id.editNoteField);


        btnAddData = (Button)findViewById(R.id.button_add);
        btnviewAll = (Button)findViewById(R.id.button_viewAll);
        btnviewUpdate= (Button)findViewById(R.id.button_update);
        btnDelete= (Button)findViewById(R.id.button_delete);
        AddData();
        viewAll();
        UpdateData();
        DeleteData();
    }
    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(editExpenseId.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(Newexpense.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Newexpense.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void UpdateData() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(editExpenseId.getText().toString(),
                                editCategory.getSelectedItem().toString(),
                                editDate.getText().toString(),editRecurrecny.getSelectedItem().toString(),editAmount.getText().toString(),editPaymentType.getSelectedItem().toString(),editCurrency.getSelectedItem().toString(),editNote.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(Newexpense.this,"Data Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Newexpense.this,"Data not Updated",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editCategory.getSelectedItem().toString(),
                                editDate.getText().toString(),editRecurrecny.getSelectedItem().toString(),editAmount.getText().toString(),editPaymentType.getSelectedItem().toString(),editCurrency.getSelectedItem().toString(),editNote.getText().toString());
                        if(isInserted == true)
                            Toast.makeText(Newexpense.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Newexpense.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext())
                        {
                            buffer.append("Expense ID :"+ res.getString(0)+"\n");
                            buffer.append("Category :"+ res.getString(1)+"\n");
                            buffer.append("Date :"+ res.getString(2)+"\n");
                            buffer.append("Reccurrency :"+ res.getString(3)+"\n");
                            buffer.append("Amount :"+ res.getString(4)+"\n");
                            buffer.append("Payment :"+ res.getString(5)+"\n");
                            buffer.append("Note :"+ res.getString(7)+"\n");
                            buffer.append("Currency :"+ res.getString(6)+"\n\n\n");
                        }
                        // Show all data
                        showMessage("Expense Transactions",buffer.toString());
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

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
/*
package com.example.home;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;

public class Newexpense extends AppCompatActivity
{
    private Spinner spinner;
    private  Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_expense);
        spinner = findViewById(R.id.spinnerCurrency);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.currency, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();

                if (item.equals("Choose Currency")) {
                    //do nothing
                } else
                    //String item = parent.getItemAtPosition(position).toString();
                    Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
                // here you can do anything else with the item selected
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner1 = findViewById(R.id.spinnerPayment);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.payment_method, android.R.layout.simple_spinner_item
        );
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();

                if (item.equals("Choose Payment")) {
                    //do nothing
                } else
                    //String item = parent.getItemAtPosition(position).toString();
                    Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
                // here you can do anything else with the item selected
            }
        });
        spinner2 = findViewById(R.id.spinnerCategory);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.category, android.R.layout.simple_spinner_item
        );
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();

                if (item.equals("Choose Category")) {
                    //do nothing
                } else
                    //String item = parent.getItemAtPosition(position).toString();
                    Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
                // here you can do anything else with the item selected
            }
        });

        Button DoneNewExpense= (Button) findViewById(R.id.DoneNexpense);
        DoneNewExpense.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent DoneNewE = new Intent(getApplicationContext(), Mainactivity.class);
                startActivity(DoneNewE);
            }
        });
        Button selectDate = findViewById(R.id.date);
        final TextView date = findViewById(R.id.textDate);
        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog= new DatePickerDialog(Newexpense.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                date.setText(day + "/" + month + "/" + year);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.show();
            }
        });
    }
}
*/


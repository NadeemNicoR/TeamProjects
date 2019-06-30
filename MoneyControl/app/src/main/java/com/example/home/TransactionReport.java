package com.example.home;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class TransactionReport extends AppCompatActivity
{

    DatabaseHelper myDb;
    ArrayList<String> listTransactions;
    ArrayAdapter adapter;


    Button btnDel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_report);
        setTitle("Transaction Report");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myDb = new DatabaseHelper(this);
        listTransactions=new ArrayList<>();

        viewData();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuforreport,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        switch (id){
            //case R.id.cat:

        }
        return true;
    }



    private void viewData() {

        ListView traList = (ListView) findViewById(R.id.list_view);
        Cursor cursor = myDb.getAllData();

        if (cursor.getCount() == 0)
        {
            Toast.makeText(this, "No data to show", Toast.LENGTH_SHORT).show();
        }
        else {

            Currency currency = new Currency();
            /*String valueOfcurr = currency.valueOfSlectedSpinner;

//            CurrencyConst currencyConst = new CurrencyConst();
//            String valueOfCurrency = currencyConst.getCurrencyName();*/

            String[] columns = new String[] {myDb.column_amount_E,
                    myDb.column_category_E, myDb.column_transactionType,
                    myDb.column_date_E,myDb.column_payment_E, myDb.column_currency_E};

            int[] to = new int[] {R.id.textViewAmt, R.id.textViewCate, R.id.textViewType, R.id.textViewDte,R.id.textViewpaytype,
                    R.id.textViewCurrency};
            ListAdapter ada = new SimpleCursorAdapter(this, R.layout.row, cursor, columns, to, 0){
                public View getView(int position, View convertView, ViewGroup parent)
                {
                    View view = super.getView(position, convertView, parent);
                    return view;
                }
            };


            traList.setAdapter(ada);
           /* btnDel = (Button) findViewById(R.id.btn_delete);

            traList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {
                    DatabaseHelper myDb2;
                    ListActivity la=new ListActivity();
                    SparseBooleanArray checkedItemPositions = la.getListView().getCheckedItemPositions();
                    myDb2 =new DatabaseHelper(getApplicationContext()) ;
                    boolean result = myDb2.deleteTransaction(id);
                }
            });*/


        }
    }

}
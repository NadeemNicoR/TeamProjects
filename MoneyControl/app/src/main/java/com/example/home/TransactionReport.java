package com.example.home;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class TransactionReport extends AppCompatActivity
{

    DatabaseHelper myDb;
    ArrayList<String> listTransactions;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_report);
        setTitle("Transaction Overview");

        myDb = new DatabaseHelper(this);
        listTransactions=new ArrayList<>();

        viewData();

    }

    private void viewData() {

        ListView traList = (ListView) findViewById(R.id.list_view);
        Cursor cursor = myDb.getAllData();

        if (cursor.getCount() == 0)
        {

            Toast.makeText(this, "No data to show", Toast.LENGTH_SHORT).show();
        }
        else {
            String[] columns = new String[] {myDb.column_amount_E,
                    myDb.column_category_E, myDb.column_transactionType,
                    myDb.column_date_E};

            int[] to = new int[] {R.id.textViewAmt, R.id.textViewCate, R.id.textViewType, R.id.textViewDte};
            ListAdapter ada = new SimpleCursorAdapter(this, R.layout.row, cursor, columns, to, 0){
                public View getView(int position, View convertView, ViewGroup parent){
                    View view = super.getView(position, convertView, parent);
                    return view;
                }
            };

            traList.setAdapter(ada);




//            ArrayList<String> ExpenceList = new ArrayList<>();
//            while (cursor.moveToNext()){
//                ExpenceList.add(cursor.getString(0) );
//                ExpenceList.add(cursor.getString(1));
//                ExpenceList.add(cursor.getString(2));
//                ExpenceList.add(cursor.getString(3));
//                ExpenceList.add(cursor.getString(4));
//                ExpenceList.add(cursor.getString(5));
//                ExpenceList.add(cursor.getString(6));
//                ExpenceList.add(cursor.getString(7));
//                ExpenceList.add(cursor.getString(8));
//            }
//            ArrayList<HashMap<String,String>> myMapList = new ArrayList<>();
//            for(int i=0; i<ExpenceList.size();i++){
//                HashMap<String,String> myMap = new HashMap<>();
//                myMap.put("amount",ExpenceList.get(i).);
//            }

        }
    }

}
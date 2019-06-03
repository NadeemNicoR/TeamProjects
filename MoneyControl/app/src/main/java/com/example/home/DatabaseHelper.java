package com.example.home;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by ProgrammingKnowledge on 4/3/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MoneyControl.db";

    public static final String TABLE_EXPENSES = "Expenses"; // TABLE_NAME
    public static final String column_expense_ID = "Expense_ID";  // COL_1
    public static final String column_category_E = "Category"; //COl_4
    public static final String column_date_E = "Date"; //COL_2
    public static final String column_recurrency_E="Recurrency"; //COL8
    public static final String column_amount_E = "Amount"; //COL_3
    public static final String column_payment_E="Payment";//COL_5
    public static final String column_currency_E="Currency"; //COL_6
    public static final String column_note_E="Note"; //COL_7

    public static final String TABLE_INCOMES = "Incomes"; // TABLE_NAME
    public static final String column_income_ID = "Income_ID";  // COL_1
    public static final String column_category_I = "Category_I"; //COl_4
    public static final String column_date_I = "Date_I"; //COL_2
    public static final String column_recurrency_I="Recurrency_I"; //COL8
    public static final String column_amount_I = "Amount_I"; //COL_3
    public static final String column_payment_I="Payment_I";//COL_5
    public static final String column_currency_I="Currency_I"; //COL_6
    public static final String column_note_I="Note_I"; //COL_7

    public static final String TABLE_PIN = "Pin";
    public static final String column_status="Status";
    public static final String column_pin="Pin";
    public static final String column_id="id";

    public static final String TABLE_CATEGORIES= "Categories";
    public static final String column_category_id="Category_Id";
    public static final String column_category_name="Category_Name";

    public static final boolean column_status_defult_value=false;
    public static final String column_pin_defult_value=null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //EXPENSE
        db.execSQL("create table " + TABLE_EXPENSES +" (Expense_ID INTEGER PRIMARY KEY AUTOINCREMENT,Category TEXT,Date TEXT,Recurrency TEXT,Amount INTEGER,Payment TEXT,Currency TEXT,Note TEXT)");

        //INCOME
        db.execSQL("create table " + TABLE_INCOMES +" (Income_ID INTEGER PRIMARY KEY AUTOINCREMENT,Category_I TEXT,Date_I TEXT,Recurrency_I TEXT,Amount_I INTEGER,Payment_I TEXT,Currency_I TEXT,Note_I TEXT)");

        //PIN
        String SQL_CREATE_TABLE_PIN = "CREATE TABLE " + TABLE_PIN  +" ("
                + column_id + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + column_status + " BOOLEAN,"
                + column_pin + " TEXT);";
        db.execSQL(SQL_CREATE_TABLE_PIN);

        db.execSQL("create table " + TABLE_CATEGORIES +" (Category_Id INTEGER PRIMARY KEY AUTOINCREMENT, Category_Name TEXT)");

        ContentValues contentValues = new ContentValues();
        contentValues.put(column_status, column_status_defult_value);
        contentValues.put(column_pin, column_pin_defult_value);

        long result = db.insert(TABLE_PIN,null ,contentValues);
        if(result == -1)
            throw new IllegalStateException("PIN Could not be initialized");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_EXPENSES);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_INCOMES);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_PIN);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CATEGORIES);
        onCreate(db);
    }


    //inserting categories in to the DB



    public boolean insertData(String category,String date,String Recurrency,String amount,String payment, String currency, String note)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //for EXPENSE

        contentValues.put(column_category_E,category);
        contentValues.put(column_date_E,date);
        contentValues.put(column_recurrency_E,Recurrency);
        contentValues.put(column_amount_E,amount);
        contentValues.put(column_payment_E,payment);
        contentValues.put(column_currency_E,currency);
        contentValues.put(column_note_E,note);
        long result = db.insert(TABLE_EXPENSES,null ,contentValues);

        if(result == -1)
            return false;
        else
            return true;

        //for INCOME
    }
    public boolean insertDataIncome(String category,String date,String Recurrency,String amount,String payment, String currency, String note) {
        {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();

            contentValues.put(column_category_I,category);
            contentValues.put(column_date_I,date);
            contentValues.put(column_recurrency_I,Recurrency);
            contentValues.put(column_amount_I,amount);
            contentValues.put(column_payment_I,payment);
            contentValues.put(column_currency_I,currency);
            contentValues.put(column_note_I,note);

            long result= db.insert(TABLE_INCOMES,null ,contentValues);
            if(result==-1)
                return false;
            else
                return true;
        }
    }
    public boolean insertCategories(String category_Name)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(column_category_name,category_Name);
        long resultCategory = db.insert(TABLE_CATEGORIES,null ,contentValues);
        if(resultCategory == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_EXPENSES,null);
        return res;
    }
    public Cursor getAllData_I() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_INCOMES,null);
        return res;
    }
    public Cursor getAllCategories() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_CATEGORIES,null);
        return res;
        //////
    }
    public Cursor dynamic_query(String query) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery(query,null);
        return res;
    }

    public boolean isPinEnabled(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select count(1) from "+TABLE_PIN +" where status = 1",null);
        res.moveToNext();
        if (res.getInt(0) > 0)
            return true;
        else return false;
    }

    public boolean isInitialPinCreated(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select count(1) from "+TABLE_PIN +" where pin is null",null);
        res.moveToNext();
        if (res.getInt(0) > 0)
            return false;
        else return true;
    }

    public String fetchCurrentPin(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select pin from "+TABLE_PIN +" where id = 1",null);
        StringBuilder buffer = new StringBuilder();
        while (res.moveToNext()) {
            for (int i = 0; i < res.getColumnCount(); i++)
                if ( null != res.getString(i))
                    buffer.append(res.getString(i));
                else buffer.append("???");
        }
        return buffer.toString();
    }

    public boolean updatePin(String pin, boolean state){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(column_pin, pin);
        contentValues.put(column_status, state);

        db.update(TABLE_PIN, contentValues, "id = ?",new String[] { "1" });
        return true;
    }

    public boolean updateData(String expenseID,String category,String date,String Recurrency,String amount,String payment, String currency, String note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_expense_ID,expenseID);
        contentValues.put(column_category_E,category);
        contentValues.put(column_date_E,date);
        contentValues.put(column_recurrency_E,Recurrency);
        contentValues.put(column_amount_E,amount);
        contentValues.put(column_payment_E,payment);
        contentValues.put(column_currency_E,currency);
        contentValues.put(column_note_E,note);

        db.update(TABLE_EXPENSES, contentValues, "Expense_ID = ?",new String[] { expenseID });
        return true;
    }
    public boolean updateData_I(String incomeID,String category_I,String date_I,String Recurrency_I,String amount_I,String payment_I, String currency_I, String note_I) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_income_ID,incomeID);
        contentValues.put(column_category_I,category_I);
        contentValues.put(column_date_I,date_I);
        contentValues.put(column_recurrency_I,Recurrency_I);
        contentValues.put(column_amount_I,amount_I);
        contentValues.put(column_payment_I,payment_I);
        contentValues.put(column_currency_I,currency_I);
        contentValues.put(column_note_I,note_I);

        db.update(TABLE_INCOMES, contentValues, "Income_ID = ?",new String[] { incomeID });
        return true;
    }


    public Integer deleteData (String expenseID) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_EXPENSES, "Expense_ID = ?",new String[] {expenseID});
    }
    public Integer deleteData_I (String incomeID)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_INCOMES, "Income_ID = ?",new String[] {incomeID});
    }
    public Integer deleteCategory (String categoryID)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_CATEGORIES, "Category_Id = ?",new String[] {categoryID});
    }

}

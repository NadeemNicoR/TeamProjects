package com.example.home;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Categories extends AppCompatActivity
{
    DatabaseHelper myDbCategory;

    EditText categoryID,categoryName;

    Button btnAddData_C;
    Button btnViewAll_C;
    Button btnDelete_C;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        setTitle("Available Categories");
        myDbCategory = new DatabaseHelper(this);



        categoryID = (EditText) findViewById(R.id.addCatID);
        categoryName = (EditText) findViewById(R.id.addCategoryName);

        btnAddData_C=(Button) findViewById(R.id.DoneCategory);
        btnViewAll_C=(Button) findViewById(R.id.viewCategory);
        btnDelete_C=(Button) findViewById(R.id.deleteCategory);

        addData_C();
        deleteData_C();
        viewData_C();
    }
    public void deleteData_C()
    {
        btnDelete_C.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDbCategory.deleteCategory(categoryID.getText().toString());
                        if (deletedRows > 0)
                            Toast.makeText(Categories.this, "Category Deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Categories.this, "Category not Deleted", Toast.LENGTH_LONG).show();
                    }
                }
        );

    }
    public void addData_C() {
        btnAddData_C.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isAdded= myDbCategory.insertCategories(categoryName.getText().toString());
                        if (isAdded == true)
                            Toast.makeText(Categories.this, "Category Added", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Categories.this, "Category Not Added", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void viewData_C() {
        btnViewAll_C.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDbCategory.getAllCategories();
                        if (res.getCount() == 0) {
                            // show message
                            showMessage_C("Error", "Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Category Id :" + res.getString(0) + "\n");
                            buffer.append("Category Name :" + res.getString(1) + "\n\n\n");
                        }
                        // Show all data
                        showMessage_C("", buffer.toString());
                    }
                }
        );
    }
    public void showMessage_C(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}

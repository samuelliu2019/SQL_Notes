package com.example.lius9308.mycontactapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName;
    EditText editPhone;
    EditText editAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText) findViewById(R.id.editText_name);
        editPhone = (EditText) findViewById(R.id.editText_phone);
        editAddress = (EditText)  findViewById(R.id.editText_address);


        myDb = new DatabaseHelper(this);
        Log.d("MyContactApp", "MainActivity: instantiated myDb");


    }

    public void addData(View view){
        Log.d("MyContactApp", "MainActivity: add contact button pressed");
        boolean inInserted = myDb.insertData(editName.getText().toString(),editPhone.getText().toString(),editAddress.getText().toString());
        if(inInserted)
        {
            Toast.makeText(MainActivity.this,"Success - contact inserted", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(MainActivity.this,"Failed - contact failed to insert ha", Toast.LENGTH_LONG).show();

        }
    }
}

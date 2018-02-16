package com.auribises.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class ActivityOne extends AppCompatActivity implements View.OnClickListener{


    // Reference Variables
    TextView txtTitle;
    EditText eTxtName, eTxtAge;
    Button btnSubmit;

    void initViews(){

        txtTitle = findViewById(R.id.textViewTitle);

        eTxtName = findViewById(R.id.editTextName);
        eTxtAge = findViewById(R.id.editTextAge);

        btnSubmit = findViewById(R.id.buttonSubmit);

        btnSubmit.setOnClickListener(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        initViews();
        Log.i("ActivityOne","--onCreate--");
    }

   /* @Override
    protected void onStart() {
        super.onStart();
        Log.i("ActivityOne","--onStart--");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ActivityOne","--onResume--");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ActivityOne","--onPause--");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ActivityOne","--onStop--");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ActivityOne","--onDestroy--");
    }
*/
    @Override
    public void onClick(View view) {

        int id = view.getId();

        switch (id){
            case R.id.button:

                break;
        }

        /*String name = eTxtName.getText().toString();

        Date date = new Date();
        String dateTime = date.toString();
        //String dateTime = new Date().toString();

        txtTitle.setText("Welcome, "+name+"\nIts: "+dateTime);

        getSupportActionBar().setTitle(name);*/

       /* String num = eTxtName.getText().toString();
        int number = Integer.parseInt(num);

        int sqNum = number*number;
        txtTitle.setText("Square of "+number+" is "+sqNum);*/


        // Forward Passing
        String name = eTxtName.getText().toString();
        String age = eTxtAge.getText().toString();

        int iAge = Integer.parseInt(age);

        Intent intent = new Intent(ActivityOne.this,ActivityTwo.class);

        //1. Put Data directly Intent
        //intent.putExtra("keyName",name);
        //intent.putExtra("keyAge",iAge);

        //2. Put Data in Bundle
        /*Bundle bundle = new Bundle();
        bundle.putString("keyName",name);
        bundle.putInt("keyAge",iAge);

        intent.putExtra("keyBundle",bundle);*/


        //2. Put Data in User Defined Object (which must be implementing Serializable)
        Person person = new Person();
        person.name = name;
        person.age = iAge;

        intent.putExtra("keyPerson",person);

        startActivity(intent);


    }

    /*public void clickHandler(View view){

        // How to start a new Activity ?
        Intent intent = new Intent(ActivityOne.this,ActivityTwo.class);
        startActivity(intent);

        Toast.makeText(this,"Button Clicked",Toast.LENGTH_LONG).show();
    }*/
}

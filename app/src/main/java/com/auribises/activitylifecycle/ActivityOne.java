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
    EditText eTxtName;
    Button btnSubmit;

    void initViews(){
        txtTitle = findViewById(R.id.textViewTitle);
        eTxtName = findViewById(R.id.editTextName);
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

    @Override
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

    @Override
    public void onClick(View view) {

        /*String name = eTxtName.getText().toString();

        Date date = new Date();
        String dateTime = date.toString();
        //String dateTime = new Date().toString();

        txtTitle.setText("Welcome, "+name+"\nIts: "+dateTime);

        getSupportActionBar().setTitle(name);*/

        String num = eTxtName.getText().toString();
        int number = Integer.parseInt(num);

        int sqNum = number*number;
        txtTitle.setText("Square of "+number+" is "+sqNum);

    }

    /*public void clickHandler(View view){

        // How to start a new Activity ?
        Intent intent = new Intent(ActivityOne.this,ActivityTwo.class);
        startActivity(intent);

        Toast.makeText(this,"Button Clicked",Toast.LENGTH_LONG).show();
    }*/
}

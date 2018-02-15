package com.auribises.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityTwo extends AppCompatActivity implements View.OnClickListener{

    EditText eTxtName, eTxtAge;
    Button btnBack;

    Intent rcvIntent;

    void initViews(){
        eTxtName = findViewById(R.id.editTextName);
        eTxtAge = findViewById(R.id.editTextAge);

        btnBack = findViewById(R.id.buttonBack);
        btnBack.setOnClickListener(this);

        rcvIntent = getIntent();

        //String name = rcvIntent.getStringExtra("keyName");
        //int iAge = rcvIntent.getIntExtra("keyAge",0);

        /*Bundle rcvBundle = rcvIntent.getBundleExtra("keyBundle");
        String name = rcvBundle.getString("keyName");
        int iAge = rcvBundle.getInt("keyAge");*/

        Person person = (Person)rcvIntent.getSerializableExtra("keyPerson");

        eTxtName.setText(person.name);
        eTxtAge.setText(String.valueOf(person.age));


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Log.i("ActivityTwo","--onCreate--");
        initViews();
    }

    @Override
    public void onClick(View view) {

    }

   /* @Override
    protected void onStart() {
        super.onStart();
        Log.i("ActivityTwo","--onStart--");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ActivityTwo","--onResume--");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ActivityTwo","--onPause--");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ActivityTwo","--onStop--");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ActivityTwo","--onDestroy--");
    }*/


}

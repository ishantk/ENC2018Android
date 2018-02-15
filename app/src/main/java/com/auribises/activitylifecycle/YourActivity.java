package com.auribises.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class YourActivity extends AppCompatActivity implements View.OnClickListener{


    EditText eTxtName, eTxtEmail;
    Button btnBack;

    void initViews(){
        eTxtName = findViewById(R.id.editTextName);
        eTxtEmail = findViewById(R.id.editTextEmail);

        btnBack = findViewById(R.id.buttonBack);
        btnBack.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your);
        initViews();
    }

    @Override
    public void onClick(View view) {

        //1. Read the data from EditText
        String name = eTxtName.getText().toString();
        String email = eTxtEmail.getText().toString();


        //2. Put the data in Intent
        Intent data = new Intent();
        data.putExtra("keyName",name);
        data.putExtra("keyEmail",email);

        //3. Send Back the Data to MyActivity
        setResult(201,data);
        finish(); // Destroy the Activity

    }
}

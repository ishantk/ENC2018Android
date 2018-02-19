package com.auribises.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

public class ViewsActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    // Declare the Views which user will interact with
    CheckBox cbCpp, cbJava, cbPython;
    RadioButton rbMale, rbFemale;
    Spinner spCity;
    EditText eTxtName;
    Button btnSubmit;

    RatingBar ratingBar;

    AutoCompleteTextView txtData;

    ArrayAdapter<String> adapter, adapterData;


    // Initialize the Views
    void initViews(){
        cbCpp = findViewById(R.id.checkBoxCpp);
        cbJava = findViewById(R.id.checkBoxJava);
        cbPython = findViewById(R.id.checkBoxPython);

        rbMale = findViewById(R.id.radioButtonMale);
        rbFemale = findViewById(R.id.radioButtonFemale);

        spCity = findViewById(R.id.spinner);

        eTxtName = findViewById(R.id.editTextName);

        txtData = findViewById(R.id.autoComplete);

        ratingBar = findViewById(R.id.ratingBar);

        btnSubmit = findViewById(R.id.buttonSubmit);



        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item);
        adapter.add("--Select City--"); //0
        adapter.add("Ludhiana");
        adapter.add("Chandigarh");
        adapter.add("Delhi");
        adapter.add("Bengaluru");
        adapter.add("California"); // n-1

        adapterData = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item);
        adapterData.add("HandBags"); //0
        adapterData.add("Handkerchiefs");
        adapterData.add("Wallet");
        adapterData.add("Walnut");
        adapterData.add("Belts");
        adapterData.add("Shoes"); // n-1

        // Set the Adapter on Spinner
        spCity.setAdapter(adapter);

        txtData.setAdapter(adapterData);

        // Anonymous Class Implementation of Interface
        spCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String city = adapter.getItem(i);
                Toast.makeText(ViewsActivity.this,"You Selected "+city,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        cbCpp.setOnCheckedChangeListener(this);
        cbJava.setOnCheckedChangeListener(this);
        cbPython.setOnCheckedChangeListener(this);

        rbMale.setOnCheckedChangeListener(this);
        rbFemale.setOnCheckedChangeListener(this);


        // Anonymous Class Implementation of Interface
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strName = eTxtName.getText().toString();
                String item = txtData.getText().toString();
                Toast.makeText(ViewsActivity.this,"Your Name is "+strName,Toast.LENGTH_LONG).show();
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(ViewsActivity.this,"You Rated "+v,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views); // Attaching or Binding the Layout on Activity

        // Views should always be initialized after setContentView
        initViews();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        int id = compoundButton.getId();

        switch (id){
            case R.id.checkBoxCpp:

                if(cbCpp.isChecked())
                    Toast.makeText(this,"You Checked Cpp "+cbCpp.isChecked(),Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(this,"You UnChecked Cpp "+cbCpp.isChecked(),Toast.LENGTH_LONG).show();

                break;

            case R.id.checkBoxJava:
                Toast.makeText(this,"You Checked Java",Toast.LENGTH_LONG).show();
                break;

            case R.id.checkBoxPython:
                Toast.makeText(this,"You Checked Python",Toast.LENGTH_LONG).show();
                break;

            case R.id.radioButtonMale:

                if(b)
                    Toast.makeText(this,"You Selected Male",Toast.LENGTH_LONG).show();

                break;

            case R.id.radioButtonFemale:
                if(b)
                    Toast.makeText(this,"You Selected Female",Toast.LENGTH_LONG).show();

                break;
        }

    }
}

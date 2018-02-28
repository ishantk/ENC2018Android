package com.auribises.activitylifecycle;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class AddCustomerActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener{


    EditText eTxtName, eTxtPhone;

    Spinner spCity;
    ArrayAdapter<String> adapter;

    RadioButton rbMale, rbFemale;
    Button btnAdd;

    Customer customer;

    ContentResolver resolver;

    void initViews(){

        customer = new Customer();

        resolver = getContentResolver();

        eTxtName = findViewById(R.id.editTextName);
        eTxtPhone = findViewById(R.id.editTextPhone);

        spCity = findViewById(R.id.spinnerCity);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item);
        adapter.add("--Select City--");
        adapter.add("Ludhiana");
        adapter.add("Chandigarh");
        adapter.add("Delhi");
        adapter.add("Bangalore");
        adapter.add("Chennai");

        spCity.setAdapter(adapter);
        spCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                customer.city = adapter.getItem(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        rbFemale = findViewById(R.id.radioButtonFemale);
        rbMale = findViewById(R.id.radioButtonMale);

        rbFemale.setOnCheckedChangeListener(this);
        rbMale.setOnCheckedChangeListener(this);

        btnAdd = findViewById(R.id.buttonAdd);
        btnAdd.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        initViews();
    }

    void clearFields(){
        eTxtName.setText("");
        eTxtPhone.setText("");
        spCity.setSelection(0);
        // radio buttons
    }

    boolean validateFields(){
        boolean flag = true;

        if(customer.name.isEmpty()){
            flag = false;
        }

        if(customer.phone.isEmpty()){
            flag = false;
        }else{
            if(customer.phone.length()!=10){
                flag = false;
            }
        }

        if(customer.city.isEmpty()){
            flag = false;
        }

        if(customer.gender.isEmpty()){
            flag = false;
        }

        return flag;
    }

    void insertCustomer(){

        ContentValues values = new ContentValues();
        values.put(Util.COL_NAME,customer.name);
        values.put(Util.COL_PHONE,customer.phone);
        values.put(Util.COL_CITY,customer.city);
        values.put(Util.COL_GENDER,customer.gender);

        Uri uri = resolver.insert(Util.URI_CUSTOMER,values);
        Toast.makeText(this,customer.name+" added successfully at "+uri.getLastPathSegment(),Toast.LENGTH_LONG).show();

        clearFields();
    }

    @Override
    public void onClick(View view) {

        customer.name = eTxtName.getText().toString();
        customer.phone = eTxtPhone.getText().toString();

        if(validateFields()) {
            insertCustomer();
        }else {
            Toast.makeText(this,"Please Enter Correct Details",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        int id = compoundButton.getId();

        if(b) {
            if (id == R.id.radioButtonFemale) {
                customer.gender = "Female";
            } else {
                customer.gender = "Male";
            }
        }

    }
}

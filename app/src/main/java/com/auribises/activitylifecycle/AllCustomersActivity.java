package com.auribises.activitylifecycle;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AllCustomersActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listView;
    ContentResolver resolver;

    ArrayAdapter<String> adapter;
    CustomerAdapter customerAdapter;

    ArrayList<Customer> customerList;

    Customer customer;

    void initViews(){
        listView = findViewById(R.id.listView);


        resolver = getContentResolver();

        String[] projection = {Util.COL_ID,Util.COL_NAME,Util.COL_PHONE,Util.COL_CITY,Util.COL_GENDER};

        Cursor cursor = resolver.query(Util.URI_CUSTOMER,projection,null,null,null);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);

        customerList = new ArrayList<>();

        int id = 0;
        String nm="",ph="",ct="",gn="";

        while (cursor.moveToNext()){
            id = cursor.getInt(cursor.getColumnIndex(Util.COL_ID));
            nm = cursor.getString(cursor.getColumnIndex(Util.COL_NAME));
            ph = cursor.getString(cursor.getColumnIndex(Util.COL_PHONE));
            ct = cursor.getString(cursor.getColumnIndex(Util.COL_CITY));
            gn = cursor.getString(cursor.getColumnIndex(Util.COL_GENDER));

            //Log.i("DATA",id+" - "+nm);
            //adapter.add(nm);

            Customer customer = new Customer(id,nm,ph,ct,gn);
            customerList.add(customer);
        }

        customerAdapter = new CustomerAdapter(this,R.layout.customer_list_item,customerList);

        listView.setAdapter(customerAdapter);
        listView.setOnItemClickListener(this);
        getSupportActionBar().setTitle("All Customers | "+customerList.size());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_customers);



        initViews();
    }

    void showOptions(){

        String[] items = {"View","Delete","Update"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                switch (i){
                    case 0:
                        Intent intent = new Intent();
                        intent.putExtra("keyCustomer",customer);
                        startActivity(intent);
                        break;

                    case 1:

                        break;

                    case 2:

                        break;
                }

            }
        });

        builder.create().show();

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        customer = customerList.get(i);

        showOptions();

    }
}

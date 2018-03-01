package com.auribises.activitylifecycle;

import android.content.ContentResolver;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AllCustomersActivity extends AppCompatActivity {

    ListView listView;
    ContentResolver resolver;

    ArrayAdapter<String> adapter;
    CustomerAdapter customerAdapter;

    ArrayList<Customer> customerList;

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
        getSupportActionBar().setTitle("All Customers | "+adapter.getCount());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_customers);



        initViews();
    }
}

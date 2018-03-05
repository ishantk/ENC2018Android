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
import android.widget.Toast;

import java.util.ArrayList;

public class AllCustomersActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listView;
    ContentResolver resolver;

    ArrayAdapter<String> adapter;
    CustomerAdapter customerAdapter;

    ArrayList<Customer> customerList;

    int pos;

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

    void deleteCustomer(){

        String where = Util.COL_ID+" = "+customer.id;
        int i = resolver.delete(Util.URI_CUSTOMER,where,null);

        if(i>0){

            customerList.remove(pos);
            customerAdapter.notifyDataSetChanged(); // Refresh the ListView

            getSupportActionBar().setTitle("All Customers | "+customerList.size());

            Toast.makeText(this,customer.name+" deleted !!",Toast.LENGTH_LONG).show();

        }

    }

    void askForDeletion(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete "+customer.name);
        builder.setMessage("Are you sure to delete ?");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                deleteCustomer();
            }
        });
        builder.setNegativeButton("Cancel",null);
        builder.create().show();
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
                        askForDeletion();
                        break;

                    case 2:
                        Intent intent1 = new Intent(AllCustomersActivity.this,AddCustomerActivity.class);
                        intent1.putExtra("keyCustomer",customer); // Forward Passing
                        startActivity(intent1);
                        break;
                }

            }
        });

        builder.create().show();

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        customer = customerList.get(i);
        pos = i;

        showOptions();

    }
}

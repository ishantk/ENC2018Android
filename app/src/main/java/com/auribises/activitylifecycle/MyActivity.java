package com.auribises.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyActivity extends AppCompatActivity implements View.OnClickListener{

    EditText eTxtName, eTxtEmail;
    Button btnSubmit;

    void initViews(){
        eTxtName = findViewById(R.id.editTextName);
        eTxtEmail = findViewById(R.id.editTextEmail);

        btnSubmit = findViewById(R.id.buttonSubmit);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        initViews();
    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(MyActivity.this,YourActivity.class);
        //startActivity(intent);
        startActivityForResult(intent,101);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 101 && resultCode == 201){
            String name = data.getStringExtra("keyName");
            String email = data.getStringExtra("keyEmail");

            eTxtName.setText(name);
            eTxtEmail.setText(email);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        // Explicit Menu
        /*menu.add(1,101,0,"All Songs");
        menu.add(1,102,0,"PlayLists");
        menu.add(1,103,0,"Artists");
        menu.add(2,104,0,"Recently Played");
        menu.add(2,105,0,"Favourites");*/

        // Implicit Menu
        getMenuInflater().inflate(R.menu.menu_myactivity,menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        //int gid = item.getGroupId();

        //Toast.makeText(this,"Item Id is: "+id+" - "+gid,Toast.LENGTH_LONG).show();

        switch (id){

            case 101:
                // Explicit Intent
                //Intent intent = new Intent(MyActivity.this,ActivityOne.class);

                // Implicit Intent
                Intent intent = new Intent("com.auribises.activitylifecycle.activityone");
                startActivity(intent);
                break;

            case 102:

                break;

            case 103:

                break;

            case R.id.add:
                Intent intent1 = new Intent("com.auribises.activitylifecycle.activityone");
                startActivity(intent1);
                break;

            case R.id.delete:

                break;
        }

        return super.onOptionsItemSelected(item);
    }
}

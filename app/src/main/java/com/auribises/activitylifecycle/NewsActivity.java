package com.auribises.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class NewsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listView;
    ArrayAdapter<String> adapter;

    void initViews(){

        listView = findViewById(R.id.listView);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        adapter.add("Zee News"); //0
        adapter.add("Aaj Tak");
        adapter.add("ABP");
        adapter.add("Khushi Ram");
        adapter.add("Republic");
        adapter.add("India Today");
        adapter.add("PTC"); //n-1

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);


        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });*/

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        initViews();
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        String news = adapter.getItem(i);
        Toast.makeText(this,"You Selected: "+news,Toast.LENGTH_LONG).show();

        String url = "";

        switch (i){
            case 0:
                url = "http://zeenews.india.com/";
                break;

            case 1:
                url = "https://aajtak.intoday.in/";
                break;

            case 2:
                url = "http://abpnews.abplive.in/";
                break;

            case 3:
                url = "http://www.khushiram.in/";
                break;

            case 4:

                break;

            case 5:

                break;
        }

        Intent intent = new Intent(NewsActivity.this,NewsDisplayActivity.class);
        intent.putExtra("keyUrl",url);
        startActivity(intent);
    }
}

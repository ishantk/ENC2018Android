package com.auribises.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Log.i("ActivityTwo","--onCreate--");
    }

    @Override
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
    }

    public void clickMe(View view){
        finish();
    }
}

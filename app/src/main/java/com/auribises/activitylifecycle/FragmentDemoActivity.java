package com.auribises.activitylifecycle;

import android.app.Notification;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FragmentDemoActivity extends AppCompatActivity {

    UpperFragment upperFragment;
    LowerFragment lowerFragment;

    FragmentManager fragmentManager;

    void initViews(){

        // Create the Objects of Fragments
        upperFragment = new UpperFragment();
        lowerFragment = new LowerFragment();

        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().add(R.id.upperFrame,upperFragment).commit();
        fragmentManager.beginTransaction().add(R.id.lowerFrame,lowerFragment).commit();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);

        initViews();

    }
}

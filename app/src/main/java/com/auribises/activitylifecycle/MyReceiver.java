package com.auribises.activitylifecycle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();


        if(action.equals("a.b.c.d")){
            Toast.makeText(context,"Action Received",Toast.LENGTH_LONG).show();
            Log.i("Broadcast","Action Received a.b.c.d");
        }

        if(action.equals("android.intent.action.BATTERY_LOW")){

        }

        if(action.equals("android.intent.action.ACTION_POWER_CONNECTED")){

        }

    }
}

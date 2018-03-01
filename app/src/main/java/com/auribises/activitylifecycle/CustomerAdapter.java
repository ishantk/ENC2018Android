package com.auribises.activitylifecycle;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ishantkumar on 01/03/18.
 */

public class CustomerAdapter extends ArrayAdapter<Customer> {

    Context context;
    int resource;
    ArrayList<Customer> objects;

    public CustomerAdapter(Context context, int resource, ArrayList<Customer> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View view = LayoutInflater.from(context).inflate(resource,parent,false);

        TextView txtName = view.findViewById(R.id.textViewName);
        TextView txtPhone = view.findViewById(R.id.textViewPhone);

        Customer customer = objects.get(position);

        txtName.setText(customer.name);
        txtPhone.setText(customer.phone);


        return view;
    }
}

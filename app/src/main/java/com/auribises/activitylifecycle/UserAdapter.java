package com.auribises.activitylifecycle;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ishantkumar on 22/02/18.
 */


public class UserAdapter extends ArrayAdapter<User> {

    Context context;
    int resource;
    ArrayList<User> objects;

    public UserAdapter(Context context, int resource, ArrayList<User> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(resource,parent,false);

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView txtName = view.findViewById(R.id.textViewName);
        TextView txtEmail = view.findViewById(R.id.textViewEmail);

        User user = objects.get(position);

        imageView.setBackgroundResource(user.image);
        txtName.setText(user.name);
        txtEmail.setText(user.email);

        return view;
    }
}

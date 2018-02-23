package com.auribises.activitylifecycle;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class LowerFragment extends Fragment implements View.OnClickListener{

    Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lower, container, false);

        //btn = view.findViewById(R.id.button5);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        btn = view.findViewById(R.id.button5);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getContext(),"You Clicked Button",Toast.LENGTH_LONG).show();
        //Toast.makeText(getActivity(),"You Clicked Button",Toast.LENGTH_LONG).show();
    }
}

package com.auribises.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class UsersActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    //ListView listView;
    GridView gridView;
    ArrayList<User> userList;
    UserAdapter userAdapter;

    void initViews(){
        //listView = findViewById(R.id.listView);
        gridView = findViewById(R.id.listView);
        userList = new ArrayList<>();

        User u1 = new User(R.drawable.contact,"John","john@example.com");
        User u2 = new User(R.drawable.todo,"Jennie","jennie@example.com");
        User u3 = new User(R.drawable.pb,"Jack","jack@example.com");
        User u4 = new User(R.drawable.category,"Jim","jim@example.com");
        User u5 = new User(R.drawable.user,"Joe","joe@example.com");
        //User u6 = new User(R.drawable.folder,"Jin","jin@example.com");

        userList.add(u1); // 0
        userList.add(u2);
        userList.add(u3);
        userList.add(u4);
        userList.add(u5);
        userList.add(new User(R.drawable.folder,"Jin","jin@example.com")); // n-1

        userAdapter = new UserAdapter(this,R.layout.list_item,userList);
        gridView.setAdapter(userAdapter);
        gridView.setOnItemClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        initViews();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        User user = userList.get(i);
        Toast.makeText(this,"You Selected: "+user.name,Toast.LENGTH_LONG).show();
    }
}

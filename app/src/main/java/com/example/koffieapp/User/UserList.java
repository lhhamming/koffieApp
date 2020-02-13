package com.example.koffieapp.User;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.koffieapp.Classes.User;
import com.example.koffieapp.DataProfiler;
import com.example.koffieapp.MainActivity;
import com.example.koffieapp.R;

import java.util.ArrayList;

public class UserList extends AppCompatActivity {

    ScrollView userList;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        userList = findViewById(R.id.userList);
        linearLayout = findViewById(R.id.userListLL);
        fillUserList();
    }

    private void fillUserList() {
        ArrayList<User> usersListArray = new ArrayList<>();
        usersListArray = DataProfiler.getInstance().getUsersList();
        if(usersListArray.size() > 0) {
            for (User u : usersListArray){
                linearLayout.addView(createTextView(u));
            }
        }
        else{
            Toast.makeText(getBaseContext(),"There arent any users in the system! add one please",Toast.LENGTH_SHORT).show();
        }
    }

    private View createTextView(User u) {
        TextView view = new TextView(this);
        view.setText(u.toString());
        return view;
    }

    public void addUser(View view) {
        Intent createUserIntent = new Intent(getBaseContext(), CreateUser.class);
        startActivity(createUserIntent);
    }

    public void goBack(View view) {
        Intent mainScreen = new Intent(getBaseContext(), MainActivity.class);
        startActivity(mainScreen);
    }
}

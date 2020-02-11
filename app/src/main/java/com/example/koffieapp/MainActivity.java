package com.example.koffieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.koffieapp.Classes.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showUsers(View view) {
        Intent userList = new Intent(getBaseContext(), UserList.class);
        startActivity(userList);
    }
}

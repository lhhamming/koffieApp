package com.example.koffieapp.Coffee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.koffieapp.R;

public class CoffeeOrder extends AppCompatActivity {

    String[] selectedUsers = new String[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_order);
        Bundle extras = getIntent().getExtras();
        selectedUsers =  extras.getStringArray("selectedUsers");
    }
}

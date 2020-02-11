package com.example.koffieapp;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.koffieapp.Classes.User;

public class CreateUser extends AppCompatActivity {

    EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        username = findViewById(R.id.username);
    }

    public void createUser(View view) {
        String usernameString = username.getText().toString();
        DataProfiler.getInstance().addUser(usernameString);
        Toast.makeText(this, "Created user: " + usernameString, Toast.LENGTH_SHORT).show();
    }

    public void goBack(View view) {
        Intent intent = new Intent(getBaseContext(), UserList.class);
        startActivity(intent);
    }
}

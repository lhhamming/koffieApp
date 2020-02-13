package com.example.koffieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.koffieapp.Coffee.CreateCoffee;
import com.example.koffieapp.Coffee.OrderList;
import com.example.koffieapp.User.UserList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkUserState();
    }

    private void checkUserState() {
        //We will call this method everytime the app is openend. to check if the user has any users in the user list.
        //If they dont have any users added to the application the button to order some coffee will be disabled;
        Button showOrderButton = findViewById(R.id.showOrderButton);
        if(DataProfiler.getInstance().getUsersList().size() > 0){
            //Do nothing. The app has some users in there.
            //To be sure we will enable the button anyway.
            showOrderButton.setEnabled(true);
        }
        else{

            showOrderButton.setEnabled(false);
        }
    }

    public void showUsers(View view) {
        Intent userList = new Intent(getBaseContext(), UserList.class);
        startActivity(userList);
    }

    public void showOrder(View view){
        Intent orderList = new Intent(getBaseContext(), OrderList.class);
        startActivity(orderList);
    }

    public void showCreateCoffee(View view) {
        Intent showCreateCofee = new Intent(getBaseContext(), CreateCoffee.class);
        startActivity(showCreateCofee);
    }
}

package com.example.koffieapp.Coffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.koffieapp.Classes.User;
import com.example.koffieapp.Coffee.CoffeeOrder;
import com.example.koffieapp.DataProfiler;
import com.example.koffieapp.R;

import java.util.ArrayList;

public class OrderList extends AppCompatActivity {

    LinearLayout userListOrder;
    LinearLayout userListReciever;
    String[] selectedUserArray = new String[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
        findViews();
        fillUserList();
    }

    private void fillUserList() {
        ArrayList<User> users = DataProfiler.getInstance().getUsersList();
        for (User u : users){
            userListOrder.addView(addViewButtonOrder(u));
        }
    }

    private void fillUserRecieverList(String userOrderer) {
        ArrayList<User> users = DataProfiler.getInstance().getUsersList();
        for (User u : users){
            //We dont want the same name to be displayed twice. So if we find it we skip it.
            if(u.getName() != userOrderer){
                userListReciever.addView(addViewButtonReciever(u));
            }
        }
    }

    private View addViewButtonOrder(User u) {
        Button userButton = new Button(this);
        userButton.setText(u.getName());
        userButton.setOnClickListener(getOnClickOrderer(userButton));
        return userButton;
    }

    private View addViewButtonReciever(User u) {
        Button userButton = new Button(this);
        userButton.setText(u.getName());
        userButton.setOnClickListener(getOnClickReciever(userButton));
        return userButton;
    }

    private void findViews() {
        userListOrder = findViewById(R.id.userOrderListLL);
        userListReciever = findViewById(R.id.userOrderListRecieverLL);
    }

    //When an order for button is pressed it will fire up this action
    View.OnClickListener getOnClickOrderer(final Button button) {
        return new View.OnClickListener() {
            public void onClick(View v) {
                resetUserRecieverList();
                String buttonString = button.getText().toString();
                selectedUserArray[0] = findUserAsAString(buttonString);
                fillUserRecieverList(buttonString);
            }
        };
    }

    private String findUserAsAString(String usernameString) {
        ArrayList<User> users = DataProfiler.getInstance().getUsersList();
        for (User u : users){
            if(u.getName().equals(usernameString)){
                return u.getName();
            }
            else{
                Toast.makeText(this, "Couldnt the user. This is a bug", Toast.LENGTH_SHORT).show();
                return "null";
            }
        }
        return null;
    }

    private void resetUserRecieverList() {
        userListReciever.removeAllViews();
    }

    //this onclick listener will be fired when a user is selected
    View.OnClickListener getOnClickReciever(final Button button) {
        return new View.OnClickListener() {
            public void onClick(View v) {
                selectedUserArray[1] = findUserAsAString(button.getText().toString());
                Button orderCoffee = findViewById(R.id.orderCoffeeButton);
                orderCoffee.setEnabled(true);
            }
        };
    }

    public void orderCoffee(View view){
        Intent coffeeOrderScreen = new Intent(getBaseContext(), CoffeeOrder.class);
        coffeeOrderScreen.putExtra("selectedUsers", selectedUserArray);
        startActivity(coffeeOrderScreen);
    }
}

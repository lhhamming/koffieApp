package com.example.koffieapp.Coffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.koffieapp.R;

public class CoffeeOrderList extends AppCompatActivity {

    String[] selectedUsers = new String[2];

    TextView userOrderer;
    TextView userReciever;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_order_list);
        Bundle extras = getIntent().getExtras();
        selectedUsers =  extras.getStringArray("selectedUsers");
        findViews();
        setTextViewText();
    }

    private void setTextViewText() {
        userOrderer.setText(selectedUsers[0]);
        userReciever.setText(selectedUsers[1]);
    }

    private void findViews() {
        userOrderer = findViewById(R.id.textViewOrderer);
        userReciever = findViewById(R.id.textViewReciever);
    }

    public void coffeeOrderIntent(View view){
        Intent n = new Intent(getBaseContext(), CoffeeOrder.class);
        startActivity(n);
    }
}

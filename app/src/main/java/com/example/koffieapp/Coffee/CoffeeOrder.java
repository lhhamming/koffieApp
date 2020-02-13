package com.example.koffieapp.Coffee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.koffieapp.Classes.Coffee;
import com.example.koffieapp.DataProfiler;
import com.example.koffieapp.R;

import java.util.ArrayList;

public class CoffeeOrder extends AppCompatActivity {

    LinearLayout coffeeOrderLL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_order);
        setViews();
        fillViewCoffee();
    }

    private void fillViewCoffee() {
        ArrayList<Coffee> coffeeList = DataProfiler.getInstance().getCoffeeList();
        for (Coffee c : coffeeList){
            coffeeOrderLL.addView(addButton(c));
        }
    }

    private View addButton(Coffee coffee) {
        Button coffeeButton = new Button(this);
        coffeeButton.setText(coffee.getName());
        coffeeButton.setOnClickListener(getOnClickCoffee(coffeeButton));
        return coffeeButton;
    }

    View.OnClickListener getOnClickCoffee(final Button button) {
        return new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(CoffeeOrder.this, "Selected : " + button.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        };
    }

    private void setViews() {
        coffeeOrderLL = findViewById(R.id.coffeeSelectionListLL);
    }
}

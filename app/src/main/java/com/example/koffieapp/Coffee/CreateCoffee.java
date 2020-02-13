package com.example.koffieapp.Coffee;

import android.content.Intent;
import android.os.Debug;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.koffieapp.DataProfiler;
import com.example.koffieapp.MainActivity;
import com.example.koffieapp.R;

public class CreateCoffee extends AppCompatActivity {

    ToggleButton toggleSugar;
    ToggleButton toggleMilk;
    EditText coffeeName;
    EditText fillsTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_coffee);
        findViews();
    }

    private void findViews() {
        toggleMilk = findViewById(R.id.toggleButtonMilk);
        toggleSugar = findViewById(R.id.toggleButtonSugar);
        coffeeName = findViewById(R.id.coffeeNameText);
        fillsTo = findViewById(R.id.coffeeFillsTo);
    }

    public void createCoffee(View view){
        String coffeename = coffeeName.getText().toString();
        int fillsto = Integer.parseInt(fillsTo.getText().toString());
        Boolean canAddMilk  = getBooleanFromToggle(toggleMilk);
        Boolean canAddSugar = getBooleanFromToggle(toggleSugar);
        try {
            DataProfiler.getInstance().addCoffee(coffeename, fillsto, canAddSugar, canAddMilk);
        }
        catch (Exception e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private Boolean getBooleanFromToggle(ToggleButton toggleButton) {
        if(toggleButton.getText().toString().equals("Yes")){
            return true;
        }
        else{
            return false;
        }
    }

    public void goBack(View view) {
        Intent goBackIntent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(goBackIntent);
    }
}

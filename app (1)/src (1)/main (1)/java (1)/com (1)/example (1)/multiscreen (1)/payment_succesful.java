package com.example.multiscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class payment_succesful extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_succesful);
        Intent intent72 = getIntent();

        Intent intent107 = getIntent();
    }

    public void BillDisplay(View view) {
        Intent intent104  = new Intent(this, BillDisplay.class);
        startActivity(intent104);
    }
}
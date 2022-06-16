package com.example.multiscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class gpayscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpayscreen);
        Intent intent106 = getIntent();

    }
    public void payment_succesful (View view){
        Intent intent107 = new Intent(this, payment_succesful.class);
        startActivity(intent107);
    }

}

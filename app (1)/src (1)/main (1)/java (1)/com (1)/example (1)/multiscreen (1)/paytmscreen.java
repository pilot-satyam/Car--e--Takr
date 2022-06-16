package com.example.multiscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class paytmscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paytmscreen);
        Intent intent108 = getIntent();
    }
    public void payment_succesful (View view){
        Intent intent109 = new Intent(this,payment_succesful.class);
        startActivity(intent109);
    }
}

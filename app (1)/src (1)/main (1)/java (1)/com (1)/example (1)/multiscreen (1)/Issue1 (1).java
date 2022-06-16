package com.example.multiscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;


public class Issue1 extends AppCompatActivity {
    private Button button8;
    private Button button10;
    private Button button9;
    private Button button11;
    private Button button15;
    private Button button27;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue1);

        Intent intent11 = getIntent();
        Intent intent31 = getIntent();
        Intent intent25 = getIntent();
        Intent intent103 = getIntent();
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);


        button10 = (Button) findViewById(R.id.text_engine_oil_leak);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oil_leak(v);
            }
        });


    }



    public void flat_tyre(View view){

        Intent intent8 = new Intent (this, flat_tyre.class);
        startActivity(intent8);
    }
    public void oil_leak (View view){
        Intent intent10 = new Intent(this, oil_leak.class);
        startActivity(intent10);
    }
    public void car_no_starting(View view){
        Intent intent9 = new Intent(this, car_no_starting.class);
        startActivity(intent9);
    }
    public void call_mechanic(View view){
        Intent intent10 = new Intent(this, call_mechanic.class);
        startActivity(intent10);
    }
    public void smoke_hood(View view){
        Intent intent15 = new Intent(this, smoke_hood.class);
        startActivity(intent15);
    }
    public void Location_pune(View view){
        Intent intent97= new Intent(this, Location_pune.class);
        startActivity(intent97);
    }

}




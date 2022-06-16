package com.example.multiscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class mech_calling extends AppCompatActivity {
    private ImageButton buttoncan;
    private Button button17;
    private ImageButton imgbutton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mech_calling);
        Intent intent12 = getIntent();
        //button17 = findViewById(R.id.paymentbtn);
    }
    public void Issue1 (View view){
        Intent intent12 = new Intent(this, Issue1.class);
        Intent intent103 = new Intent(this,Issue1.class);
        startActivity(intent12);
        startActivity(intent103);
    }
    public void Payment(View view){
        Intent intent14 = new Intent(this, Payment.class);
        startActivity(intent14);
    }
    public void  Calling(View view){
        Intent intent26 = new Intent(this, Calling.class);
        startActivity(intent26);
    }
    public void datafetch (View view){
        Intent intent42 = new Intent(this,datafetch.class);
        startActivity(intent42);
    }
    public void IssueResolved(View  view){
        Intent intent101 = new Intent(this, IssueResolved.class);
        startActivity(intent101);
    }
}

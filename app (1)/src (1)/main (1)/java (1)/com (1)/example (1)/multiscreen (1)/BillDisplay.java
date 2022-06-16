package com.example.multiscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class BillDisplay extends AppCompatActivity {
    PDFView mpdfView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_display);
        Intent intent104 = getIntent();


        mpdfView2 = (PDFView) findViewById(R.id.pdfView2);
        mpdfView2.fromAsset("FreshBooks - Invoice Details.pdf").load();
    }
    public void Ratings(View view){
        Intent intent105 = new Intent(this, Ratings.class);
        startActivity(intent105);
    }
}

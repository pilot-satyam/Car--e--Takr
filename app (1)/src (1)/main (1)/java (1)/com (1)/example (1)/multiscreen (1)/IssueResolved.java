package com.example.multiscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class IssueResolved extends AppCompatActivity {
    PDFView mpdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_resolved);
        Intent intent101 = getIntent();

        mpdfView = (PDFView) findViewById(R.id.pdfView);
        mpdfView.fromAsset("Bill.pdf").load();
    }
    public void BottomSheet(View view){
        Intent intent102 = new Intent(this, BottomSheet.class);
        startActivity(intent102);
    }
}

package com.example.multiscreen;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.braintreepayments.cardform.view.CardForm;

public class Creditcard extends AppCompatActivity {


    CardForm cardForm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditcard);

        Intent intent99 = getIntent();
        Intent intent95 = getIntent();
/*
        cardForm = (CardForm) findViewById(R.id.credit_Card);
        TextView textView = (TextView) findViewById(R.id.payment_amount);
        Button btnPay = (Button) findViewById(R.id.btn_pay);

        textView.setText("1999/-");
        btnPay.setText(String.format("Payer %s", textView.getText()));*/


    }
}


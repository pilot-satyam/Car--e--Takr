package com.example.multiscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class BottomSheet extends AppCompatActivity {
    // Initialize Variable
    Button btShow;
    ImageView btGpay,imageView2,imageView3,imageView4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);
        Intent intent195 = getIntent();
        Intent intent102 = getIntent();

        //
        btShow = findViewById(R.id.bt_show);

        imageView2 = findViewById(R.id.paytmmm);
        imageView3 = findViewById(R.id.bhim);
        imageView4 = findViewById(R.id.paypall);

        btShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create Bottom Sheet Dialog
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(BottomSheet.this);
                bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog);
                bottomSheetDialog.setCanceledOnTouchOutside(false);

                // Initialize And Assign Variable
                EditText editText = bottomSheetDialog.findViewById(R.id.credit);
                /*btGpay = findViewById(R.id.gpaaay);

                btGpay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });*/
                bottomSheetDialog.show();

            }
        });

    }
    public void gpayscreen (View view){
        Intent intent106 = new Intent(this,gpayscreen.class);
        startActivity(intent106);
    }
    public void paytmscreen (View view){
        Intent intent108 = new Intent(this,paytmscreen.class);
        startActivity(intent108);
    }
    public void bhimscreen (View view){
        Intent intent111 = new Intent(this,bhimscreen.class);
        startActivity(intent111);
    }
}

package com.example.multiscreen;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Location_pune extends AppCompatActivity {
    ProgressBar mProgressbar3;
    ImageView mimageView3;
    Button mButton3;
    private int mProgressStatus3 = 0;
    private Handler mHandler3 = new Handler();
    TextView mLoadText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_pune);
        Intent intent97 = getIntent();
        Intent intent50 = getIntent();
        final Intent intent24 = getIntent();
        Intent intent49 = getIntent();

        mProgressbar3 = findViewById(R.id.progressBar3);
        mimageView3 = findViewById(R.id.mapview);
        mButton3 = findViewById(R.id.mapcont);



        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgressStatus3 < 100){
                    mProgressStatus3++;
                    android.os.SystemClock.sleep(50);
                    mHandler3.post(new Runnable() {
                        @Override
                        public void run() {
                            mProgressbar3.setProgress(mProgressStatus3);
                        }
                    });
                }
                mHandler3.post(new Runnable() {
                    @Override
                    public void run() {
                        mimageView3.setVisibility(View.VISIBLE);
                        mButton3.setVisibility(View.VISIBLE);
                        mButton3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                /*Intent intent98 = new Intent(Location_pune.this, call_mechanic.class);
                                startActivity(intent98);*/
                                Intent intent111= new Intent();
                                intent111.setAction(Intent.ACTION_VIEW);
                                intent111.setData(Uri.parse("geo:18.5204,73.8567"));
                                startActivity(intent111);

                            }
                        });

                    }
                });
            }
        }).start();





















    }
}

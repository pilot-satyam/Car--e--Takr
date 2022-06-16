package com.example.multiscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Mechanicdetails extends AppCompatActivity {
    private int mProgressStatus = 0;
    private  ProgressBar mProgressBar2;
    private Handler mHandler2 = new Handler();
    private TextView mLoadingTeext2;
    Button mnextbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanicdetails);
        Intent intent34  = getIntent();
        Intent intent47 = getIntent();


        mProgressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
        mLoadingTeext2 = (TextView) findViewById(R.id.loading2);
        mnextbtn = (Button) findViewById(R.id.nexbtn);


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgressStatus < 100){
                    mProgressStatus++;
                    android.os.SystemClock.sleep(50);
                    mHandler2.post(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar2.setProgress(mProgressStatus);
                        }
                    });
                }
                mHandler2.post(new Runnable() {
                    @Override
                    public void run() {
                        mLoadingTeext2.setVisibility(View.VISIBLE);
                        mnextbtn.setVisibility(View.VISIBLE);
                    }
                });
            }
        }).start();
    }
    public void mech_calling(View view){
        Intent intent12 = new Intent(this,mech_calling.class);
        startActivity(intent12);
    }
}

package com.example.multiscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


public class call_mechanic extends AppCompatActivity  {
    private  ProgressBar mProgressBar;
    private Button button12,mnext,mlist;

    private TextView mLoadingTeext;
    private int mProgressStatus = 0;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_mechanic);
        Intent intent10 = getIntent();
        Intent intent14 = getIntent();
        Intent intent23 = getIntent();
        Intent intent24 = getIntent();
        Intent intent25 = getIntent();
        Intent intent27 = getIntent();
        Intent intent49 = getIntent();
        Intent intent50 = getIntent();



        mProgressBar = (ProgressBar) findViewById(R.id.progressbar);
        mLoadingTeext = (TextView) findViewById(R.id.loading);
        mnext = (Button) findViewById(R.id.next);
        mlist = (Button) findViewById(R.id.list_mech);




        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgressStatus < 100){
                    mProgressStatus++;
                    android.os.SystemClock.sleep(50);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar.setProgress(mProgressStatus);
                        }
                    });
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mLoadingTeext.setVisibility(View.VISIBLE);
                        mnext.setVisibility(View.VISIBLE);
                        mlist.setVisibility(View.VISIBLE);
                        mlist.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                NotificationCompat.Builder builder = new NotificationCompat.Builder(call_mechanic.this);
                                builder.setContentTitle("Car(e)Takr");
                                builder.setContentText(" The search is complete");
                                builder.setSmallIcon(R.drawable.ic_launcher_background);
                                builder.setAutoCancel(true);
                                Intent intent34 = new Intent(call_mechanic.this, Mechanicdetails.class);
                                startActivity(intent34);

                                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(call_mechanic.this);
                                managerCompat.notify(1, builder.build());//id should be unique
                            }
                        });
                        mnext.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent45 = new Intent(call_mechanic.this, Database.class);
                                startActivity(intent45);
                            }
                        });
                    }
                });
            }
        }).start();
    }
    /*public void Mechanicdetails(View view){
        Intent intent34 = new Intent(this, Mechanicdetails.class);
        startActivity(intent34);
    }
    public void Database(View view){
        Intent intent45 = new Intent(this, Database.class);
        startActivity(intent45);
    }*/

}

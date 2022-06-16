package com.example.multiscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Permissions extends AppCompatActivity {
    private Button button;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);
        Intent intent5 = getIntent();
        
        button =(Button) findViewById(R.id.permissioncontact);
        button2 = (Button) findViewById(R.id.nextbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog();
                button2.setVisibility(View.VISIBLE);

            }


        });

    }
    public void openDialog(){
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(),"Permissions Dialog");

    }
    public void MakeandModel(View view){
        Intent intent37 = new Intent(this, MakeandModel.class);
        startActivity(intent37);
    }
}

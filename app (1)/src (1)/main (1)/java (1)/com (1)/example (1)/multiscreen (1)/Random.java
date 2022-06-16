package com.example.multiscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Random extends AppCompatActivity {
    Button button_save, button_result;
    EditText name_et, gender_et, age_et;
    TextView textView;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    DocumentReference documentReference = db.collection("User").document("User_doc1");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        Intent intent44 = getIntent();
        // Database reference pointing to root of database
        button_save = findViewById(R.id.savebtn);
        name_et = findViewById(R.id.text1);
        age_et = findViewById(R.id.text2);
        gender_et = findViewById(R.id.text3);
        button_result = findViewById(R.id.fetchtn);
        textView = findViewById(R.id.result);

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = name_et.getText().toString();
                final String gender = gender_et.getText().toString();
                String age = age_et.getText().toString();

                Map<String, Object> data = new HashMap<>();
                data.put("Name",name);
                data.put("gender",gender);
                data.put("Age",age);

                documentReference.set(data)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_LONG).show();
                            }
                        });
                button_result.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        documentReference.get()
                                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                    @Override
                                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                                        if (documentSnapshot.exists()){
                                            String name_result = documentSnapshot.getString("Name");
                                            String gender_result = documentSnapshot.getString("gender");
                                            String age_result = documentSnapshot.getString("Age");

                                            textView.setText("Name"+ name_result+"\n"+ "Gender"+gender_result+"\n"+"Age"+age_result);
                                        }

                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_LONG).show();
                                    }
                                });
                    }
                });


            }
        });



    }
}

package com.example.multiscreen;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class newAcc extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
    Pattern.compile("^" +
             //"(?=.*[0-9])" +         //at least 1 digit
             //"(?=.*[a-z])" +         //at least 1 lower case letter
             //"(?=.*[A-Z])" +         //at least 1 upper case letter
             "(?=.*[a-zA-Z])" +      //any letter
             "(?=.*[@#$%^&+=])" +    //at least 1 special character
             "(?=\\S+$)" +           //no white spaces
             ".{4,}" +               //at least 4 characters
             "$");
    private Button button18;
    EditText mFullName, mEmail, mPassword, mPhone , mUsername;
    Button mRegisterBtn, mLoginBtn;
    EditText e1,e2,e3,e4,e5;
    Button b1;
    DatabaseHelpertwo db;


    FirebaseAuth fAuth;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_acc);
        Intent intent3 = getIntent();
        Intent myintent = getIntent();

        mFullName = findViewById(R.id.namefield);
        mEmail = findViewById(R.id.emailidfield);
        mPassword = findViewById(R.id.passwordfield);
        mPhone = findViewById(R.id.numberfield);
        mUsername = findViewById(R.id.usernamefield);
        mRegisterBtn = findViewById(R.id.signup);
        mLoginBtn = findViewById(R.id.loginbtn);
        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);
        e1 = findViewById(R.id.emailidfield);
        e2 = findViewById(R.id.passwordfield);
        e3= findViewById(R.id.passwordfield2);
        e4= findViewById(R.id.passwordfield2);
        e5= findViewById(R.id.passwordfield2);
        b1 = findViewById(R.id.signup);
        db = new DatabaseHelpertwo(this);


       // if(fAuth.getCurrentUser() != null){
          //  startActivity(new Intent(getApplicationContext(),MakeandModel.class));
            //finish();
        //}
/*
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s4 = e4.getText().toString();
                String s5 = e5.getText().toString();
                if(s1.equals("")||s2.equals("")||s3.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();

                }
                else{
                    if(s2.equals(s3)){
                        Boolean checkmail = db.checkmail(s1);
                        if(checkmail==true){
                            Boolean insert = db.insert(s1,s2,s4,s5);
                            if(insert==true){
                                Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(getApplicationContext(),"Registered not Successful",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Email Already Exists", Toast.LENGTH_SHORT).show();

                        }

                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Passwrords do not match", Toast.LENGTH_SHORT).show();

                    }

                }
            }
        });
*/

       mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required");
                    return;
                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    mEmail.setError("Please Enter a valid Email Address");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    mPassword.setError("Password is Required");
                    return;
                }
                if (password.length()<8){
                    mPassword.setError("Password must atleast be 8 characters long");
                    return;
                }
                else if (!PASSWORD_PATTERN.matcher(password).matches()) {
                    mPassword.setError("Password too weak");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(newAcc.this,"User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MakeandModel.class));
                        }
                        else{
                            Toast.makeText(newAcc.this,"Error"+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),login.class));
            }
        });

    }
    //public void MakeandModel(View view){

       // Intent intent22 = new Intent(this,MakeandModel.class);
       // startActivity(intent22);
   // }

}

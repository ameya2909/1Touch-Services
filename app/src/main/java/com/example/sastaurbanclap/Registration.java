package com.example.sastaurbanclap;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class Registration extends AppCompatActivity {
    EditText mfullname,memail,mphone,mpassword;
    Button mregisteration,mloginbutton;
    FirebaseAuth fAuth;
    ProgressBar progressbar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mfullname = findViewById(R.id.fullname);
        memail = findViewById(R.id.loginemail);
        mphone = findViewById(R.id.phone);
        mpassword = findViewById(R.id.password);
        mregisteration = findViewById(R.id.registerbutton);
        mloginbutton = findViewById(R.id.loginbutton);
        fAuth = FirebaseAuth.getInstance();
        progressbar = findViewById(R.id.progressbar);

        if (fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),SelectService.class));
            finish();
        }

        mregisteration.setOnClickListener(v -> {
            String email =memail.getText().toString().trim();
            String password =mpassword.getText().toString().trim();
            String fullname =mfullname.getText().toString().trim();

            if(TextUtils.isEmpty(email)){
                memail.setError("Email is required.");
                return;
            }
            if(TextUtils.isEmpty(password)){
                memail.setError("Password is required.");
                return;
            }
            if(TextUtils.isEmpty(fullname)){
                memail.setError("Please enter name.");
                return;
            }

            progressbar.setVisibility(View.VISIBLE);

            fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"User Connected!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(),SelectService.class));
                }else{
                    Toast.makeText(getApplicationContext(),"Error!"+ Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_LONG).show();
                }
                progressbar.setVisibility(View.GONE);
            });
        });
        mloginbutton.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),LoginPage.class)));
    }
}
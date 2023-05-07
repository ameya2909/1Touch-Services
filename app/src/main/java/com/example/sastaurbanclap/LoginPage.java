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
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class LoginPage extends AppCompatActivity {
    EditText memail,mpassword;
    Button mbtnlogin;
    TextView mtextView2;
    FirebaseAuth fAuth;
    ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        memail = findViewById(R.id.email);
        mpassword = findViewById(R.id.password);
        mbtnlogin = findViewById(R.id.btnlogin);
        mtextView2 = findViewById(R.id.textView2);
        progressBar = findViewById(R.id.progressBar);
        fAuth = FirebaseAuth.getInstance();

        mbtnlogin.setOnClickListener(v -> {
            String email = memail.getText().toString().trim();
            String password = mpassword.getText().toString().trim();

            if(TextUtils.isEmpty(email)){
                memail.setError("Email is required.");
                return;
            }
            if(TextUtils.isEmpty(password)){
                mpassword.setError("Password is required.");
                return;
            }
            progressBar.setVisibility(View.VISIBLE);

            fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Login Sucessfull",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }else{
                    Toast.makeText(getApplicationContext(),"Error!"+ Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                }
                progressBar.setVisibility(View.GONE);

            });
        });
        mtextView2.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),Registration.class)));
    }
}
package com.example.sastaurbanclap;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SelectService extends AppCompatActivity {
    Button mREPAIRS , mELECTRICIANS, mPLUMBERS, mCARPENTERS;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_service);
        mREPAIRS = findViewById(R.id.btn1);
        mELECTRICIANS = findViewById(R.id.btn3);
        mPLUMBERS = findViewById(R.id.btn4);
        mCARPENTERS = findViewById(R.id.btn2);



        mELECTRICIANS.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), ServiceElectrician.class)));
        mPLUMBERS.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), ServicePlumber.class)));
        mCARPENTERS.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), ServiceCarpenter.class)));
        mREPAIRS.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), ServiceRepairs.class)));


    }
}
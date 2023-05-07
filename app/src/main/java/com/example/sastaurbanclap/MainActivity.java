package com.example.sastaurbanclap;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Button mSS;
    Spinner mspinner2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSS= findViewById(R.id.buttonss);
        mSS.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), SelectService.class)));
        mspinner2=findViewById(R.id.spinner2);
        String[] apptype= getResources().getStringArray(R.array.Select_Locality);
        ArrayAdapter adapter2=new ArrayAdapter(this, android.R.layout.simple_spinner_item,apptype);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mspinner2.setAdapter(adapter2);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId()==R.id.spinner)
        {
            String valuefromspinner= (String) parent.getItemAtPosition(position);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
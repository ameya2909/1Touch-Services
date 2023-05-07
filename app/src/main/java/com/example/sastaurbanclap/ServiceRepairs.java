package com.example.sastaurbanclap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ServiceRepairs extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner mspinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_repairs);
        mspinner=findViewById(R.id.spinner);
        String[] apptype= getResources().getStringArray(R.array.Select_Appliance);
        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_spinner_item,apptype);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mspinner.setAdapter(adapter);
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
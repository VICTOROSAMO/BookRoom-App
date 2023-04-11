package com.accommodation.bookroomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class DropdownMenu extends AppCompatActivity {

    String [] items = {"Severe allergies/asthma", "Mental health conditions", "Chronic illnesses", "Mobility issues", "Other"};

    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> adapterItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dropdown_menu);

        autoCompleteTextView = findViewById(R.id.dropdown_list);

        adapterItems = new ArrayAdapter<String>(this,R.layout.list_item, items);

        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(DropdownMenu.this, "You chose"+" " +item,Toast.LENGTH_SHORT).show();

                startActivity(new Intent(DropdownMenu.this, FemaleBooking1.class));
                Toast.makeText(DropdownMenu.this, "Due to your health issues, Dispensaries are located nearby", Toast.LENGTH_LONG).show();

            }
        });

    }
}
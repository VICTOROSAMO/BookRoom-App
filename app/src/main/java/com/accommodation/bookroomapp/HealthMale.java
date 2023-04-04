package com.accommodation.bookroomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class HealthMale extends AppCompatActivity {


    private Button yes_Btn, no_Btn;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.male_health);


                yes_Btn = findViewById(R.id.yes_btn);
                no_Btn = findViewById(R.id.no_btn);
                imageView = findViewById(R.id.mf_img);

                Glide.with(this)
                        .load(R.drawable.maleicon)
                        .into(imageView);

                yes_Btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(HealthMale.this, MaleBooking1.class));
                        Toast.makeText(HealthMale.this, "Welcome to male student's Hostels", Toast.LENGTH_LONG).show();
                        Toast.makeText(HealthMale.this, "Due to your health issues, Dispensaries are located nearby", Toast.LENGTH_LONG).show();
                    }
                });

                no_Btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(HealthMale.this, MaleBooking2.class));
                        Toast.makeText(HealthMale.this, "Welcome to Male student's Hostels", Toast.LENGTH_LONG).show();
                    }
                });

            }
    }

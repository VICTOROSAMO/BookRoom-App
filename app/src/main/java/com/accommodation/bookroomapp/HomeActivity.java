package com.accommodation.bookroomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class HomeActivity extends AppCompatActivity {

    private Button mBtn, fBtn;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mBtn = findViewById(R.id.btnMale);
        fBtn = findViewById(R.id.btnFemale);
        imageView = findViewById(R.id.mf_img);

        Glide.with(this)
                       .load(R.drawable.male_female_img)
                               .into(imageView);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, HealthMale.class));
                Toast.makeText(HomeActivity.this, "Confirm with us about your health", Toast.LENGTH_LONG).show();
            }
        });

        fBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, HealthFemale.class));
                Toast.makeText(HomeActivity.this, "Confirm with us about your health", Toast.LENGTH_LONG).show();
            }
        });

    }}

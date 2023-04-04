package com.accommodation.bookroomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class FinalActivity extends AppCompatActivity {

    ImageView imageView;
    Button mainPage, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        imageView = findViewById(R.id.final_img);
        mainPage = findViewById(R.id.home_btn);
        logout = findViewById(R.id.logout_btn);

        Glide.with(this)
                .load(R.drawable.final_img)
                .into(imageView);

        mainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FinalActivity.this, HomeActivity.class));
            }
        });



        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }

    @Override
    public void onBackPressed() {

        Toast.makeText(FinalActivity.this, "Thanks for using Book Room App", Toast.LENGTH_SHORT).show();
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {

                finishAffinity();
            }
        },3000);

    }
}
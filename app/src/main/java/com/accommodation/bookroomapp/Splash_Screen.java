package com.accommodation.bookroomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Splash_Screen extends AppCompatActivity {

    private ImageView imageView;

    Handler h = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imageView = findViewById(R.id.splashScreen_img);

        Glide.with(this)
                        .load(R.drawable.splash_screen)
                                .into(imageView);



        h.postDelayed(new Runnable() {
            @Override
            public void run() {
           startActivity(new Intent(Splash_Screen.this,HomeActivity.class));

            }
        },5000);


    }


}
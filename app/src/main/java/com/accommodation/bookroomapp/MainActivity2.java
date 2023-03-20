package com.accommodation.bookroomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;

public class MainActivity2 extends AppCompatActivity {

   private ImageView imageView;
   ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView = findViewById(R.id.hostelpage);
        progress = new ProgressDialog(this);

        Glide.with(this)
                .load(R.drawable.hostelpage)
                .into(imageView);

        progress.setMessage("Still working on this page! Kindly check later...");
        progress.show();

        // schedule the dismissal of the progress dialog after 10 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progress.dismiss();

                // transition back to previous activity
                onBackPressed();
            }
        }, 8000);
    }

    @Override
    public void onBackPressed() {
        finish();

    }
}
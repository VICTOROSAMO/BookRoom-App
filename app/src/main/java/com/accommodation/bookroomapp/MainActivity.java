package com.accommodation.bookroomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MainActivity extends AppCompatActivity {

    private Button btn_signUp,btn_signIn;
    TextView txtSlogan;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_signIn = findViewById(R.id.btnSignIn);
        btn_signUp = findViewById(R.id.btnSignUp);
        imageView = findViewById(R.id.bg_img);

        txtSlogan = findViewById(R.id.txtSlogan);

       // RequestOptions options = new RequestOptions()
                 // set the desired image size
        Glide.with(this)
                .load(R.drawable.homepg) // replace with your image resource or URL
               // .apply(options) // apply the RequestOptions
                .into(imageView); // replace with your ImageView



        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,LoginActivity.class));

            }
        });

        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Sign_UpActivity.class));

            }
        });
    }
    @Override
    public void onBackPressed() {
            finishAffinity();

    }

}
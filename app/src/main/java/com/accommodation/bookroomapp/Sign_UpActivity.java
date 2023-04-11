package com.accommodation.bookroomapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.FirebaseDatabase;

public class Sign_UpActivity extends AppCompatActivity {

   EditText  pass, email;
     Button signUp;
    private FirebaseAuth mAuth;
    private ProgressDialog progress;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        pass = findViewById(R.id.edit_SignUp);
        signUp = findViewById(R.id.signUp_btn);
        email = findViewById(R.id.edit_email);
        imageView = findViewById(R.id.bg_img1);
        mAuth = FirebaseAuth.getInstance();

        progress = new ProgressDialog(this);


        Glide.with(this)
                        .load(R.drawable.homepg)
                        .into(imageView);



        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = pass.getText().toString().trim();
                String eMail = email.getText().toString().trim();
                if (TextUtils.isEmpty(eMail)) {
                    email.setError("Email is Required");
                    return;}
                if (TextUtils.isEmpty(password)) {
                    pass.setError("Password is Required");
                    return;
                }
                progress.setMessage("Signing up, Please wait...");
                progress.show();

                mAuth.createUserWithEmailAndPassword(eMail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progress.dismiss();
                        if (task.isSuccessful()) {
                            Toast.makeText(Sign_UpActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Sign_UpActivity.this, LoginActivity.class));
                        } else {
                            progress.dismiss();
                            Toast.makeText(Sign_UpActivity.this, "Registration Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }}
                });



            }




        });
    }
}
package com.accommodation.bookroomapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

   private EditText editEmail, editPass;
    private Button btnSignIn;
    private FirebaseAuth mAuth;
    private ImageView imageView;

    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = findViewById(R.id.edtRegNumber);
        editPass = findViewById(R.id.edtPassword);
        btnSignIn = findViewById(R.id.btnSignIn);

        imageView = findViewById(R.id.bg_img2);

        mAuth = FirebaseAuth.getInstance();

        progress = new ProgressDialog(this);


        Glide.with(this)
                        .load(R.drawable.homepg)
                                .into(imageView);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = editEmail.getText().toString().trim();
                String pass = editPass.getText().toString().trim();


                progress.setMessage("Logging in...");
                progress.show();

                if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    if(!pass.isEmpty()){


            mAuth.signInWithEmailAndPassword(email,pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        progress.dismiss();
                        Toast.makeText(LoginActivity.this,"Login Successfull", Toast.LENGTH_SHORT ).show();
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progress.dismiss();
                        Toast.makeText(LoginActivity.this,"The credentials aren't familiar to us!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                });

                    } else {
                        editPass.setError("Password is Required");
                        progress.dismiss();
                    }
                } else if(email.isEmpty()){
                    editEmail.setError("Email is Required");
                    progress.dismiss();
                }
                else {
                    editEmail.setError("Please enter valid email");
                    progress.dismiss();
                }

            }
        });
    }


}
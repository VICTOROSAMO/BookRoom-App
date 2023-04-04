package com.accommodation.bookroomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.accommodation.bookroomapp.Model.Student;
import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FbookRoom2 extends AppCompatActivity {

    Button btn;
    ImageView imageView;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fbook_room2);

        btn = findViewById(R.id.choose_btn);
        imageView = findViewById(R.id.bg_img1);
        dialog = new ProgressDialog(this);

        Glide.with(this)
                .load(R.drawable.homepg)
                .into(imageView);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddStudentDialog();


            }
        });



    }

    public void showAddStudentDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter your details");

        // Inflate the layout for the dialog
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialogue_user_details, null);
        builder.setView(dialogView);

        // Get references to the input fields
        EditText regNoEditText = dialogView.findViewById(R.id.edit_reg_no);
        EditText hostelEditText = dialogView.findViewById(R.id.edit_hostel);
        EditText roomEditText = dialogView.findViewById(R.id.edit_room);

        // Set up the positive button click listener
        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Get the input field values
                String regNo = regNoEditText.getText().toString();
                String hostel = hostelEditText.getText().toString();
                int room = Integer.parseInt(roomEditText.getText().toString());

                // Submit the data to the Firebase Realtime Database
                DatabaseReference studentsRef = FirebaseDatabase.getInstance().getReference("students");
                String studentId = studentsRef.push().getKey();
                Student student = new Student(regNo, hostel, room);
                studentsRef.child(studentId).setValue(student);

                dialogueSubmit();



            }

            public void dialogueSubmit(){
                dialog.setMessage("Submitting details...");
                dialog.show();

                Handler h =new Handler();
                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(FbookRoom2.this, FinalActivity.class));
                        dialog.dismiss();
                    }
                },5000);


            }
        });

        // Set up the negative button click listener
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                startActivity(new Intent(FbookRoom2.this, FemaleBooking2.class));
            }
        });

        // Show the builder dialog
        builder.show();





    }
}
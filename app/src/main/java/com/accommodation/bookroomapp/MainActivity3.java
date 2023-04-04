package com.accommodation.bookroomapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Context;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    RecyclerView recyclerView;
    private DatabaseReference mRef;
    private Context context;
    private ImageView img2;
    private ArrayList<Messages> messagesList;
    private ReclyclerAdapter reclyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        recyclerView = findViewById(R.id.recycler_view1);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        mRef = FirebaseDatabase.getInstance().getReference();

        messagesList = new ArrayList<>();

        ClearAll();

        GetDataFromFirebase();

        //imageView = findViewById(R.id.hostelpage);


       /* Glide.with(this)
                .load(R.drawable.hostelpage)
                .into(imageView);*/

    }

    private void GetDataFromFirebase() {

        Query query = mRef.child("Category");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                ClearAll();

                for(DataSnapshot snapshot2 : snapshot.getChildren()){

                    Messages messages = new Messages();

                    messages.setImageUrl(snapshot2.child("Image").getValue().toString());
                    messages.setName(snapshot2.child("Name").getValue().toString());

                    messagesList.add(messages);
                }

                reclyclerAdapter = new ReclyclerAdapter(context, messagesList);
                recyclerView.setAdapter(reclyclerAdapter);
                reclyclerAdapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    private void ClearAll(){
        if(messagesList != null){
            messagesList.clear();

            if(reclyclerAdapter != null ){
                reclyclerAdapter.notifyDataSetChanged();
            }
        }
        messagesList = new ArrayList<>();


    }

    @Override
    public void onBackPressed() {
        finish();

    }

}
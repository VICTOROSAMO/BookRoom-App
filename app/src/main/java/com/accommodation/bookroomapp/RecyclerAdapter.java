package com.accommodation.bookroomapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.core.Context;

import java.util.ArrayList;



    class ReclyclerAdapter extends RecyclerView.Adapter<ReclyclerAdapter.ViewHolder> {

        private static final String Tag = "RecyclerView";

        private Context mContext;
        private ArrayList<Messages> messagesList;

        public ReclyclerAdapter(Context mContext, ArrayList<Messages> messagesList) {
            this.mContext = mContext;
            this.messagesList = messagesList;
        }

        @NonNull
        @Override
        public ReclyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.message_item,parent,  false);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            holder.textView.setText(messagesList.get(position).getName());

            Glide.with(holder.itemView.getContext()).load(messagesList.get(position).getImageUrl())
                    .into(holder.imageView);
        }

        @Override
        public int getItemCount() {
            return messagesList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            ImageView imageView;
            TextView textView;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                imageView = itemView.findViewById(R.id.imageView);
                textView = itemView.findViewById(R.id.txtView);

            }
        }
    }


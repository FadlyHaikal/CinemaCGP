package com.example.cinemacgp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ViewHolder extends RecyclerView.ViewHolder{

    TextView titleView, crewView, ratingView;
    ImageView movieImageView;
    private Adapter adapter;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        titleView = itemView.findViewById(R.id.title);
        crewView = itemView.findViewById(R.id.crew);
        ratingView = itemView.findViewById(R.id.rating);
        movieImageView = itemView.findViewById(R.id.movieImage);
    }

    public ViewHolder linkAdapter(Adapter adapter){
        this.adapter = adapter;
        return this;
    }
}

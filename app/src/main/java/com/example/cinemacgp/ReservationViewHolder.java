package com.example.cinemacgp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ReservationViewHolder extends RecyclerView.ViewHolder{
    TextView titleView, cinemaView, reservationIdView;
    ImageView movieImageView;
    private ReservationAdapter adapter;

    public ReservationViewHolder(@NonNull View itemView) {
        super(itemView);
        titleView = itemView.findViewById(R.id.title);
        cinemaView = itemView.findViewById(R.id.cinema);
        reservationIdView = itemView.findViewById(R.id.reservationId);
        movieImageView = itemView.findViewById(R.id.movieImage);
    }

    public ReservationViewHolder linkAdapter(ReservationAdapter adapter){
        this.adapter = adapter;
        return this;
    }
}

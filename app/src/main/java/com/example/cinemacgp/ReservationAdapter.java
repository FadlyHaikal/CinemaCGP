package com.example.cinemacgp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ReservationAdapter extends RecyclerView.Adapter<ReservationViewHolder>{
    List<CinemaReservation> items;
    Context ctx;

    public ReservationAdapter(List<CinemaReservation> items, Context ctx) {
        this.ctx = ctx;
        this.items = items;
    }

    @NonNull
    @Override
    public ReservationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reservation_item_view, parent, false);
        return new ReservationViewHolder(view).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull ReservationViewHolder holder, int position) {
        holder.titleView.setText(items.get(position).getTitle());
        holder.cinemaView.setText(items.get(position).getCinemaName());
        holder.reservationIdView.setText(items.get(position).getId());
        Glide.with(ctx).load(items.get(position).getImage()).into(holder.movieImageView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

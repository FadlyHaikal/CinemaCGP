package com.example.cinemacgp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder>{
    List<Movie> items;
    Context ctx;

    public Adapter(List<Movie> items, Context ctx) {
        this.ctx = ctx;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titleView.setText(items.get(position).getFullTitle());
        holder.crewView.setText(items.get(position).getCrew());
        holder.ratingView.setText(items.get(position).getImDbRating());
        Glide.with(ctx).load(items.get(position).getImage()).into(holder.movieImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx, MovieDetailActivity.class);
                intent.putExtra("movieId", items.get(holder.getAdapterPosition()).getId());
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

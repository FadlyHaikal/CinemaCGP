package com.example.cinemacgp.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cinemacgp.Adapter;
import com.example.cinemacgp.CinemaReservation;
import com.example.cinemacgp.Movie;
import com.example.cinemacgp.MovieDataService;
import com.example.cinemacgp.databinding.FragmentHomeBinding;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    int counter;
    Context ctx;
    List<Movie> movie_list;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ctx = this.getContext();

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final MovieDataService movieDataService = new MovieDataService(this.getContext());
        counter = 0;

        RecyclerView recyclerView = binding.recyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(ctx));

        movieDataService.getMovies(new MovieDataService.VolleyResponseListener() {
            @Override
            public void onResponse(List<Movie> movies) {
                movie_list = movies;
                Adapter adapter = new Adapter(movies, ctx);
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onError(String message) {
                Toast.makeText(ctx, message, Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
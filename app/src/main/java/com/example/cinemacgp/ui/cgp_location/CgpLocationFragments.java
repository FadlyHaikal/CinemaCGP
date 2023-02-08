package com.example.cinemacgp.ui.cgp_location;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cinemacgp.Adapter;
import com.example.cinemacgp.CgpAlphaMapsActivity;
import com.example.cinemacgp.CgpBetaMapsActivity;
import com.example.cinemacgp.CinemaReservation;
import com.example.cinemacgp.Movie;
import com.example.cinemacgp.MovieDataService;
import com.example.cinemacgp.ReservationAdapter;
import com.example.cinemacgp.ReservationDataService;
import com.example.cinemacgp.databinding.FragmentCgpLocationBinding;

import java.util.List;

public class CgpLocationFragments extends Fragment {

    private FragmentCgpLocationBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCgpLocationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button btnCinemaCgpAlpha = binding.btnCinemaCgpAlpha;
        Button btnCinemaCgpBeta = binding.btnCinemaCgpBeta;

        btnCinemaCgpAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity().getApplicationContext(), CgpAlphaMapsActivity.class);
                startActivity(intent);
            }
        });

        btnCinemaCgpBeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity().getApplicationContext(), CgpBetaMapsActivity.class);
                startActivity(intent);
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
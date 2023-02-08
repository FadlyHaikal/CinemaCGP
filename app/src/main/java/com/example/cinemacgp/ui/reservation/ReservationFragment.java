package com.example.cinemacgp.ui.reservation;

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

import com.example.cinemacgp.CinemaReservation;
import com.example.cinemacgp.ReservationAdapter;
import com.example.cinemacgp.ReservationDataService;
import com.example.cinemacgp.databinding.FragmentReservationBinding;

import java.util.List;

public class ReservationFragment extends Fragment {

    private FragmentReservationBinding binding;
    Context ctx;
    List<CinemaReservation> reservation_list;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentReservationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ctx = this.getContext();

        final ReservationDataService reservationDataService = new ReservationDataService(this.getContext());

        RecyclerView recyclerView = binding.recyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(ctx));

        reservationDataService.getReservation(new ReservationDataService.VolleyResponseListeners2() {
            @Override
            public void onResponse(List<CinemaReservation> reservations) {
                reservation_list = reservations;
                ReservationAdapter adapter = new ReservationAdapter(reservation_list, ctx);
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
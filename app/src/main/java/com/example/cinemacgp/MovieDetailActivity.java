package com.example.cinemacgp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieDetailActivity extends AppCompatActivity {
    ActionBar actionBar;
    TextView title, description, genres, duration, stars, directors, release_date;
    RatingBar rating;
    ImageView image;
    Button btnCinemaAlpha, btnCinemaBeta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Movie Detail");
        setContentView(R.layout.activity_movie_detail);
        String movieId = getIntent().getStringExtra("movieId");

        image = (ImageView)findViewById(R.id.poster);
        title = (TextView)findViewById(R.id.title);
        description = (TextView)findViewById(R.id.description);
        genres = (TextView)findViewById(R.id.genres);
        duration = (TextView)findViewById(R.id.duration);
        stars = (TextView)findViewById(R.id.stars);
        directors = (TextView)findViewById(R.id.directors);
        release_date = (TextView)findViewById(R.id.release_date);
        rating = (RatingBar) findViewById(R.id.rating);
        btnCinemaAlpha = (Button) findViewById(R.id.btnReserveAlpha);
        btnCinemaBeta = (Button) findViewById(R.id.btnReserveBeta);

        final MovieDataService movieDataService = new MovieDataService(MovieDetailActivity.this);
        movieDataService.getMovieById(movieId, new MovieDataService.MovieByIdResponseListener() {
            @Override
            public void onResponse(Movie movie) {
                Glide.with(MovieDetailActivity.this).load(movie.getImage()).into(image);
                title.setText(movie.getTitle());
                description.setText(movie.getPlot());
                genres.setText("Genres: " + movie.getGenres());
                duration.setText("Duration: " + movie.getRuntimeMinutes() + " Minutes");
                stars.setText("Actors: " + movie.getStars());
                directors.setText("Director: " + movie.getDirectors());
                release_date.setText("Release Date: " + movie.getReleaseDate());
                rating.setRating((float) Float.parseFloat(movie.getImDbRating())/2);
                btnCinemaAlpha.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final ReservationDataService reservationDataService = new ReservationDataService(MovieDetailActivity.this);
                        reservationDataService.postReservation("Cinema CGP Alpha", movieId, movie.getImage(), movie.getTitle());
                        Toast.makeText(MovieDetailActivity.this, "Add Movie on CGP Alpha Cinema Success", Toast.LENGTH_SHORT).show();
                    }
                });
                btnCinemaBeta.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final ReservationDataService reservationDataService = new ReservationDataService(MovieDetailActivity.this);
                        reservationDataService.postReservation("Cinema CGP Beta", movieId, movie.getImage(), movie.getTitle());
                        Toast.makeText(MovieDetailActivity.this, "Add Movie on CGP Beta Cinema Success", Toast.LENGTH_SHORT).show();
                    }
                });
            }
            @Override
            public void onError(String message) {
                Toast.makeText(MovieDetailActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
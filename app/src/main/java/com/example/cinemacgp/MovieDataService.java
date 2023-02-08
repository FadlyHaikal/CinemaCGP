package com.example.cinemacgp;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MovieDataService {
    public static final String endPoint = "https://imdb-api.com/en/API/";
    public static final String token = "/k_c8fv21ng";

    Context ctx;

    public MovieDataService(Context context){
        this.ctx = context;
    }

    public interface VolleyResponseListener {
        void onResponse(List<Movie> movies);
        void onError(String message);
    }

    public void getMovies(final VolleyResponseListener volleyResponseListener){
        List<Movie> movies = new ArrayList<Movie>();

        String url = endPoint + "Top250Movies" + token;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray resp = response.getJSONArray("items");
                    for(int i=0; i < resp.length(); i++){
                        JSONObject movie = resp.getJSONObject(i);
                        String id = movie.getString("id");
                        String fullTitle = movie.getString("fullTitle");
                        String image =  movie.getString("image");
                        String imDbRating = movie.getString("imDbRating");
                        String crew = movie.getString("crew");
                        movies.add(new Movie(id, fullTitle, image, imDbRating, crew));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                volleyResponseListener.onResponse(movies);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyResponseListener.onError("Error Occured");
            }
        });

        MySingleton.getInstance(ctx).addToRequestQueue(request);
    }

    public interface MovieByIdResponseListener {
        void onResponse(Movie movie);
        void onError(String message);
    }

    public void getMovieById(String movieId, final MovieByIdResponseListener movieByIdResponseListener){
        String url = endPoint + "Title" + token + "/" + movieId;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    String id = response.getString("id");
                    String title = response.getString("title");
                    String fullTitle = response.getString("fullTitle");
                    String image =  response.getString("image");
                    String imDbRating = response.getString("imDbRating");
                    String plot  = response.getString("plot");
                    String year = response.getString("year");
                    String directors = response.getString("directors");
                    String stars = response.getString("stars");
                    String releaseDate = response.getString("releaseDate");
                    String runtimeMinutes = response.getString("runtimeMins");
                    String genres = response.getString("genres");

                    Movie movie = new Movie(id, title, plot, year, image, directors, stars, releaseDate, runtimeMinutes, fullTitle, genres, imDbRating);
                    movieByIdResponseListener.onResponse(movie);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                movieByIdResponseListener.onError("Error Occured");
            }
        });

        MySingleton.getInstance(ctx).addToRequestQueue(request);
    }
}

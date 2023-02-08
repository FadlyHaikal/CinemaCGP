package com.example.cinemacgp;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ReservationDataService {
    public static final String reservationUrl = "https://63e2c93865ae493177049e86.mockapi.io/CinemaReservation";

    Context ctx;

    public ReservationDataService(Context context){
        this.ctx = context;
    }

    public interface VolleyResponseListeners2 {
        void onResponse(List<CinemaReservation> reservations);
        void onError(String message);
    }

    public void getReservation(final ReservationDataService.VolleyResponseListeners2 VolleyResponseListener2){
        List<CinemaReservation> list_reservation = new ArrayList<CinemaReservation>();

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, reservationUrl, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for(int i=0; i < response.length(); i++){
                        JSONObject reservation = response.getJSONObject(i);
                        String id = reservation.getString("id");
                        String cinemaName = reservation.getString("cinemaName");
                        String movieId = reservation.getString("movieId");
                        String image = reservation.getString("image");
                        String title = reservation.getString("title");
                        list_reservation.add(new CinemaReservation(id, cinemaName, movieId, image, title));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                VolleyResponseListener2.onResponse(list_reservation);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyResponseListener2.onError("Error Occured");
            }
        });

        MySingleton.getInstance(ctx).addToRequestQueue(request);
    }

    void postReservation(String cinemaName, String movieId, String image, String title) {
        try {
            RequestQueue requestQueue = Volley.newRequestQueue(ctx);
            String URL = "https://63e2c93865ae493177049e86.mockapi.io/CinemaReservation";
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("cinemaName", cinemaName);
            jsonBody.put("movieId", movieId);
            jsonBody.put("image", image);
            jsonBody.put("title", title);
            final String requestBody = jsonBody.toString();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("VOLLEY", response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("VOLLEY", error.toString());
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public byte[] getBody() throws AuthFailureError {
                    try {
                        return requestBody == null ? null : requestBody.getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                        return null;
                    }
                }

                @Override
                protected Response<String> parseNetworkResponse(NetworkResponse response) {
                    String responseString = "";
                    if (response != null) {
                        responseString = String.valueOf(response.statusCode);
                        // can get more details such as response.headers
                    }
                    return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
                }
            };

            requestQueue.add(stringRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}

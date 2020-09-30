package com.example.zomatoproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.SearchView;

import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import org.json.JSONObject;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Retrofit retrofit;
    private Gson gson;
    private RetrofitApi retrofitApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.id_recyclerview);
        final SearchView searchView = findViewById(R.id.id_searchView);
        Button button = findViewById(R.id.id_searchButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = searchView.getQuery().toString();
                Log.e("location ", location);
                requestCall(location);
            }
        });
    }

    private void requestCall(String location) {
        gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder().baseUrl("https://developers.zomato.com/documentation/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        retrofitApi = retrofit.create(RetrofitApi.class);
        retrofitApi.getResturants(RetrofitApi.KEY, location).enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if (response.isSuccessful()) {
                    Log.e("entity ", response.body().getLocationList().get(0).getEntity_type());
                    locationCredentialForResturants(response.body().getLocationList().get(0));
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.e("error ", t.getLocalizedMessage());
            }
        });
    }

    private void locationCredentialForResturants(Location locations) {
        if (!locations.getEntity_type().equals("")) {
            if (retrofit != null) {
                retrofitApi.getResturantsLocationDetail(RetrofitApi.KEY, locations.getEntity_id(), locations.getEntity_type()).enqueue(new Callback<ResturantModel>() {
                    @Override
                    public void onResponse(Call<ResturantModel> call, Response<ResturantModel> response) {
                        if (response.isSuccessful()) {
                            sendToAdapter(response.body().getBestRetedRasturant());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResturantModel> call, Throwable t) {
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }

    private void sendToAdapter(List<BestRatedResturant> bestRatedResturants) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Adapter(bestRatedResturants));
    }

}
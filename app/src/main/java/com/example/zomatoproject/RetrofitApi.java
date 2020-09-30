package com.example.zomatoproject;

import com.google.gson.JsonElement;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitApi {
    String KEY="1b3c8b37ea96785391fa55c288ac385c";
    @GET("locations")
    Call<Model> getResturants(@Query("user-key") String key, @Query("query") String location);
    @GET("location_details")
    Call<ResturantModel> getResturantsLocationDetail(@Query("user-key") String key, @Query("entity_id") int entity_id,@Query("entity_type") String entity_type);
}

package com.example.retrofitpractise;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FlowerResponse {
    @GET("feeds/flowers.json")
    Call<List<FlowerService>> flowerservice();
}

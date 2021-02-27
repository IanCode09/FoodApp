package com.lexy.foodapp.retrofit;

import com.lexy.foodapp.model.FoodData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("fooddata.json")
    Call<List<FoodData>> getAllData();

}

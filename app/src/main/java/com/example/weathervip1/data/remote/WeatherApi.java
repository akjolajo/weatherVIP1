package com.example.weathervip1.data.remote;



import com.example.weathervip1.data.models.MainResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    @GET("weather")
    Call<MainResponse> getWeather(
            @Query("q") String city,
            @Query("appid") String appid,
            @Query("units") String units
    );
}
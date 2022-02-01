package com.example.weathervip1.data.repasitory;

import androidx.lifecycle.MutableLiveData;

import com.example.MainResponse;
import com.example.weathervip1.R;
import com.example.weathervip1.common.Resource;
import com.example.weathervip1.data.remote.WeatherApi;

import org.checkerframework.checker.units.qual.C;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {
    private WeatherApi api;



    @Inject
    public MainRepository(WeatherApi api){
        this.api  = api;

    }

    public MutableLiveData<Resource<MainResponse>> getWeather(String city){

        MutableLiveData<Resource<MainResponse>> livedata = new MutableLiveData<>();
        livedata.setValue(Resource.loading());
        api.getWeather("Bishkek", "bff2008a7f2e0a8857d1b0fd6a47a5f9", "metric").enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                if (response.isSuccessful() && response.body() != null){
                    livedata.setValue(Resource.success(response.body()));
                } else{
                    livedata.setValue(Resource.error(response.message(), null));
                }
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                livedata.setValue(Resource.error(t.getLocalizedMessage(), null));
            }
        });
        return livedata;
    }





}

package com.example.weathervip1.ui;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.MainResponse;
import com.example.weathervip1.common.Resource;
import com.example.weathervip1.data.repasitory.MainRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class WeatherViewModel extends ViewModel {

    public MainRepository repository;

    @Inject
    public WeatherViewModel(MainRepository repository){
        this.repository = repository;
    }

    public LiveData<Resource<MainResponse>> weatherLiveData;

    public void getWeather(String city){
        weatherLiveData = repository.getWeather("Bishkek");
    }

}

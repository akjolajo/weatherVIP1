package com.example.weathervip1.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.weathervip1.Prefs;
import com.example.weathervip1.R;
import com.example.weathervip1.base.BaseFragment;
import com.example.weathervip1.common.Resource;
import com.example.weathervip1.data.models.MainResponse;
import com.example.weathervip1.databinding.FragmentWeathertvBinding;

public class WeathertvFragment extends BaseFragment<FragmentWeathertvBinding> {

    private WeatherViewModel viewModel;

    @Override
    protected FragmentWeathertvBinding bind() {
        return FragmentWeathertvBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void setupObservers() {

        viewModel.weatherLiveData.observe(getViewLifecycleOwner(), new Observer<Resource<MainResponse>>() {
            @Override
            public void onChanged(Resource<MainResponse> resource) {
                switch (resource.status){
                    case SUCCESS: {
                        setupUI(resource.data);

                        break;
                    }
                    case ERROR: {
                        break;
                    }
                    case LOADING: {
                        break;
                    }
                }

            }
        });

    }

    private void setupUI(MainResponse weather) {
        binding.mainTempIndicator.setText(weather.getMain().getTemp().toString());
    }

    @Override
    protected void setupListeners() {

    }

    @Override
    protected void callRequests() {

        viewModel.getWeather(getCity());

    }

    private String getCity(){
        Prefs prefs = new Prefs(requireActivity());
        return prefs.getCity();
    }

    @Override
    protected void setupViews() {

        viewModel = new ViewModelProvider(requireActivity()).get(WeatherViewModel.class);

    }
}
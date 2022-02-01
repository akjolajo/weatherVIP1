package com.example.weathervip1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weathervip1.base.BaseFragment;
import com.example.weathervip1.databinding.FragmentCityBinding;

public class cityFragment extends BaseFragment<FragmentCityBinding> {

    @Override
    protected FragmentCityBinding bind() {
        return FragmentCityBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected void setupObservers() {

    }

    @Override
    protected void setupListeners() {

        binding.btnCityName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Prefs prefs = new Prefs(requireContext());
                prefs.saveCity(binding.cityName.getText().toString());


            }
        });

    }

    @Override
    protected void callRequests() {

    }

    @Override
    protected void setupViews() {

    }
}
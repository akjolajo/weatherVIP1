package com.example.weathervip1;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {
    private SharedPreferences preferences;

    public Prefs(Context context){
        preferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE);
    }


    public void  saveCity(String city){
        preferences.edit().putString("saveCity", city).apply();
    }

    public String getCity(){
        return preferences.getString("saveCity", "Bishkek");
    }
}

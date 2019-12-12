package com.example.weatherappretrofit2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

// Interface class for Query

public interface WeatherService {


    // api.openweathermap.org/data/2.5/weather?zip={zip code},{country code}

//    api.openweathermap.org/data/2.5/weather?id=2172797


    //https://samples.openweathermap.org/data/2.5/weather?zip=94040,us&appid=f2e5cdc1a477a401a1efc9fec31c6dbe


    @GET("data/2.5/weather?")
    Call<WeatherData> getNameOnly(@Query("zip") String zipCode, @Query("country code") String countryCode, @Query("APPID") String app_id);


    @GET("data/2.5/weather?")
    Call<WeatherData> getByID(@Query("id")String id, @Query("APPID") String app_id);


//    Call<WeatherData> getCurrentWeatherData(@Query("lat") String lat, @Query("lon") String lon, @Query("APPID") String app_id);

}


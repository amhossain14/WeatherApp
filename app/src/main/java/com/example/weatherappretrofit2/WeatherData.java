package com.example.weatherappretrofit2;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


// POJO Class
public class WeatherData {


    public float getDt() {
        return dt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @SerializedName("dt")
    public float dt;
    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;


    @SerializedName("weather")
    public ArrayList<Weather> weather;


    @SerializedName("sys")
    public Sys sys;

}

class Sys {

    String type;
    String message;
    String country;
    String sunset;
    String sunrise;

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public String getCountry() {
        return country;
    }

    public String getSunset() {
        return sunset;
    }

    public String getSunrise() {
        return sunrise;
    }


}



class Weather {

    private int id;
    private String main;
    private String description;


    public int getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }


}


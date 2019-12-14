package com.example.weatherappretrofit2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView display;
    EditText search_Edit;
    Button search_button;

    String zipcode;
    WeatherService weatherService;

    // hello
EditText AA;
    EditText AasdasdasdasdasA;

    EditText AasdasdasdasdaasdasdsssA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "http://api.openweathermap.org/";
        final String apiKey = "f2e5cdc1a477a401a1efc9fec31c6dbe";

        display = findViewById(R.id.display);
        search_Edit = findViewById(R.id.search_Edit);
        search_button = findViewById(R.id.search_button);


        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zipcode = search_Edit.getText().toString();

                // this is for search_button

//                Toast.makeText(MainActivity.this, zipcode, Toast.LENGTH_SHORT).show();
//                Log.e("ZIPPPPPPPPP13",zipcode);


                weatherService = retrofit.create(WeatherService.class);
                Call<WeatherData> call = weatherService.getNameOnly(zipcode, "US", apiKey);



                call.enqueue(new Callback<WeatherData>() {
                    @Override
                    public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {

                        if (!response.isSuccessful()) {
                            Log.e("aaa", "Failed-------" + response.code());
                            display.setText(response.code());
                        }

                        WeatherData weatherData = response.body();
                        Log.e("AAAA", weatherData.sys.getSunset());
                        Toast.makeText(MainActivity.this, weatherData.getName(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<WeatherData> call, Throwable t) {

                        Log.e("ERRRRRRRRRRR", t.getMessage());

                    }
                });




//                Call<WeatherData> caller = weatherService.getByID(zipcode,apiKey);


//    2172797



//                caller.enqueue(new Callback<WeatherData>() {
//                    @Override
//                    public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
//                        if (!response.isSuccessful()) {
//                            Log.e("aaa", "Failed-------" + response.code());
//                            display.setText(response.code());
//                        }
//
//                        WeatherData weatherData = response.body();
//                        Log.e("AAAA", weatherData.weather.get(0).getDescription());
//
//                        display.setText(weatherData.weather.get(0).getDescription());
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<WeatherData> call, Throwable t) {
//
//                    }
//                });

//                Call<WeatherData> call = weatherService.getCurrentWeatherData(lat, lon, apiKey);



//                call.enqueue(new Callback<WeatherData>() {
//                    @Override
//                    public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
//
//                        if (!response.isSuccessful()) {
//                            Log.e("aaa", "Failed-------" + response.code());
//
//                            display.setText(response.code());
//                        }
//
//                        WeatherData weatherData = response.body();
//
////                        weatherData.getName();
////                        Log.e("11",weatherData.getName() + weatherData.getId()+ weatherData.getDt());
////
//
//                        Toast.makeText(MainActivity.this, weatherData.weather.get(0).getDescription(), Toast.LENGTH_SHORT).show();
//display.setText(weatherData.weather.get(0).getDescription());
//
//                    }
//
////                    +" "+weatherData.sys.get(0).getMessage() + " " +weatherData.sys.get(0).getSunrise()
////
////                    weatherData.getName()+" "+ weatherData.getDt()+" "
////                            +weatherData.weather.get(0).getDescription()+" "+
////                            weatherData.weather.get(0).getMain()+" "+
//
//                    @Override
//                    public void onFailure(Call<WeatherData> call, Throwable t) {
//
//
//                    }
//                });

            }
        }); // search_button ENDS


    }


}

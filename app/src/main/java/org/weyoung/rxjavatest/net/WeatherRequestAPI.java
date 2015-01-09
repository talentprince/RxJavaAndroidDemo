package org.weyoung.rxjavatest.net;

import org.weyoung.rxjavatest.data.Weather;

import retrofit.http.GET;
import retrofit.http.Query;

public interface WeatherRequestAPI {
    @GET("/weather")
    Weather getWeather(@Query("location") String location);
}

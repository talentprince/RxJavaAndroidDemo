package org.weyoung.rxjavatest.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class WeatherResult {

    @Expose
    private String currentCity;
    @Expose
    private String pm25;
    @Expose
    private List<WeatherIndex> index = new ArrayList<WeatherIndex>();
    @SerializedName("weather_data")
    @Expose
    private List<WeatherData> weatherData = new ArrayList<WeatherData>();

    /**
     *
     * @return
     * The currentCity
     */
    public String getCurrentCity() {
        return currentCity;
    }

    /**
     *
     * @param currentCity
     * The currentCity
     */
    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    /**
     *
     * @return
     * The pm25
     */
    public String getPm25() {
        return pm25;
    }

    /**
     *
     * @param pm25
     * The pm25
     */
    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    /**
     *
     * @return
     * The index
     */
    public List<WeatherIndex> getIndex() {
        return index;
    }

    /**
     *
     * @param index
     * The index
     */
    public void setIndex(List<WeatherIndex> index) {
        this.index = index;
    }

    /**
     *
     * @return
     * The weatherData
     */
    public List<WeatherData> getWeatherData() {
        return weatherData;
    }

    /**
     *
     * @param weatherData
     * The weather_data
     */
    public void setWeatherData(List<WeatherData> weatherData) {
        this.weatherData = weatherData;
    }
}
package org.weyoung.rxjavatest.data;


import com.google.gson.annotations.Expose;

public class WeatherData {

    @Expose
    private String date;
    @Expose
    private String dayPictureUrl;
    @Expose
    private String nightPictureUrl;
    @Expose
    private String weather;
    @Expose
    private String wind;
    @Expose
    private String temperature;
    /**
     * @return The date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return The dayPictureUrl
     */
    public String getDayPictureUrl() {
        return dayPictureUrl;
    }

    /**
     * @param dayPictureUrl The dayPictureUrl
     */
    public void setDayPictureUrl(String dayPictureUrl) {
        this.dayPictureUrl = dayPictureUrl;
    }

    /**
     * @return The nightPictureUrl
     */
    public String getNightPictureUrl() {
        return nightPictureUrl;
    }

    /**
     * @param nightPictureUrl The nightPictureUrl
     */
    public void setNightPictureUrl(String nightPictureUrl) {
        this.nightPictureUrl = nightPictureUrl;
    }

    /**
     * @return The weather
     */
    public String getWeather() {
        return weather;
    }

    /**
     * @param weather The weather
     */
    public void setWeather(String weather) {
        this.weather = weather;
    }

    /**
     * @return The wind
     */
    public String getWind() {
        return wind;
    }

    /**
     * @param wind The wind
     */
    public void setWind(String wind) {
        this.wind = wind;
    }

    /**
     * @return The temperature
     */
    public String getTemperature() {
        return temperature;
    }

    /**
     * @param temperature The temperature
     */
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

}
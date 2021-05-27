package com.example.springboot.web.externapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    private Weather[] weather;
    private Main main;
    private Sys sys;
    private String name;

    public WeatherResponse() {}

    public WeatherResponse(Weather[] weather) {
        this.weather = weather;
    }

    public WeatherResponse(Weather[] weather, Main main) {
        this.weather = weather;
        this.main = main;
    }

    public WeatherResponse(Weather[] weather, Main main, Sys sys) {
        this.weather = weather;
        this.main = main;
        this.sys = sys;
    }

    public WeatherResponse(Weather[] weather, Main main, Sys sys, String name) {
        this.weather = weather;
        this.main = main;
        this.sys = sys;
        this.name = name;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

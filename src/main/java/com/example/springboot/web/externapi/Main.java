package com.example.springboot.web.externapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {

    private double temp;
    private double feels_like;

    public Main() {}

    public int getTemp() {
        int castedTemp = (int) Math.round(temp - 273.15);
        return castedTemp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getFeels_like() {
        int castedTempFeels_like = (int) Math.round(feels_like - 273.15);
        return castedTempFeels_like;
    }

    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }
}

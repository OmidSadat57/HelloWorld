package com.example.springboot.web.externapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class WeatherApiController {

    private final String API_URL = "http://api.openweathermap.org/data/2.5/weather" + "?appid=";

    @Autowired
    private Environment env;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/fetchWeatherData")
    public String zeigeWetterDatenNeuP(@RequestParam(value = "cityName") String cityName, Model model) {
        String cName = cityName;
        WeatherResponse weatherResponse = restTemplate.getForObject(
                API_URL + env.getProperty("API_KEY") + "&q=" + cName, WeatherResponse.class);
        model.addAttribute("weatherResponse", weatherResponse);
        return "weatherdataresult";
    }
}

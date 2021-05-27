package com.example.springboot.web;

import com.example.springboot.persistence.WunschStadtEntity;
import com.example.springboot.service.WunschStadtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WunschStadtWebController {

    @Autowired
    private WunschStadtService wunschStadtService;

    @GetMapping("/getCities")
    public String getAllCities(Model model) {
        List<WunschStadtEntity> wunschStadtEntities = wunschStadtService.findAllCities();
        model.addAttribute("wunschStadtEntities", wunschStadtEntities);
        return "wunschstadttabelle";
    }

    @GetMapping("/getCities1")
    public String getAllCities1(Model model) {
        List<WunschStadtEntity> wunschStadtEntities = wunschStadtService.findAllCities();
        model.addAttribute("wunschStadtEntities", wunschStadtEntities);
        return "test";
    }

    @PostMapping("/createcity")
    public String createCity(@ModelAttribute WunschStadtEntity wunschStadtEntity, Model model) {
        wunschStadtService.save(wunschStadtEntity);
        model.addAttribute("wunschStadtEntity", wunschStadtEntity);
        return "gespeichertestadt";
    }

    @PostMapping("/createcity1")
    public String createCity1(@RequestParam(value = "cityName") String cityName,
                              @RequestParam(value = "urlaubsWunsch") String urlaubsWunsch,
                              Model model) {
        WunschStadtEntity wunschStadtEntity = new WunschStadtEntity();
        wunschStadtEntity.setStadtName(cityName);
        wunschStadtEntity.setUrlaubsWunsch(urlaubsWunsch);
        wunschStadtService.save(wunschStadtEntity);
        model.addAttribute("wunschStadtEntity", wunschStadtEntity);
        return "gespeichertestadt";
    }

    @GetMapping("/createCityForm")
    public String createCityForm(Model model) {
        model.addAttribute("wunschStadtEntity", new WunschStadtEntity());
        return "stadtspeichern";
    }

    @GetMapping("/createCityForm1")
    public String createCityForm1(@RequestParam(value = "cityName") String cityName, Model model) {
        WunschStadtEntity wunschStadtEntity = new WunschStadtEntity();
        wunschStadtEntity.setStadtName(cityName);
        model.addAttribute("wunschStadtEntity", wunschStadtEntity);
        return "stadtspeichern";
    }

}

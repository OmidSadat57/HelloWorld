package com.example.springboot.web;

import com.example.springboot.persistence.WunschStadtEntity;
import com.example.springboot.service.WunschStadtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
//    @GetMapping(path = Endpoints.GETCITIES)
//    public ModelAndView getAllCities() {
//        List<WunschStadtEntity> wunschStadtEntities = wunschStadtService.findAllCities();
//        model.addAttribute("wunschStadtEntities", wunschStadtEntities);
//        return new ModelAndView(ViewNames.TEST);
//    }

    @PostMapping("/createcity")
    public String createCity(@ModelAttribute WunschStadtEntity wunschStadtEntity, Model model) {
        wunschStadtService.save(wunschStadtEntity);
        model.addAttribute("wunschStadtEntity", wunschStadtEntity);
        return "gespeichertestadt";
    }

    @GetMapping("/createCityForm")
    public String createCity(Model model) {
        model.addAttribute("wunschStadtEntity", new WunschStadtEntity());
        return "stadtspeichern";
    }
//
//    @GetMapping("/cities/count")
//    public String count() {
//
//        long anzahlDatensetze = wunschStadtService.count();
//        String anzahlDatensetzeString = String.valueOf(anzahlDatensetze);
//        String nachrichtImBrowser = "Anzhl der verfügbaren Datensätze in der Datenbank: [ " + anzahlDatensetzeString + " ]";
//        return nachrichtImBrowser;
//    }
}

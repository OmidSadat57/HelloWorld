package com.example.springboot;

import com.example.springboot.persistence.WunschStadtEntity;
import com.example.springboot.service.WunschStadtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WunschStadtRestController {

    @Autowired
    private WunschStadtService wunschStadtService;

    @RequestMapping("/")
    public List<WunschStadtEntity> showAllCities() {
        return wunschStadtService.findAllCities();
    }

    @RequestMapping("/getCities")
    public List<WunschStadtEntity> getAllCities() {
        return wunschStadtService.findAllCities();
    }

    @PostMapping("/createCity")
    public WunschStadtEntity createCity(@RequestBody WunschStadtEntity wunschStadt) {
        return wunschStadtService.save(wunschStadt);
    }

    @GetMapping("/cities/count")
    public String count() {

        long anzahlDatensetze = wunschStadtService.count();
        String anzahlDatensetzeString = String.valueOf(anzahlDatensetze);
        String nachrichtImBrowser = "Anzhl der verfügbaren Datensätze in der Datenbank: [ " + anzahlDatensetzeString + " ]";
        return nachrichtImBrowser;
    }

//    @RequestMapping(path = "/cities")
   /* @GetMapping("/cities")
    public ResponseEntity<List<WunschStadtEntity>> getAllCities() {
//        var cities = WunschStadtService.fetchAllCities();
//        return ResponseEntity.ok(cities);
        return wunschStadtRepository.findAll();
    }*/

    /*@GetMapping("/city/{id}")
    public ResponseEntity<WunschStadtEntity> getCityById(@PathVariable(value = "id") Long cityId)
            throws Exception {
        WunschStadtEntity wunschStadt =
                wunschStadtService
                        .findById(cityId)
                        .orElseThrow(() -> new Exception("City not found on :: " + cityId));
        return ResponseEntity.ok().body(wunschStadt);
    }*/
}

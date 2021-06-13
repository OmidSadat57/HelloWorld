package com.example.springboot;

import com.example.springboot.persistence.WunschStadtEntity;
import com.example.springboot.service.WunschStadtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WunschStadtRestController {

    @Autowired
    private WunschStadtService wunschStadtService;
//
//    @RequestMapping("/")
//    public List<WunschStadtEntity> showAllCities() {
//        return wunschStadtService.findAllCities();
//    }
//
    @GetMapping("/getCitiesJson")
    public List<WunschStadtEntity> getAllCities(@AuthenticationPrincipal OidcUser user) {
        return wunschStadtService.findAllCities(user.getEmail());
    }
//
    @PostMapping("/saveCityJson")
    public WunschStadtEntity createCity(@AuthenticationPrincipal OidcUser user,
                                        @RequestBody WunschStadtEntity wunschStadt) {
        wunschStadt.setOwner(user.getEmail());
        return wunschStadtService.save(wunschStadt);
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

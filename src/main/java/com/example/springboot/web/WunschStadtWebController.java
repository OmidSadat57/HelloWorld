package com.example.springboot.web;

import com.example.springboot.persistence.WunschStadtEntity;
import com.example.springboot.service.WunschStadtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
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

    @GetMapping("/")
    public String sayWelcome() {
        return "welcomepage";
    }

    @GetMapping("/getCities1")
    public String getAllCities1(@AuthenticationPrincipal OidcUser user, Model model) {
        List<WunschStadtEntity> wunschStadtEntities = wunschStadtService.findAllCities(user.getEmail());
        model.addAttribute("wunschStadtEntities", wunschStadtEntities);
        return "welcomepage";
    }

    @GetMapping("/getCities2")
    public String getAllCities2(@AuthenticationPrincipal OidcUser user, Model model) {
        return "stadtspeicherndynamisch";
    }

    @PostMapping("/createcity")
    public String createCity(@ModelAttribute WunschStadtEntity wunschStadtEntity,
                             @AuthenticationPrincipal OidcUser user, Model model) {
        wunschStadtEntity.setOwner(user.getEmail());
        wunschStadtService.save(wunschStadtEntity);
        model.addAttribute("wunschStadtEntity", wunschStadtEntity);
        return "gespeichertestadt";
    }

    @PostMapping("/createcity1")
    public String createCity1(@RequestParam(value = "cityName") String cityName,
                              @RequestParam(value = "urlaubsWunsch") String urlaubsWunsch,
                              @AuthenticationPrincipal OidcUser user,
                              Model model) {
        WunschStadtEntity wunschStadtEntity = new WunschStadtEntity();
        wunschStadtEntity.setOwner(user.getEmail());
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

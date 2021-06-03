package com.example.springboot.service;

import com.example.springboot.persistence.WunschStadtEntity;
import com.example.springboot.persistence.WunschStadtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WunschStadtService {

    @Autowired
    private WunschStadtRepository wunschStadtRepository;

    public List<WunschStadtEntity> findAllCities(String user) {
        var iterator = wunschStadtRepository.findAll();
        var wunschStaedte = new ArrayList<WunschStadtEntity>();
//        iterator.forEach(wunschStaedte::add);
        for(WunschStadtEntity entity : iterator) {
            if(entity.getOwner()!=null && entity.getOwner().equals(user)) {
                wunschStaedte.add(entity);
            }
        }
        return wunschStaedte;
    }

    public Long count() {
        return wunschStadtRepository.count();
    }

    public void deleteById(Long stadtId) {

        wunschStadtRepository.deleteById(stadtId);
    }

    public WunschStadtEntity save(WunschStadtEntity wunschStadt) {
        return wunschStadtRepository.save(wunschStadt);
    }

}

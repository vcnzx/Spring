package com.charlie.dojo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charlie.dojo.models.Ninja;
import com.charlie.dojo.repositories.NinjaRepository;

@Service
public class NinjaService {
    
    @Autowired NinjaRepository ninjaRepository;

    //! CREATE
    public void createNinja(Ninja ninja){
        ninjaRepository.save(ninja);
    }
}

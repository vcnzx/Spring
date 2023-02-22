package com.charlie.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.charlie.dojo.models.Dojo;
import com.charlie.dojo.models.Ninja;
import com.charlie.dojo.repositories.DojoRepository;

@Service
public class DojoService{

    @Autowired DojoRepository dojoRepository;

    //! CREATE
	public void createDojo(Dojo dojo) {
        dojoRepository.save(dojo);
	}

    public List<Dojo> listAll() {
        return dojoRepository.findAll();
    }

    //! READ
    public Dojo getOneDojo(Long id){
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        return optionalDojo.orElse(null);
    }

    
}

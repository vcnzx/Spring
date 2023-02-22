package com.charlie.dojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.charlie.dojo.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long>{
    List<Dojo> findAll();

    
}

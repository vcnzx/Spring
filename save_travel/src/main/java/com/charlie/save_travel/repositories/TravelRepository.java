package com.charlie.save_travel.repositories;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

import com.charlie.save_travel.models.Travel;

public interface TravelRepository extends CrudRepository<Travel, Long> {

    List<Travel> findAll();
    
}

package com.charlie.books.repositories;

import org.springframework.data.repository.CrudRepository;

import com.charlie.books.models.Buk;
import java.util.List;

public interface BukRepository extends CrudRepository<Buk, Long>{

    List<Buk> findAll();
    
}

package com.charlie.books.repositories;

import org.springframework.data.repository.CrudRepository;

import com.charlie.books.models.Book;
import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long>{

    List<Book> findAll();
    
}

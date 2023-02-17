package com.charlie.books.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.charlie.books.services.BukService;

import com.charlie.books.models.Buk;;

@RestController
public class BooksApi {
    
    @Autowired BukService bukService;

    // private final BukService bukService;
    // public BooksApi(BukService bukService){
    //     this.bukService = bukService;
    // }

    @RequestMapping("/api/books")
    public List<Buk> booksApi(){
        List<Buk> books = bukService.allBooks();
        return books;
    }
}

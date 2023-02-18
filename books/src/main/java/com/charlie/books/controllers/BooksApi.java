package com.charlie.books.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.charlie.books.services.BookService;

import com.charlie.books.models.Book;;

@RestController
public class BooksApi {
    
    @Autowired BookService bookService;

    // private final BukService bukService;
    // public BooksApi(BukService bukService){
    //     this.bukService = bukService;
    // }

    @RequestMapping("/api/books")
    public List<Book> booksApi(){
        List<Book> books = bookService.allBooks();
        return books;
    }
}

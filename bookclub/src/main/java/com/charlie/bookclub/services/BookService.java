package com.charlie.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charlie.bookclub.models.Book;
import com.charlie.bookclub.repositories.BookRepository;

@Service
public class BookService {
    //! Connect service to repo
    @Autowired BookRepository bookRepo;


    //! CREATE
    public void addBook(Book book){
        bookRepo.save(book);
    }

    //! READ ALL
    public List<Book> getAll(){
        return bookRepo.findAll();
    }

    //! READ ONE
    public Book getOne(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        return optionalBook.orElse(null);
    }

    //! UPDATE ONE
    public void updateBook(Book book){
        bookRepo.save(book);
    }

    //! DELETE
    public void deleteBook(Long id){
        bookRepo.deleteById(id);
    }
}

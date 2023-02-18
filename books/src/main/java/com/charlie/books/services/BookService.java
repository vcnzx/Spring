package com.charlie.books.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

import com.charlie.books.repositories.BookRepository;
import com.charlie.books.models.Book;

@Service //MAKES A FILE A SERVICE IN SPRING
public class BookService { //SERVICE CONTAINS BUSINESS LOGIC
    //CONNECTION TO REPO
    @Autowired BookRepository bookRepository;

    //! CREATE
    public void createBook(Book book){
        bookRepository.save(book);
    }


    //! READ ALL
    public List<Book> allBooks(){
        return bookRepository.findAll();
    }

    //! READ ONE
    public Book getOneBook(Long id){
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }

    //! UPDATE

    //! DELETE

}

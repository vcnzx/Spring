package com.charlie.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.charlie.bookclub.models.Book;
import com.charlie.bookclub.services.BookService;

@Controller
public class BookController {
    
    //! CONNECT CONTROLLER TO SERVICE
    @Autowired BookService bookService;

    //! CREATE BOOK
    @GetMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book){
        return "books/new.jsp";
    }

    @PostMapping("/books")
    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult results){
        if(results.hasErrors()){
            return "books/new.jsp";
        }
        else{            
            bookService.addBook(book);
            return "redirect:/books";
        }
    }

    //! READ ALL BOOKS
    @GetMapping("/books")
    public String dashboard(HttpSession session,Model model){
        List<Book> books = bookService.getAll();
        if(session.getAttribute("userId") == null){
            return "redirect:/logout";
        }
        model.addAttribute("books", books);
        return "/books/welcome.jsp";
    }



    //! READ ONE BOOK
    @GetMapping("/books/{id}") //does this not matter?
    public String show(@PathVariable("id")Long id, Model model, HttpSession session){
        if(session.getAttribute("userId") == null){
            return "redirect:/logout";
        }
        Book book = bookService.getOne(id);
        model.addAttribute("book", book);
        return "/books/show.jsp";
    }

    //! EDIT BOOK
    @GetMapping("/books/edit/{id}")
    public String edit(@PathVariable("id")Long id, Model model, HttpSession session){
        if(session.getAttribute("userId") == null){
            return "redirect:/logout";
        }
        Book book = bookService.getOne(id);
        model.addAttribute("book", book);
        return "/books/edit.jsp";
    }

    @PutMapping("/books/{id}") //does this not matter?
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult results){
        if(results.hasErrors()){
            return "/books/edit.jsp";
        }
        else {
            bookService.updateBook(book);
            return "redirect:/books";
        }
    }

    @DeleteMapping("/books/delete/{id}")
    public String delete(@PathVariable("id")Long id){
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}

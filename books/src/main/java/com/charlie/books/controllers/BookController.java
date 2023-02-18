package com.charlie.books.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import com.charlie.books.models.Book;
import com.charlie.books.services.BookService;

@Controller
public class BookController {
    
    //connect to service
    @Autowired BookService bookService;

    //! Create
    @RequestMapping("books/new")
    public String newBook(@ModelAttribute("book") Book book){
        return "new.jsp";
    }

    @RequestMapping(value="/books", method=RequestMethod.POST)
    public String createBook(
        // @RequestParam("title") String title,
        // @RequestParam("author") String author,
        // @RequestParam("pages") Integer pages,
        // HttpSession session,
        @ModelAttribute("book") Book book
        ){
        // Book newBook = new Book(title, author, pages);
        bookService.createBook(book);
        // session.setAttribute("title", title);
        // session.setAttribute("author", author);
        // session.setAttribute("pages", pages);
        return "redirect:/";
    }
    //! Read All
    @RequestMapping("/")
    public String index(Model model){
        List<Book> books = bookService.allBooks();
        System.out.println(books);
        model.addAttribute("books", books);
        return "index.jsp";
    }

    //! Read One
    @GetMapping("/books/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        Book book = bookService.getOneBook(id);
        model.addAttribute("book", book);
        return "show.jsp";
    }
    //! Update

    //! Delete

}

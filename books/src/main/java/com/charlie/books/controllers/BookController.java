package com.charlie.books.controllers;

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
import org.springframework.web.bind.annotation.PutMapping;
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
        @Valid @ModelAttribute("book") Book book, BindingResult result
        ){
        // Book newBook = new Book(title, author, pages);
        if(result.hasErrors()){
            return "new.jsp";
        }
        else {
            bookService.createBook(book);
            // session.setAttribute("title", title);
            // session.setAttribute("author", author);
            // session.setAttribute("pages", pages);
            return "redirect:/";
        }
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
    @GetMapping("/books/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        Book book = bookService.getOneBook(id);
        model.addAttribute("book", book);
        return "edit.jsp";
    }

    @PutMapping("/books/{id}")
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result){
        if(result.hasErrors()){
            return "edit.jsp";
        }
        else{
            bookService.updateBook(book);
            return "redirect:/";
        }
        
    }

    //! Delete
    @DeleteMapping("/books/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        Book book = bookService.getOneBook(id);
        bookService.deleteBookById(book);
        return "redirect:/";
    }

}

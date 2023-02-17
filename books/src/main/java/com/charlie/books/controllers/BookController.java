package com.charlie.books.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import com.charlie.books.models.Buk;
import com.charlie.books.services.BukService;

@Controller
public class BookController {
    
    //connect to service
    @Autowired BukService bukservice;

    //! Create
    @RequestMapping("books/new")
    public String newBook(){
        return "new.jsp";
    }

    @RequestMapping(value="/books", method=RequestMethod.POST)
    public String createBook(
        @RequestParam("title") String title,
        @RequestParam("author") String author,
        @RequestParam("pages") Integer pages,
        HttpSession session
        ){
        // session.setAttribute("title", title);
        // session.setAttribute("author", author);
        // session.setAttribute("pages", pages);
        return "redirect:/";
    }
    //! Read All
    @RequestMapping("/")
    public String index(Model model){
        List<Buk> books = bukservice.allBooks();
        System.out.println(books);
        model.addAttribute("books", books);
        return "index.jsp";
    }

    //! Read One

    //! Update

    //! Delete

}

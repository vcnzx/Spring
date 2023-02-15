package com.charlie.omikuji.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;

@Controller
public class OmikujiController {
    @GetMapping("/")
    public String index(){
        return "index.jsp";
    }

    @PostMapping("/process")
    public String process(
            @RequestParam(value="number") Integer number, 
            @RequestParam(value="city") String city,
            @RequestParam(value="name") String name,
            @RequestParam(value="hobby") String hobby,
            @RequestParam(value="animal") String animal,
            @RequestParam(value="message") String message,
            HttpSession session
            ){
        session.setAttribute("number",number);
        session.setAttribute("city",city);
        session.setAttribute("name", name);
        session.setAttribute("hobby", hobby);
        session.setAttribute("animal", animal);
        session.setAttribute("message", message);
        return "redirect:/show";
    }

    @GetMapping("/show")
    public String show(){
        return "show.jsp";
    }
}

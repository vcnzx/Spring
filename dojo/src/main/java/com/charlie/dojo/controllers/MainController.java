package com.charlie.dojo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.charlie.dojo.models.Dojo;
import com.charlie.dojo.models.Ninja;
import com.charlie.dojo.services.DojoService;
import com.charlie.dojo.services.NinjaService;

@Controller
public class MainController {
    
    @Autowired DojoService dojoService;
    @Autowired NinjaService ninjaService;

    //! CREATE
    // Dojo
    @RequestMapping(value={"/dojos/new", "/"})
    public String newDojo(@ModelAttribute("dojo") Dojo dojo, Model model){
        List<Dojo> dojos = dojoService.listAll();
        model.addAttribute("dojos", dojos);
        return "dojos/new.jsp";
    }

    @PostMapping("/dojos")
    public String createDojo(@ModelAttribute("dojo") Dojo dojo){
        dojoService.createDojo(dojo);
        return "redirect:/";
    }

    // Ninja
    @GetMapping("/ninjas/new")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model){
        List<Dojo> dojos = dojoService.listAll();
        model.addAttribute("dojos", dojos);
        return "ninjas/new.jsp";
    }

    @PostMapping("/ninjas")
    public String createNinja(@ModelAttribute("ninja") Ninja ninja){
        ninjaService.createNinja(ninja);
        return "redirect:/";
    }

    //! READ
    @GetMapping("/dojos/{id}")
    public String showDojo(@PathVariable("id") Long id, Model model){
        Dojo dojo = dojoService.getOneDojo(id);
        model.addAttribute("dojo", dojo);
        return "dojos/show.jsp";
    }
}

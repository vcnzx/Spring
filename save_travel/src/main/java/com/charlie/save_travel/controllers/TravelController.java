package com.charlie.save_travel.controllers;

import javax.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.BindingResult;

import com.charlie.save_travel.models.Travel;
import com.charlie.save_travel.services.TravelServices;

@Controller
public class TravelController {

    @Autowired TravelServices travelService;


    //! Create
    @GetMapping("expenses/new")
    public String newExpenses(@ModelAttribute("expenses") Travel expenses){
        return "new.jsp";
    }
    @PostMapping("/expenses")
    public String newExpense(

        @Valid @ModelAttribute("expenses") Travel expenses, BindingResult result
        ){

        if(result.hasErrors()){
            return "new.jsp";
        }
        else {
            travelService.createExpense(expenses);

            return "redirect:/";
        }
        }

    //! Read All
    @GetMapping("/")
    public String index(Model model){
        List<Travel> expenses = travelService.allExpenses();
        model.addAttribute("expenses", expenses);
        return "index.jsp";
    }

    //! Read One
    @GetMapping("/expenses/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        Travel expense = travelService.getOne(id);
        model.addAttribute("expense", expense);
        return "show.jsp";
    }

    //! Update
    @GetMapping("/expenses/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        Travel expenses = travelService.getOne(id);
        model.addAttribute("expenses", expenses);
        return "edit.jsp";
    }

    @PutMapping("/expenses/{id}")
    public String update(@Valid @ModelAttribute("expenses") Travel expenses, BindingResult result){
        if(result.hasErrors()){
            return "edit.jsp";
        }
        else{
            travelService.updateExpense(expenses);
            return "redirect:/";
        }
    }

    //! Delete
    @DeleteMapping("/expenses/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        Travel expense = travelService.getOne(id);
        travelService.deleteExpenseById(expense);
        return "redirect:/";
    }
}

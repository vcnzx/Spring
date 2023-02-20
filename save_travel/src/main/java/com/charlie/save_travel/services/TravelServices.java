package com.charlie.save_travel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charlie.save_travel.repositories.TravelRepository;
import com.charlie.save_travel.models.Travel;

@Service
public class TravelServices {
    
    @Autowired TravelRepository travelRepository;

    //! CREATE
    public void createExpense(Travel expense){
        travelRepository.save(expense);
    }

    //! READ ALL
    public List<Travel> allExpenses(){
        return travelRepository.findAll();
    }

    //! READ ONE
    public Travel getOne(Long id){
        Optional<Travel> optionalExpense = travelRepository.findById(id);
        return optionalExpense.orElse(null);
    }

    //! UPDATE
    public void updateExpense(Travel expense) {
        travelRepository.save(expense);
    }

    //! DELETE
    public void deleteExpenseById(Travel expense) {
        travelRepository.delete(expense);
    }
}

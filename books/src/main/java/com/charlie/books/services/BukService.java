package com.charlie.books.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.charlie.books.repositories.BukRepository;
import com.charlie.books.models.Buk;

@Service //MAKES A FILE A SERVICE IN SPRING
public class BukService { //SERVICE CONTAINS BUSINESS LOGIC
    //CONNECTION TO REPO
    @Autowired BukRepository bukRepository;

    //! CREATE

    //! READ ALL
    public List<Buk> allBooks(){
        return bukRepository.findAll();
    }

    //! UPDATE

    //! DELETE

}

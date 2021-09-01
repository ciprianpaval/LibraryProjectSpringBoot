package com.example.demo.service;

import com.example.demo.model.Rental;
import com.example.demo.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {
    @Autowired
    RentalRepository rentalRepository;
    @Autowired
    ClientService clientService;
    @Autowired
    BookService bookService;
    @Autowired
    ComicBookService comicBookService;

    public List<Rental> getAll(){
        return rentalRepository.findAll();
    }

}

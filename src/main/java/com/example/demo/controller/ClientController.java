package com.example.demo.controller;

import com.example.demo.dto.ClientDto;
import com.example.demo.model.Client;
import com.example.demo.service.ClientService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;
    @GetMapping("/client")
    public List<Client> get(){
        return clientService.get();
    }
    @GetMapping("/client/{id}")
    public ResponseEntity getId(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(clientService.getId(id));
        }
        catch (NotFoundException e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/clientByFirstName/{firstname}")
    public ResponseEntity getByFirstName(@PathVariable String firstname){
        try {
            return ResponseEntity.ok(clientService.getByFirstName(firstname));
        }
        catch (NotFoundException e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/clientByLastName/{lastname}")
    public ResponseEntity getByLastName(@PathVariable String lastname){
        try {
            return ResponseEntity.ok(clientService.getByLastName(lastname));
        }
        catch (NotFoundException e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/clientByEmail/{email}")
    public ResponseEntity getByEmail(@PathVariable String email){
        try {
            return ResponseEntity.ok(clientService.getByEmail(email));
        }
        catch (NotFoundException e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/client")
    Client createNewClient(@RequestBody Client newClient) {
        return clientService.add(newClient, newClient.getFirstname(),newClient.getLastname(),newClient.getEmail());
    }
    @PutMapping("client/{id}")
    ResponseEntity updateClient(@RequestBody ClientDto clientDto, @PathVariable Integer id){
        try{
            return ResponseEntity.ok(clientService.update(id,clientDto.getFirstname(),clientDto.getLastname(),clientDto.getEmail()));
        }
        catch (EntityNotFoundException e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("client/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id){
        try{
            clientService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        catch (EmptyResultDataAccessException e)
        {
            return ResponseEntity.notFound().build();
        }
    }

}

package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.model.Client;
import com.example.demo.model.Rental;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.RentalRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private BookService bookService;
    @Autowired
    private RentalRepository rentalRepository;

    public void insert(Client client){
        clientRepository.save(client);
    }
    public List<Client> get(){
        return clientRepository.findAll();
    }
    public List<Client> getId(Integer id) throws NotFoundException
    {
        List<Client> clients = clientRepository.findById(id).stream().toList();
        if(clients.isEmpty())
        {
            throw new NotFoundException("404");
        }
        else
        {
            return clients;
        }
    }
    public List<Client> getByFirstName(String firstname) throws NotFoundException
    {
        List<Client> clients = clientRepository.findClientByFirstName(firstname).stream().toList();
        if(clients.isEmpty())
        {
            throw new NotFoundException("404");
        }
        else
        {
            return clients;
        }
    }
    public List<Client> getByLastName(String lastname) throws NotFoundException
    {
        List<Client> clients = clientRepository.findClientByLastName(lastname).stream().toList();
        if(clients.isEmpty())
        {
            throw new NotFoundException("404");
        }
        else
        {
            return clients;
        }
    }
    public List<Client> getByEmail(String email) throws NotFoundException
    {
        List<Client> clients = clientRepository.findClientByEmail(email).stream().toList();
        if(clients.isEmpty())
        {
            throw new NotFoundException("404");
        }
        else
        {
            return clients;
        }
    }
    public Client add(Client client,String firstname,String lastname,String email){
        client.setFirstname(firstname);
        client.setLastname(lastname);
        client.setEmail(email);
        client = clientRepository.save(client);
        return  client;
    }
    public Client update(Integer id, String firsname, String lastname, String email)
    {
        Client updateclient= clientRepository.getOne(id);
        updateclient.setFirstname(firsname);
        updateclient.setLastname(lastname);
        updateclient.setEmail(email);
        updateclient=clientRepository.save(updateclient);
        return updateclient;
    }
    public void deleteById(Integer id){
        clientRepository.deleteById(id);
    }

    public List<Client> sortName() throws NotFoundException{
        List<Client> client = clientRepository.sortByName().stream().toList();
        if(client.isEmpty())
        {
            throw new NotFoundException("404");
        }
        else
        {
            return client;
        }
    }
    public boolean rentabook(String title, Integer idClient,String rented_date, String returned_date) throws NotFoundException {
        try {
            List<Book> books = bookService.getTitle(title);
            Book book = books.get(0);
            bookService.deletebyid(book.getId());
            Rental rental = new Rental(rented_date,returned_date, book.getId(),clientRepository.getById(idClient));
            rentalRepository.save(rental);
            return true;

        }
        catch (NotFoundException e)
        {
            throw new NotFoundException("404");
        }
    }

}

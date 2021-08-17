package com.example.demo.repository;

import com.example.demo.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Integer> {
    @Query("select c from Client c where c.firstname=:firstname")
    public List<Client> findClientByFirstName(@Param("firstname")String firstname);
    @Query("select c from Client c where c.lastname=:lastname")
    public List<Client> findClientByLastName(@Param("lastname")String lastname);
    @Query("select c from Client c where c.email=:email")
    public List<Client> findClientByEmail(@Param("email")String email);

}

package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="rentals")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    @Column(name="rented_date")
    private String rented_date;
    @Column(name="returned_date")
    private String returned_date;
    @Column(name="item_id")
    private Integer item_id;
    @ManyToOne
    @JoinColumn (name="client_id")
    private Client client;


    public Rental(String rented_date, String returned_date, Integer item_id, Client client) {
        this.rented_date = rented_date;
        this.returned_date = returned_date;
        this.item_id = item_id;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Rental() {
    }

    public Rental( String rented_date, String returned_date) {
        this.rented_date = rented_date;
        this.returned_date = returned_date;
    }

    public Integer getId() {
        return id;
    }


    public String getRented_date() {
        return rented_date;
    }

    public void setRented_date(String rented_date) {
        this.rented_date = rented_date;
    }

    public String getReturned_date() {
        return returned_date;
    }

    public void setReturned_date(String returned_date) {
        this.returned_date = returned_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return Objects.equals(id, rental.id) && Objects.equals(rented_date, rental.rented_date) && Objects.equals(returned_date, rental.returned_date) && Objects.equals(client, rental.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rented_date, returned_date, client);
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", rented_date='" + rented_date + '\'' +
                ", returned_date='" + returned_date + '\'' +
                ", client=" + client +
                '}';
    }
}

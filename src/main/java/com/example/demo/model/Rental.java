package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="rental")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    @Column(name="item_id")
    private Integer item_id;
    @Column(name="client_id")
    private Integer client_id;
    @Column(name="rented_date")
    private String rented_date;
    @Column(name="returned_date")
    private String returned_date;

    public Rental() {
    }

    public Rental(Integer id, Integer item_id, Integer client_id, String rented_date, String returned_date) {
        this.id = id;
        this.item_id = item_id;
        this.client_id = client_id;
        this.rented_date = rented_date;
        this.returned_date = returned_date;
    }

    public Integer getId() {
        return id;
    }


    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
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
        return Objects.equals(id, rental.id) && Objects.equals(item_id, rental.item_id) && Objects.equals(client_id, rental.client_id) && Objects.equals(rented_date, rental.rented_date) && Objects.equals(returned_date, rental.returned_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, item_id, client_id, rented_date, returned_date);
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", item_id=" + item_id +
                ", client_id=" + client_id +
                ", rented_date='" + rented_date + '\'' +
                ", returned_date='" + returned_date + '\'' +
                '}';
    }
}

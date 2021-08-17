package com.example.demo.dto;

import java.util.Objects;

public class ClientDto {
    private String firstname;
    private String lastname;
    private String email;

    public ClientDto() {
    }

    public ClientDto(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDto clientDto = (ClientDto) o;
        return Objects.equals(firstname, clientDto.firstname) && Objects.equals(lastname, clientDto.lastname) && Objects.equals(email, clientDto.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, email);
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

package com.example.demo.dto;

import java.util.Objects;

public class RentInfo {
    private String rent_date;
    private String return_date;
    private String bookTitle;

    public String getRent_date() {
        return rent_date;
    }

    public void setRent_date(String rent_date) {
        this.rent_date = rent_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public RentInfo() {
    }

    public RentInfo(String rent_date, String return_date, String bookTitle) {
        this.rent_date = rent_date;
        this.return_date = return_date;
        this.bookTitle = bookTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentInfo rentInfo = (RentInfo) o;
        return Objects.equals(rent_date, rentInfo.rent_date) && Objects.equals(return_date, rentInfo.return_date) && Objects.equals(bookTitle, rentInfo.bookTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rent_date, return_date, bookTitle);
    }

    @Override
    public String toString() {
        return "RentInfo{" +
                "rent_date='" + rent_date + '\'' +
                ", return_date='" + return_date + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                '}';
    }
}

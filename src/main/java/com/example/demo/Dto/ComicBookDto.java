package com.example.demo.Dto;

import java.util.Objects;

public class ComicBookDto {
    private String series;
    private Integer number;

    public ComicBookDto() {
    }

    public ComicBookDto(String series, Integer number) {
        this.series = series;
        this.number = number;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComicBookDto that = (ComicBookDto) o;
        return Objects.equals(series, that.series) && Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(series, number);
    }

    @Override
    public String toString() {
        return "ComicBookDto{" +
                "series='" + series + '\'' +
                ", number=" + number +
                '}';
    }
}

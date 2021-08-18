package com.example.demo.controller;

import com.example.demo.dto.ComicBookDto;
import com.example.demo.model.ComicBook;
import com.example.demo.service.ComicBookService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
public class ComicBookController {
    @Autowired
    private ComicBookService ComicbookService;
    @GetMapping("/comicbooks")
    public List<ComicBook> get(){
        return ComicbookService.get();
    }
    @GetMapping("/comicbooks/{id}")
    public ResponseEntity getId(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(ComicbookService.getId(id));
        }
        catch (NotFoundException e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/comicbooksBySeries/{series}")
    public ResponseEntity getSeries(@PathVariable String series){
        try {
            return ResponseEntity.ok(ComicbookService.getSeries(series));
        }
        catch (NotFoundException e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/comicbooksByNumbers/{numbers}")
    public ResponseEntity getNumbers(@PathVariable Integer numbers){
        try {
            return ResponseEntity.ok(ComicbookService.getNumbers(numbers));
        }
        catch (NotFoundException e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/comicbooks")
    ComicBook createNewComicBook(@RequestBody ComicBook newComicBook) {
        return ComicbookService.add(newComicBook, newComicBook.getSeries(), newComicBook.getNumber());

    }
    @PutMapping("comicbooks/{id}")
    ResponseEntity updateComicBook(@RequestBody ComicBookDto comicBookDto, @PathVariable Integer id){
        try{
            return ResponseEntity.ok(ComicbookService.update(id,comicBookDto.getSeries(),comicBookDto.getNumber()));
        }
        catch (EntityNotFoundException e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/comicbooks/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id){
        try{
            ComicbookService.deletebyid(id);
            return ResponseEntity.ok().build();
        }
        catch (EmptyResultDataAccessException e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/comicbooksBySeries/{series}")
    public ResponseEntity deleteById(@PathVariable String series){
        try{
            ComicbookService.deletebyseries(series);
            return ResponseEntity.ok().build();
        }
        catch (EmptyResultDataAccessException e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/sortByserie")
    public ResponseEntity sortBySerie(){
        try {
            return ResponseEntity.ok(ComicbookService.sortBySerie());
        }
        catch (NotFoundException e)
        {
            return ResponseEntity.notFound().build();
        }
    }
}

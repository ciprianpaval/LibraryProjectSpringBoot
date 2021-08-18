package com.example.demo.controller;

import com.example.demo.dto.BookDto;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController("/")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("books")
    public List<Book> get(){
        return bookService.get();
    }
    @GetMapping("books/{id}")
    public ResponseEntity getId(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(bookService.getId(id));
        }
        catch (NotFoundException e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("booksByTitle/{title}")
    public ResponseEntity getTitle(@PathVariable String title){
        try {
            return ResponseEntity.ok(bookService.getTitle(title));
        }
        catch (NotFoundException e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("booksByAuthor/{author}")
    public ResponseEntity getAthor(@PathVariable String author){
        try {
            return ResponseEntity.ok(bookService.getAuthor(author));
        }
        catch (NotFoundException e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/books")
    Book createNewBook(@RequestBody Book newBook) {
        return bookService.add(newBook, newBook.getTitle(), newBook.getAuthor());

    }
    @PutMapping("books/{id}")
    ResponseEntity updateBook(@RequestBody BookDto bookDto, @PathVariable Integer id){
        try{
            return ResponseEntity.ok(bookService.update(id,bookDto.getTitle(),bookDto.getAuthor()));
        }
        catch (EntityNotFoundException e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("books/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id){
        try{
            bookService.deletebyid(id);
            return ResponseEntity.ok().build();
        }
        catch (EmptyResultDataAccessException e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("sortbooksByTitle")
    public ResponseEntity sortTitle(){
        try {
            return ResponseEntity.ok(bookService.sortTitle());
        }
        catch (NotFoundException e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("sortbooksByAuthor")
    public ResponseEntity sortAuthor(){
        try {
            return ResponseEntity.ok(bookService.sortAuthor());
        }
        catch (NotFoundException e)
        {
            return ResponseEntity.notFound().build();
        }
    }



}

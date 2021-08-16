package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public void insert(Book book){
        bookRepository.save(book);
    }
    public List<Book> get(){
        return bookRepository.findAll();
    }
    public List<Book> getId(Integer id) throws NotFoundException
    {
        List<Book> books = bookRepository.findById(id).stream().toList();
        if(books.isEmpty())
        {
            throw new NotFoundException("404");
        }
        else
        {
            return books;
        }
    }
    public List<Book> getTitle(String title) throws NotFoundException{
        List<Book> books = bookRepository.findBookByTitle(title).stream().toList();
        if(books.isEmpty())
        {
            throw new NotFoundException("404");
        }
        else
        {
            return books;
        }
    }
    public List<Book> getAuthor(String author) throws NotFoundException{
        List<Book> books = bookRepository.findBookByAuthor(author).stream().toList();
        if(books.isEmpty())
        {
            throw new NotFoundException("404");
        }
        else
        {
            return books;
        }
    }
    public Book add(Book book,String title, String author)
    {
        book.setTitle(title);
        book.setAuthor(author);
        book=bookRepository.save(book);
        return book;
    }
    public Book update(Integer id,String title, String author)
    {
        Book updatebook= bookRepository.getOne(id);
        updatebook.setAuthor(author);
        updatebook.setTitle(title);
        updatebook=bookRepository.save(updatebook);
        return updatebook;
    }

    public void deletebyid(Integer id)
    {
        bookRepository.deleteById(id);
    }

}

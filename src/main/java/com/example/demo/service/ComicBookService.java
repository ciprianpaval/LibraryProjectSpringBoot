package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.model.ComicBook;
import com.example.demo.repository.ComicBookRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicBookService {
    @Autowired
    private ComicBookRepository comicBookRepository;
    public void insert(ComicBook comicBook){
        comicBookRepository.save(comicBook);
    }
    public List<ComicBook> get(){
        return comicBookRepository.findAll();
    }
    public List<ComicBook> getId(Integer id) throws NotFoundException
    {
        List<ComicBook> comicbooks = comicBookRepository.findById(id).stream().toList();
        if(comicbooks.isEmpty())
        {
            throw new NotFoundException("404");
        }
        else
        {
            return comicbooks;
        }
    }
    public List<ComicBook> getSeries(String series) throws NotFoundException{
        List<ComicBook> comicbooks = comicBookRepository.findBookBySeries(series).stream().toList();
        if(comicbooks.isEmpty())
        {
            throw new NotFoundException("404");
        }
        else
        {
            return comicbooks;
        }
    }
    public List<ComicBook> getNumbers(Integer number) throws NotFoundException{
        List<ComicBook> comicbooks = comicBookRepository.findBookByNumber(number).stream().toList();
        if(comicbooks.isEmpty())
        {
            throw new NotFoundException("404");
        }
        else
        {
            return comicbooks;
        }
    }
    public ComicBook add(ComicBook comicbook,String series, Integer numbers)
    {
        comicbook.setSeries(series);
        comicbook.setNumber(numbers);
        comicbook=comicBookRepository.save(comicbook);
        return comicbook;
    }
    public ComicBook update(Integer id, String series, Integer number)
    {
        ComicBook updatecomicbook= comicBookRepository.getOne(id);
        updatecomicbook.setSeries(series);
        updatecomicbook.setNumber(number);
        updatecomicbook=comicBookRepository.save(updatecomicbook);
        return updatecomicbook;
    }
    public void deletebyid(Integer id)
    {
        comicBookRepository.deleteById(id);
    }
    public void deletebyseries(String series)
    {
        comicBookRepository.deleteBookBySeries(series);
    }
}

package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book,Integer>, PagingAndSortingRepository<Book,Integer> {
    @Query("select b from Book b where b.title =:title")
    public List<Book> findBookByTitle(@Param("title")String title);
    @Query("select b from Book b where b.author =:author")
    public List<Book> findBookByAuthor(@Param("author")String author);
    @Query("select b from Book b order by b.title")
    public List<Book> findBookBySortTitle();
    @Query("select b from Book b order by b.author")
    public List<Book> findBookBySortAuthor();
}


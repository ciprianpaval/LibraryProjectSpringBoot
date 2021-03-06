package com.example.demo.repository;

import com.example.demo.model.ComicBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ComicBookRepository extends JpaRepository<ComicBook,Integer> {
    @Query("select cb from ComicBook cb where cb.series =:series")
    public List<ComicBook> findBookBySeries(@Param("series")String series);
    @Query("select cb from ComicBook cb where cb.number =:number")
    public List<ComicBook> findBookByNumber(@Param("number")Integer number);
    @Transactional
    @Modifying
    @Query("delete  from ComicBook cb where cb.series =:series")
    public  void deleteBookBySeries(@Param("series")String series);
    @Query("select cb from ComicBook cb order by cb.series,cb.number")
    public List<ComicBook> sortBySerie();
}

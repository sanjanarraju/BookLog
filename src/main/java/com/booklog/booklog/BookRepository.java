package com.booklog.booklog;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBySeriesIsNullOrderByTitleAsc(); // Standalones
    List<Book> findBySeriesIdOrderBySeriesOrderAsc(Long seriesId);
    List<Book> findAllByOrderBySeries_NameAscSeriesOrderAscTitleAsc();
}

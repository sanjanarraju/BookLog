package com.booklog.booklog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookSeriesRepository extends JpaRepository<BookSeries, Long> {
    BookSeries findByName(String name);
}

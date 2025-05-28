package com.booklog.booklog;

import com.booklog.booklog.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {}

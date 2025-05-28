package com.booklog.booklog;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepo;
    private final BookSeriesRepository seriesRepo;

    public BookService(BookRepository bookRepo, BookSeriesRepository seriesRepo) {
        this.bookRepo = bookRepo;
        this.seriesRepo = seriesRepo;
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAllByOrderBySeries_NameAscSeriesOrderAscTitleAsc();
    }

    public List<BookSeries> getAllSeries() {
        return seriesRepo.findAll();
    }

    public Optional<Book> getBook(Long id) {
        return bookRepo.findById(id);
    }

    public Book saveBook(Book book) {
        return bookRepo.save(book);
    }

    public BookSeries saveSeries(BookSeries series) {
        return seriesRepo.save(series);
    }

    public Optional<Book> updateBook(Long id, Book updated) {
        return bookRepo.findById(id).map(existing -> {
            existing.setTitle(updated.getTitle());
            existing.setAuthor(updated.getAuthor());
            existing.setGenre(updated.getGenre());
            existing.setRating(updated.getRating());
            existing.setNotes(updated.getNotes());
            existing.setSeries(updated.getSeries());
            existing.setSeriesOrder(updated.getSeriesOrder());
            return bookRepo.save(existing);
        });
    }

    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }
}

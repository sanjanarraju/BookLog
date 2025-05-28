package com.booklog.booklog;

import com.booklog.booklog.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<Book> getAll() {
        return repo.findAll();
    }

    public Optional<Book> getById(Long id) {
        return repo.findById(id);
    }

    public Book save(Book book) {
        return repo.save(book);
    }

    public Optional<Book> update(Long id, Book book) {
        return repo.findById(id).map(existing -> {
            existing.setTitle(book.getTitle());
            existing.setAuthor(book.getAuthor());
            existing.setGenre(book.getGenre());
            existing.setRating(book.getRating());
            existing.setNotes(book.getNotes());
            return repo.save(existing);
        });
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

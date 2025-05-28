package com.booklog.booklog;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController {
    private final BookService service;
    private final BookSeriesRepository seriesRepo;

    public BookController(BookService service, BookSeriesRepository seriesRepo) {
        this.service = service;
        this.seriesRepo = seriesRepo;
    }

    // --- Series endpoints ---

    @GetMapping("/series")
    public List<BookSeries> getAllSeries() {
        return service.getAllSeries();
    }

    @PostMapping("/series")
    public ResponseEntity<BookSeries> createSeries(@RequestBody BookSeries series) {
        // Prevent duplicate series names
        if (series.getName() == null || series.getName().trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        // Optionally, check for existing series with the same name
        BookSeries existing = seriesRepo.findByName(series.getName());
        if (existing != null) {
            return ResponseEntity.ok(existing);
        }
        return ResponseEntity.ok(service.saveSeries(series));
    }

    // --- Book endpoints ---

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        Optional<Book> book = service.getBook(id);
        return book.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) {
        // Attach series if present
        if (book.getSeries() != null && book.getSeries().getId() != null) {
            BookSeries series = seriesRepo.findById(book.getSeries().getId()).orElse(null);
            if (series == null) {
                return ResponseEntity.badRequest().build(); // Series doesn't exist
            }
            book.setSeries(series);
        } else {
            book.setSeries(null);
            book.setSeriesOrder(null);
        }
        Book saved = service.saveBook(book);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody Book book) {
        // Attach series if present
        if (book.getSeries() != null && book.getSeries().getId() != null) {
            BookSeries series = seriesRepo.findById(book.getSeries().getId()).orElse(null);
            if (series == null) {
                return ResponseEntity.badRequest().build();
            }
            book.setSeries(series);
        } else {
            book.setSeries(null);
            book.setSeriesOrder(null);
        }
        Optional<Book> updated = service.updateBook(id, book);
        return updated.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}

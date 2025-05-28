package com.booklog.booklog;

import com.booklog.booklog.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) {
        return ResponseEntity.ok(service.save(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody Book book) {
        return service.update(id, book)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

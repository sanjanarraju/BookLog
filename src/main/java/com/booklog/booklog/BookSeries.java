package com.booklog.booklog;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BookSeries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "series", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    public BookSeries() {}

    public BookSeries(String name) { this.name = name; }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Book> getBooks() { return books; }
    public void setBooks(List<Book> books) { this.books = books; }
}

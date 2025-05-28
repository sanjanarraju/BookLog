package com.booklog.booklog;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Author is required")
    private String author;

    private String genre;

    @Min(value = 1, message = "Rating must be between 1 and 5")
    @Max(value = 5, message = "Rating must be between 1 and 5")
    private Integer rating;

    @Column(length = 2000)
    private String notes;

    public Book() {}

    public Book(String title, String author, String genre, Integer rating, String notes) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
        this.notes = notes;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}

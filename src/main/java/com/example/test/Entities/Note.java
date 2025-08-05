package com.example.test.Entities;

import com.example.test.Entities.Author;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @NotNull
    private String title;
    
    @Null
    private String content;
    private LocalDateTime createdAt;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "authorId")
    private Author author;

    public Note() {
        this.createdAt = LocalDateTime.now();
    }

    public Note(String title, String content, Author author) {
        this.title = title;
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.author = author;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public Author getAuthor() {
        return author;
    }
}

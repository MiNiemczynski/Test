package com.example.test.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String name;
    
    public Author() {
    }

    public Author(String name) 
    {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}

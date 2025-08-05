package com.example.test.Repositories;

import com.example.test.Entities.Author;
import java.util.*;
import org.springframework.data.repository.Repository;

public interface AuthorRepository extends Repository<Author, Long> {
    Author save(Author author);
    List<Author> findAll();
    Optional<Author> findById(long id);
}
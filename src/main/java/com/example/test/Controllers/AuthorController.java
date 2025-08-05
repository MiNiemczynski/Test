package com.example.test.Controllers;

import com.example.test.Entities.Author;
import com.example.test.Repositories.AuthorRepository;
import java.util.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Api/Authors")
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping
    public Author postAuthor(Author author) {
        return authorRepository.save(author);
    }

    @GetMapping
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Author> getAuthorById(@PathVariable long id) {
        Optional<Author> found = authorRepository.findById(id);
        if (found != null) {
            return found;
        } else {
            throw new NoSuchElementException("Brak autora o id: " + id);
        }
    }
}

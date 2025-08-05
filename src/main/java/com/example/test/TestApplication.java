package com.example.test;

import com.example.test.Entities.*;
import com.example.test.Repositories.*;
import java.util.NoSuchElementException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(AuthorRepository authorRepo, NoteRepository noteRepo) {
        return args -> {
            Author author = new Author("Stephen King");
            authorRepo.save(author);
            
            Note note1 = new Note("Important", "I need to write a book soon", author);            
            Note note2 = new Note("Not so important", "Need to buy milk", author);
            
            noteRepo.save(note1);
            noteRepo.save(note2);
        };
    }
}

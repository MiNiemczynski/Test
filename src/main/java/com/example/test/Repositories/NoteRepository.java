package com.example.test.Repositories;

import com.example.test.Entities.Note;
import java.util.*;
import org.springframework.data.repository.Repository;

public interface NoteRepository extends Repository<Note, Long> {
    Note save(Note note);
    List<Note> findAll();
    Optional<Note> findById(Long id);
    void deleteById(Long id);
}
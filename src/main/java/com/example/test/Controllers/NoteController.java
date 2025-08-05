package com.example.test.Controllers;

import com.example.test.Entities.Author;
import com.example.test.Repositories.NoteRepository;
import com.example.test.Entities.Note;
import java.util.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Api/Notes")
public class NoteController {
    private NoteRepository noteRepository;
    
    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }
    @PostMapping
    public Note postNote(Note note)
    {
        return noteRepository.save(note);
    }
    @GetMapping
    public List<Note> getNotes() {
        return noteRepository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Note> getNoteById(@PathVariable long id) {
        Optional<Note> found = noteRepository.findById(id);
        if (found != null) {
            return found;
        } else {
            throw new NoSuchElementException("Brak notatki o id: " + id);
        }
    }
    @DeleteMapping("/{id}")
    public void deleteNoteById(@PathVariable long id)
    {
        noteRepository.deleteById(id);
    }
}

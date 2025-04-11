package com.afitech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afitech.modele.Etudiant;
import com.afitech.modele.Note;
import com.afitech.modele.User;
import com.afitech.repository.EtudiantRepository;
import com.afitech.repository.NoteRepository;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @GetMapping
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return noteRepository.save(note);
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note noteDetails) {
        Note note = noteRepository.findById(id).orElse(null);
        if (note != null) {
            note.setValeur(noteDetails.getValeur());
            note.setMatiere(noteDetails.getMatiere());
            note.setEtudiant(noteDetails.getEtudiant());
            return noteRepository.save(note);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteRepository.deleteById(id);
    }

    @GetMapping("/etudiant/{etudiantId}")
    public List<Note> getNotesByEtudiant(@PathVariable Long etudiantId) {
        return noteRepository.findByEtudiantId(etudiantId);
    }

    @GetMapping("/etudiant")
    public ResponseEntity<?> getNotesForCurrentEtudiant(Authentication authentication) {
        try {
            if (authentication == null || !(authentication.getPrincipal() instanceof User)) {
                return ResponseEntity.status(401).body("Non authentifié");
            }

            User user = (User) authentication.getPrincipal();
            Etudiant etudiant = etudiantRepository.findByUser(user);

            if (etudiant == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(noteRepository.findByEtudiantId(etudiant.getId()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erreur serveur");
        }
    }
}

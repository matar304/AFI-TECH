package com.afitech.service.impl;

import com.afitech.modele.Note;
import com.afitech.repository.NoteRepository;
import com.afitech.service.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note ajouterNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note modifierNote(Long id, Note note) {
        note.setId(id);
        return noteRepository.save(note);
    }

    @Override
    public List<Note> listerNote(Long id) {
        return noteRepository.findAll();
    }

    @Override
    public List<Note> getNotesByEtudiant(Long etudiantId) {
        return noteRepository.findByEtudiantId(etudiantId);
    }

    @Override
    public Note rechercherNote(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerNote(Long id) {
        noteRepository.deleteById(id);
    }
}

package com.afitech.service.services;

import java.util.List;


import com.afitech.modele.Note;

public interface NoteService {
    Note ajouterNote(Note note);
    Note modifierNote(Long id, Note note);
    List<Note> listerNote(Long id);
    List<Note> getNotesByEtudiant(Long etudiantId);
    Note rechercherNote(Long id);
    void supprimerNote(Long id);
}

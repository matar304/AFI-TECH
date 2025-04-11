package com.afitech.controller;

import com.afitech.modele.Note;
import com.afitech.service.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/notes")
@Tag(name = "Notes")
public class NoteControlleur {
    @Autowired
    private NoteService noteService;

    @PostMapping
    @Operation(summary = "Ajouter une note", description = "Création d'une nouvelle note pour un étudiant")
    @ApiResponse(responseCode = "200", description = "Note créée avec succès")
    @ApiResponse(responseCode = "400", description = "Données invalides")
    public Note ajouterNote(@RequestBody Note note) {
        return noteService.ajouterNote(note);
    }

    @GetMapping("/etudiant/{etudiantId}")
    @Operation(summary = "Obtenir les notes d'un étudiant", description = "Récupération de toutes les notes d'un étudiant")
    @ApiResponse(responseCode = "200", description = "Liste des notes récupérée")
    @ApiResponse(responseCode = "404", description = "Étudiant non trouvé")
    public List<Note> getNotesByEtudiant(@PathVariable Long etudiantId) {
        return noteService.getNotesByEtudiant(etudiantId);
    }
}

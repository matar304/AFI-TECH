package com.afitech.controller;

import com.afitech.modele.Etudiant;
import com.afitech.service.services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/etudiants")
@Tag(name = "Étudiants")
public class EtudiantControlleur {
    @Autowired
    private EtudiantService etudiantService;

    @PostMapping
    @Operation(summary = "Ajouter un étudiant", description = "Création d'un nouvel étudiant")
    @ApiResponse(responseCode = "200", description = "Étudiant créé avec succès")
    @ApiResponse(responseCode = "400", description = "Données invalides")
    public Etudiant ajouterEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.ajouterEtudiant(etudiant);
    }

    @PostMapping("/connexion")
    @Operation(summary = "Authentifier un étudiant", description = "Connexion d'un étudiant avec matricule et mot de passe")
    @ApiResponse(responseCode = "200", description = "Authentification réussie")
    @ApiResponse(responseCode = "401", description = "Authentification échouée")
    public Etudiant authentifier(@RequestParam String matricule, 
                               @RequestParam String motDePasse) {
        return etudiantService.authentifier(matricule, motDePasse);
    }
}

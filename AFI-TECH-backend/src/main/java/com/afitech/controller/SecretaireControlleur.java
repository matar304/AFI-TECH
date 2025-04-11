package com.afitech.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.afitech.modele.Secretaire;
import com.afitech.service.services.SecretaireService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/secretaires")
@Tag(name = "Gestion des secrétaires", description = "API pour la gestion des secrétaires")
public class SecretaireControlleur {

    @Autowired
    private SecretaireService secretaireService;

    @PostMapping
    @Operation(summary = "Ajouter un secrétaire", description = "Création d'un nouveau secrétaire")
    @ApiResponse(responseCode = "200", description = "Secrétaire créé avec succès")
    @ApiResponse(responseCode = "400", description = "Données invalides")
    public Secretaire ajouterSecretaire(@RequestBody Secretaire secretaire) {
        return secretaireService.ajouterSecretaire(secretaire);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un secrétaire", description = "Mise à jour des informations d'un secrétaire existant")
    @ApiResponse(responseCode = "200", description = "Secrétaire modifié avec succès")
    @ApiResponse(responseCode = "404", description = "Secrétaire non trouvé")
    public Secretaire modifierSecretaire(@PathVariable Long id, @RequestBody Secretaire secretaire) {
        return secretaireService.modifierSecretaire(id, secretaire);
    }

    @GetMapping
    @Operation(summary = "Lister les secrétaires", description = "Récupération de la liste complète des secrétaires")
    @ApiResponse(responseCode = "200", description = "Liste récupérée avec succès")
    public List<Secretaire> listerSecretaires() {
        return secretaireService.listerSecretaire();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Rechercher un secrétaire", description = "Récupération d'un secrétaire par son ID")
    @ApiResponse(responseCode = "200", description = "Secrétaire trouvé")
    @ApiResponse(responseCode = "404", description = "Secrétaire non trouvé")
    public Secretaire rechercherSecretaire(@PathVariable Long id) {
        return secretaireService.rechercherSecretaire(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un secrétaire", description = "Suppression d'un secrétaire par son ID")
    @ApiResponse(responseCode = "204", description = "Secrétaire supprimé avec succès")
    @ApiResponse(responseCode = "404", description = "Secrétaire non trouvé")
    public void supprimerSecretaire(@PathVariable Long id) {
        secretaireService.supprimerSecretaire(id);
    }
}

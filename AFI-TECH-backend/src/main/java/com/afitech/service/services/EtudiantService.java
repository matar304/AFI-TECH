package com.afitech.service.services;

import java.util.List;

import com.afitech.modele.Etudiant;

public interface EtudiantService {

    Etudiant ajouterEtudiant(Etudiant etudiant);
    Etudiant modifierEtudiant(Long id, Etudiant etudiant);
    List<Etudiant> listerEtudiant();
    Etudiant rechercherEtudiant(Long id);
    void supprimerEtudiant(Long id);
    Etudiant authentifier(String matricule, String motDePasse);
}

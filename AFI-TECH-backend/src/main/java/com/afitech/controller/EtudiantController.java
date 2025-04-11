package com.afitech.controller;

import com.afitech.modele.Etudiant;
import com.afitech.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @PostMapping
    public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @GetMapping("/{id}")
    public Etudiant getEtudiantById(@PathVariable Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @GetMapping("/matricule/{matricule}")
    public Etudiant getEtudiantByMatricule(@PathVariable String matricule) {
        return etudiantRepository.findByMatricule(matricule);
    }

    @PutMapping("/{id}")
    public Etudiant updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiantDetails) {
        Etudiant etudiant = etudiantRepository.findById(id).orElse(null);
        if (etudiant != null) {
            etudiant.setNom(etudiantDetails.getNom());
            etudiant.setPrenom(etudiantDetails.getPrenom());
            etudiant.setMatricule(etudiantDetails.getMatricule());
            etudiant.setEmail(etudiantDetails.getEmail());
            return etudiantRepository.save(etudiant);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteEtudiant(@PathVariable Long id) {
        etudiantRepository.deleteById(id);
    }
}

package com.afitech.service.impl;

import com.afitech.modele.Etudiant;
import com.afitech.repository.EtudiantRepository;
import com.afitech.service.services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EtudiantServiceImpl implements EtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public Etudiant ajouterEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant modifierEtudiant(Long id, Etudiant etudiant) {
        etudiant.setId(id);
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> listerEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant rechercherEtudiant(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public Etudiant authentifier(String matricule, String motDePasse) {
        Etudiant etudiant = etudiantRepository.findByMatricule(matricule);
        if(etudiant != null && etudiant.getMotDePasse().equals(motDePasse)) {
            return etudiant;
        }
        return null;
    }
}

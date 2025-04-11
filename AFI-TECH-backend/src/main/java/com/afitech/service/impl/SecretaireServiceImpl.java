package com.afitech.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.afitech.modele.Secretaire;
import com.afitech.repository.SecretaireRepository;
import com.afitech.service.services.SecretaireService;

@Service
public class SecretaireServiceImpl implements SecretaireService {

    @Autowired
    private SecretaireRepository secretaireRepository;

    @Override
    public Secretaire ajouterSecretaire(Secretaire secretaire) {
        return secretaireRepository.save(secretaire);
    }

    @Override
    public Secretaire modifierSecretaire(Long id, Secretaire secretaire) {
        secretaire.setId(id);
        return secretaireRepository.save(secretaire);
    }

    @Override
    public List<Secretaire> listerSecretaire() {
        return secretaireRepository.findAll();
    }

    @Override
    public Secretaire rechercherSecretaire(Long id) {
        return secretaireRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerSecretaire(Long id) {
        secretaireRepository.deleteById(id);
    }
}

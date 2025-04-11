package com.afitech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afitech.modele.Etudiant;
import com.afitech.modele.User;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    Etudiant findByMatricule(String matricule);

    Etudiant findByUser(User user);
}

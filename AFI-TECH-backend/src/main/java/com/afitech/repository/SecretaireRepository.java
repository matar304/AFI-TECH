package com.afitech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afitech.modele.Secretaire;

@Repository
public interface SecretaireRepository extends JpaRepository<Secretaire, Long>{

}

package com.afitech.service.services;

import java.util.List;


import com.afitech.modele.Secretaire;

public interface SecretaireService {

	
	Secretaire ajouterSecretaire(Secretaire secretaire);
	Secretaire modifierSecretaire( Long id,Secretaire secretaire);
	List<Secretaire> listerSecretaire();
	Secretaire rechercherSecretaire( Long id);
	void supprimerSecretaire(Long id);
	
}

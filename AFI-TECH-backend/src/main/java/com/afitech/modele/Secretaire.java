package com.afitech.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table (name = "Secretaire")

public class Secretaire {
	 @Id
	  @GeneratedValue (strategy=GenerationType.SEQUENCE,generator = "SEQ_SECRETAIRE")
	  @SequenceGenerator (name="SEQ_SECRETAIRE",sequenceName = "SEQ_SECRETAIRE", allocationSize =1)
	  private Long id;
	  private  String nom;
	  private String prenom;
	  private String matricule;
	  private String motDePasse;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	  
}

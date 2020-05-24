package com.gestiondepharmacie.model;

import java.util.List;

import com.gestiondepharmacie.Pharmacie1;

public class Medicament {
	
	String nom ; 
	double prix ;
	int stock ;
	
	public Medicament() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medicament(String nom, double prix, int stock) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.stock = stock;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	} 
	

	public  void ajoutStock(Medicament medicament, int stock) {

		medicament.setStock(stock + medicament.getStock());

	}

	public  void dimunierStock(Medicament medicament, int medicamentStock) {

		medicament.setStock(medicamentStock);

	}

}

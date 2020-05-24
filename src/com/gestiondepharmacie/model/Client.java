package com.gestiondepharmacie.model;

import java.util.List;

import com.gestiondepharmacie.Pharmacie1;

public class Client {
	
	private String nom ; 
	private double credit ;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String nom, double credit) {
		super();
		this.nom = nom;
		this.credit = credit;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	} 
	
	
	

	 
	 

}

package com.gestiondepharmacie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.gestiondepharmacie.model.Client;
import com.gestiondepharmacie.model.Medicament;

public class Pharmacie1 {

	private List<Client> clients = new ArrayList<>();

	private List<Medicament> medicaments = new ArrayList<>();

	
	public Pharmacie1(List<Client> clients, List<Medicament> medicaments) {
		super();
		this.clients = clients;
		this.medicaments = medicaments;
	}
	
	
	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Medicament> getMedicaments() {
		return medicaments;
	}

	public void setMedicaments(List<Medicament> medicaments) {
		this.medicaments = medicaments;
	}

	

	// affichage des clients et medicaments
	void affichage(List<Client> clients, List<Medicament> medicaments) {

		System.out.println("Affichage des stocks");
		medicaments.stream().forEach(medicament -> {
			System.out.println("Stock du médicament " + medicament.getNom() + " : " + medicament.getStock());
		});

		System.out.println("Affichage des crédits");
		clients.stream().forEach(client -> {
			System.out.println("Crédit du client " + client.getNom() + " : " + client.getCredit());
		});

	}

	/*
	 * la methode achat permet a un client d'acheter un medicament
	 * */
	void achat(List<Client> clients, List<Medicament> medicaments) {

		System.out.println("Achat");

		Client client = lireClient(clients);

		if (client != null) {

			Medicament medicament = lireMedicament(medicaments);

			// Medicament medicament = null ;
			System.out.println("quel est le montant du paiement?");

			Double str1 = GestionPharmacie.scanner.nextDouble();

			System.out.println("quelle est la quantité achetée?");
			GestionPharmacie.scanner.nextLine();
			int str2 = GestionPharmacie.scanner.nextInt();

			int medicamentStock = medicament.getStock() - str2;

			if (medicamentStock < 0) {
				System.out.println("Achat Impossible. Quantité insuffisante");
			} else {
				medicament.dimunierStock(medicament, medicamentStock);
				paiement(str1, medicament, client, str2);
			}
		}

	}

	/*
	 * la methode d'approvisionnement permet d'approvisioner un medicament 
	 * */
	void approvisionnement(List<Medicament> medicaments) {

		System.out.println("Approvisionnement");

		GestionPharmacie.scanner.nextLine();
		Medicament medicament = lireMedicament(medicaments);

		System.out.println("Donner le stock du medicament :");

		int str1 = GestionPharmacie.scanner.nextInt();

		medicament.ajoutStock(medicament, str1);

	}
	
	
	/*
	 * retourne l'objet medicament
	 * */	
	Medicament lireMedicament(List<Medicament> medicaments) {

		Medicament m = null;
		boolean trouve = false;
		System.out.println("Donner le nom du medicament  :");
		String str = GestionPharmacie.scanner.nextLine();

		while (trouve == false) {

			for (Medicament medicament : medicaments) {
				if (medicament.getNom().equals(str)) {
					trouve = true;
					return medicament;
				}

			}

			if (trouve == false) {

				System.out.println("Medicament inconnu. Veuilliez recommencer");
				str = GestionPharmacie.scanner.nextLine();
			}

		}

		return m;

	}

	/*
	 * retourne l'objet client
	 * */	
	Client lireClient(List<Client> clients) {
		GestionPharmacie.scanner.nextLine();

		Client c = null;
		boolean trouver = false;
		System.out.println("nom d'un client  :");
		String strr = GestionPharmacie.scanner.nextLine();

		while (trouver == false) {

			for (Client client : clients) {
				if (client.getNom().equals(strr)) {
					trouver = true;
					return client;
				}
			}

			if (trouver == false) {

				System.out.println("Client inconnu. Veuilliez recommencer");
				strr = GestionPharmacie.scanner.nextLine();
			}

		}

		return c;

	}
	
	/*
	 * permet d'effectuer un paiement
	 * */	

	void paiement(double montant, Medicament medicament, Client client, int quantite) {

		double credit = (medicament.getPrix() * quantite) - montant;

		client.setCredit(client.getCredit() + credit);

	}

}

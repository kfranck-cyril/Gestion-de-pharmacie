package com.gestiondepharmacie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.gestiondepharmacie.model.Client;
import com.gestiondepharmacie.model.Medicament;

public class GestionPharmacie {
	protected static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {

		List<Client> clients = new ArrayList<Client>();
		List<Medicament> medicaments = new ArrayList<Medicament>();

		// client
		clients.add(new Client("Malfichu", 0.0));
		clients.add(new Client("Palichon", 0.0));

		// medicament
		medicaments.add(new Medicament("Aspiron", 20.40, 5));
		medicaments.add(new Medicament("Rhinoplexil", 19.15, 5));
		
		  Pharmacie1 pharmacie1 = new Pharmacie1(clients, medicaments);

		int choix;

		do {
			choix = menu();

			switch (choix) {
			case 1:
				pharmacie1.achat(clients, medicaments);
				break;
			case 2:
				pharmacie1.approvisionnement(medicaments);
				break;
			case 3:
				pharmacie1.affichage(clients, medicaments);
				break;
			case 4:
				quitter();
			}
		} while (choix < 4);
	}
	
	// menu
	static int menu() {
		int choix = 0;
		System.out.println();
		System.out.println();
		System.out.println("1 : Achat de médicament");
		System.out.println("2 : Approvisionnement en  médicaments");
		System.out.println("3 : Etats des stocks et des crédits");
		System.out.println("4 : Quitter");
		while ((choix != 1) && (choix != 2) && (choix != 3) && (choix != 4)) {
			choix = scanner.nextInt();
		}
		return choix;
	}
	
	// quitter
		static void quitter() {

			System.out.println("programme terminé! ");
		}

}

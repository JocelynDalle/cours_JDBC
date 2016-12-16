package com.humanbooster.jdbc.utils.manager;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.humanbooster.jdbc.utils.service.ScannerUtilsService;

public class ScannerUtils implements ScannerUtilsService {
	Scanner sc = new Scanner(System.in);

	/**.
	 * méthode récupérant un int entre deux valeurs passées en paramètres
	 * @param min le minimum que devra renvoyer la méthode
	 * @param max le maximum que devra renvoyer la méthode 
	 * @return int la valeur saisie
	 */
	public int scanIntBetween(final int min, final int max) {
		int value = 0;
		boolean stay = true;
		while (stay) {

			try {
				value = Integer.parseInt(sc.nextLine());
				if (value >= min && value <= max) {
					stay = false;
				} else {
					System.out.println("Veuillez saisir un nombre entre " + min + " et " + max);
				}
			} catch (InputMismatchException e) {
				System.out.println("saisie incorrecte");
			} catch (NumberFormatException e) {
				System.out.println("saisie incorrecte");
			}
		}
		return value;
	}
	
	
	public int scanInt() {
		int value = 0;
		boolean stay = true;
		while (stay) {

			try {
				value = Integer.parseInt(sc.nextLine());
				stay = false;
			} catch (InputMismatchException e) {
				System.out.println("saisie incorrecte");
			} catch (NumberFormatException e) {
				System.out.println("saisie incorrecte");
			}
		}
		return value;
	}
	
	
	public float scanFloat() {
		float value = 0f;
		boolean stay = true;
		while (stay) {
			try {
				value = Float.parseFloat(sc.nextLine());
				stay = false;
			} catch (InputMismatchException e) {
				System.out.println("saisie incorrecte");
			} catch (NumberFormatException e) {
				System.out.println("saisie incorrecte");
			}
		}
		return value;
	}
	
	public String scanString(int max, int min) {
	boolean stay;
	String name;
	do {
		name = sc.nextLine();
		if (name.length() > max || name.length() < min) {
			System.out.println("Invalide");
			stay = true;
		} else {
			stay = false;
		}
	} while (stay);
	return name;
	}
	
	
	public char scanYesOrNo() {
	String choice;
	char res;
	boolean stay;
	do {
		System.out.println("(Y / N)");
		choice = sc.nextLine();
		res = choice.toUpperCase().charAt(0);
		
		if (res != 'Y' && res != 'N') {
			System.out.println("Invalide");
			stay = true;
		} else {
			stay = false;
		}
	} while (stay);
	return res;
	}
}

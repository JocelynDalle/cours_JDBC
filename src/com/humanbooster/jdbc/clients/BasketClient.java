package com.humanbooster.jdbc.clients;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import com.humanbooster.jdbc.managers.BasketManager;
import com.humanbooster.jdbc.objects.Basket;
import com.humanbooster.jdbc.objects.User;
import com.humanbooster.jdbc.utils.DataConnect;
import com.humanbooster.jdbc.utils.manager.DateUtils;
import com.humanbooster.jdbc.utils.manager.ListUtils;
import com.humanbooster.jdbc.utils.manager.ScannerUtils;
import com.humanbooster.jdbc.utils.service.DateUtilsService;
import com.humanbooster.jdbc.utils.service.ListUtilsService;
import com.humanbooster.jdbc.utils.service.ScannerUtilsService;

public class BasketClient {

	public static void main(String[] args) {

		DateUtilsService dus = new DateUtils();
		ListUtilsService lus = new ListUtils();
		ScannerUtilsService sus = new ScannerUtils();
		Connection connect = null;

		System.out.println("BASKET MANAGER 2017");
	
		try {
			connect = DataConnect.getConnection();
			BasketManager bm = new BasketManager(connect);
			Calendar calen = Calendar.getInstance();
			Random rng = new Random();
			calen.set(rng.nextInt(10) + 2006, rng.nextInt(12) - 1, rng.nextInt(28));
			java.sql.Date date = dus.convertCalendarToSQLDate(calen);

			User u1 = new User("Joce", "Pipou");
			Basket b1 = new Basket("Airness", "Noir", 99.99f, u1, date);

			// création de champs dans la BDD
			System.out.println("\n---- TEST DE CREATION (INSERT INTO) ----\n");
			System.out.println(bm.createBasket(b1));

			System.out.println("\n---- AFFICHAGE DES RESULTAT PAR MARQUE (SELECT) ----\n");
			String brand = "Adidas";
			List<Basket> lsBasket = bm.findBasket(brand);
			lus.printList(lsBasket);

			System.out.println("\n---- AFFICHAGE DU COMPTAGE DE BASKET (SELECT COUNT(*)) ----\n");
			System.out.println("il y a " + bm.getNumberOfBasket() + " baskets dans la base de données");

			System.out.println("\n---- AFFICHAGE DU DERNIER ID DE BASKET ----\n");
			System.out.println("le dernier id de Basket est le : " + bm.getLastBasketId());

			System.out.println("\n---- AFFICHAGE D'UNE BASKET EN FONCTION DE SON ID ----\n");
			int id1 = 14;
			System.out.println(bm.getBasketById(id1));

			System.out.println("\n---- MISE A JOUR DES DONNEES D'UNE BASKET PASSEE EN PARAM ----\n");
			int id2 = 12;
			float price2 = 41.89f;
			String color2 = "Marron";
			System.out.println(bm.updateBasket(id2, price2, color2));

			System.out.println("\n---- AFFICHAGE DE TOUTES LES BASKET (SELECT) ----\n");
			List<Basket> allBasket = bm.getAll();
			lus.printList(allBasket);

			System.out.println("\n---- SUPPRESSION D'UNE BASKET PAR ID (DELETE) ----\n");
			int id3 = 16;
			System.out.println(bm.deleteBasket(id3));

			System.out.println("\n---- SUPPRESSION DE TOUTES LES DONNEES / RESET AUTO_INCREMENT ----\n");
			System.out.println(bm.deleteAll());

			System.out.println("\n---- AJOUT DE PLUSIEURS BASKET PAR UNE LISTE ----\n");
			System.out.println(bm.createBaskets(allBasket));

			System.out.println("\n---- MISE A JOUR D'UNE TABLE PAR UNE LISTE ----\n");
			Basket b2 = new Basket("Adidas", "doré", 49.99f);
			Basket b3 = new Basket("Nike", "argenté", 49.99f);
			Basket b4 = new Basket("Airness", "platinum", 99.99f);
			List<Basket> lsUpdateBasket = new ArrayList<Basket>();
			lsUpdateBasket.add(b2);
			lsUpdateBasket.add(b3);
			lsUpdateBasket.add(b4);
			System.out.println(bm.updateBaskets(lsUpdateBasket));

			System.out.println("\n---- RECHERCHE BASKET AVANT DATE EN PARAM ----\n");
			calen.set(2013, 0, 1);
			List<Basket> lsDateBasket = bm.getBasketAfterDate(dus.convertCalendarToDate(calen));
			lus.printList(lsDateBasket);

			System.out.println("CA TOUT MARCHE !!!!");

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} finally {
			DataConnect.closeConnection(connect);
		}

	}

}

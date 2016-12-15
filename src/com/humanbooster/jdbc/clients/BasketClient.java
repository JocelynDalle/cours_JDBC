package com.humanbooster.jdbc.clients;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import com.humanbooster.jdbc.managers.BasketManager;
import com.humanbooster.jdbc.objects.Basket;
import com.humanbooster.jdbc.utils.DataConnect;
import com.humanbooster.jdbc.utils.manager.DateUtils;
import com.humanbooster.jdbc.utils.manager.ListUtils;
import com.humanbooster.jdbc.utils.service.DateUtilsService;
import com.humanbooster.jdbc.utils.service.ListUtilsService;

public class BasketClient {

	public static void main(String[] args) {
		
		DateUtilsService dus = new DateUtils();
		ListUtilsService lus = new ListUtils();
		Connection connect = null;
		
		

		try {
			connect = DataConnect.getConnection();
			BasketManager bm = new BasketManager(connect);
			Calendar calen = Calendar.getInstance();
			calen.set(2016, 10, 8);
			java.sql.Date date = dus.convertCalendarToSQLDate(calen);
			
			
			
			Basket b1 = new Basket("Converse", "Bleu", 49.99f, "Joce", date);
			
			//création de champs dans la BDD
			System.out.println("\n---- TEST DE CREATION (INSERT INTO) ----\n");
			bm.createBasket(b1);
			
			System.out.println("\n---- AFFICHAGE DES RESULTAT PAR MARQUE (SELECT) ----\n");
			String brand = "Adidas";
			List<Basket> lsBasket = bm.findBasket(brand);
			lus.printList(lsBasket);
			
			System.out.println("\n---- AFFICHAGE DU COMPTAGE DE BASKET (SELECT COUNT(*)) ----\n");
			System.out.println("il y a " + bm.getNumberOfBasket() + " baskets dans la base de données");			
			

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} finally {
			DataConnect.closeConnection(connect);
		}

	}
	

}

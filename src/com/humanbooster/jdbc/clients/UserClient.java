package com.humanbooster.jdbc.clients;

import java.sql.Connection;
import java.sql.SQLException;

import com.humanbooster.jdbc.managers.UserManager;
import com.humanbooster.jdbc.objects.User;
import com.humanbooster.jdbc.service.UserService;
import com.humanbooster.jdbc.utils.DataConnect;

public class UserClient {

	public static void main(String[] args) {

		Connection connect = null;

		try {
			connect = DataConnect.getConnection();

			
			//pour se connecter à la base de données
			System.out.println("\n---- TEST CONNEXION ----\n");
			System.out.println("connection : " + connect);
			
			UserService um = new UserManager(connect);

			System.out.println("\n---- SUPPRESSION DES ENTREES DE LA BDD (DELETE FROM user) ----\n");

			
			um.deleteAllEntries();
			
			User u1 = new User("Bill", "Boule");
			User u2 = new User("Bono", "Jean");

			
			//création de champs dans la BDD
			System.out.println("\n---- TEST DE CREATION (INSERT INTO) ----\n");
			um.createUser(u1);
			um.createUserDirty(u2);

			//récupération de données dans la BDD
			System.out.println("\n---- RECUPERATION DE DONNEES (SELECT FROM) ----\n");
			String l1 = "Bill";
			String l2 = "Bono";

			System.out.println(um.getUser(l1));
			System.out.println(um.getUserDirty(l2));
			
			//modification de données dans la BDD
			System.out.println("\n---- MODIFICATION DE DONNEES (UPDATE SET) ----\n");
			
			String pw1 = "Django";
			String pw2 = "Juanito";
			
			um.updateUser(l1, pw1);
			um.updateUserDirty(l2, pw2);
			
			//suppression de données dans la BDD
			System.out.println("\n---- SUPPRESSION DE DONNEES (DELETE FROM) ----\n");
			
			um.deleteUser(l1);
			um.deleteUserDirty(l2);


			

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} finally {
			DataConnect.closeConnection(connect);
		}

	}
}

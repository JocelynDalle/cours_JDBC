package com.humanbooster.jdbc.utils.manager;

import java.util.List;

import com.humanbooster.jdbc.utils.service.ListUtilsService;

public class ListUtils implements ListUtilsService {

	public void printList(List<?> ls) {
		System.out.println("-------- Affichage de la liste ------");
		for (Object elem : ls) {
			System.out.println(elem);
		}
		if (ls.size() == 0) {
			System.out.println("La liste est vide");
		}
	}
	
}

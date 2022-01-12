package com.xworkz.hibernate.islands;

import com.xworkz.hibernate.islands.dao.IslandDAO;
import com.xworkz.hibernate.islands.dao.IslandDAOImpl;
import com.xworkz.hibernate.islands.dto.IslandDTO;

public class IslandArrival {

	public static void main(String[] args) {

		IslandDTO dto = new IslandDTO(1, "Andaman", "Bay of Bengal", "India");
		IslandDTO dto1 = new IslandDTO(2, "St. Mary's", "Malpe in Udupi", "India");
		IslandDTO dto2 = new IslandDTO(3, "Swaraj Dweep", "Bay of Bengal", "India");
		
		IslandDAO dao = new IslandDAOImpl();
		/*
		dao.create_island(dto1);
		
		System.out.println(dao.getIslandDTO(1));
		dao.deleteIslandDTO(3);
		dao.updateNameById(2, "St. Mary's Island");
		System.out.println(dao.getIslandCountryById(1));
		System.out.println(dao.getIslandNameByCountry(1,"India"));
		dao.getAllIslands();
		dao.create_island(dto2);
		System.out.println(dao.updateIslandNameByCountry(1, "india", "Andaman"));
		*/
		System.out.println(dao.deleteIslandByName(3, "swaraj dweep"));
		
	}
}

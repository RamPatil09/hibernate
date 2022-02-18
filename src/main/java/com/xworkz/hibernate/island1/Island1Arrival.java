package com.xworkz.hibernate.island1;

import com.xworkz.hibernate.island1.dao.Island1DAO;
import com.xworkz.hibernate.island1.dao.Island1DAOImpl;
import com.xworkz.hibernate.island1.dto.Island1DTO;

public class Island1Arrival {

	public static void main(String[] args) {

		Island1DTO dto2 = new Island1DTO("Swaraj Dweep", "Bay of Bengal", "India");
		Island1DTO dto = new Island1DTO("Netaji Subhash Chandra Bose", "Bay of Bengal", "India");
		Island1DTO dto3 = new Island1DTO("Hope Island", "Bay of Bengal", "India");
		Island1DTO dto4 = new Island1DTO("Elephanta Island", "Mumbai Harbour", "India");
		Island1DTO dto5 = new Island1DTO("Greenland", "Denmark", "North America");
		Island1DTO dto6 = new Island1DTO("New Guinea", "Indonesia and Papua New Guinea", "Oceania");

		Island1DAO dao = new Island1DAOImpl();
		/*
		System.out.println(dao.createIsland(dto2));
		System.out.println(dao.createIsland(dto6));
		System.out.println(dao.createIsland(dto5));
		System.out.println(dao.createIsland(dto4));
		
		System.out.println(dao.createIsland(dto));
		System.out.println(dao.getIslandDToById(4));
		List<Island1DTO> list = dao.getAll();
		for (Island1DTO island1dto : list) {
			System.out.println(island1dto);
		}
		;
		System.out.println(dao.updateNameById("Netaji Subhash Chandra Bose Island",4));
		System.out.println(dao.getIslandCountryById(9));
		List<Object> list= dao.getIslandNameByCountry("India");
		for (Object object : list) {
			System.out.println(object);
		}
		System.out.println(dao.deleteIslandByName("New Guinea"));
		
		*/
		//dao.deleteIslandDTOById(8);
		dao.createIsland(dto3);
	}
}

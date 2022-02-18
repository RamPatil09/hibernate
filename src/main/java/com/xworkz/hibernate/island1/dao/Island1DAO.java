package com.xworkz.hibernate.island1.dao;

import java.util.List;

import com.xworkz.hibernate.island1.dto.Island1DTO;

public interface Island1DAO {

	boolean createIsland(Island1DTO dto);

	Island1DTO getIslandDToById(int id);

	List<Island1DTO> getAll();

	boolean deleteIslandDTOById(int id);

	boolean updateNameById(String name, int id);

	Object getIslandCountryById(int id);

	List<Object> getIslandNameByCountry(String country);

	boolean deleteIslandByName(String name);
}

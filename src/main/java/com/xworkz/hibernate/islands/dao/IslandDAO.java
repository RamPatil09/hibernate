package com.xworkz.hibernate.islands.dao;

import com.xworkz.hibernate.islands.dto.IslandDTO;

public interface IslandDAO {

	public boolean create_island(IslandDTO dto);
	public IslandDTO getIslandDTO(int id);
	public boolean deleteIslandDTO(int id);
	public boolean updateNameById(int id,String name);
	public String getIslandCountryById(int id);
	public String getIslandNameByCountry(int id,String country);
	public boolean updateIslandNameByCountry(int id,String country,String name);
	public boolean deleteIslandByName(int id,String name);
}

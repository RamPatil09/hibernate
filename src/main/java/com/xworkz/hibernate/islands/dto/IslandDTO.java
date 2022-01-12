package com.xworkz.hibernate.islands.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "island_details", schema = "hibernate")
public class IslandDTO {

	@Id
	@Column(name = "island_id")
	private int islandId;
	@Column(name = "island_name")
	private String islandName;
	@Column(name = "island_location")
	private String location;
	@Column(name = "island_country")
	private String country;

	public IslandDTO() {
		super();
	}

	public IslandDTO(int islandId, String islandName, String location, String country) {
		super();
		this.islandId = islandId;
		this.islandName = islandName;
		this.location = location;
		this.country = country;
	}

	public int getIslandId() {
		return islandId;
	}

	public void setIslandId(int islandId) {
		this.islandId = islandId;
	}

	public String getIslandName() {
		return islandName;
	}

	public void setIslandName(String islandName) {
		this.islandName = islandName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "IslandDTO [islandId=" + islandId + ", islandName=" + islandName + ", location=" + location
				+ ", country=" + country + "]";
	}

}
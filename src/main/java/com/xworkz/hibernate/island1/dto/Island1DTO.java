package com.xworkz.hibernate.island1.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "island_details", schema = "hibernate")
@NamedQueries({ @NamedQuery(name = "getIslandDToById", query = "from Island1DTO where id= :id"),
		@NamedQuery(name = "getAll", query = "from Island1DTO"),
		@NamedQuery(name = "deleteIslandDTOById", query = "delete from Island1DTO where id =:id"),
		@NamedQuery(name = "updateNameById", query = "update Island1DTO set islandName=:name where id=:id"),
		@NamedQuery(name = "getIslandCountryById", query = "select country from Island1DTO where id= :id"),
		@NamedQuery(name = "getIslandNameByCountry", query = "select islandName from Island1DTO where country=:country"),
		@NamedQuery(name = "deleteIslandByName", query = "delete from Island1DTO where islandName=:name") })
public class Island1DTO {

	@Id
	@GenericGenerator(name = "ref", strategy = "increment")
	@GeneratedValue(generator = "ref")
	@Column(name = "island_id")
	private int islandId;
	@Column(name = "island_name")
	private String islandName;
	@Column(name = "island_location")
	private String location;
	@Column(name = "island_country")
	private String country;

	public Island1DTO() {
		super();
	}

	public Island1DTO(String islandName, String location, String country) {
		super();
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
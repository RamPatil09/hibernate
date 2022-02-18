package com.xworkz.hibernate.medicalstore.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "medicine_details", schema = "hibernate")
@NamedQueries({ @NamedQuery(name = "getAllMedicines", query = "from MedicalStoreDTO"),
		@NamedQuery(name = "getMedicineDetailsByName", query = "from MedicalStoreDTO where medicineName=:name"),
		@NamedQuery(name = "getPriceByName", query = "select price from MedicalStoreDTO where medicineName=:name"),
		@NamedQuery(name = "updatePriceByName", query = "update MedicalStoreDTO set price=:price where medicineName=:name"),
		@NamedQuery(name = "updateExpireDateById", query = "update MedicalStoreDTO set date=:date where id=:id"),
		@NamedQuery(name = "deleteMedicineByName", query = "delete from MedicalStoreDTO where medicineName=:name") })
public class MedicalStoreDTO {

	@Id
	@GenericGenerator(name = "ref", strategy = "increment")
	@GeneratedValue(generator = "ref")
	@Column(name = "id")
	private int id;
	@Column(name = "medicine_name")
	private String medicineName;
	@Column(name = "brand")
	private String brand;
	@Column(name = "price")
	private double price;
	@Column(name = "expire_date")
	private String date;

	public MedicalStoreDTO() {

	}

	public MedicalStoreDTO(String medicineName, String brand, double price, String date) {
		super();
		this.medicineName = medicineName;
		this.brand = brand;
		this.price = price;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "MedicalStoreDTO [id=" + id + ", medicineName=" + medicineName + ", brand=" + brand + ", price=" + price
				+ ", date=" + date + "]";
	}

}

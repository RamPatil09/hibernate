package com.xworkz.hibernate.medicalstore.dao;

import java.util.List;

import com.xworkz.hibernate.medicalstore.dto.MedicalStoreDTO;

public interface MedicineDAO {

	boolean saveMedicineDetails(MedicalStoreDTO dto);

	List<MedicalStoreDTO> getAllMedicines();

	Object getMedicineDetailsByName(String name);

	Object getPriceByName(String name);

	boolean updatePriceByName(String name, double price);
	
	boolean updateExpireDateById(String date,int id);
	
	boolean deleteMedicineByName(String name);
}

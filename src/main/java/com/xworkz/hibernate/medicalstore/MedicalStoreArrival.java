package com.xworkz.hibernate.medicalstore;

import com.xworkz.hibernate.medicalstore.dao.MedicineDAO;
import com.xworkz.hibernate.medicalstore.dao.MedicineDAOImpl;
import com.xworkz.hibernate.medicalstore.dto.MedicalStoreDTO;

public class MedicalStoreArrival {

	public static void main(String[] args) {

		MedicineDAO dao = new MedicineDAOImpl();

		MedicalStoreDTO dto = new MedicalStoreDTO("Dolo","Paracetamol Tablets",26.88,"Mar-22");
		MedicalStoreDTO dto2 = new MedicalStoreDTO("Amlotec-5", "Amlodipine tablet BP", 25.00, "May-23");
		MedicalStoreDTO dto3 = new MedicalStoreDTO("Caccimax", "Meyer", 203.00, "May-23");
		MedicalStoreDTO dto4 = new MedicalStoreDTO("Cystone", "Himalaya", 104.00, "June-24");
		MedicalStoreDTO dto5 = new MedicalStoreDTO("Liv.52 DS", "Himalaya", 119.00, "January-23");
		MedicalStoreDTO dto6 = new MedicalStoreDTO("Ultra-Q300", "Meyer", 1036.00, "March-23");
		MedicalStoreDTO dto7 = new MedicalStoreDTO("Pain-X", "Ortho", 119.00, "June-2024");
		MedicalStoreDTO dto8 = new MedicalStoreDTO("Calcium + Vitamin D3", "TATA 1mg", 298.00, "May-23");
		MedicalStoreDTO dto9 = new MedicalStoreDTO("Flexiqule Capsule", "Alchem life", 188.00, "May-23");
		MedicalStoreDTO dto10 = new MedicalStoreDTO("Shallaki", "Himalaya", 149.00, "July-24");
		
		/*
		System.out.println(dao.saveMedicineDetails(dto6));
		System.out.println(dao.saveMedicineDetails(dto5));
		System.out.println(dao.saveMedicineDetails(dto4));
		System.out.println(dao.saveMedicineDetails(dto3));
		System.out.println(dao.saveMedicineDetails(dto2));
		dao.saveMedicineDetails(dto10);
		dao.saveMedicineDetails(dto9);
		dao.saveMedicineDetails(dto8);
		dao.saveMedicineDetails(dto7);
		
		List<MedicalStoreDTO> dtos = dao.getAllMedicines();
		for (MedicalStoreDTO medicalStoreDTO : dtos) {
			System.out.println(medicalStoreDTO);
		}
		System.out.println(dao.getMedicineDetailsByName("Shallaki"));
		System.out.println("Price of Dolo is " + dao.getPriceByName("Dolo"));
		System.out.println(dao.updatePriceByName("Dolo", 27.00));
		System.out.println(dao.updateExpireDateById("May-2023", 1));
		*/
		
		System.out.println(dao.deleteMedicineByName("Ultra-Q300"));
		
	}
}

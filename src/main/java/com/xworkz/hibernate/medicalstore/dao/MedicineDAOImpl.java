package com.xworkz.hibernate.medicalstore.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.xworkz.hibernate.medicalstore.dto.MedicalStoreDTO;
import com.xworkz.singleton.HibernateUtil;

public class MedicineDAOImpl implements MedicineDAO {

	@Override
	public boolean saveMedicineDetails(MedicalStoreDTO dto) {
		if (dto != null) {
			try {
				SessionFactory factory = HibernateUtil.getSessionFactory();
				Session session = factory.openSession();
				Transaction transaction = session.beginTransaction();
				session.save(dto);
				transaction.commit();
				session.close();
				factory.close();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public List<MedicalStoreDTO> getAllMedicines() {
		try {
			List<MedicalStoreDTO> dtos = HibernateUtil.getSessionFactory().openSession()
					.getNamedQuery("getAllMedicines").list();
			return dtos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object getMedicineDetailsByName(String name) {

		if (name != null) {
			try {
				Object dto = HibernateUtil.getSessionFactory().openSession().getNamedQuery("getMedicineDetailsByName")
						.setParameter("name", name).uniqueResult();
				return dto;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Object getPriceByName(String name) {

		if (name != null) {
			try {
				Object object = HibernateUtil.getSessionFactory().openSession().getNamedQuery("getPriceByName")
						.setParameter("name", name).uniqueResult();
				return object != null ? object : null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean updatePriceByName(String name, double price) {
		if (name != null && price != 0) {
			try {
				SessionFactory factory = HibernateUtil.getSessionFactory();
				Session session = factory.openSession();
				Transaction transaction = session.beginTransaction();
				Query query = session.getNamedQuery("updatePriceByName");
				query.setParameter("price", price);
				query.setParameter("name", name);
				int i = query.executeUpdate();
				transaction.commit();
				session.close();
				factory.close();
				return i > 0 ? true : false;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean updateExpireDateById(String date, int id) {
		if (date != null && id != 0) {
			try {
				SessionFactory factory = HibernateUtil.getSessionFactory();
				Session session = factory.openSession();
				Transaction transaction = session.beginTransaction();
				Query query = session.getNamedQuery("updateExpireDateById");
				query.setParameter("date", date);
				query.setParameter("id", id);
				int i = query.executeUpdate();
				transaction.commit();
				session.close();
				factory.close();
				return i > 0 ? true : false;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean deleteMedicineByName(String name) {
		if (name != null) {
			try {
				SessionFactory factory = HibernateUtil.getSessionFactory();
				Session session = factory.openSession();
				Transaction transaction = session.beginTransaction();
				Query query = session.getNamedQuery("deleteMedicineByName");
				query.setParameter("name", name);
				int i = query.executeUpdate();
				transaction.commit();
				session.close();
				factory.close();
				return i > 0 ? true : false;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}

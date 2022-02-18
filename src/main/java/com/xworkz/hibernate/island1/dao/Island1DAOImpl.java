package com.xworkz.hibernate.island1.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.xworkz.hibernate.island1.dto.Island1DTO;
import com.xworkz.singleton.HibernateUtil;

public class Island1DAOImpl implements Island1DAO {

	@Override
	public boolean createIsland(Island1DTO dto) {
		if (dto != null) {

			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			try {
				session.save(dto);
			} catch (Exception e) {
				e.printStackTrace();
			}
			transaction.commit();
			session.close();
			factory.close();
			System.out.println("Saved Successfully");
			return true;
		} else {
			System.out.println("DTO can't be null");
			return false;
		}
	}

	@Override
	public Island1DTO getIslandDToById(int id) {
		if (id != 0) {
			Island1DTO dto = (Island1DTO) HibernateUtil.getSessionFactory().openSession()
					.getNamedQuery("getIslandDToById").setParameter("id", id).uniqueResult();
			return dto;
		} else {
			return null;
		}
	}

	@Override
	public List<Island1DTO> getAll() {
		try {
			List<Island1DTO> list = HibernateUtil.getSessionFactory().openSession().getNamedQuery("getAll").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteIslandDTOById(int id) {
		if (id != 0) {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.getNamedQuery("deleteIslandDTOById");
			query.setParameter("id", id);
			int rowsAffected = query.executeUpdate();
			transaction.commit();
			session.close();
			factory.close();
			if(rowsAffected > 0) {
				System.out.println("Deleted Successfully");
			}else {
				System.out.println("Unable to delete check id once again...");
			}
			return rowsAffected > 0 ? true : false;
			
		}
		return false;
	}

	@Override
	public boolean updateNameById(String name, int id) {
		if (id != 0 && name != null) {
			try {
				SessionFactory factory = HibernateUtil.getSessionFactory();
				Session session = factory.openSession();
				Transaction transaction = session.beginTransaction();
				Query query = session.getNamedQuery("updateNameById");
				query.setParameter("name", name);
				query.setParameter("id", id);
				int rowsAffected = query.executeUpdate();
				transaction.commit();
				session.close();
				factory.close();
				return rowsAffected > 0 ? true : false;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public Object getIslandCountryById(int id) {
		if (id != 0) {
			try {
				Object obj = HibernateUtil.getSessionFactory().openSession().getNamedQuery("getIslandCountryById")
						.setParameter("id", id).uniqueResult();
				return obj != null ? obj : "Invalid ID";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Object> getIslandNameByCountry(String country) {
		if (country != null) {
			try {
				List<Object> object = HibernateUtil.getSessionFactory().openSession()
						.getNamedQuery("getIslandNameByCountry").setParameter("country", country).list();
				return object;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean deleteIslandByName(String name) {
		if (name != null) {
			try {
				SessionFactory factory = HibernateUtil.getSessionFactory();
				Session session = factory.openSession();
				Transaction transaction = session.beginTransaction();
				Query query = session.getNamedQuery("deleteIslandByName");
				query.setParameter("name", name);
				int rowsAffected = query.executeUpdate();
				transaction.commit();
				session.close();
				factory.close();
				return rowsAffected > 0 ? true : false;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}

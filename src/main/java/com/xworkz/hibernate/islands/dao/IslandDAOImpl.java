package com.xworkz.hibernate.islands.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.hibernate.islands.dto.IslandDTO;
import com.xworkz.hibernate.mobilerecharge.dto.MobileRechargeDTO;

public class IslandDAOImpl implements IslandDAO {

	@Override
	public boolean create_island(IslandDTO dto) {

		if (dto != null) {
			System.out.println("Inside save method");
			Configuration configuration = new Configuration();
			configuration.configure("resources/hibernate.cfg.xml");
			configuration.addAnnotatedClass(IslandDTO.class);
			SessionFactory factory = configuration.buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(dto);
			transaction.commit();
			session.close();
			factory.close();
			return true;
		} else {
			System.out.println("island can't be empty");
			return false;
		}
	}

	@Override
	public IslandDTO getIslandDTO(int id) {
		if (id != 0) {
			System.out.println("Inside get method");
			Configuration configuration = new Configuration();
			configuration.configure("resources/hibernate.cfg.xml");
			configuration.addAnnotatedClass(IslandDTO.class);
			SessionFactory factory = configuration.buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			IslandDTO dto = session.get(IslandDTO.class, id);
			transaction.commit();
			session.close();
			factory.close();
			return dto;
		} else {
			System.out.println("Id can't be 0");
			return null;
		}
	}

	@Override
	public boolean deleteIslandDTO(int id) {
		if (id != 0) {
			System.out.println("Inside delete method");
			Configuration configuration = new Configuration();
			configuration.configure("resources/hibernate.cfg.xml");
			configuration.addAnnotatedClass(IslandDTO.class);
			SessionFactory factory = configuration.buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			IslandDTO dto = session.get(IslandDTO.class, id);
			if (dto != null) {
				session.delete(dto);
			}
			transaction.commit();
			session.close();
			factory.close();
			return true;
		} else {
			System.out.println("Id can't be 0");
			return false;
		}

	}

	@Override
	public boolean updateNameById(int id, String name) {
		if (id != 0) {
			System.out.println("Inside update ");
			Configuration configuration = new Configuration();
			configuration.configure("resources/hibernate.cfg.xml");
			configuration.addAnnotatedClass(IslandDTO.class);
			SessionFactory factory = configuration.buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			IslandDTO dto = session.get(IslandDTO.class, id);
			if (dto != null) {
				dto.setIslandName(name);
				session.update(dto);
			}
			transaction.commit();
			session.close();
			factory.close();
			return true;
		} else {
			System.out.println("Id can't be 0");
			return false;
		}
	}

	@Override
	public String getIslandCountryById(int id) {
		if (id != 0) {
			System.out.println("Inside get Island Country By Id method");
			Configuration configuration = new Configuration();
			configuration.configure("resources/hibernate.cfg.xml");
			configuration.addAnnotatedClass(IslandDTO.class);
			SessionFactory factory = configuration.buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			IslandDTO dto = session.get(IslandDTO.class, id);
			String dto2 = dto.getCountry();
			transaction.commit();
			session.close();
			factory.close();
			return dto2;
		} else {
			System.out.println("Id can't be 0");
			return null;
		}
	}

	@Override
	public String getIslandNameByCountry(int id, String country) {
		if (id != 0) {
			System.out.println("Inside get Island Name By Country method");
			Configuration configuration = new Configuration();
			configuration.configure("resources/hibernate.cfg.xml");
			configuration.addAnnotatedClass(IslandDTO.class);
			SessionFactory factory = configuration.buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			IslandDTO dto = session.get(IslandDTO.class, id);
			if (dto.getCountry().equalsIgnoreCase(country)) {
				String string = dto.getIslandName();
				return string;
			}
			transaction.commit();
			session.close();
			factory.close();
		}
		return null;

	}

	@Override
	public boolean updateIslandNameByCountry(int id, String country, String name) {
		if (id != 0) {
			System.out.println("Inside update Island Name By Country method");
			Configuration configuration = new Configuration();
			configuration.configure("resources/hibernate.cfg.xml");
			configuration.addAnnotatedClass(IslandDTO.class);
			SessionFactory factory = configuration.buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			IslandDTO dto = session.get(IslandDTO.class, id);
			if (dto.getCountry().equalsIgnoreCase(country))
				dto.setIslandName(name);
			session.update(dto);
			transaction.commit();
			session.close();
			factory.close();
			return true;
		} else {
			System.out.println("Id can't be 0");
			return false;
		}
	}

	@Override
	public boolean deleteIslandByName(int id, String name) {
		if (name != null) {
			System.out.println("Inside delete Island By Name");
			Configuration configuration = new Configuration();
			configuration.configure("resources/hibernate.cfg.xml");
			configuration.addAnnotatedClass(IslandDTO.class);
			SessionFactory factory = configuration.buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			IslandDTO dto = session.get(IslandDTO.class, id);
			if (dto.getIslandName().equalsIgnoreCase(name)) {
				session.delete(dto);
			} else {
				System.out.println("Island Not found");
			}
			transaction.commit();
			session.close();
			factory.close();
			return true;
		}
		return false;
	}
}

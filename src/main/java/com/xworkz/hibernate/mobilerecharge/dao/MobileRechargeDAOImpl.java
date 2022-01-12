package com.xworkz.hibernate.mobilerecharge.dao;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.internal.DefaultSessionFactoryBuilderService;
import org.hibernate.cfg.Configuration;

import com.xworkz.hibernate.islands.dto.IslandDTO;
import com.xworkz.hibernate.mobilerecharge.dto.MobileRechargeDTO;
import com.xworkz.hibernate.mobilerecharge.enumfiles.RechargeType;
import com.xworkz.hibernate.mobilerecharge.enumfiles.ServiceProvider;

public class MobileRechargeDAOImpl implements MobileRechargeDAO {

	@Override
	public boolean createRecharge(MobileRechargeDTO dto) {

		if (dto != null) {
			System.out.println("Inside create recharge method");
			Configuration configuration = new Configuration();
			configuration.configure("resources/hibernate.cfg.xml");
			configuration.addAnnotatedClass(MobileRechargeDTO.class);
			SessionFactory factory = configuration.buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(dto);
			transaction.commit();
			session.close();
			factory.close();
			return true;
		} else {
			System.out.println("Mobile Recharge dto can't be empty");
			return false;
		}
	}

	@Override
	public MobileRechargeDTO getMobileRechargeDTO(int id) {
		if (id != 0) {
			System.out.println("Inside get method");
			Configuration configuration = new Configuration();
			configuration.configure("resources/hibernate.cfg.xml");
			configuration.addAnnotatedClass(MobileRechargeDTO.class);
			SessionFactory factory = configuration.buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			MobileRechargeDTO dtoFromDb = session.get(MobileRechargeDTO.class, id);
			return dtoFromDb;
		} else {
			System.out.println("Id cant be 0");
			return null;
		}
	}

	@Override
	public boolean deleteMobileRechargeDTO(int id) {
		if (id != 0) {
			System.out.println("Inside delete method");
			Configuration configuration = new Configuration();
			configuration.configure("resources/hibernate.cfg.xml");
			configuration.addAnnotatedClass(MobileRechargeDTO.class);
			SessionFactory factory = configuration.buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			MobileRechargeDTO detailsFromDb = session.get(MobileRechargeDTO.class, id);
			if (detailsFromDb != null) {
				session.delete(detailsFromDb);
			}
			transaction.commit();
			session.close();
			factory.close();
			return true;
		} else {
			System.out.println("Id cant be 0");
			return false;
		}
	}

	@Override
	public boolean updateServiceProviderByPhoneNumber(int id, long phNumber, ServiceProvider provider) {
		if (phNumber != 0) {
			System.out.println("Inside update method");
			Configuration configuration = new Configuration();
			configuration.configure("resources/hibernate.cfg.xml");
			configuration.addAnnotatedClass(MobileRechargeDTO.class);
			SessionFactory factory = configuration.buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			MobileRechargeDTO detailsFromDb = session.get(MobileRechargeDTO.class, id);
			if (detailsFromDb != null) {
				if (detailsFromDb.getNumber() == phNumber)
					detailsFromDb.setServiceProvider(provider);
				session.update(detailsFromDb);
			}
			transaction.commit();
			session.close();
			factory.close();
			return true;
		} else {
			System.out.println("Phone number can't be 0");
			return false;
		}
	}

	@Override
	public ServiceProvider getServiceProviderByType(int id, RechargeType rechargeType) {
		if (id != 0) {
			ServiceProvider provider = null;
			System.out.println("Inside get Service Provider By Type");
			Configuration configuration = new Configuration();
			configuration.configure("resources/hibernate.cfg.xml");
			configuration.addAnnotatedClass(MobileRechargeDTO.class);
			SessionFactory factory = configuration.buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			MobileRechargeDTO dto = session.get(MobileRechargeDTO.class, id);
			if (dto.getRechargeType().equals(rechargeType)) {
				provider = dto.getServiceProvider();
			}
			transaction.commit();
			session.close();
			factory.close();
			return provider;
		} else {
			System.out.println("Id can't be 0");
			return null;
		}
	}

	@Override
	public double getPlanByServiceProvider(int id, ServiceProvider provider) {
		if (id != 0) {
			double plan = 0;
			System.out.println("Inside get Plan By Service Provider method");
			Configuration configuration = new Configuration();
			configuration.configure("resources/hibernate.cfg.xml");
			configuration.addAnnotatedClass(MobileRechargeDTO.class);
			SessionFactory factory = configuration.buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			MobileRechargeDTO dto = session.get(MobileRechargeDTO.class, id);
			if (dto.getServiceProvider().equals(provider)) {
				plan = dto.getPlan();
			}
			transaction.commit();
			session.close();
			factory.close();
			return plan;
		} else {
			System.out.println("Id can't be 0");
			return 0;
		}
	}

	@Override
	public long getPhNumberById(int id) {
		if (id != 0) {
			System.out.println("Inside get phone number by id");
			Configuration configuration = new Configuration();
			configuration.configure("resources/hibernate.cfg.xml");
			configuration.addAnnotatedClass(MobileRechargeDTO.class);
			SessionFactory factory = configuration.buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			MobileRechargeDTO dto = session.get(MobileRechargeDTO.class, id);
			long number = dto.getNumber();
			transaction.commit();
			session.close();
			factory.close();
			return number;
		} else {
			System.out.println("Id can't be 0");
			return 0;
		}
	}

	@Override
	public boolean updatePlanById(int id, double plan) {
		if (id != 0) {
			System.out.println("Inside update plan by id method");
			Configuration configuration = new Configuration();
			configuration.configure("resources/hibernate.cfg.xml");
			configuration.addAnnotatedClass(MobileRechargeDTO.class);
			SessionFactory factory = configuration.buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			MobileRechargeDTO dto = session.get(MobileRechargeDTO.class, id);
			dto.setPlan(plan);
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
	public boolean updateTypeByPhNumber(int id, long phnumber, RechargeType rechargeType) {
		if (id != 0) {
			System.out.println("Inside update Type By PhNumber method");
			Configuration configuration = new Configuration();
			configuration.configure("resources/hibernate.cfg.xml");
			configuration.addAnnotatedClass(MobileRechargeDTO.class);
			SessionFactory factory = configuration.buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			MobileRechargeDTO dto = session.get(MobileRechargeDTO.class, id);
			if (dto.getNumber() == phnumber) {
				dto.setRechargeType(rechargeType);
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
	public boolean deleteByServiceprovider(int id, ServiceProvider provider) {
		if (id != 0) {
			System.out.println("Inside delete Serviceprovider By Id");
			Configuration configuration = new Configuration();
			configuration.configure("resources/hibernate.cfg.xml");
			configuration.addAnnotatedClass(MobileRechargeDTO.class);
			SessionFactory factory = configuration.buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			MobileRechargeDTO dto = session.get(MobileRechargeDTO.class, id);
			if (dto.getServiceProvider().equals(provider)) {
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
	public boolean deleteByType(int id, RechargeType rechargeType ) {
		if (id != 0) {
			System.out.println("Inside delete Serviceprovider By Id");
			Configuration configuration = new Configuration();
			configuration.configure("resources/hibernate.cfg.xml");
			configuration.addAnnotatedClass(MobileRechargeDTO.class);
			SessionFactory factory = configuration.buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			MobileRechargeDTO dto = session.get(MobileRechargeDTO.class, id);
			if (dto.getRechargeType().equals(rechargeType)) {
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
}

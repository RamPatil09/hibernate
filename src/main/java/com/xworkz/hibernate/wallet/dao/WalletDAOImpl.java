package com.xworkz.hibernate.wallet.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.hibernate.wallet.dto.WalletDTO;

public class WalletDAOImpl implements WalletDAO {

	@Override
	public boolean createWallet(WalletDTO dto) {

		if (dto != null) {
			System.out.println("Invoked create Wallet method");
			Configuration configuration = new Configuration();
			configuration.configure("resources/hibernate.cfg.xml");
			configuration.addAnnotatedClass(WalletDTO.class);
			SessionFactory factory = configuration.buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(dto);
			transaction.commit();
			session.close();
			factory.close();
			return true;
		} else {
			System.out.println("Wallet dto can't be empty");
			return false;
		}
	}

	@Override
	public WalletDTO getWalletDTO(int id) {
		if (id != 0) {
			System.out.println("Inside get method");
			Configuration configuration = new Configuration();
			configuration.configure("resources/hibernate.cfg.xml");
			configuration.addAnnotatedClass(WalletDTO.class);
			SessionFactory factory = configuration.buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			WalletDTO dto = session.get(WalletDTO.class, id);
			transaction.commit();
			session.close();
			factory.close();
			return dto;
		} else {
			System.out.println("Id can't be empty");
			return null;
		}
	}

	@Override
	public boolean deleteWalletDTO(int id) {
		if (id != 0) {
			System.out.println("Inside delete method");
			Configuration configuration = new Configuration();
			configuration.configure("resources/hibernate.cfg.xml");
			configuration.addAnnotatedClass(WalletDTO.class);
			SessionFactory factory = configuration.buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			WalletDTO dto = session.get(WalletDTO.class, id);
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
	public boolean updateAmountById(int id, double amount) {
		if (id != 0) {
			System.out.println("Inside update method");
			Configuration configuration = new Configuration();
			configuration.configure("resources/hibernate.cfg.xml");
			configuration.addAnnotatedClass(WalletDTO.class);
			SessionFactory factory = configuration.buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			WalletDTO dto = session.get(WalletDTO.class, id);
			if (dto != null) {
				dto.setAmount(amount);
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
}

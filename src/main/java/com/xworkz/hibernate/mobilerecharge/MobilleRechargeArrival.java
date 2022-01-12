package com.xworkz.hibernate.mobilerecharge;

import com.xworkz.hibernate.mobilerecharge.dao.MobileRechargeDAO;
import com.xworkz.hibernate.mobilerecharge.dao.MobileRechargeDAOImpl;
import com.xworkz.hibernate.mobilerecharge.dto.MobileRechargeDTO;
import com.xworkz.hibernate.mobilerecharge.enumfiles.RechargeType;
import com.xworkz.hibernate.mobilerecharge.enumfiles.ServiceProvider;

public class MobilleRechargeArrival {

	public static void main(String[] args) {

		MobileRechargeDTO dto = new MobileRechargeDTO(1, ServiceProvider.AIRTEL, 7849051346L, 799.0,
				RechargeType.PREPAID);
		MobileRechargeDTO dto2 = new MobileRechargeDTO(2, ServiceProvider.JIO, 6360307277L, 699.0,
				RechargeType.PREPAID);
		MobileRechargeDTO dto3 = new MobileRechargeDTO(3, ServiceProvider.BSNL, 9448876428L, 399.0,
				RechargeType.POSTPAID);
		MobileRechargeDTO dto4 = new MobileRechargeDTO(4, ServiceProvider.AIRTEL, 9448376428L, 399.0,
				RechargeType.PREPAID);
		MobileRechargeDTO dto5 = new MobileRechargeDTO(5, ServiceProvider.JIO, 6361336068L, 399.0,
				RechargeType.PREPAID);
		MobileRechargeDTO dto6 = new MobileRechargeDTO(6, ServiceProvider.JIO, 8217566973L, 699.0,
				RechargeType.PREPAID);
		MobileRechargeDTO dto7 = new MobileRechargeDTO(7, ServiceProvider.JIO, 6360307277L, 699.0,
				RechargeType.PREPAID);

		MobileRechargeDAO dao = new MobileRechargeDAOImpl();
		/*
		dao.createRecharge(dto3); dao.createRecharge(dto2);
		dao.createRecharge(dto6); 
		dao.createRecharge(dto4); dao.createRecharge(dto6); dao.createRecharge(dto5);
		dao.createRecharge(dto8); dao.createRecharge(dto7);
		dao.updateServiceProviderByPhoneNumber(2,6360307277L, ServiceProvider.JIO);
		System.out.println(dao.getMobileRechargeDTO(1));
		System.out.println(dao.getMobileRechargeDTO(5));
		dao.deleteMobileRechargeDTO(7);
		System.out.println(dao.getServiceProviderByType(1, RechargeType.PREPAID));
		System.out.println(dao.getPlanByServiceProvider(3, ServiceProvider.BSNL));
		System.out.println(dao.getPhNumberById(5));
		System.out.println(dao.updatePlanById(3, 699.0));
		System.out.println(dao.updateTypeByPhNumber(1, 7849051346L, RechargeType.POSTPAID));
		 */
		
		dao.deleteByServiceprovider(6, ServiceProvider.NULL);
		dao.deleteByType(5, RechargeType.NULL);
		
	}
}
